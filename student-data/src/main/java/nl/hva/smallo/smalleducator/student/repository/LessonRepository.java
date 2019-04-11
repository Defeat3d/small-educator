package nl.hva.smallo.smalleducator.student.repository;

import nl.hva.smallo.smalleducator.student.entity.Lesson;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LessonRepository extends CrudRepository<Lesson, UUID> {
}
