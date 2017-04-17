package com.coffeemath.totalwararmymanager.Controller.TestModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by jqalc on 4/9/17.
 */
public class Games {
    private ObservableList<Game> games;
    private Game cursor;
    public Games(){
        games = FXCollections.observableArrayList();
    }
    public void setCursor(Game game){cursor = game;}
    public Game getCursor(){return cursor;}
    public ObservableList<Game> getGames(){return games;}
}
