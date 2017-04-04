package com.coffeemath.totalwararmymanager.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ChoosePlayerSceneController implements Initializable {

    @FXML
    private VBox vBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        TableColumn playerCol = new TableColumn();
        playerCol.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        playerCol.setCellFactory(param -> {
            return new TableCell<Player, String>(){
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty){
                        setGraphic(null); setText(null);
                    }
                    else{
                        Player player = getTableView().getItems().get(getIndex());
                        Button playerBtn = new Button(player.getName());
                        playerBtn.setOnAction(e -> System.out.println(player.getName()));
                        setGraphic();
                        setText(null);
                    }
                }
            };
        });

        TableColumn editCol = new TableColumn();
        editCol.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        editCol.setCellFactory(param -> {
            return new TableCell<Player, String>(){
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty){
                        setGraphic(null); setText(null);
                    }
                    else{
                        Player player = getTableView().getItems().get(getIndex());
                        Button playerBtn = new Button("Edited");
                        playerBtn.setOnAction(e -> System.out.println(player.getName()+" edited."));
                        setGraphic(playerBtn);
                        setText(null);
                    }
                }
            };
        });*/
        GraphicTable players = new GraphicTable(new PlayerBtn(), new EditBtn());
        players.setItems(loadPlayers());
        //TableView playerList = new TableView();
        //playerList.setItems(loadPlayers());
        //playerList.getColumns().addAll(playerCol,editCol);
        Pane h = new Pane();
        h.getChildren().add(new Button("Add Player"));
        vBox.getChildren().addAll(h);
    }

    private ObservableList<Player> loadPlayers(){
        ObservableList<Player> players = FXCollections.observableArrayList();
        players.add(new Player("Aaron"));
        return players;
    }
}



class PlayerBtn{
    private Button playerBtn;
    public PlayerBtn(Player player){
        playerBtn = new Button(player.getName());
        playerBtn.setOnAction(e -> System.out.println(playerBtn.getText()));
    }
    public PlayerBtn(){
        this(new Player("Default"));
    }
}

class EditBtn{
    private Player player;
    private Button editBtn;
    public EditBtn(Player player){
        this.player = player;
        editBtn = new Button("Edit");
        editBtn.setOnAction(e -> System.out.println());
    }
    public EditBtn(){
        this(new Player("Default"));
    }
}

class Player extends Object{
    private String name;
    public Player(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}