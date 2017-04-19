package com.coffeemath.totalwararmymanager.Controller.Toolkit;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by Alcoseba on 4/4/2017.
 */
public class GraphicColumn<S,T> extends TableColumn<S,T> {
    public GraphicColumn(String title, String property, GraphicAction<T> graphicAction){
        super(title);
        super.setCellValueFactory(new PropertyValueFactory<S, T>(property));
        super.setCellFactory(param -> new GraphicCell<S, T>(graphicAction));
    }
    public GraphicColumn(String property, GraphicAction<T> graphicAction){
        this("",property,graphicAction);
    }
}
