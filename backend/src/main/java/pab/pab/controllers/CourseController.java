package pab.pab.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pab.pab.application.CourseFacade;
import pab.pab.dto.CourseCreateDTO;
import pab.pab.dto.CourseDTO;

import java.util.List;

@RestController
@Tag(name="COURSE")
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseFacade courseFacade;

    @GetMapping
    @Operation(summary="Get all courses")
    public List<CourseDTO> getAllCourses() {
        return courseFacade.getCourses();
    }

    @GetMapping("/{courseId}")
    @Operation(summary="Get course by id")
    public CourseDTO getCourseById(@PathVariable Integer courseId) {
        return courseFacade.getCourse(courseId);
    }

    @PostMapping
    @Operation(summary="Create course")
    public CourseDTO addCourse(@RequestBody CourseCreateDTO courseCreateDTO) {
        return courseFacade.createCourse(courseCreateDTO);
    }

    @PutMapping("/{courseId}")
    @Operation(summary = "Update course")
    public CourseDTO updateCourse(@PathVariable Integer courseId, @RequestBody CourseCreateDTO courseCreateDTO) {
        return courseFacade.updateCourse(courseId, courseCreateDTO);
    }

    @DeleteMapping("/{courseId}")
    @Operation(summary = "Delete course")
    public void deleteCourse(@PathVariable Integer courseId) {
        courseFacade.deleteCourse(courseId);
    }
}
