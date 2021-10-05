package team.java.auction.house.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO {
    private Long employeeId;
    private Long addressId;
    private Long contactId;
    private String login;
    private String md5Password;
    private String surname;
    private String name;
    private String role;
    private boolean isAccountActive;
    private Date employeeOnboardingDate;
    private Date employeeOffboardingDate;
}