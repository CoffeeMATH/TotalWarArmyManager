package com.coffeemath.totalwararmymanager.Controller;

import com.coffeemath.totalwararmymanager.Controller.Toolkit.Functions;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicAction;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicColumn;
import com.coffeemath.totalwararmymanager.Models.Army;
import com.coffeemath.totalwararmymanager.Models.Unit;
import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
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
    public static Army stillCursor;

    /** Column Functions **/
    private Functions functions = new Functions();
    private GraphicAction<Unit> unitCol_c = item -> new Label(item.getName());
    private GraphicAction<Unit> ucPercentageCol_c = item -> new Label(String.valueOf(item.u_UCost));
    private GraphicAction<Unit> rcPercentageCol_c = item -> new Label(String.valueOf(item.u_RCost));
    private GraphicAction<Unit> delCol_c = item -> functions.activatedButton("Delete", e -> {stillCursor.deleteUnit(stillCursor.a_units.indexOf(item)); units.refresh();});

    /** Presentation **/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stillCursor = ChooseArmySceneController.armyScroll.ACursor;
        units.setItems(stillCursor.a_units);
        stillCursor.a_units.addListener(new ListChangeListener<Unit>() {
            @Override
            public void onChanged(Change<? extends Unit> c) {
                while(c.next()) units.refresh();
            }
        });
        playerLabel.setText(ChoosePlayerSceneController.playerScroll.PCursor.getName());
        gameLabel.setText(ChooseGameSceneController.gameScroll.GCursor.getName());
        armyLabel.setText(stillCursor.getName());
        genName.setText(stillCursor.leader_name);
        UCLabel.textProperty().bind(stillCursor.totalUCProperty().asString());
        RCLabel.textProperty().bind(stillCursor.totalRCProperty().asString());
        GraphicColumn<Unit,Unit> unitCol = new GraphicColumn<>("unit", unitCol_c);
        GraphicColumn<Unit,Unit> delCol = new GraphicColumn<>("unit",  delCol_c);
        GraphicColumn<Unit,Unit> ucCol = new GraphicColumn<>("unit",ucPercentageCol_c);
        GraphicColumn<Unit,Unit> rcCol = new GraphicColumn<>("unit",rcPercentageCol_c);
        unitCol.prefWidthProperty().bind(units.widthProperty().multiply(0.5));
        ucCol.prefWidthProperty().bind(units.widthProperty().multiply(0.15));
        rcCol.prefWidthProperty().bind(units.widthProperty().multiply(0.15));
        delCol.prefWidthProperty().bind(units.widthProperty().multiply(0.2));
        units.getColumns().addAll(unitCol,ucCol,rcCol,delCol);
        addBtn.setOnAction(e -> functions.openNewWindow("Add Unit","View/Scenes/CreateScenes/unitName.fxml"));
        backBtn.setOnAction(e -> functions.goToScene(backBtn,"View/Scenes/MainScenes/chooseArmyScene.fxml"));
    }
}
