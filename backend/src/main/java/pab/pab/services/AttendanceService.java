package pab.pab.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pab.pab.dto.AttendanceDTO;
import pab.pab.dto.UserCreateDTO;
import pab.pab.dto.UserDTO;
import pab.pab.models.Attendance;
import pab.pab.models.User;
import pab.pab.models.UserFormations;
import pab.pab.repositories.AttendanceRepository;
import pab.pab.repositories.UserFormationsRepository;
import pab.pab.repositories.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AttendanceService {
	
	@Autowired
	private AttendanceRepository attendanceRepository;

	private final ModelMapper modelMapper = new ModelMapper();
	
	public AttendanceDTO getAttendanceById(Integer id) {
		Optional<Attendance> attendance = attendanceRepository.findById(id);
		if (attendance.isEmpty()) {
			throw new RuntimeException("Attendance not found");
		}
		return modelMapper.map(attendance.get(), AttendanceDTO.class);
	}

	public List<AttendanceDTO> getAttendances() {
		List<Attendance> attendances = attendanceRepository.findAll();
		return attendances.stream().map(attendance -> modelMapper.map(attendance, AttendanceDTO.class)).toList();
	}
	
	public AttendanceDTO createAttendance(AttendanceDTO AttendanceDTO) {
		Attendance attendanceSaved = attendanceRepository.save(modelMapper.map(AttendanceDTO, Attendance.class));

		return modelMapper.map(attendanceSaved, AttendanceDTO.class);
	}

	public AttendanceDTO updateAttendance(Integer id, AttendanceDTO attendanceDTO) {
		if (!attendanceRepository.existsById(id)) {
			throw new RuntimeException("Attendance do not exist");
		}

		Attendance attendance = attendanceRepository.findById(id).get();
		if (Objects.nonNull(attendanceDTO.getStatus())) {
			attendance.setStatus(attendanceDTO.getStatus());
		}
		Attendance attendanceUpdated = attendanceRepository.save(attendance);

		return modelMapper.map(attendanceUpdated, AttendanceDTO.class);
	}

	public Boolean attendanceExist(Integer id) {
		return attendanceRepository.existsById(id);
	}
	
	

}
