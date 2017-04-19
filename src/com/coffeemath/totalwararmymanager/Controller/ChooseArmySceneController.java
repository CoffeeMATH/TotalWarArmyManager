package com.coffeemath.totalwararmymanager.Controller;

import com.coffeemath.totalwararmymanager.Controller.Toolkit.Functions;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicAction;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicColumn;
import com.coffeemath.totalwararmymanager.Models.Armies;
import com.coffeemath.totalwararmymanager.Models.Army;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Alcoseba on 4/13/2017.
 */
public class ChooseArmySceneController implements Initializable {

    /** Load UI Elements from FXML **/
    @FXML private VBox root;
    @FXML private TableView<Army> armies;
    @FXML private Button addBtn;
    @FXML private Button backBtn;
    @FXML private Label playerLabel;
    @FXML private Label gameLabel;

    /** Load Database List **/
    public static Armies armyScroll;

    /** Column Functions **/
    private Functions functions = new Functions();
    private GraphicAction<Army> armyCell = item -> functions.activatedButton(item.getName(),e -> {
        armyScroll.ACursor = item;
        functions.goToScene(armies,"View/Scenes/MainScenes/armyDetailsScene.fxml");
    });
    private GraphicAction<Army> delCell = item -> functions.activatedButton("Delete",e -> armyScroll.deleteArmy(armyScroll.ArmyList.indexOf(item)));
    //private GraphicAction<String> typeCell = item -> {Label l = new Label(); l.setText(item); return l;};
    //private GraphicAction<String> genCell = item -> {Label l = new Label(); l.setText(item); return l;};

    /** Presentation **/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        armyScroll = ChooseGameSceneController.gameScroll.GCursor.g_armies;
        armies.setItems(armyScroll.ArmyList);
        playerLabel.setText(ChoosePlayerSceneController.playerScroll.PCursor.getName());
        gameLabel.setText(ChooseGameSceneController.gameScroll.GCursor.getName());
        GraphicColumn<Army,Army> armyCol = new GraphicColumn<>("army",armyCell);
        //GraphicColumn<Army,String> typeCol =  new GraphicColumn<>("type",typeCell);
        //GraphicColumn<Army,String> genCol =  new GraphicColumn<>("genName",genCell);
        GraphicColumn<Army,Army> delCol = new GraphicColumn<>("army",delCell);
        armyCol.prefWidthProperty().bind(armies.widthProperty().multiply(0.6));
        //genCol.prefWidthProperty().bind(armies.widthProperty().multiply(0.3));
       // typeCol.prefWidthProperty().bind(armies.widthProperty().multiply(0.15));
        delCol.prefWidthProperty().bind(armies.widthProperty().multiply(0.4));
        armies.getColumns().addAll(armyCol,delCol);
        addBtn.setOnAction(e -> functions.openNewWindow("Add Army","View/Scenes/CreateScenes/armyName.fxml"));
        backBtn.setOnAction(e -> functions.goToScene(backBtn,"View/Scenes/MainScenes/chooseGameScene.fxml"));
    }
}