package team.java.auction.house.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {
    private Long customerId;
    private Long addressId;
    private Long contactId;
    private String login;
    private String md5Password;
    private String companyName;
    private String regon;
    private String nip;
    private String surname;
    private String name;
    private String customerType;
}