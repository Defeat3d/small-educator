package nl.hva.smallo.smalleducator.course.entity;

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

    @ManyToOne
    private Course course;

    @OneToOne
    private Chat chat;

    public UUID getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public Chat getChat() {
        return chat;
    }

}
