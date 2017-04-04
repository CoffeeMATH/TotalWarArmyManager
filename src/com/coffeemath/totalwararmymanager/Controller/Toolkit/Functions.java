package com.coffeemath.totalwararmymanager.Controller.Toolkit;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by jqalc on 4/5/17.
 */
public class Functions {
    public void openNewWindow(String title, String path) throws IOException {
        openNewWindow(new Stage(),title,path);
    }
    public void openNewWindow(Stage stage,String title,String path) throws IOException{
        stage.setTitle(title);
        stage.setScene(new Scene(loadPath(path)));
        stage.show();
    }
    private Parent loadPath(String path) throws IOException{
        return FXMLLoader.load(getClass().getResource("../"+path));
    }
    public void goToScene(Stage currentWindow, String path) throws IOException{
        currentWindow.setScene(new Scene(loadPath(path)));
    }
}
