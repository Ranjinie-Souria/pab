package pab.pab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pab.pab.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
