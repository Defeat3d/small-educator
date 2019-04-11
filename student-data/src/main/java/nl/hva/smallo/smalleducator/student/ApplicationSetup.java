package nl.hva.smallo.smalleducator.student;

import nl.hva.smallo.smalleducator.student.entity.Course;
import nl.hva.smallo.smalleducator.student.entity.CourseCode;
import nl.hva.smallo.smalleducator.student.entity.Lesson;
import nl.hva.smallo.smalleducator.student.entity.Student;
import nl.hva.smallo.smalleducator.student.repository.CourseCodeRepository;
import nl.hva.smallo.smalleducator.student.repository.CourseRepository;
import nl.hva.smallo.smalleducator.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationSetup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseCodeRepository courseCodeRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        studentRepository.save(new Student("Big O", "bigo@hva.nl", "bigopassword"));
        studentRepository.save(new Student("Small K", "koen.deubel@hva.nl", "koenpassword"));
        Course course = new Course("Architecture & Design");
        course = courseRepository.save(course);
        Lesson lesson = new Lesson();
        course.getLessons().add(lesson);
        Course course2 = courseRepository.save(course);
        studentRepository.findAll().forEach(s -> {
            courseCodeRepository.save(new CourseCode(course2, s, "88888888"));
            studentRepository.save(s);
        });
        courseRepository.save(course2);
    }

}