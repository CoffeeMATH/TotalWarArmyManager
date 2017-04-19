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

    /** Load Database List **/
    public static Armies armyScroll;

    /** Column Functions **/
    private Functions functions = new Functions();
    private GraphicAction<Army> armyCell = item -> functions.activatedButton(item.getName(),e -> {
        armyScroll.ACursor = item;
        functions.goToScene(armies,"View/Scenes/MainScenes/armyDetailsScene.fxml");
    });
    private GraphicAction<Army> delCell = item -> functions.activatedButton("Delete",e -> armyScroll.deleteArmy(armyScroll.ArmyList.indexOf(item)));
    private GraphicAction<Army> UCCell = item -> new Label(String.valueOf(item.getTotalUC()));
    private GraphicAction<Army> RCCell = item -> new Label(String.valueOf(item.getTotalRC()));

    /** Presentation **/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        functions.fix(root,600,400);
        armyScroll = ChooseGameSceneController.gameScroll.GCursor.g_armies;
        armies.prefHeightProperty().bind(root.heightProperty().multiply(0.925));
        armies.setItems(armyScroll.ArmyList);
        GraphicColumn<Army,Army> armyCol = new GraphicColumn<>("army",armyCell);
        GraphicColumn<Army,Army> delCol = new GraphicColumn<>("army",delCell);
        GraphicColumn<Army,Army> ucCol = new GraphicColumn<>("UC","army",UCCell);
        GraphicColumn<Army,Army> rcCol = new GraphicColumn<>("RC","army",RCCell);
        armyCol.prefWidthProperty().bind(armies.widthProperty().multiply(0.6));
        ucCol.prefWidthProperty().bind(armies.widthProperty().multiply(0.125));
        rcCol.prefWidthProperty().bind(ucCol.widthProperty());
        delCol.prefWidthProperty().bind(armies.widthProperty().multiply(0.15));
        armies.getColumns().addAll(armyCol,ucCol,rcCol,delCol);
        addBtn.setOnAction(e -> functions.openNewWindow("Add Army","View/Scenes/CreateScenes/armyName.fxml"));
        backBtn.setOnAction(e -> functions.goToScene(backBtn,"View/Scenes/MainScenes/chooseGameScene.fxml"));
    }
}