package pab.pab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pab.pab.models.User;
import pab.pab.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> getUserById(Integer id) {
		return userRepository.findById(id);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	public User saveUser(User user) {
		userRepository.save(user);
		return user;
	}
	
	public void deleteUser(Integer idUser) {
		User user = this.getUserById(idUser).get();
		if(user != null) {
			userRepository.delete(user);
		}
	}

	public User updateUser(Integer id, User user) {
		if(this.getUserById(id).get() != null) {
			User editedUser = user;
			editedUser.setId(id);
			userRepository.save(editedUser);
			return editedUser;
		}
		return null;
	}
	
	

}
