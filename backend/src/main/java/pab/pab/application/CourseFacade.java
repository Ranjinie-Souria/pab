package pab.pab.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pab.pab.dto.CourseCreateDTO;
import pab.pab.dto.CourseDTO;
import pab.pab.services.CourseService;

import java.util.List;

@Service
public class CourseFacade {

    @Autowired
    private CourseService courseService;

    public CourseDTO getCourse(Integer courseId) {
        return courseService.getCourse(courseId);
    }

    public void deleteCourse(Integer courseId) {
        courseService.deleteCourse(courseId);
    }

    public CourseDTO createCourse(CourseCreateDTO courseCreateDTO) {
        return courseService.createCourse(courseCreateDTO);
    }

    public List<CourseDTO> getCourses() {
        return courseService.getAllCourses();
    }

    public CourseDTO updateCourse(Integer courseId, CourseCreateDTO courseCreateDTO) {
        return courseService.updateCourse(courseId, courseCreateDTO);
    }
}
