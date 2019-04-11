package nl.smallo.smalleducator.student.ui

import com.google.gson.GsonBuilder
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class Main : Application() {

    override fun start(primaryStage: Stage) {
        stage = primaryStage
        stage.title = "SmallEducator by Koen Deubel, 500761121"

        stage.scene = Scene(LoginScene(), 1000.0, 800.0)
        stage.show()
    }

    companion object {

        const val HOST = "http://localhost:8001"

        val gson = GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create()

        lateinit var stage: Stage

    }

}

fun main() = Application.launch(Main::class.java)