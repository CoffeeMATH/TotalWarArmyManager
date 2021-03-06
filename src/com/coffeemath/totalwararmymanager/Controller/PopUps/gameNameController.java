/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffeemath.totalwararmymanager.Controller.PopUps;

import com.coffeemath.totalwararmymanager.Controller.ChooseGameSceneController;
import com.coffeemath.totalwararmymanager.Controller.ChoosePlayerSceneController;
import com.coffeemath.totalwararmymanager.Controller.TestModels.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * FXML Controller class
 *
 * @author L-LHora
 */
public class gameNameController implements Initializable {
    @FXML private TextArea gameField;
    @FXML private Button addGame;
    @FXML private ChoiceBox<String> factions;
    @FXML
    private void submit(){
        ChooseGameSceneController.gameScroll.addGame(gameField.getText(),factions.getSelectionModel().getSelectedItem());
        ((Stage)gameField.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> factionList = FXCollections.observableArrayList("Rome","Carthage","Macedon");
        factions.setItems(factionList);
        factions.getSelectionModel().selectFirst();
        addGame.setOnAction(e -> submit());
        gameField.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER) submit();
        });
    }
}