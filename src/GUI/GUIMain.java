package GUI;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * GUIMain class - runs the GUI itself by connecting
 * GUIView and GUIController
 */
public class GUIMain extends Application {
    private GUIView theView;
    private GUIController theController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.theView = new GUIView();
    }

    @Override
    public void start(Stage primaryStage) {
        this.theController = new GUIController(theView);

        primaryStage.setScene(new Scene(theView.getRoot(), GUIView.getWIDTH(), GUIView.getHEIGHT()));
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);

        primaryStage.setTitle("Bixby : Pet Simulator");

        primaryStage.show();
    }
}
