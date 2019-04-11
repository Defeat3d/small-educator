package nl.hva.smallo.smalleducator.student.api;

import nl.hva.smallo.smalleducator.student.entity.Student;
import nl.hva.smallo.smalleducator.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController("students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public Student registerStudent() {
        return studentRepository.save(new Student());
    }

    @GetMapping
    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path = {"/by-id/{id}"})
    public Student getStudent(@PathVariable String id) {
        return studentRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @GetMapping(path = {"/login/{email}/{password}"})
    public Student login(@PathVariable String email, @PathVariable String password) {
        return studentRepository.findByEmailAndPassword(email, password).orElse(null);
    }

}
