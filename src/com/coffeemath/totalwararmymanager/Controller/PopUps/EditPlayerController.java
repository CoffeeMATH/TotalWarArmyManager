package com.coffeemath.totalwararmymanager.Controller.PopUps;

import com.coffeemath.totalwararmymanager.Controller.ChoosePlayerSceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * Created by Alcoseba on 4/13/2017.
 */
public class EditPlayerController {
    @FXML private TextArea nameField;
    @FXML private void editThePlayer(ActionEvent event){
        ChoosePlayerSceneController.playerScroll.updatePlayer(ChoosePlayerSceneController.playerScroll.
                        PlayerList.indexOf(ChoosePlayerSceneController.playerScroll.PCursor),
                        nameField.getText()
                );
        ((Stage)nameField.getScene().getWindow()).close();
    }
}
