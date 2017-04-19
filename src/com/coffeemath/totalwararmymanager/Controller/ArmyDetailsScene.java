package com.coffeemath.totalwararmymanager.Controller;

import com.coffeemath.totalwararmymanager.Controller.Toolkit.Functions;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicAction;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicColumn;
import com.coffeemath.totalwararmymanager.Models.Army;
import com.coffeemath.totalwararmymanager.Models.Unit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ArmyDetailsScene implements Initializable {

    /** Load UI Elements from FXML **/
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

    /** Load Database List **/
    private Army stillCursor;

    /** Column Functions **/
    private Functions functions = new Functions();
    private GraphicAction<Unit> unitCol_c = item -> new Label(item.getName());
    private GraphicAction<Unit> ucPercentageCol_c = item -> new Label(String.valueOf(item.u_UCost));
    private GraphicAction<Unit> rcPercentageCol_c = item -> new Label(String.valueOf(item.u_RCost));
    private GraphicAction<Unit> delCol_c = item -> functions.activatedButton("Delete", e -> stillCursor.deleteUnit(item.getName()));
    /** Presentation **/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stillCursor = ChooseArmySceneController.armyScroll.ACursor;
        playerLabel.setText(ChoosePlayerSceneController.playerScroll.PCursor.getName());
        gameLabel.setText(ChooseGameSceneController.gameScroll.GCursor.getName());
        armyLabel.setText(ChooseArmySceneController.armyScroll.ACursor.getName());
        GraphicColumn<Unit,Unit> unitCol = new GraphicColumn<>("unit", unitCol_c);
        GraphicColumn<Unit,Unit> delCol = new GraphicColumn<>("unit",  rcPercentageCol_c);

        addBtn.setOnAction(e -> functions.openNewWindow("Add Unit",""));
        backBtn.setOnAction(e -> functions.goToScene(backBtn,"View/Scenes/MainScenes/chooseArmyScene.fxml"));
    }
}
