package pab.pab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pab.pab.Utils.UserType;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String address;
    private List<FormationDTO> formations;
    private UserType userType;
}
