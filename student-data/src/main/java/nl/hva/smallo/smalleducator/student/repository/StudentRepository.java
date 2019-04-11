package nl.hva.smallo.smalleducator.student.repository;

import nl.hva.smallo.smalleducator.student.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends CrudRepository<Student, UUID> {

    Optional<Student> findByEmailAndPassword(String email, String password);

}
