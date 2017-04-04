package com.coffeemath.totalwararmymanager.Controller;

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
    private GraphicAction<String> playerCell = item -> {
        Button playerBtn = new Button(item.toString());
        playerBtn.setOnAction(e -> System.out.println(item));
        return playerBtn;
    };
    private GraphicAction<String> editCell = item -> {
        Button editBtn = new Button("Edit");
        editBtn.setOnAction(e -> System.out.println(item + " edited."));
        return editBtn;
    };
    private GraphicAction<String> delCell = item -> {
        Button delBtn = new Button("Delete");
        delBtn.setOnAction(e -> System.out.println(item+ " deleted."));
        return delBtn;
    };

    @FXML
    private VBox vBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableView<Player> players = new TableView<>();
        players.setItems(loadPlayers());
        players.getColumns().addAll(new GraphicColumn<>("name",playerCell),
                                    new GraphicColumn<>("name",editCell),
                                    new GraphicColumn<>("name",delCell));
        Button addPlayerBtn = new Button("Add Player");
        addPlayerBtn.setOnAction(e -> {

        });
        Pane h = new Pane();
        h.getChildren().add(addPlayerBtn);
        vBox.getChildren().addAll(players,h);
    }

    private ObservableList<Player> loadPlayers(){
        ObservableList<Player> players = FXCollections.observableArrayList();
        players.add(new Player("Aaron"));
        players.add(new Player("Wendy"));
        return players;
    }
}
