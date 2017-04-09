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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ChoosePlayerSceneController implements Initializable{
    /* Scene Elements */
    @FXML private VBox vBox;
    private Button addPlayerBtn = new Button("Add Player");;
    private TableView<Player> players = new TableView<>();

    /* List of Players */
    public static Scroll<Player> playerScroll = new Scroll<>();

    /* Functionalities */
    private Functions functions = new Functions();
    private GraphicAction<Player> playerCell = item -> functions.activatedButton(item.getName(),e -> {
        playerScroll.setCursor(item);
        functions.goToScene(vBox,"View/MainScenes/chooseGameScene.fxml");
    });
    private GraphicAction<Player> editCell = item -> functions.activatedButton("Edit",e -> System.out.println(item.getName() + " edited."));
    private GraphicAction<Player> delCell = item -> functions.activatedButton("Delete",e -> playerScroll.getItems().remove(item));


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        players.setItems(playerScroll.getItems());
        players.getColumns().addAll(new GraphicColumn<>("player",playerCell),
                                    new GraphicColumn<>("player",editCell),
                                    new GraphicColumn<>("player",delCell));
        addPlayerBtn.setOnAction(e -> functions.openNewWindow("Add Player", "View/CreateScenes/playerName.fxml"));
        Pane h = new Pane();
        h.getChildren().add(addPlayerBtn);
        vBox.getChildren().addAll(players,h);
    }
}
