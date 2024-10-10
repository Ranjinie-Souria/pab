package pab.pab.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pab.pab.application.AttendanceFacade;
import pab.pab.dto.AttendanceDTO;

import java.util.List;

@RestController
@Tag(name="ATTENDANCE")
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceFacade attendanceFacade;

    @GetMapping
    public List<AttendanceDTO> getAllAttendances() {
        return attendanceFacade.getAttendances();
    }

    @GetMapping("/{attendanceId}")
    public AttendanceDTO getAttendanceById(@PathVariable Integer attendanceId) {
        return attendanceFacade.getAttendance(attendanceId);
    }

    @PutMapping("/{attendanceId}")
    public AttendanceDTO updateAttendance(@PathVariable Integer attendanceId, @RequestBody AttendanceDTO attendanceDTO) {
        return attendanceFacade.updateAttendance(attendanceId, attendanceDTO);
    }
}
