package com.coffeemath.totalwararmymanager.Controller;

import com.coffeemath.totalwararmymanager.Controller.TestModels.Unit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ArmyDetailsScene implements Initializable {
    @FXML private VBox root;
    @FXML private Label playerLabel;
    @FXML private Label gameLabel;
    @FXML private Label armyLabel;
    @FXML private Label genName;
    @FXML private Label UCLabel;
    @FXML private Label RCLabel;
    @FXML private TableView<Unit> units;
    @FXML private Button addBtn;
    @FXML private Button backBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
