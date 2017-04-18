package com.coffeemath.totalwararmymanager.Controller.PopUps;

import com.coffeemath.totalwararmymanager.Controller.ChooseGameSceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * Created by Alcoseba on 4/13/2017.
 */
public class EditGameController {
    @FXML private TextArea nameField;
    @FXML private void editTheGame(ActionEvent event){
        ChooseGameSceneController.gameScroll.updateGame(ChooseGameSceneController.gameScroll.
                GameList.indexOf(ChooseGameSceneController.gameScroll.GCursor),
                nameField.getText());
        ((Stage)nameField.getScene().getWindow()).close();
    }
}
