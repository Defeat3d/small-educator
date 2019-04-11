package nl.hva.smallo.smalleducator.student.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;

    @OneToOne(cascade = CascadeType.MERGE)
    private Chat chat;

    public Lesson() {
        this.chat = new Chat();
    }

    public UUID getId() {
        return id;
    }

    public Chat getChat() {
        return chat;
    }

}
