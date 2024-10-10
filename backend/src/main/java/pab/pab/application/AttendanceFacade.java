package pab.pab.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pab.pab.dto.AttendanceDTO;
import pab.pab.dto.CourseCreateDTO;
import pab.pab.dto.CourseDTO;
import pab.pab.models.Attendance;
import pab.pab.services.AttendanceService;
import pab.pab.services.CourseService;

import java.util.List;

@Service
public class AttendanceFacade {

    @Autowired
    private AttendanceService attendanceService;

    public AttendanceDTO getAttendance(Integer attendanceId) {
        return attendanceService.getAttendanceById(attendanceId);
    }

    public List<AttendanceDTO> getAttendances() {
        return attendanceService.getAttendances();
    }

    public AttendanceDTO updateAttendance(Integer attendanceId, AttendanceDTO attendanceDTO) {
        return attendanceService.updateAttendance(attendanceId, attendanceDTO);
    }
}
