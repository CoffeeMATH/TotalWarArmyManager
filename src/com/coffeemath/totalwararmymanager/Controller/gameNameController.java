/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffeemath.totalwararmymanager.Controller;

import com.coffeemath.totalwararmymanager.Controller.TestModels.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author L-LHora
 */
public class gameNameController {
    @FXML private TextArea gameField;
    @FXML
    private void addTheGame(ActionEvent event){
        ChoosePlayerSceneController.playerScroll.getCursor().getGames().getItems().add(new Game(gameField.getText()));
        ((Stage)gameField.getScene().getWindow()).close();
    }
    
}
