package team.java.auction.house.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID", unique = true, nullable = false)
    private Long addressId;

    @Column(name = "TOWN", nullable = false)
    private String town;

    @Column(name = "PLACE")
    private String place;

    @Column(name = "COUNTY", nullable = false)
    private String county;

    @Column(name = "ZIPCODE", nullable = false)
    private String zipcode;

    @Column(name = "STREET", nullable = false)
    private String street;


    @Column(name = "STREET_NUMBER", nullable = false)
    private String streetNumber;


    @Column(name = "FLAT_NUMBER")
    private String flatNumber;
}