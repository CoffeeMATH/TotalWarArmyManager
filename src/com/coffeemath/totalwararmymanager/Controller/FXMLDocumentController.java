/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffeemath.totalwararmymanager.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.*;
import java.lang.*;
/**
 *
 * @author L-LHora
 */
public class FXMLDocumentController implements Initializable {
    Functions functions = new Functions();
    @FXML
    private ImageView image;

    @FXML
    private Button button;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        Stage stage; 
        Parent root;
        if(event.getSource()==button){
            functions.goToScene((Stage)button.getScene().getWindow(),"../View/choosePlayerScene.fxml");
       }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // image.setImage(new Image ("/average.png"));
    }
}