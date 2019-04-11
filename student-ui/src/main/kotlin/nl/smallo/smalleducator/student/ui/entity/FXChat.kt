package nl.smallo.smalleducator.student.ui.entity

import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ListChangeListener
import javafx.collections.ObservableList
import khttp.post
import nl.hva.smallo.smalleducator.student.entity.Chat
import nl.hva.smallo.smalleducator.student.entity.ChatEntry
import nl.smallo.smalleducator.student.ui.DelegateProperties
import nl.smallo.smalleducator.student.ui.Main.Companion.HOST
import nl.smallo.smalleducator.student.ui.Main.Companion.gson
import java.net.URLEncoder
import java.util.*

class FXChat(chat: Chat) : Chat(), DelegateProperties {

    val idProperty = SimpleObjectProperty<UUID>(chat.id)
    private val _id by idProperty
    override fun getId(): UUID = _id

    private val _messages = FXCollections.observableList<FXEntry>(chat.messages.map { FXEntry(it) })
    override fun getMessages(): ObservableList<FXEntry> = _messages

    init {
        messages.addListener { change: ListChangeListener.Change<out FXEntry> ->
            change.next()
            val req = post("$HOST$CHATS_ENDPOINT/by-id/$id/${URLEncoder.encode(change.addedSubList[0].sender, "UTF-8")}/${URLEncoder.encode(change.addedSubList[0].message, "UTF-8")}")
            val res = gson.fromJson(req.text, Chat::class.java).also { println(it.id) }
            messages += res.messages.map { FXEntry(it) }.filter { it !in messages }
        }
    }

    fun sendMessage(sender: String, message: String) {
        messages += FXEntry(ChatEntry(sender, message))
    }

    companion object {

        const val CHATS_ENDPOINT = "/chats"

    }

}

class FXEntry(entry: ChatEntry) : ChatEntry(), DelegateProperties {

    val idProperty = SimpleObjectProperty<UUID>(entry.id)
    private val _id by idProperty
    override fun getId(): UUID = _id

    val senderProperty = SimpleStringProperty(entry.sender)
    private val _sender by senderProperty
    override fun getSender(): String = _sender

    val messageProperty = SimpleStringProperty(entry.message)
    private val _message by messageProperty
    override fun getMessage(): String = _message

    override fun equals(other: Any?): Boolean {
        if (other is FXEntry) {
            return other.id == id
        }
        return super.equals(other)
    }

}
