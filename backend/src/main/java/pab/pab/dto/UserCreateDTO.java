package pab.pab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pab.pab.Utils.UserType;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private String address;
    private List<Integer> formationIds;
    private UserType userType;
    
}
