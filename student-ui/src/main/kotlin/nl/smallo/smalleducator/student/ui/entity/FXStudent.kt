package nl.smallo.smalleducator.student.ui.entity

import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableSet
import nl.hva.smallo.smalleducator.student.entity.Student
import nl.smallo.smalleducator.student.ui.DelegateProperties
import java.util.*

class FXStudent(student: Student) : Student(), DelegateProperties {

    val idProperty = SimpleObjectProperty<UUID>(student.id)
    private val _id by idProperty
    override fun getId(): UUID = _id

    val nameProperty = SimpleStringProperty(student.name)
    private val _name by nameProperty
    override fun getName(): String = _name

    val emailProperty = SimpleStringProperty(student.email)
    private val _email by emailProperty
    override fun getEmail(): String = _email

    val passwordProperty = SimpleStringProperty(student.password)
    private val _password by passwordProperty
    override fun getPassword(): String = _password

    private val _courseCodes = FXCollections.observableSet<FXCourseCode>(student.courseCodes.map { FXCourseCode(it) }.toSet())
    override fun getCourseCodes(): ObservableSet<FXCourseCode> = _courseCodes

}