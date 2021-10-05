package team.java.auction.house.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CONTACT")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTACT_ID", unique = true, nullable = false)
    private Long contactId;

    @Column(name = "PHONE_NUMBER_1", nullable = false)
    private String phoneNumber1;

    @Column(name = "PHONE_NUMBER_2")
    private String phoneNumber2;

    @Column(name = "FAX")
    private String fax;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "WEBPAGE")
    private String webpage;
}