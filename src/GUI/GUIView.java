package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class GUIView extends Application {
    private static final int HEIGHT = 500;
    private static final int WIDTH = 700;

    private AnchorPane root;
    private HBox statSection;
    private ProgressBar hungerBar;
    private ProgressBar happinessBar;
    private ProgressBar hygieneBar;
    private ProgressBar sleepBar;
    private HBox buttonSection;
    private Rectangle sprite;
    private Button petBtn;
    private Button feedBtn;
    private Button cleanBtn;
    private Button sleepBtn;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new AnchorPane();

//        statSection = new HBox(10);
//        hungerStats = new StatBar(100, "hunger");
        Label timeLbl = new Label("Day 1");
        timeLbl.setLayoutX(20);
        timeLbl.setLayoutY(20);

        root.getChildren().add(timeLbl);

        Label hungerLbl = new Label("Hunger:");
        hungerLbl.setLayoutX(20 + 50);
        hungerLbl.setLayoutY(20);
        hungerBar = new ProgressBar();
        hungerBar.setPrefHeight(20);
        hungerBar.setProgress(0.7);
        hungerBar.setPrefWidth(150);
        hungerBar.setStyle("-fx-accent: red;");
        hungerBar.setLayoutX(220);
        hungerBar.setLayoutY(20);

        root.getChildren().addAll(hungerBar, hungerLbl);

        sprite = new Rectangle(100, 100);

//        root.getChildren().add(sprite);

//        buttonSection = new HBox(10);
        feedBtn = new Button("Feed");
        feedBtn.setLayoutX(20);
        feedBtn.setLayoutY(HEIGHT - 50 - feedBtn.getHeight());

        sleepBtn = new Button("Sleep");
        sleepBtn.setLayoutX(20 + 60 + feedBtn.getWidth());
        sleepBtn.setLayoutY(HEIGHT - 50 - sleepBtn.getHeight());
        root.getChildren().addAll(feedBtn, sleepBtn);

//        root.getChildren().add(buttonSection);

        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);

        primaryStage.setTitle("Bixby : Pet Simulator");

        primaryStage.show();

    }
}
