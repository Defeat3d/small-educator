package nl.hva.smallo.smalleducator.student.entity;

import nl.hva.smallo.smalleducator.course.entity.CourseCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;
import java.util.UUID;

@Entity
public class Student {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;

    private Set<CourseCode> courseCodes;

    public UUID getId() {
        return id;
    }

    public Set<CourseCode> getCourseCodes() {
        return courseCodes;
    }

}
