package com.coffeemath.totalwararmymanager.Controller;

import com.coffeemath.totalwararmymanager.Controller.TestModels.Game;
import com.coffeemath.totalwararmymanager.Controller.TestModels.Scroll;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.Functions;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicAction;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicColumn;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ChooseGameSceneController implements Initializable {
    @FXML private VBox root;
    @FXML private TableView<Game> games;
    @FXML private Button addBtn;
    @FXML private Button backBtn;
    @FXML private Label playerLabel;

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
        games.prefHeightProperty().bind(root.widthProperty().multiply(0.925));
        playerLabel.setText(ChoosePlayerSceneController.playerScroll.getCursor().getName());
        GraphicColumn<Game,Game> gameCol = new GraphicColumn<>("game",gameCell);
        GraphicColumn<Game,Game> editCol = new GraphicColumn<>("game",editCell);
        GraphicColumn<Game,Game> delCol = new GraphicColumn<>("game",delCell);
        gameCol.prefWidthProperty().bind(games.widthProperty().multiply(0.7));
        editCol.prefWidthProperty().bind(games.widthProperty().multiply(0.15));
        delCol.prefWidthProperty().bind(games.widthProperty().multiply(0.15));
        games.getColumns().addAll(gameCol,editCol,delCol);
        addBtn.setOnAction(e -> functions.openNewWindow("Add Game","View/Scenes/CreateScenes/gameName.fxml"));
        backBtn.setOnAction(e -> functions.goToScene(backBtn,"View/Scenes/MainScenes/choosePlayerScene.fxml"));
    }
}
