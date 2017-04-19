/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffeemath.totalwararmymanager.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.coffeemath.totalwararmymanager.Controller.Toolkit.Functions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.lang.*;
/**
 *
 * @author L-LHora
 */
public class FXMLDocumentController implements Initializable {
    Functions functions = new Functions();
    @FXML private Pane parent;
    @FXML private Button button;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        if(event.getSource()==button){
            functions.goToScene(button,"View/Scenes/MainScenes/choosePlayerScene.fxml");
       }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        functions.fix(parent,600,400);
        button.layoutXProperty().bind(parent.widthProperty().subtract(button.getLayoutX()).multiply(0.46));
        button.layoutYProperty().bind(parent.heightProperty().subtract(button.getLayoutY()).multiply(0.7175));
    }
}