package team.java.auction.house.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderDTO {
    private Long orderId;
    private CustomerDTO customersId;
    private Date orderDate;
    private Date orderAcceptanceDate;
    private boolean isOrderAccepted;
    private BigDecimal paid;
    private Date shipmentDate;
    private boolean isOrderCompleted;
    private Date orderCompletedDate;
    private List<ProductDTO> products;
}
