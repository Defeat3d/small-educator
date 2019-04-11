package nl.smallo.smalleducator.student.ui

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import nl.hva.smallo.smalleducator.student.entity.Student
import nl.smallo.smalleducator.student.ui.Main.Companion.HOST
import nl.smallo.smalleducator.student.ui.Main.Companion.gson
import nl.smallo.smalleducator.student.ui.Main.Companion.stage
import nl.smallo.smalleducator.student.ui.entity.FXStudent
import java.net.URL

class LoginScene : VBox() {

    @FXML
    private lateinit var emailField: TextField
    @FXML
    private lateinit var passwordField: PasswordField

    init {
        FXMLLoader(javaClass.getResource("/fxml/login.fxml")).apply {
            setRoot(this@LoginScene)
            setController(this@LoginScene)
            load()
        }
    }

    @FXML
    private fun login() {
        val student = gson.fromJson(URL("$HOST/login/${emailField.text}/${passwordField.text}").readText(), Student::class.java)
        if (student?.id == null) {
            // error
            return
        }
        stage.scene.root = MainScene(FXStudent(student))
    }

}