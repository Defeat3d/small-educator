package nl.hva.smallo.smalleducator.student.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Course {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;

    private String name;

    @OneToMany(cascade = CascadeType.MERGE)
    private Set<Lesson> lessons = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE)
    private Set<CourseCode> codes = new HashSet<>();

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public Set<CourseCode> getCodes() {
        return codes;
    }

}
