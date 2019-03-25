package nl.hva.smallo.smalleducator.course.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;

@Entity
public class Chat {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;

    @OneToMany
    private Set<Entry> messages;

    public UUID getId() {
        return id;
    }

    public Set<Entry> getMessages() {
        return messages;
    }

    @Entity
    public class Entry {

        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        @Type(type = "uuid-char")
        private UUID id;

        private String sender;

        private String message;

        public UUID getId() {
            return id;
        }

        public String getSender() {
            return sender;
        }

        public String getMessage() {
            return message;
        }


    }

}
