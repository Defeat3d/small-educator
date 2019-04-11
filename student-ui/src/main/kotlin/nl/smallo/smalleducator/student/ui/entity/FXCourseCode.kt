package nl.smallo.smalleducator.student.ui.entity

import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import nl.hva.smallo.smalleducator.student.entity.CourseCode
import nl.smallo.smalleducator.student.ui.DelegateProperties

class FXCourseCode(courseCode: CourseCode) : CourseCode(), DelegateProperties {

    val studentProperty = SimpleObjectProperty<FXStudent>(FXStudent(courseCode.student))
    private val _student by studentProperty
    override fun getStudent(): FXStudent = _student

    val courseProperty = SimpleObjectProperty<FXCourse>(FXCourse(courseCode.course))
    private val _course by courseProperty
    override fun getCourse(): FXCourse = _course

    val codeProperty = SimpleStringProperty(courseCode.code)
    private val _code by codeProperty
    override fun getCode(): String = _code

}