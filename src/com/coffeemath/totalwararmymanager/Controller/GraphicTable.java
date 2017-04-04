package com.coffeemath.totalwararmymanager.Controller;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



/**
 * Created by jqalc on 4/4/17.
 */
public class GraphicTable extends TableView {
    public GraphicTable(Node... columnGraphics){
        super();
        for(Node o: columnGraphics){
            TableColumn column = new TableColumn();
            column.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
            column.setCellFactory(param ->{
                return new TableCell(){
                    @Override
                    protected void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        if(empty){
                            setGraphic(null); setText(null);
                        }
                        else{
                            setGraphic(o); setText(null);
                        }
                    }
                };
            });
            this.getColumns().add(column);
        }
    }

}
