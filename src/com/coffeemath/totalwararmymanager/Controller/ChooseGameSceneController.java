package com.coffeemath.totalwararmymanager.Controller;

import com.coffeemath.totalwararmymanager.Controller.TestModels.Game;
import com.coffeemath.totalwararmymanager.Controller.TestModels.Scroll;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.Functions;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicAction;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicColumn;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ChooseGameSceneController implements Initializable {
    @FXML private TableView<Game> games;
    @FXML private Button addBtn;
    @FXML private Button backBtn;

    public static Scroll<Game> gameScroll;

    private Functions functions = new Functions();
    private GraphicAction<Game> gameCell = item -> functions.activatedButton(item.getName(),e -> {
        gameScroll.setCursor(item);
        functions.goToScene(games,"View/Scenes/MainScenes/chooseArmyScene.fxml");
    });
    private GraphicAction<Game> editCell = item -> functions.activatedButton("Edit", e -> {
        gameScroll.setCursor(item);
        functions.openTemporaryWindow("Edit Game","View/Scenes/EditScenes/editGame.fxml");
        games.refresh();
    });
    private GraphicAction<Game> delCell = item -> functions.activatedButton("Delete",e -> gameScroll.getItems().remove(item));

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gameScroll = ChoosePlayerSceneController.playerScroll.getCursor().getGames();
        games.setItems(gameScroll.getItems());
        games.getColumns().addAll(new GraphicColumn<>("game",gameCell),
                new GraphicColumn<>("game",editCell),
                new GraphicColumn<>("game",delCell));
        addBtn.setOnAction(e -> functions.openNewWindow("Add Game","View/Scenes/CreateScenes/gameName.fxml"));
        backBtn.setOnAction(e -> functions.goToScene(backBtn,"View/Scenes/MainScenes/choosePlayerScene.fxml"));
    }
}
