package pab.pab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pab.pab.models.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Integer> {
}
