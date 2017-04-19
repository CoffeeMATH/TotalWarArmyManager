package com.coffeemath.totalwararmymanager.Controller.PopUps.Warnings;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by Alcoseba on 4/19/2017.
 */
public class UnitsFullController {
    @FXML private Label handle;
    @FXML
    private void close(){
        ((Stage)handle.getScene().getWindow()).close();
    }
}
