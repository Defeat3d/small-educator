package nl.hva.smallo.smalleducator.student.repository;

import nl.hva.smallo.smalleducator.student.entity.CourseCode;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CourseCodeRepository extends CrudRepository<CourseCode, UUID> {
}
