package pab.pab.repositories;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pab.pab.models.Course;


public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	Optional<Course> findByName(String name);
	Optional<Course> findByDate(Timestamp date);

}