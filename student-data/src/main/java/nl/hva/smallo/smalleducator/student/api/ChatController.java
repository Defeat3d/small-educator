package nl.hva.smallo.smalleducator.student.api;

import nl.hva.smallo.smalleducator.student.entity.Chat;
import nl.hva.smallo.smalleducator.student.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController("chats")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    @PostMapping(path = {"chats/by-id/{id}/{sender}/{message}"})
    public Chat sendMessage(@PathVariable String id, @PathVariable String sender, @PathVariable String message) {
        final Optional<Chat> optionalChat = chatRepository.findById(UUID.fromString(id));
        if (!optionalChat.isPresent()) {
            return null;
        }
        final Chat chat = optionalChat.get();
        if (chat.addMessage(sender, message)) {
            return chatRepository.save(chat);
        }
        return null;
    }

    @GetMapping(path = {"chats/by-id/{id}"})
    public Chat getChat(@PathVariable String id) {
        return chatRepository.findById(UUID.fromString(id)).orElse(null);
    }

}
