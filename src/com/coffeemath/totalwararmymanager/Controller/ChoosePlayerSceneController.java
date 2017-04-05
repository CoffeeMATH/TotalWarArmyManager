package com.coffeemath.totalwararmymanager.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChoosePlayerSceneController implements Initializable {

    @FXML
    private VBox vBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* Player Column */
        TableColumn<Player,String> playerCol = new TableColumn<>();
        playerCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        playerCol.setCellFactory(param -> new PlayerCell<>());
        /* Edit Column */
        TableColumn<Player,String> editCol = new TableColumn<>();
        editCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        editCol.setCellFactory(param -> new EditCell<>());
        /* Delete Column */
        TableColumn<Player,String> delCol = new TableColumn<>();
        delCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        delCol.setCellFactory(param -> new DeleteCell<>());

        TableView<Player> players = new TableView<>();
        players.setItems(loadPlayers());

        players.getColumns().addAll(playerCol,editCol,delCol);
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
        return players;
    }
}

class PlayerCell<Player,String> extends ButtonCell<Player,String>{
    public PlayerCell(){super();}
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty){
            button.setText(item.toString());
            button.setOnAction(e -> System.out.println(item));
        }
        else{setGraphic(null);setText(null);}
    }
}

class EditCell<Player,String> extends ButtonCell<Player,String>{
    public EditCell(){super("Edit");}
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty)
            button.setOnAction(e -> System.out.println(item+" edited."));
        else{setGraphic(null);setText(null);}
    }
}

class DeleteCell<Player,String> extends ButtonCell<Player,String>{
    public DeleteCell(){super("Delete");}
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty)
            button.setOnAction(e -> System.out.println(item+" deleted."));
        else{setGraphic(null);setText(null);}
    }
}