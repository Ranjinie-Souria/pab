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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Integer> getFormationIds() {
		return formationIds;
	}
	public void setFormationIds(List<Integer> formationIds) {
		this.formationIds = formationIds;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
    
    
}
