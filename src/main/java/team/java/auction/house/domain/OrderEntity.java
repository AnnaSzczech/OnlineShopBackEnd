package team.java.auction.house.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID", unique = true, nullable = false)
    private Long OrderId;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private CustomerEntity customersId;

    @Column(name = "ORDER_DATE", nullable = false)
    private Date orderDate;

    @Column(name = "ORDER_ACCEPTANCE_DATE")
    private Date orderAcceptanceDate;

    @Column(name = "IS_ORDER_ACCEPTED", nullable = false)
    private boolean isOrderAccepted;

    @Column(name = "PAID")
    private BigDecimal paid;

    @Column(name = "SHIPMENT_DATE")
    private Date shipmentDate;

    @Column(name = "IS_ORDER_COMPLETED", nullable = false)
    private boolean isOrderCompleted;

    @Column(name = "ORDER_COMPLETED_DATE")
    private Date orderCompletedDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_ORDER_PRODUCT",
            joinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")}
    )
    private List<ProductEntity> products = new ArrayList<>();

    public OrderEntity(CustomerEntity customersId, List<ProductEntity> products) {
        this.products = products;
        this.customersId = customersId;
        orderDate = Date.valueOf(LocalDate.now());
    }
}
