package GUI;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GUIView {
    private static final int HEIGHT = 500;
    private static final int WIDTH = 500;

    private AnchorPane root;
    private HBox topPane;
    private HBox bottomPane;
    private VBox mainDisplay;

    private Label dayLbl;

    private ImageView petView;
    private GridPane statsView;
    private VBox menuView;
    private VBox startView;
    private AnchorPane gameView;

    private StatBar hungerStats;
    private StatBar hygieneStats;
    private StatBar sleepStats;
    private StatBar happinessStats;

    private Button feedBtn;
    private Button cleanBtn;
    private Button sleepBtn;
    private Button petBtn;

    private Button menuBtn;
    private Button skipBtn;
    private Button statsBtn;

    private Button resetPetBtn;
    private Button newPetBtn;
    private Button saveStatBtn;

    private Button newGameBtn;
    private Button continueBtn;

    private Label petNameLbl = new Label("PetExample");
    private Label petAgeLbl = new Label("1 day");

    public GUIView() throws FileNotFoundException {

        root = new AnchorPane();

        topPane = new HBox();
        bottomPane = new HBox();

        configStartView();

        configTopPane();

        configBottomPane();

        configMainDisplay();

        configPetView();

        configMenuView();

        configStatsView();

        gameView = new AnchorPane();
        gameView.getChildren().addAll(topPane, mainDisplay, bottomPane);

//        root.getChildren().addAll(startView);
    }

    private void configMenuView() {
        newPetBtn = createMenuButton("Create A New Pet");
        resetPetBtn = createMenuButton("Reset Current Pet");
        saveStatBtn = createMenuButton("Save Pet State");

        menuView = new VBox();
        menuView.setSpacing(30);
        menuView.setPrefWidth(WIDTH);
        menuView.setAlignment(Pos.CENTER);
        menuView.setPadding(new Insets(100, 30, 30, 30));
        menuView.getChildren().addAll(newPetBtn, resetPetBtn, saveStatBtn);
    }

    private void configPetView() throws FileNotFoundException {
        petView = new ImageView(new Image(new
                FileInputStream("src/Images/bixby_pet.gif")));

        petView.setFitHeight(300);
        petView.setFitWidth(300);
        petView.setPreserveRatio(true);
    }

    private void configMainDisplay() {
        mainDisplay = new VBox();
        mainDisplay.setPrefWidth(WIDTH);
        mainDisplay.setPadding(new Insets(10, 10, 10, 10));

        double y = menuBtn.getPrefHeight() + bottomPane.getPadding().getTop() +
                bottomPane.getPadding().getBottom();

        mainDisplay.setLayoutY(y);
        mainDisplay.setLayoutX(0);
        mainDisplay.setAlignment(Pos.CENTER);
    }

    private void configStartView() throws FileNotFoundException {
        ImageView startImg = new ImageView(new Image(new
                FileInputStream("src/Images/menu_img.png")));

        startImg.setFitHeight(300);
        startImg.setFitWidth(300);
        startImg.setPreserveRatio(true);

        newGameBtn = createMenuButton("New Game");
        continueBtn = createMenuButton("Continue");

        startView = new VBox();
        startView.setSpacing(30);
        startView.setPrefWidth(WIDTH);
        startView.setAlignment(Pos.CENTER);
        startView.setPadding(new Insets(30, 30, 30, 30));
        startView.getChildren().addAll(startImg, newGameBtn, continueBtn);
    }

    private void configStatsView() {
        initStatBars();

        statsView = new GridPane();
        statsView.setHgap(30);
        statsView.setVgap(20);

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

    private void initStatBars() {
        hungerStats = new StatBar(StatTypes.HUNGER);
        hygieneStats = new StatBar(StatTypes.HYGIENE);
        sleepStats = new StatBar(StatTypes.SLEEP);
        happinessStats = new StatBar(StatTypes.HAPPINESS);
    }

    private void configTopPane() {
        feedBtn = createActionButton("Feed");
        cleanBtn = createActionButton("Clean");
        sleepBtn = createActionButton("Sleep");
        petBtn = createActionButton("Pet");

        topPane.setPadding(new Insets(20, 30, 20,  30));

        double spacing = (WIDTH - (feedBtn.getPrefWidth()*4 +
                topPane.getPadding().getLeft() + topPane.getPadding().getRight())) / 3;

        topPane.setSpacing(spacing);
        topPane.getChildren().addAll(feedBtn, cleanBtn, sleepBtn, petBtn);

        topPane.setLayoutX(0);
        topPane.setLayoutY(0);
    }

    private void configBottomPane() {
        menuBtn = createActionButton("Menu");
        skipBtn = createActionButton("Skip");
        statsBtn = createActionButton("Stats");

        createDayLbl();

        bottomPane.setPadding(new Insets(20, 30, 20,  30));

        double spacing = (WIDTH - (menuBtn.getPrefWidth()*4 + bottomPane.getPadding().getLeft()
                + bottomPane.getPadding().getRight())) / 3;

        bottomPane.setSpacing(spacing);
        bottomPane.getChildren().addAll(dayLbl, menuBtn, skipBtn, statsBtn);

        double y = HEIGHT - (menuBtn.getPrefHeight() + bottomPane.getPadding().getTop()
                + bottomPane.getPadding().getBottom());

        bottomPane.setLayoutX(0);
        bottomPane.setLayoutY(y);
    }

    private Button createMenuButton(String btnLbl) {
        Button menuButton = new Button(btnLbl);
        menuButton.setPrefWidth(150);
        menuButton.setPrefHeight(30);
        return menuButton;
    }

    private Button createActionButton(String btnLbl) {
        Button actionButton = new Button(btnLbl);
        actionButton.setPrefHeight(50);
        actionButton.setPrefWidth(100);
        return actionButton;
    }

    private void createDayLbl() {
        dayLbl = new Label("Day 1");
        dayLbl.setMinHeight(50);
        dayLbl.setMinWidth(100);
        dayLbl.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                new CornerRadii(5) , BorderWidths.DEFAULT)));
        dayLbl.setAlignment(Pos.CENTER);
    }

    public AnchorPane getRoot() {
        return root;
    }

    public VBox getMainDisplay() {
        return mainDisplay;
    }

    public ImageView getPetView() {
        return petView;
    }

    public GridPane getStatsView() {
        return statsView;
    }

    public VBox getMenuView() {
        return menuView;
    }

    public VBox getStartView() {
        return startView;
    }

    public Button getFeedBtn() {
        return feedBtn;
    }

    public Button getCleanBtn() {
        return cleanBtn;
    }

    public Button getSleepBtn() {
        return sleepBtn;
    }

    public Button getPetBtn() {
        return petBtn;
    }

    public Button getMenuBtn() {
        return menuBtn;
    }

    public Button getSkipBtn() {
        return skipBtn;
    }

    public Button getStatsBtn() {
        return statsBtn;
    }

    public Button getResetPetBtn() {
        return resetPetBtn;
    }

    public Button getNewPetBtn() {
        return newPetBtn;
    }

    public Button getSaveStatBtn() {
        return saveStatBtn;
    }

    public Button getNewGameBtn() {
        return newGameBtn;
    }

    public Button getContinueBtn() {
        return continueBtn;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public AnchorPane getGameView() {
        return gameView;
    }
}
