package team.java.auction.house.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import team.java.auction.house.domain.CustomerEntity;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesInvoiceDTO {
    private Long id;
    private CustomerEntity customer;
    private String salesInvoiceNumber;
    private String salesDate;
    private String netValue;
    private String grossValue;
    private String vatValue;
    private String bankName;
    private String paymentMethod;
    private String documentType;
    @JsonManagedReference
    private List<SalesInvoiceItemDTO> salesInvoiceItems;
}
