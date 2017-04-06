/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffeemath.totalwararmymanager.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.coffeemath.totalwararmymanager.Controller.TestModels.Lists;
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
public class PlayerNameController implements Initializable {
    @FXML private TextArea nameField;
    @FXML private AnchorPane window;

    @FXML
    public void addThePlayer(ActionEvent event){
        Lists.Players.add(new Player(nameField.getText()));
        ((Stage)window.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
