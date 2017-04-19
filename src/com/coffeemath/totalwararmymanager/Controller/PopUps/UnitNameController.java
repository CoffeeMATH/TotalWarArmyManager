package com.coffeemath.totalwararmymanager.Controller.PopUps;

import com.coffeemath.totalwararmymanager.Controller.ArmyDetailsScene;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.Functions;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicAction;
import com.coffeemath.totalwararmymanager.Controller.Toolkit.GraphicColumn;
import com.coffeemath.totalwararmymanager.Models.Unit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Alcoseba on 4/19/2017.
 */
public class UnitNameController implements Initializable {

    /** Load UI Elements from FXML **/
    @FXML private VBox root;
    @FXML private TableView<Unit> unitSelect;
    @FXML private Button doneButton;

    /** Column Functions **/
    private Functions functions = new Functions();
    private GraphicAction<Unit> units = item -> functions.activatedButton(item.getName(),e -> ArmyDetailsScene.stillCursor.addUnit(item.getName()));

    /** Presentation **/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        unitSelect.setItems(ArmyDetailsScene.stillCursor.showUnit());
        unitSelect.getColumns().add(new GraphicColumn<>("unit",units));
        doneButton.setOnAction(e -> ((Stage)doneButton.getScene().getWindow()).close());
    }
}
