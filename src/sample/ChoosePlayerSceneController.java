package sample;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author L-LHora
 */
public class ChoosePlayerSceneController implements Initializable {

   @FXML
    private Button button1;

    @FXML
    private Label label;

    @FXML
    void handleButtonAction(ActionEvent event) {
         try{
             FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("playerName.fxml"));
             Parent root1 = (Parent) fxmlLoader1.load();
             Stage stage1 = new Stage();
             stage1.setScene(new Scene(root1));
             stage1.initModality(Modality.APPLICATION_MODAL);
             stage1.initOwner(button1.getScene().getWindow());
             stage1.showAndWait();

         } catch (IOException ex) {
           Logger.getLogger(ChoosePlayerSceneController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
