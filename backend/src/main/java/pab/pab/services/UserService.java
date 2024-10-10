package pab.pab.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pab.pab.dto.UserCreateDTO;
import pab.pab.dto.UserDTO;
import pab.pab.models.User;
import pab.pab.models.UserFormations;
import pab.pab.repositories.UserFormationsRepository;
import pab.pab.repositories.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserFormationsRepository userFormationsRepository;

	private final ModelMapper modelMapper = new ModelMapper();
	
	public UserDTO getUserById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new RuntimeException("User not found");
		}
		return modelMapper.map(user.get(), UserDTO.class);
	}

	public List<UserDTO> getUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
	}
	
	public UserDTO createUser(UserCreateDTO userCreateDTO) {
		User userSaved = userRepository.save(modelMapper.map(userCreateDTO, User.class));
		if (Objects.nonNull(userCreateDTO.getFormationIds()) && !userCreateDTO.getFormationIds().isEmpty()) {
			userCreateDTO.getFormationIds().forEach(formationId -> userFormationsRepository.save(new UserFormations(userSaved.getId(), formationId)));
		}
		return modelMapper.map(userSaved, UserDTO.class);
	}
	
	public void deleteUser(Integer idUser) {
		userRepository.deleteById(idUser);
	}

	public UserDTO updateUser(Integer id, UserCreateDTO userCreateDTO) {
		if (userRepository.existsById(id)) {
			User user = userRepository.findById(id).get();
			if (Objects.nonNull(userCreateDTO.getUserType())) {
				user.setUserType(userCreateDTO.getUserType());
			}
			if (Objects.nonNull(userCreateDTO.getEmail())) {
				user.setEmail(userCreateDTO.getEmail());
			}
			if (Objects.nonNull(userCreateDTO.getLastname())) {
				user.setLastname(userCreateDTO.getLastname());
			}
			if (Objects.nonNull(userCreateDTO.getFirstname())) {
				user.setFirstname(userCreateDTO.getFirstname());
			}
			if (Objects.nonNull(userCreateDTO.getAddress())) {
				user.setAddress(userCreateDTO.getAddress());
			}
			if (Objects.nonNull(userCreateDTO.getPhone())) {
				user.setPhone(userCreateDTO.getPhone());
			}
			User userUpdated = userRepository.save(user);
			return modelMapper.map(userUpdated, UserDTO.class);
		}
		throw new RuntimeException("User not exist");
	}

	public Boolean userExist(Integer id) {
		return userRepository.existsById(id);
	}
	
	

}
