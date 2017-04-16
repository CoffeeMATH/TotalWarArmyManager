/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffeemath.totalwararmymanager.Controller.PopUps;

import java.net.URL;
import java.util.ResourceBundle;

import com.coffeemath.totalwararmymanager.Controller.ChoosePlayerSceneController;
import com.coffeemath.totalwararmymanager.Controller.TestModels.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author L-LHora
 */
public class PlayerNameController implements Initializable {
    @FXML private TextArea nameField;
    @FXML private AnchorPane window;
    @FXML private Button addButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addButton.setOnAction(e -> submit());
        nameField.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER) submit();
        });
    }
    private void submit(){
        ChoosePlayerSceneController.playerScroll.getItems().add(new Player(nameField.getText()));
        ((Stage)window.getScene().getWindow()).close();
    }
}
