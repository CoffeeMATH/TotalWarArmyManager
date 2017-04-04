package com.coffeemath.totalwararmymanager.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.coffeemath.totalwararmymanager.Controller.Toolkit.Functions;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicAction;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ChoosePlayerSceneController implements Initializable {
    private Functions functions = new Functions();
    public ObservableList<Player> playerList = FXCollections.observableArrayList();
    private GraphicAction<Player> playerCell = item -> functions.activatedButton(item.getName(),e -> System.out.println(item.getName()));
    private GraphicAction<Player> editCell = item -> functions.activatedButton("Edit",e -> System.out.println(item.getName() + " edited."));
    private GraphicAction<Player> delCell = item -> functions.activatedButton("Delete",e -> playerList.remove(item));

    @FXML private VBox vBox;
    private Button addPlayerBtn = new Button("Add Player");;
    private TableView<Player> players = new TableView<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        players.setItems(playerList);
        players.getColumns().addAll(new GraphicColumn<>("player",playerCell),
                                    new GraphicColumn<>("player",editCell),
                                    new GraphicColumn<>("player",delCell));
        addPlayerBtn.setOnAction(e -> {
           // try{
               // functions.openNewWindow("Add Player","../../View/playerName.fxml");
                playerList.add(new Player("Aaron"));
           // }
           // catch(IOException error){ error.printStackTrace(); }
        });
        Pane h = new Pane();
        h.getChildren().add(addPlayerBtn);
        vBox.getChildren().addAll(players,h);
    }
}
