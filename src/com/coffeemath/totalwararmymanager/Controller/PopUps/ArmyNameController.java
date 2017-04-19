package com.coffeemath.totalwararmymanager.Controller.PopUps;

import com.coffeemath.totalwararmymanager.Controller.ChooseArmySceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ArmyNameController implements Initializable {
    @FXML private TextArea armyField;
    @FXML private TextArea genField;
    @FXML private RadioButton landOption;
    @FXML private RadioButton navalOption;
    private ToggleGroup toggleGroup = new ToggleGroup();
    @FXML private void addTheArmy(ActionEvent event){
        String terrain = ((RadioButton)toggleGroup.getSelectedToggle()).getText();
        int ttype;
        if(terrain.equals("Land")) ttype = 0;
        else ttype = 1;
        ChooseArmySceneController.armyScroll.addArmy(armyField.getText(),ttype,genField.getText());
        ((Stage)armyField.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        landOption.setToggleGroup(toggleGroup);
        navalOption.setToggleGroup(toggleGroup);
        landOption.setSelected(true);
    }
}
