package com.coffeemath.totalwararmymanager.Controller.Toolkit;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by Alcoseba on 4/4/2017.
 */
public class GraphicColumn<S,T> extends TableColumn<S,T> {
    public GraphicColumn(String property, GraphicAction<T> graphicAction){
        super();
        super.setCellValueFactory(new PropertyValueFactory<S, T>(property));
        super.setCellFactory(param -> new GraphicCell<S, T>(graphicAction));
    }
}
