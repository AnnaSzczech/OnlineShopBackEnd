package team.java.auction.house.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "COPIES")
public class CopyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity product;

    @JoinColumn(name = "PRODUCT_CODE")
    private String productCode;

    @Column(name = "NET_PRICE")
    private double netPrice;

    @Column(name = "GROS_PRICE")
    private double grosPrice;

    @Column(name = "VAT_PERCENTAGE")
    private int vatPercentage;

    @Column(name = "ADDED_DATE")
    private Date addedDate;

    @Column(name = "SOLD_DATE")
    private Date soldDate;

    @Column(name = "SOLD")
    private boolean isSold;
}
