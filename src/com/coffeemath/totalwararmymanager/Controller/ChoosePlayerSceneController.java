package com.coffeemath.totalwararmymanager.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.coffeemath.totalwararmymanager.Controller.TestModels.Player;
import com.coffeemath.totalwararmymanager.Controller.TestModels.Scroll;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.Functions;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicAction;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicColumn;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ChoosePlayerSceneController implements Initializable{
    @FXML private VBox root;
    @FXML private Button addPlayerBtn;
    @FXML private Button backBtn;
    @FXML private TableView<Player> players;

    public static Scroll<Player> playerScroll = new Scroll<>();

    private Functions functions = new Functions();
    private GraphicAction<Player> playerCell = item -> functions.activatedButton(item.getName(),e -> {
        playerScroll.setCursor(item);
        functions.goToScene(addPlayerBtn,"View/Scenes/MainScenes/chooseGameScene.fxml");
    });
    private GraphicAction<Player> editCell = item -> functions.activatedButton("Edit",e -> {
        playerScroll.setCursor(item);
        functions.openTemporaryWindow("Edit Player","View/Scenes/EditScenes/editPlayer.fxml");
        players.refresh();
    });
    private GraphicAction<Player> delCell = item -> functions.activatedButton("Delete",e -> playerScroll.getItems().remove(item));

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        players.setItems(playerScroll.getItems());
        players.prefHeightProperty().bind(root.heightProperty().multiply(0.925));
        GraphicColumn<Player,Player> playerCol = new GraphicColumn<>("player",playerCell);
        GraphicColumn<Player,Player> editCol = new GraphicColumn<>("player",editCell);
        GraphicColumn<Player,Player> delCol = new GraphicColumn<>("player",delCell);
        playerCol.prefWidthProperty().bind(players.widthProperty().multiply(0.7));
        editCol.prefWidthProperty().bind(players.widthProperty().multiply(0.15));
        delCol.prefWidthProperty().bind(players.widthProperty().multiply(0.15));
        players.getColumns().addAll(playerCol,editCol,delCol);
        addPlayerBtn.setOnAction(e -> functions.openNewWindow("Add Player", "View/Scenes/CreateScenes/playerName.fxml"));
        backBtn.setOnAction(e -> functions.goToScene(backBtn,"View/Scenes/MainScenes/FXMLDocument.fxml"));
    }
}