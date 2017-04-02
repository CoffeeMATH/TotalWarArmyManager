package com.coffeemath.totalwararmymanager.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;


/**
 * Created by Alcoseba on 4/2/2017.
 */
public class ButtonTable<T> extends TableView {
    private ObservableList<TableColumn> columns;
    private TableColumn objectCol;
    public ButtonTable(ObservableList<T> objects, String[] statics){
        columns = FXCollections.observableArrayList();
        objectCol = new TableColumn();
        objectCol.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        this.setItems(objects);
    }
    public void setDynamicButtonAction(EventHandler<ActionEvent> e){
        objectCol.setCellFactory(param -> dynamicCell(e));
    }
    public void setStaticButtonAction(int index, EventHandler<ActionEvent> e){
        //columns.get(index).setCellFactory();
    }
    private TableCell<T,String> staticCell(String btnText){
        return new TableCell<T, String>(){
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if(empty){
                    setGraphic(null); setText(null);
                }
                else{
                    Button objectBtn = new Button(btnText);
                    setGraphic(objectBtn);
                    setText(null);
                }
            }
        };
    }
    private TableCell<T,String> dynamicCell(EventHandler<ActionEvent> btnAction){
        return new TableCell<T, String>(){
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if(empty){
                    setGraphic(null); setText(null);
                }
                else{
                    Button objectBtn = new Button(getTableView().getItems().get(getIndex()).toString());
                    objectBtn.setOnAction(btnAction);
                    setGraphic(objectBtn);
                    setText(null);
                }
            }
        };
    }
}

