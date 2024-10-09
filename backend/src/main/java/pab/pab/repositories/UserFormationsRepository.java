package pab.pab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pab.pab.models.UserFormations;

import java.util.List;

@Repository
public interface UserFormationsRepository extends JpaRepository<UserFormations, Integer> {
    void deleteByUserIdAndFormationId(Integer userId, Integer formationId);
    List<UserFormations> findByUserId(Integer userId);
}