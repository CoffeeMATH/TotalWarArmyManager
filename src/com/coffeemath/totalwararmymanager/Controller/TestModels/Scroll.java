package com.coffeemath.totalwararmymanager.Controller.TestModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Alcoseba on 4/9/2017.
 */
public class Scroll<S>{
    private ObservableList<S> items;
    private S cursor;
    public Scroll(){
        items = FXCollections.observableArrayList();
    }
    public void setCursor(S cursor) {this.cursor = cursor;}
    public ObservableList<S> getItems() {return items;}
    public S getCursor() {return cursor;}
}
