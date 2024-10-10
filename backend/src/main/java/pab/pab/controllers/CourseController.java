package pab.pab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pab.pab.application.CourseFacade;
import pab.pab.dto.CourseCreateDTO;
import pab.pab.dto.CourseDTO;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseFacade courseFacade;

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseFacade.getCourses();
    }

    @GetMapping("/{courseId}")
    public CourseDTO getCourseById(@PathVariable Integer courseId) {
        return courseFacade.getCourse(courseId);
    }

    @PostMapping
    public CourseDTO addCourse(@RequestBody CourseCreateDTO courseCreateDTO) {
        return courseFacade.createCourse(courseCreateDTO);
    }

    @PutMapping("/{courseId}")
    public CourseDTO updateCourse(@PathVariable Integer courseId, @RequestBody CourseCreateDTO courseCreateDTO) {
        return courseFacade.updateCourse(courseId, courseCreateDTO);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable Integer courseId) {
        courseFacade.deleteCourse(courseId);
    }
}
