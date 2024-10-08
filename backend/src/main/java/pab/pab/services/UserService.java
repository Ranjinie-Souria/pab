package pab.pab.services;

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
	

}
