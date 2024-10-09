package pab.pab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pab.pab.models.Course;

import java.time.LocalDate;
import java.util.Optional;


public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	Optional<Course> findByName(String name);
	Optional<Course> findByDate(LocalDate date);

}