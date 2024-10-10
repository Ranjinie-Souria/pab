package pab.pab.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import pab.pab.dto.CourseCreateDTO;
import pab.pab.dto.CourseDTO;
import pab.pab.models.Course;
import pab.pab.repositories.CourseRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    private ModelMapper modelMapper;

    public CourseDTO createCourse (CourseCreateDTO courseCreateDTO) {
        Course course = modelMapper.map(courseCreateDTO, Course.class);
        return modelMapper.map(courseRepository.save(course), CourseDTO.class);
    }

    public void deleteCourse (Integer courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (Objects.nonNull(course)) {
            course.setDeletedDate(LocalDateTime.now());
            courseRepository.save(course);
        }
    }

    public CourseDTO updateCourse (Integer courseId, CourseCreateDTO courseCreateDTO) {
        if (!courseRepository.existsById(courseId)) {
            throw new RuntimeException("Course not found");
        }

        Course course = courseRepository.findByIdAndDeletedDateIsNull(courseId).orElse(null);
        if (Objects.isNull(course)) {
            throw new RuntimeException("This course was deleted");
        }

        if (Objects.nonNull(courseCreateDTO.getName())) {
            course.setName(courseCreateDTO.getName());
        }
        if (Objects.nonNull(courseCreateDTO.getDate())) {
            course.setDate(courseCreateDTO.getDate());
        }
        if (Objects.nonNull(courseCreateDTO.getRoomNb())) {
            course.setRoomNb(courseCreateDTO.getRoomNb());
        }
        if (Objects.nonNull(courseCreateDTO.getDuration()) && courseCreateDTO.getDuration() > 0) {
            course.setDuration(courseCreateDTO.getDuration());
        }

        return modelMapper.map(courseRepository.save(course), CourseDTO.class);
    }

    public CourseDTO getCourse (Integer courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new RuntimeException("Course not found");
        }

        Course course = courseRepository.findByIdAndDeletedDateIsNull(courseId).orElse(null);
        if (Objects.isNull(course)) {
            throw new RuntimeException("This course was deleted");
        }

        return modelMapper.map(course, CourseDTO.class);
    }

    public List<CourseDTO> getAllCourses () {
        return courseRepository.findAllByDeletedDateIsNull().stream().map(course ->
                modelMapper.map(course, CourseDTO.class)).toList();
    }
}
