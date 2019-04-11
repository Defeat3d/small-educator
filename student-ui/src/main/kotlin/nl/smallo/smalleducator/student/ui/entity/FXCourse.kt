package nl.smallo.smalleducator.student.ui.entity

import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableSet
import nl.hva.smallo.smalleducator.student.entity.Course
import nl.smallo.smalleducator.student.ui.DelegateProperties
import java.util.*

class FXCourse(course: Course) : Course(), DelegateProperties {

    val idProperty = SimpleObjectProperty<UUID>(course.id)
    private val _id by idProperty
    override fun getId(): UUID = _id

    val nameProperty = SimpleStringProperty(course.name)
    private val _name by nameProperty
    override fun getName(): String = _name

    private val _lessons = FXCollections.observableSet(course.lessons.map { FXLesson(it) }.toSet())
    override fun getLessons(): ObservableSet<FXLesson> = _lessons

    private val _codes = FXCollections.observableSet(course.codes.map { FXCourseCode(it) }.toSet())
    override fun getCodes(): ObservableSet<FXCourseCode> = _codes

}