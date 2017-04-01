package TotalWarArmyManager;//package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javafx.fxml.FXMLLoader.load;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader fxmlLoaderR = new FXMLLoader(getClass().getResource("TotalWarArmyManager/FXMLDocument.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("TotalWarArmyManager/"));
            Parent root = fxmlLoaderR.load();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        }catch (IOException ex) {
            //Logger.getLogger(ChoosePlayerSceneController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR!");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
