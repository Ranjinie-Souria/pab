package pab.pab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pab.pab.models.Course;

import java.util.List;
import java.util.Optional;


public interface CourseRepository extends JpaRepository<Course, Integer>{

	Optional<Course> findByIdAndDeletedDateIsNull(Integer id);
	List<Course> findAllByDeletedDateIsNull();
}