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
        armies.getColumns().addAll(new GraphicColumn<>("army",armyCell),
                new GraphicColumn<>("type",typeCell),
                new GraphicColumn<>("genName",genCell),
                new GraphicColumn<>("army",delCell));
        addBtn.setOnAction(e -> functions.openNewWindow("Add Army","View/Scenes/CreateScenes/armyName.fxml"));
        backBtn.setOnAction(e -> functions.goToScene(backBtn,"View/Scenes/MainScenes/chooseGameScene.fxml"));
    }
}
