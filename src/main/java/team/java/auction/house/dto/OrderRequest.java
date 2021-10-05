package team.java.auction.house.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderRequest {
    private Long customerId;
    private List<Long> productsIds = new ArrayList<>();
}
