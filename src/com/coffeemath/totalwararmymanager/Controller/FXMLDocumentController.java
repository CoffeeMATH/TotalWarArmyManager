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
    @FXML
    private ImageView image;

    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        Stage stage; 
        Parent root;
        if(event.getSource()==button){
           //get reference to the button's stage         
           stage=(Stage) button.getScene().getWindow();
           //load up OTHER FXML document
     root = FXMLLoader.load(getClass().getResource("View/choosePlayerScene.fxml"));
        //create a new scene with root and set the stage
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
       }

    
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // image.setImage(new Image ("/average.png"));
    }
}