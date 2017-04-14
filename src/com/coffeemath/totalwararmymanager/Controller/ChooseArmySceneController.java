package com.coffeemath.totalwararmymanager.Controller;

import com.coffeemath.totalwararmymanager.Controller.TestModels.Army;
import com.coffeemath.totalwararmymanager.Controller.TestModels.Scroll;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.Functions;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicAction;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicColumn;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Alcoseba on 4/13/2017.
 */
public class ChooseArmySceneController implements Initializable {
    @FXML private TableView<Army> armies;
    @FXML private Button addBtn;
    @FXML private Button backBtn;

    public static Scroll<Army> armyScroll;

    private Functions functions = new Functions();
    private GraphicAction<Army> armyCell = item -> functions.activatedButton(item.getName(),e -> {
        armyScroll.setCursor(item);
    });
    private GraphicAction<Army> delCell = item -> functions.activatedButton("Delete",e -> armyScroll.getItems().remove(item));
    private GraphicAction<String> typeCell = item -> {Label l = new Label(); l.setText(item); return l;};
    private GraphicAction<String> genCell = item -> {Label l = new Label(); l.setText(item); return l;};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        armyScroll = ChooseGameSceneController.gameScroll.getCursor().getArmies();
        armies.setItems(armyScroll.getItems());
        GraphicColumn<Army,Army> armyCol = new GraphicColumn<>("army",armyCell);
        GraphicColumn<Army,String> typeCol =  new GraphicColumn<>("type",typeCell);
        GraphicColumn<Army,String> genCol =  new GraphicColumn<>("genName",genCell);
        GraphicColumn<Army,Army> delCol = new GraphicColumn<>("army",delCell);
        armyCol.setMinWidth(250); armyCol.setMaxWidth(250);
        typeCol.setMinWidth(50); typeCol.setMaxWidth(50);
        genCol.setMinWidth(100); genCol.setMaxWidth(100);
        delCol.setMinWidth(100); delCol.setMaxWidth(100);
        armies.getColumns().addAll(armyCol,typeCol,genCol,delCol);
        addBtn.setOnAction(e -> functions.openNewWindow("Add Army","View/Scenes/CreateScenes/armyName.fxml"));
        backBtn.setOnAction(e -> functions.goToScene(backBtn,"View/Scenes/MainScenes/chooseGameScene.fxml"));
    }
}