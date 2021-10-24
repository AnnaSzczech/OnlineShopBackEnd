package team.java.auction.house.domain;

import lombok.*;

import javax.persistence.*;


@NamedNativeQuery(
        name = "UserEntity.findByLogin",
        query = "SELECT * FROM USERS WHERE USERS.LOGIN = :login",
        resultClass = UserEntity.class
)
@Table(name = "USERS")
@Entity
@Builder
@EqualsAndHashCode(exclude = "id")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "LOGIN", unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "ROLE", nullable = false)
    private String role;
}