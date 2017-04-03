package com.coffeemath.totalwararmymanager.Controller;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

/**
 * Created by Alcoseba on 4/4/2017.
 */
public class ButtonCell<S,T> extends TableCell<S,T> {
    protected Button button;
    public ButtonCell(String label){
        button = new Button(label);
        setGraphic(button);
    }
    public ButtonCell(){
        button = new Button();
        setGraphic(button);
    }
}
