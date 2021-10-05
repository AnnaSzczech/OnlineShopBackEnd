package team.java.auction.house.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SALES_INVOICES")
public class SalesInvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customer;

    @Column(name = "SALES_INVOICE_NUMBER")
    private String salesInvoiceNumber;

    @Column(name = "SALES_DATE")
    private String salesDate;

    @Column(name = "NET_VALUE")
    private String netValue;

    @Column(name = "GROSS_VALUE")
    private String grossValue;

    @Column(name = "VAT_VALUE")
    private String vatValue;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;

    @Column(name = "DOCUMENT_TYPE")
    private String documentType;

    @OneToMany(mappedBy = "salesInvoice",
            cascade = CascadeType.ALL)
    private List<SalesInvoiceItemEntity> salesInvoiceItems;
}
