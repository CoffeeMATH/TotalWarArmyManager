package com.coffeemath.totalwararmymanager.Controller.Toolkit;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

/**
 * Created by Alcoseba on 4/4/2017.
 */
public class GraphicCell<S,T> extends TableCell<S,T>{
    private GraphicAction<T> graphicAction;

    public GraphicCell(GraphicAction<T> graphicAction){
        this.graphicAction = graphicAction;
    }
    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty) {
            Node graphic = graphicAction.nodeGraphic(item);
            if(graphic instanceof Button) ((Button) graphic).prefWidthProperty().bind(getTableColumn().maxWidthProperty());
            setGraphic(graphic);
        }
        else
            setGraphic(null);
        setText(null);
    }
}