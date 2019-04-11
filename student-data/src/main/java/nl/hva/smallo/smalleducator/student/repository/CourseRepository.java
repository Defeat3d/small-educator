package nl.hva.smallo.smalleducator.student.repository;

import nl.hva.smallo.smalleducator.student.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CourseRepository extends CrudRepository<Course, UUID> {

    Iterable<Course> findAllByCodes(String... codes);

}
