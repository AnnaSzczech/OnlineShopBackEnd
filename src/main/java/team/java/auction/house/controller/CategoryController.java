package team.java.auction.house.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.java.auction.house.domain.CategoryEntity;
import team.java.auction.house.dto.CategoryDTO;
import team.java.auction.house.dto.ErrorMessage;
import team.java.auction.house.dto.Response;
import team.java.auction.house.service.CategoryService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/category")
public class CategoryController extends BasicResponse {

    @Autowired
    private CategoryService categoryService;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping(value = "/all")
    public Response<List<CategoryDTO>> getCategories() {
        List<CategoryEntity> categories = categoryService.findAll();
        List<CategoryDTO> data = new ArrayList<>();
        categories.forEach(category -> data.add(modelMapper.map(category, CategoryDTO.class)));
        return data.isEmpty() ? createNoDataResponse() : createOkResponse(data);
    }

    @GetMapping(value = "/{id}")
    public Response<CategoryDTO> getCategory(@PathVariable("id") Long categoryId) {
        Optional<CategoryEntity> category = categoryService.findById(categoryId);
        return (category.isPresent()) ? createOkResponse(modelMapper.map(category.get(), CategoryDTO.class)) : createNoDataResponse();
    }

    @PostMapping
    public Response<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        Optional<CategoryEntity> category = categoryService.findByName(categoryDTO.getName());
        if (category.isPresent()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
            return createErrorResponse(new ErrorMessage(409, "Podana kategoria już istnieje!", date));
        }
        CategoryEntity cat = modelMapper.map(categoryDTO, CategoryEntity.class);
        categoryService.save(cat);
        return createOkResponse();
    }
}