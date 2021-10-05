package team.java.auction.house.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NamedNativeQuery(
        name = "SalesInvoiceItemEntity.allItemsForInvoice",
        query = "SELECT * FROM SALES_INVOICE_ITEMS " +
                "WHERE SALES_INVOICE_ITEMS.SALES_INVOICE_ID = :SALES_INVOICE_ID",
        resultClass = SalesInvoiceItemEntity.class
)
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SALES_INVOICE_ITEMS")
public class SalesInvoiceItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "SALES_INVOICE_ID")
    private SalesInvoiceEntity salesInvoice;

    @ManyToOne
    @JoinColumn(name = "COPY_ID")
    private CopyEntity copy;

    @Column(name = "NET_PRICE")
    private double netPrice;

    @Column(name = "GROSS_PRICE")
    private double grossPrice;

    @Column(name = "VAT_PERCENTAGE")
    private int vatPercentage;
}
