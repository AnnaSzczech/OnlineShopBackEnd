package team.java.auction.house.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CopyDTO {
    private Long id;
    private ProductDTO product;
    private String productCode;
    private double netPrice;
    private double grossPrice;
    private int vatPercentage;
    private Date addedDate;
    private Date soldDate;
    private boolean isSold;
}
