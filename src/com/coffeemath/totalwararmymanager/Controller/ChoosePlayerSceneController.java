package com.coffeemath.totalwararmymanager.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.coffeemath.totalwararmymanager.Model.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
    
public class ChoosePlayerSceneController implements Initializable {

   @FXML
   private Button button1;

   @FXML
   private ListView<TableView<playerRow>> list;

    @FXML
    void handleButtonAction(ActionEvent event) {
         try{
             FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("View/playerName.fxml"));
             Parent root1 = (Parent) fxmlLoader1.load();
             Stage stage1 = new Stage();
             stage1.setScene(new Scene(root1));
             stage1.initModality(Modality.APPLICATION_MODAL);
             stage1.initOwner(button1.getScene().getWindow());
             stage1.showAndWait();

         } catch (IOException ex) {
           Logger.getLogger(ChoosePlayerSceneController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list = new ListView<>();
        list.getItems().add(tableOfPlayers());
    }

    private TableView<playerRow> tableOfPlayers(){

        TableColumn<playerRow, Button> playerCol = new TableColumn<>();
        playerCol.setMinWidth(200);
        playerCol.setCellValueFactory(new PropertyValueFactory<>("p"));

        TableColumn<playerRow, Button> delCol = new TableColumn<>();
        delCol.setMinWidth(200);
        delCol.setCellValueFactory(new PropertyValueFactory<>("x"));

        TableView<playerRow> table = new TableView<>();
        table.setItems(loadPlayers());
        table.getColumns().addAll(playerCol,delCol);

        return table;
    }

    private ObservableList<playerRow> loadPlayers(){
        ObservableList<playerRow> players = FXCollections.observableArrayList();
        players.add(new playerRow("Aaron"));
        return players;
    }
}

class playerRow{
    public Button p;
    public Button x;
    public playerRow(String name){
        p = new Button(name);
        x = new Button("Delete");
        p.setOnAction(e -> System.out.println(p.getText()));
        x.setOnAction(e -> System.out.println("Deleted "+p.getText()));
    }
}