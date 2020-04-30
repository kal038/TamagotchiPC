package GUI;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GUIView extends Application {
    private static final int HEIGHT = 500;
    private static final int WIDTH = 500;

    private AnchorPane root;

    /**
     * The top pane of the GUI where the
     * action buttons live
     */
    private HBox topPane;

    /**
     * The bottom pane of the GUI where the
     * time indicator and other buttons live
     */
    private HBox bottomPane;

    /**
     * The main display that gets updated
     * according to the current view
     */
    private VBox mainDisplay;

    private Label dayLbl;

    private ImageView petView;

    private GridPane statsView;

    private VBox menuView;

    /**
     * All the stat bar objects
     */
    private StatBar hungerStats;
    private StatBar hygieneStats;
    private StatBar sleepStats;
    private StatBar happinessStats;

    /**
     * All the action buttons
     */
    private ActionButton feedBtn;
    private ActionButton cleanBtn;
    private ActionButton sleepBtn;
    private ActionButton petBtn;

    /**
     * All other buttons
     */
    private ActionButton menuBtn;
    private ActionButton skipBtn;
    private ActionButton statsBtn;

    /**
     * Menu buttons
     */
    private Button resetPetBtn;
    private Button newPetBtn;
    private Button saveStatBtn;

    private Label petNameLbl = new Label("PetExample");
    private Label petAgeLbl = new Label("1 day");

    private static final int PET = 0;
    private static final int STATS = 1;
    private static final int MENU = 2;

    private int viewMode;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        root = new AnchorPane();

        topPane = new HBox();
        bottomPane = new HBox();

        initActionButtons();
        configTopPane();

        mainDisplay = new VBox();
        mainDisplay.setPrefWidth(WIDTH);
        mainDisplay.setPadding(new Insets(10, 10, 10, 10));

        double y = menuBtn.getActionButton().getPrefHeight() +
                bottomPane.getPadding().getTop() + bottomPane.getPadding().getBottom();

        mainDisplay.setLayoutY(y);
        mainDisplay.setLayoutX(0);
        mainDisplay.setAlignment(Pos.CENTER);

        statsView = new GridPane();
        statsView.setHgap(30);
        statsView.setVgap(20);

        initStatBars();

        petView = new ImageView(new Image(new
                FileInputStream("src/Images/bixby_pet.gif")));

        petView.setFitHeight(300);
        petView.setFitWidth(300);
        petView.setPreserveRatio(true);

        newPetBtn = createMenuButton("Create A New Pet");
        resetPetBtn = createMenuButton("Reset Current Pet");
        saveStatBtn = createMenuButton("Save Pet State");

        menuView = new VBox();
        menuView.setSpacing(30);
        menuView.setPrefWidth(WIDTH);
        menuView.setAlignment(Pos.CENTER);
        menuView.setPadding(new Insets(100, 30, 30, 30));
        menuView.getChildren().addAll(newPetBtn, resetPetBtn, saveStatBtn);

        configStatsView();

        viewMode = PET;
        setView(petView);

        createDayLbl();

        statsBtn.getActionButton().setOnAction(event -> {
            if (viewMode == STATS) {
                viewMode = PET;
                setView(petView);
            } else {
                viewMode = STATS;
                setView(statsView);
            }
        });

        menuBtn.getActionButton().setOnAction(event -> {
            if (viewMode == MENU) {
                viewMode = PET;
                setView(petView);
            } else {
                viewMode = MENU;
                setView(menuView);
            }
        });

        configBottomPane();

        root.getChildren().addAll(topPane, mainDisplay, bottomPane);

        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);

        primaryStage.setTitle("Bixby : Pet Simulator");

        primaryStage.show();
    }

    private void configStatsView() {
        statsView.setPadding(new Insets(30, 30, 30, 30));

        Label petNamePH = new Label("Pet Name : ");
        Label petAgePH = new Label("Pet Age : ");

        GridPane.setHalignment(petNamePH, HPos.LEFT);
        statsView.add(petNamePH, 0, 1);
        GridPane.setHalignment(petNameLbl, HPos.LEFT);
        statsView.add(petNameLbl, 1, 1);

        GridPane.setHalignment(petAgePH, HPos.LEFT);
        statsView.add(petAgePH, 0, 2);
        GridPane.setHalignment(petAgeLbl, HPos.LEFT);
        statsView.add(petAgeLbl, 1, 2);

        GridPane.setHalignment(hungerStats.getStatLbl(), HPos.LEFT);
        statsView.add(hungerStats.getStatLbl(), 0, 3);
        GridPane.setHalignment(hungerStats.getStatProgressBar(), HPos.LEFT);
        statsView.add(hungerStats.getStatProgressBar(), 1, 3);

        GridPane.setHalignment(hygieneStats.getStatLbl(), HPos.LEFT);
        statsView.add(hygieneStats.getStatLbl(), 0, 4);
        GridPane.setHalignment(hygieneStats.getStatProgressBar(), HPos.LEFT);
        statsView.add(hygieneStats.getStatProgressBar(), 1, 4);

        GridPane.setHalignment(sleepStats.getStatLbl(), HPos.LEFT);
        statsView.add(sleepStats.getStatLbl(), 0, 5);
        GridPane.setHalignment(sleepStats.getStatProgressBar(), HPos.LEFT);
        statsView.add(sleepStats.getStatProgressBar(), 1, 5);

        GridPane.setHalignment(happinessStats.getStatLbl(), HPos.LEFT);
        statsView.add(happinessStats.getStatLbl(), 0, 6);
        GridPane.setHalignment(happinessStats.getStatProgressBar(), HPos.LEFT);
        statsView.add(happinessStats.getStatProgressBar(), 1, 6);
    }

    private void createDayLbl() {
        dayLbl = new Label("Day 1");
        dayLbl.setMinHeight(50);
        dayLbl.setMinWidth(100);
        dayLbl.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                new CornerRadii(5) , BorderWidths.DEFAULT)));
        dayLbl.setAlignment(Pos.CENTER);
    }

    private void setView(Node view) {
        mainDisplay.getChildren().clear();
        mainDisplay.getChildren().add(view);
    }

    private void initActionButtons() {
        feedBtn = new ActionButton(ActionTypes.FEED);
        cleanBtn = new ActionButton(ActionTypes.CLEAN);
        sleepBtn = new ActionButton(ActionTypes.SLEEP);
        petBtn = new ActionButton(ActionTypes.PET);

        menuBtn = new ActionButton(ActionTypes.MENU);
        skipBtn = new ActionButton(ActionTypes.SKIP);
        statsBtn = new ActionButton(ActionTypes.STATS);
    }

    private void initStatBars() {
        hungerStats = new StatBar(StatTypes.HUNGER);
        hygieneStats = new StatBar(StatTypes.HYGIENE);
        sleepStats = new StatBar(StatTypes.SLEEP);
        happinessStats = new StatBar(StatTypes.HAPPINESS);
    }

    private void configTopPane() {
        topPane.setPadding(new Insets(20, 30, 20,  30));

        double spacing = (WIDTH - (feedBtn.getActionButton().getPrefWidth()*4 +
                topPane.getPadding().getLeft() + topPane.getPadding().getRight())) / 3;

        topPane.setSpacing(spacing);
        topPane.getChildren().addAll(feedBtn.getActionButton(),
                cleanBtn.getActionButton(), sleepBtn.getActionButton(),
                petBtn.getActionButton());

        topPane.setLayoutX(0);
        topPane.setLayoutY(0);
    }

    private void configBottomPane() {
        bottomPane.setPadding(new Insets(20, 30, 20,  30));

        double spacing = (WIDTH - (menuBtn.getActionButton().getPrefWidth()*4
                + bottomPane.getPadding().getLeft() + bottomPane.getPadding().getRight())) / 3;

        bottomPane.setSpacing(spacing);
        bottomPane.getChildren().addAll(dayLbl, menuBtn.getActionButton(),
                skipBtn.getActionButton(), statsBtn.getActionButton());

        double y = HEIGHT - (menuBtn.getActionButton().getPrefHeight() +
                bottomPane.getPadding().getTop() + bottomPane.getPadding().getBottom());

        bottomPane.setLayoutX(0);
        bottomPane.setLayoutY(y);
    }

    private Button createMenuButton(String btnLbl) {
        Button menuButton = new Button(btnLbl);
        menuButton.setPrefWidth(150);
        menuButton.setPrefHeight(30);
        return menuButton;
    }
}
