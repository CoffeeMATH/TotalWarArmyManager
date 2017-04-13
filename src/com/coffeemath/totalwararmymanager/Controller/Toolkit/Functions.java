package com.coffeemath.totalwararmymanager.Controller.Toolkit;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by jqalc on 4/5/17.
 */
public class Functions {
    public void openNewWindow(String title, String path){
        openNewWindow(new Stage(),title,path);
    }
    public void openNewWindow(Stage stage,String title,String path){loadWindow(stage,title,path).show();}

    public void openTemporaryWindow(String title, String path) {openTemporaryWindow(new Stage(),title,path);}
    private void openTemporaryWindow(Stage stage, String title, String path){loadWindow(stage,title,path).showAndWait();}
    public void goToScene(Node ob, String path){
        ((Stage)ob.getScene().getWindow()).setScene(new Scene(loadPath(path)));
    }
    public Button activatedButton(String label, EventHandler<ActionEvent> buttonAction){
        Button button = new Button(label);
        button.setOnAction(buttonAction);
        return button;
    }
    private Stage loadWindow(Stage stage, String title, String path){
        stage.setTitle(title);
        stage.setScene(new Scene(loadPath(path)));
        return stage;
    }
    private Parent loadPath(String path){
        try {
            return FXMLLoader.load(getClass().getResource("../../"+path));
        }
        catch(IOException error){error.printStackTrace(); return null;}
    }
}
