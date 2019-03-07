package nl.hva.smallo.smalleducator.mentor.repository;

import nl.hva.smallo.smalleducator.mentor.entity.Mentor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MentorRepository extends CrudRepository<Mentor, UUID> {

}
