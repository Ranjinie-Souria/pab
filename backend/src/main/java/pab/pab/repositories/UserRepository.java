package pab.pab.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pab.pab.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByFirstname(String firstname);
	Optional<User> findByEmail(String email);
	List<User> findByFormation_id(Integer formationId);
	List<User> findByUserType(String usertype);
	
}
