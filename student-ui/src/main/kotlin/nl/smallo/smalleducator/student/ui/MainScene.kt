package nl.smallo.smalleducator.student.ui

import com.google.gson.reflect.TypeToken
import javafx.beans.property.SimpleObjectProperty
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Cursor
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.input.KeyCode
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.media.MediaView
import nl.hva.smallo.smalleducator.student.entity.Course
import nl.smallo.smalleducator.student.ui.Main.Companion.gson
import nl.smallo.smalleducator.student.ui.Main.Companion.stage
import nl.smallo.smalleducator.student.ui.entity.FXChat
import nl.smallo.smalleducator.student.ui.entity.FXCourse
import nl.smallo.smalleducator.student.ui.entity.FXLesson
import nl.smallo.smalleducator.student.ui.entity.FXStudent
import java.net.URL
import java.util.*

class MainScene(private val student: FXStudent) : VBox(), Initializable, DelegateProperties {

    @FXML
    private lateinit var nameField: Label
    @FXML
    private lateinit var courseBox: VBox
    @FXML
    private lateinit var mediaView: MediaView
    @FXML
    private lateinit var contextArea: TextArea
    @FXML
    private lateinit var chatBox: VBox
    @FXML
    private lateinit var chatField: TextField

    private val selectedCourseProperty = SimpleObjectProperty<FXCourse?>()
    private var selectedCourse by selectedCourseProperty
    private val selectedLessonProperty = SimpleObjectProperty<FXLesson?>()
    private var selectedLesson by selectedLessonProperty
    private val chatProperty = SimpleObjectProperty<FXChat?>()
    private var chat by chatProperty

    init {
        FXMLLoader(javaClass.getResource("/fxml/main.fxml")).apply {
            setRoot(this@MainScene)
            setController(this@MainScene)
            load()
        }
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        nameField.textProperty().bind(student.nameProperty)
        selectedLessonProperty.addListener { _, _, new ->
            chat = new?.chat
        }
        chatField.setOnKeyPressed {
            if (it.code == KeyCode.ENTER && chat != null) {
                chat?.sendMessage(student.name, chatField.text)
                chatField.clear()
            }
        }
        val courses = loadCourses().map { FXCourse(it) }.also {
            it.forEach { course -> courseBox.children += course.selectionHBox() }
        }
        selectedCourse = courses.firstOrNull()
        selectedLesson = selectedCourse?.lessons?.firstOrNull()
    }

    @FXML
    private fun logout() {
        stage.scene.root = LoginScene()
    }

    private fun FXCourse.selectionHBox(): HBox {
        val hBox = HBox(10.0)
        hBox.children += Label("-").apply {
            hoverProperty().addListener { _, _, new ->
                cursor = if (new) Cursor.HAND else Cursor.DEFAULT
            }
            setOnMouseClicked {
                courseBox.children -= hBox
            }
        }
        hBox.children += Label(this.name).apply {
            setOnMouseClicked {
                selectedCourse = this@selectionHBox
            }
        }
        return hBox
    }

    private fun loadCourses(): List<Course> = gson.fromJson<List<Course>>(URL("${Main.HOST}/courses").readText(), object : TypeToken<List<Course>>() {}.type)

}