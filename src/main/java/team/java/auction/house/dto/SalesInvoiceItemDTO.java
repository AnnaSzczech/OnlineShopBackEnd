package team.java.auction.house.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesInvoiceItemDTO {
    private Long id;
    @JsonBackReference
    private SalesInvoiceDTO salesInvoice;
    private CopyDTO copy;
    private double netPrice;
    private double grossPrice;
    private int vatPercentage;
}
