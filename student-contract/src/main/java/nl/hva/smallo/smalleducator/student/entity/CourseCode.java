package nl.hva.smallo.smalleducator.student.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Random;
import java.util.UUID;

@Entity
public class CourseCode {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Student student;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Course course;

    private String code = String.format("%08d", new Random().nextInt(100000000));

    public CourseCode() {

    }

    public CourseCode(Course course, Student student, String code) {
        this.student = student;
        this.course = course;
        this.code = code;
    }

    public UUID getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getCode() {
        return code;
    }

}
