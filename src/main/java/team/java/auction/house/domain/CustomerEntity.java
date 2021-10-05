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
@Table(name = "CUSTOMERS")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", unique = true, nullable = false)
    private Long customerId;

    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID", unique = true, nullable = false)
    private AddressEntity addressId;

    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTACT_ID", unique = true, nullable = false)
    private ContactEntity contactId;

    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "MD5_PASSWORD", nullable = false)
    private String md5Password;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "REGON")
    private String regon;

    @Column(name = "NIP")
    private String nip;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CUSTOMER_TYPE", nullable = false)
    private String customerType;

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL)
    private List<SalesInvoiceEntity> salesInvoices;
}
