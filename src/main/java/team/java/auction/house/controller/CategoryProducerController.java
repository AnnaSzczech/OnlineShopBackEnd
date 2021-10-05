package team.java.auction.house.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.java.auction.house.domain.CategoryProducerEntity;
import team.java.auction.house.dto.CategoryProducerDTO;
import team.java.auction.house.dto.ErrorMessage;
import team.java.auction.house.dto.Response;
import team.java.auction.house.service.CategoryProducerService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/categoryProducer")
public class CategoryProducerController extends BasicResponse {

    @Autowired
    private CategoryProducerService categoryProducerService;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping(value = "/all")
    public Response<List<CategoryProducerDTO>> getCategoryProducers() {
        List<CategoryProducerEntity> categoryProducers = categoryProducerService.findAll();
        List<CategoryProducerDTO> data = new ArrayList<>();
        categoryProducers.forEach(categoryProducer -> data.add(modelMapper.map(categoryProducer,CategoryProducerDTO.class)));
        return data.isEmpty() ? createNoDataResponse() : createOkResponse(data);
    }

    @GetMapping(value = "/{id}")
    public Response<CategoryProducerDTO> getCategory(@PathVariable("id") Long categoryProducerId) {
        Optional<CategoryProducerEntity> categoryProducer = categoryProducerService.findById(categoryProducerId);
        return (categoryProducer.isPresent()) ? createOkResponse(modelMapper.map(categoryProducer,CategoryProducerDTO.class)) : createNoDataResponse();
    }

    @PostMapping
    public Response<CategoryProducerDTO> createCategory(@RequestBody CategoryProducerDTO categoryProducerDTO) {
        Optional<CategoryProducerEntity> categoryProducer = categoryProducerService.findById(categoryProducerDTO.getId());
        if (categoryProducer.isPresent()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
            return createErrorResponse(new ErrorMessage(409, "Podana para: kategoria <-> producent już istnieje!", date));
        }
        categoryProducerService.save(modelMapper.map(categoryProducerDTO,CategoryProducerEntity.class));
        return createOkResponse();
    }
}