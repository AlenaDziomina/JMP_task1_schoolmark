package com.grouk.task1;

import com.grouk.task1.util.SceneLoader;
import javafx.application.Application;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application {

    private final static String MAIN_FXML = "/com/grouk/task1/fxml/main.fxml";
    private final static String RESOURCE_NAME = "uiResource";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL source = getClass().getResource(MAIN_FXML);
        ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME);
        String title = resourceBundle.getString("main.title");

        SceneLoader.loadScene(source, primaryStage, title, resourceBundle);
    }
}
