package team.java.auction.house.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID", unique = true, nullable = false)
    private Long productId;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_PRODUCER_ID", nullable = false)
    private CategoryProducerEntity categoryProducer;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "VERSION")
    private int version = 1;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(
            mappedBy = "product",
            cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST},
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<PhotoEntity> photos = new ArrayList<>();

    @Column(name = "NET_PRICE", nullable = false)
    private BigDecimal netPrice;

    @Column(name = "GROSS_PRICE", nullable = false)
    private BigDecimal grossPrice;

    @Column(name = "VAT", nullable = false)
    private int vat;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "products")
    private List<OrderEntity> orders = new ArrayList<>();

    public ProductEntity(CategoryProducerEntity categoryProducer, String productName, String description, List<PhotoEntity> photos, BigDecimal netPrice, int vat) {
        this.categoryProducer = categoryProducer;
        this.productName = productName;
        this.description = description;
        this.photos = photos;
        this.netPrice = netPrice;
        this.vat = vat;
        grossPrice = netPrice.multiply(BigDecimal.valueOf(vat).add(BigDecimal.ONE));
    }
}
