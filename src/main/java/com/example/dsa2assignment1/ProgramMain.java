package com.example.dsa2assignment1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProgramMain extends Application {

    public void start(Stage stage)
    {
        StackImplementation stackImp = new StackImplementation();
        Scene scene = new Scene(stackImp, 450, 150);

        stage.setTitle("Stack Assignment");
        stage.setScene(scene);
        stage.show();
    }
}
