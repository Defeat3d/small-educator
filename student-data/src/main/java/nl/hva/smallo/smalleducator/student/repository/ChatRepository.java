package nl.hva.smallo.smalleducator.student.repository;


import nl.hva.smallo.smalleducator.student.entity.Chat;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ChatRepository extends CrudRepository<Chat, UUID> {
}
