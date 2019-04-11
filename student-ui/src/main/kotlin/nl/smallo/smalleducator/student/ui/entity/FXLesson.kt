package nl.smallo.smalleducator.student.ui.entity

import javafx.beans.property.SimpleObjectProperty
import nl.hva.smallo.smalleducator.student.entity.Lesson
import nl.smallo.smalleducator.student.ui.DelegateProperties
import java.util.*

class FXLesson(lesson: Lesson) : Lesson(), DelegateProperties {

    val idProperty = SimpleObjectProperty<UUID>(lesson.id)
    private val _id by idProperty
    override fun getId(): UUID = _id

    val chatProperty = SimpleObjectProperty<FXChat>(FXChat(lesson.chat))
    private val _chat by chatProperty
    override fun getChat(): FXChat = _chat

}