package nl.hva.smallo.smalleducator.teacher.api;

import nl.hva.smallo.smalleducator.teacher.entity.Teacher;
import nl.hva.smallo.smalleducator.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController("teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping
    public Teacher registerTeacher() {
        return teacherRepository.save(new Teacher());
    }

    @GetMapping
    public Iterable<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping(path = {"/by-id/{id}"})
    public Teacher getTeacher(@PathVariable String id) {
        return teacherRepository.findById(UUID.fromString(id)).orElse(null);
    }

}
