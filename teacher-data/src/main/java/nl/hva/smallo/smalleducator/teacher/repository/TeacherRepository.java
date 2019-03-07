package nl.hva.smallo.smalleducator.teacher.repository;

import nl.hva.smallo.smalleducator.teacher.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, UUID> {

}
