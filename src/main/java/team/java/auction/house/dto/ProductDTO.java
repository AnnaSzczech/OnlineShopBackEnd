package team.java.auction.house.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    private Long productId;
    private CategoryProducerDTO categoryProducer;
    private String productName;
    private String type;
    private int version = 1;
    private String description;
    @JsonManagedReference
    private List<PhotoDTO> photos = new ArrayList<>();
    private BigDecimal netPrice;
    private BigDecimal grossPrice;
    private int vat;
    @JsonBackReference
    private List<OrderDTO> orders;
}
