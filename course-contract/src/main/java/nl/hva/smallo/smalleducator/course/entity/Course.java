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
public class Course {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;

    @OneToMany
    private Set<Lesson> lessons;

    @OneToMany
    private Set<CourseCode> codes;

    public UUID getId() {
        return id;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public Set<CourseCode> getCodes() {
        return codes;
    }

}
