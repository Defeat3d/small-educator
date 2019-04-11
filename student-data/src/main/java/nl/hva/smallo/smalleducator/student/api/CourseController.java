package nl.hva.smallo.smalleducator.student.api;

import nl.hva.smallo.smalleducator.student.entity.Course;
import nl.hva.smallo.smalleducator.student.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(path = {"courses"})
    public Iterable<Course> getCourses() {
        return courseRepository.findAll();
    }

    @GetMapping(path = {"courses/by-codes/{codes}"})
    public Iterable<Course> getCoursesByCodes(@PathVariable String[] codes) {
        return courseRepository.findAllByCodes(codes);
    }

}
