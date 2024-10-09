package pab.pab.repositories;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pab.pab.models.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{
	
	Optional<Attendance> findByDate(Timestamp date);
	List<Attendance> findByStatus(String status);

}
