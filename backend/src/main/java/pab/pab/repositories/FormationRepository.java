package pab.pab.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pab.pab.models.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Integer>{
	
	Optional<Formation> findByName(String name);
	List<Formation> findByYear(Integer year);
	
}