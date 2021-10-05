package team.java.auction.house.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.java.auction.house.domain.CategoryProducerEntity;
import team.java.auction.house.domain.PhotoEntity;
import team.java.auction.house.domain.ProductEntity;
import team.java.auction.house.dto.ErrorMessage;
import team.java.auction.house.dto.ProductDTO;
import team.java.auction.house.dto.ProductRequest;
import team.java.auction.house.dto.Response;
import team.java.auction.house.service.CategoryProducerService;
import team.java.auction.house.service.ProductService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/product")
public class ProductController extends BasicResponse {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryProducerService categoryProducerService;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping(value = "/{id}")
    public Response<ProductDTO> getProduct(@PathVariable("id") Long productId) {
        Optional<ProductEntity> product = productService.findProductById(productId);
        return (product.isPresent()) ? createOkResponse(modelMapper.map(product.get(), ProductDTO.class)) : createNoDataResponse();
    }

    @PostMapping
    public Response<ProductDTO> createProduct(@Query ProductRequest productRequest) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        if (productRequest.getCategoryProducer() == null || productRequest.getProductName() == null || productRequest.getNetPrice() == null) {
            return createErrorResponse(new ErrorMessage(401, "Brak wymaganych pól!", date));
        }
        Optional<CategoryProducerEntity> categoryProducer = categoryProducerService.findById(productRequest.getCategoryProducer());
        if (!categoryProducer.isPresent()) {
            return createErrorResponse(new ErrorMessage(401, "Podana kategoria nie istnieje!", date));
        }
        List<PhotoEntity> photos = new ArrayList<>();
        productRequest.getPhotos().forEach(photo -> photos.add(modelMapper.map(photo, PhotoEntity.class)));
        ProductEntity product = new ProductEntity(categoryProducer.get(), productRequest.getProductName(), productRequest.getDescription(), photos, productRequest.getNetPrice(), productRequest.getVat());
        photos.forEach(photo -> photo.setProduct(product));
        productService.saveProduct(product);
        return createOkResponse(modelMapper.map(product, ProductDTO.class));
    }

//    public List<PhotoEntity> createPhotos(List<PhotoDTO> photosDTO) {
//        if () {
//            return
//                    List < PhotoEntity > photos = new ArrayList<>();
//        }
//        photosDTO.forEach(photo -> photos.add(modelMapper.map(photo, PhotoEntity.class)));
//        return photos;
//    }
}
