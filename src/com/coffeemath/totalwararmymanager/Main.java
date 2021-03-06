package com.coffeemath.totalwararmymanager;

import com.coffeemath.totalwararmymanager.Controller.TestModels.Player;
import com.coffeemath.totalwararmymanager.Controller.TestModels.Scroll;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.Functions;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private Functions functions = new Functions();
    @Override
    public void start(Stage primaryStage) throws Exception {
        functions.openNewWindow(primaryStage,"Total War Army Manager","View/Scenes/MainScenes/FXMLDocument.fxml");
    }
    public static void main(String[] args) {
        launch(args);
    }
}
