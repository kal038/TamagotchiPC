package GUI;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
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
    private VBox feedView;
    private AnchorPane gameView;

    private ToggleGroup foodGroup;
    private RadioButton apple;
    private RadioButton grapes;
    private RadioButton meat;
    private RadioButton water;


    private StatBar hungerStats;
    private StatBar hygieneStats;
    private StatBar sleepStats;
    private StatBar happinessStats;

    private Button feedBtn;
    private Button walkBtn;
    private Button sleepBtn;
    private Button petBtn;

    private Button menuBtn;
    private Button skipBtn;
    private Button statsBtn;

    private Button saveExitBtn;

    private Button newPetBtn;
    private Button loadPetBtn;

    private TextField petNameTxt;

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
        saveExitBtn = createMenuButton("Save and Exit");

        menuView = new VBox();
        menuView.setSpacing(30);
        menuView.setPrefWidth(WIDTH);
        menuView.setAlignment(Pos.CENTER);
        menuView.setPadding(new Insets(100, 30, 30, 30));
        menuView.getChildren().addAll(saveExitBtn);
    }

    private void configFeedView() {
        feedView = new VBox();
        foodGroup = new ToggleGroup();
    }

    private void configPetView() throws FileNotFoundException {
        petView = new ImageView(new Image(new
                FileInputStream("src/Images/bixby_pet.gif")));

        petView.setFitHeight(300);
        petView.setFitWidth(300);
        petView.setPreserveRatio(true);
    }

    public void updatePetView() throws FileNotFoundException {
        petView = new ImageView(new Image(new
                FileInputStream("src/Images/bixby_pet2.gif")));

        petView.setFitHeight(300);
        petView.setFitWidth(300);
        petView.setPreserveRatio(true);
    }

    public void updateDayLbl(int day) {
        dayLbl.setText("Day " + day);

        bottomPane.getChildren().clear();
        bottomPane.getChildren().addAll(dayLbl, menuBtn, skipBtn, statsBtn);
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

        petNameTxt = new TextField();
        petNameTxt.setText("Reggie");
        petNameTxt.setMaxWidth(150);

        startImg.setFitHeight(300);
        startImg.setFitWidth(300);
        startImg.setPreserveRatio(true);

        newPetBtn = createMenuButton("Create New Pet");
        loadPetBtn = createMenuButton("Load Pet");

        startView = new VBox();
        startView.setSpacing(10);
        startView.setPrefWidth(WIDTH);
        startView.setAlignment(Pos.CENTER);
        startView.setPadding(new Insets(10, 30, 30, 30));
        startView.getChildren().addAll(startImg, new Label("Pet Name : "),
                petNameTxt, newPetBtn, loadPetBtn);
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
        walkBtn = createActionButton("Clean");
        sleepBtn = createActionButton("Sleep");
        petBtn = createActionButton("Pet");

        topPane.setPadding(new Insets(20, 30, 20,  30));

        double spacing = (WIDTH - (feedBtn.getPrefWidth()*4 +
                topPane.getPadding().getLeft() + topPane.getPadding().getRight())) / 3;

        topPane.setSpacing(spacing);
        topPane.getChildren().addAll(feedBtn, walkBtn, sleepBtn, petBtn);

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

    public Button getWalkBtn() {
        return walkBtn;
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

    public Button getSaveExitBtn() {
        return saveExitBtn;
    }

    public Button getNewPetBtn() {
        return newPetBtn;
    }

    public Button getLoadPetBtn() {
        return loadPetBtn;
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

    public TextField getPetNameTxt() {
        return petNameTxt;
    }

    public void setPetNameLbl(String petName) {
        this.petNameLbl.setText(petName);
    }


}
