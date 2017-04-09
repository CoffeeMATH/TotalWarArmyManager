package com.coffeemath.totalwararmymanager.Controller;

import com.coffeemath.totalwararmymanager.Controller.TestModels.Game;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.Functions;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicAction;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicColumn;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author L-LHora
 */
public class ChooseGameSceneController implements Initializable {
    @FXML private TableView<Game> games;
    @FXML private Button addBtn;
    @FXML private Button backBtn;

    private Functions functions = new Functions();
    private GraphicAction<Game> gameCell = item -> functions.activatedButton(item.getName(),e -> System.out.println(item.getName()));
    private GraphicAction<Game> editCell = item -> functions.activatedButton("Edit", e -> System.out.println(item.getName() + " edited."));
    private GraphicAction<Game> delCell = item -> functions.activatedButton("Delete",e ->
            ChoosePlayerSceneController.playerScroll.getCursor().getGames().getItems().remove(item));

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        games.setItems(ChoosePlayerSceneController.playerScroll.getCursor().getGames().getItems());
        games.getColumns().addAll(new GraphicColumn<>("game",gameCell),
                new GraphicColumn<>("game",editCell),
                new GraphicColumn<>("game",delCell));
        addBtn.setOnAction(e -> functions.openNewWindow("Add Game","View/Scenes/CreateScenes/gameName.fxml"));
        backBtn.setOnAction(e -> functions.goToScene(backBtn,"View/Scenes/MainScenes/choosePlayerScene.fxml"));
    }
}
