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
public class AddressDTO {
    private Long addressId;
    private String town;
    private String place;
    private String county;
    private String zipcode;
    private String street;
    private String streetNumber;
    private String flatNumber;
}