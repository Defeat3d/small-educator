package nl.hva.smallo.smalleducator.course.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Random;

@Entity
public class CourseCode {

    private final String code = String.format("%08d", new Random().nextInt(100000000));
    @ManyToOne
    @JoinColumn
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public String getCode() {
        return code;
    }

}
