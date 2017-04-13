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
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author L-LHora
 */
public class PlayerNameController {
    @FXML private TextArea nameField;
    @FXML private AnchorPane window;

    @FXML
    public void addThePlayer(ActionEvent event){
        ChoosePlayerSceneController.playerScroll.getItems().add(new Player(nameField.getText()));
        ((Stage)window.getScene().getWindow()).close();
    }
}
