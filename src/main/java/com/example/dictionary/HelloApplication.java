package com.example.dictionary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application {
    public Pane create() {

        HashmapDictionary dict = new HashmapDictionary();

        Pane root = new Pane();
        root.setPrefSize(600, 600);
        TextField t1 = new TextField();
        Label meaningLabel = new Label("word");
        Button b1 = new Button("Search");
        b1.setTranslateY(180);
        b1.setTranslateX(50);
        t1.setTranslateY(150);
        t1.setTranslateX(50);
        meaningLabel.setTranslateX(50);
        meaningLabel.setTranslateY(200);
        b1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent actionEvent) {
                String word = t1.getText();
                if (word.isBlank()) {
                    meaningLabel.setText("Please enter a wod");
                } else {
                    meaningLabel.setText(dict.find(word));
                }
                System.out.println("hai");
            }
        });
        root.getChildren().addAll(t1, b1, meaningLabel);
        return root;
    }

public void connetToDatabase()
{

}@Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(create(), 500, 500);
        connetToDatabase();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}