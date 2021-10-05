package team.java.auction.house.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
    private Long employeeId;

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

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ROLE", nullable = false)
    private String role;

    @Column(name = "IS_ACCOUNT_ACTIVE", nullable = false)
    private boolean isAccountActive;

    @Column(name = "EMPLOYEE_ONBOARDING_DATE", nullable = false)
    private Date employeeOnboardingDate;

    @Column(name = "EMPLOYEE_OFFBOARDING_DATE")
    private Date employeeOffboardingDate;
}