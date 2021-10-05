package team.java.auction.house.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRequest {
    private Long categoryProducer;
    private String productName;
    private String description;
    private BigDecimal netPrice;
    private List<PhotoDTO> photos;
    private int vat;
}
