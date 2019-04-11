package nl.hva.smallo.smalleducator.student.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Chat {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ChatEntry> messages = new ArrayList<ChatEntry>();

    public Chat() {
    }

    public UUID getId() {
        return id;
    }

    public List<ChatEntry> getMessages() {
        return messages;
    }

    public boolean addMessage(String sender, String message) {
        return messages.add(new ChatEntry(sender, message));
    }

}