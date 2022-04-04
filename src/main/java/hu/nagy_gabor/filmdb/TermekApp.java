package hu.nagy_gabor.filmdb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TermekApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TermekApp.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 540, 400);
        stage.setTitle("TermekDb");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}