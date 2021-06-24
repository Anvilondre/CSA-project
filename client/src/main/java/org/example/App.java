package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("authorization"));
        this.stage = stage;
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void goToWarehouse(String login, String password) throws IOException {
        System.out.println(login + " " + password);
        stage.setResizable(true);
        scene.setRoot(loadFXML("warehouse"));
        stage.setScene(new Scene(loadFXML("warehouse")));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}