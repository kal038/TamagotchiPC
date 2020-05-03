package GUI;

import Pet.Food;
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

    private ImageView petImgView;
    private GridPane statsView;
    private VBox menuView;
    private VBox startView;
    private VBox feedView;
    private VBox walkView;
    private VBox sleepView;
    private VBox petView;
    private AnchorPane gameView;

    private ToggleGroup foodGroup;
    private Slider foodSlider;
    private Button feedConfBtn;
    private Slider walkSlider;
    private Button walkConfBtn;
    private Slider sleepSlider;
    private Button sleepConfBtn;
    private Slider petSlider;
    private Button petConfBtn;

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
        configPetImgView();

        configFeedView();
        configWalkView();
        configSleepView();
        configPetView();

        configMenuView();
        configStatsView();

        gameView = new AnchorPane();
        gameView.getChildren().addAll(topPane, mainDisplay, bottomPane);
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
        VBox foodList = new VBox();
        foodList.setPrefWidth(WIDTH);
        foodList.setAlignment(Pos.TOP_LEFT);
        foodList.setSpacing(10);

        foodGroup = new ToggleGroup();

        RadioButton apple = new RadioButton("Apple");
        apple.setToggleGroup(foodGroup);
        apple.setSelected(true);

        RadioButton grapes = new RadioButton("Grapes");
        grapes.setToggleGroup(foodGroup);

        RadioButton meat = new RadioButton("Meat");
        meat.setToggleGroup(foodGroup);

        RadioButton water = new RadioButton("Water");
        water.setToggleGroup(foodGroup);

        RadioButton ant = new RadioButton("Ant");
        ant.setToggleGroup(foodGroup);

        RadioButton grass = new RadioButton("Grass");
        grass.setToggleGroup(foodGroup);

        foodList.getChildren().addAll(new Label("Item to Feed :"), apple, grapes,
                meat, water, ant, grass);

        foodSlider = createActionSlider();

        feedConfBtn = createMenuButton("Feed This!");

        feedView = new VBox();
        feedView.setSpacing(10);
        feedView.setPrefWidth(WIDTH);
        feedView.setAlignment(Pos.CENTER);
        feedView.setPadding(new Insets(10, 30, 30, 30));
        feedView.getChildren().addAll(foodList,
                new Label("Quantity of Food :"), foodSlider, feedConfBtn);
    }

    private void configPetView() {
        petSlider = createActionSlider();

        petConfBtn = createMenuButton("Pet Now!");

        petView = new VBox();
        petView.setSpacing(30);
        petView.setPrefWidth(WIDTH);
        petView.setAlignment(Pos.CENTER);
        petView.setPadding(new Insets(60, 30, 30, 30));
        petView.getChildren().addAll(new Label("Number of Pets :"), petSlider,
                petConfBtn);
    }

    private void configSleepView() {
        sleepSlider = createActionSlider();

        sleepConfBtn = createMenuButton("Sleep Now!");

        sleepView = new VBox();
        sleepView.setSpacing(30);
        sleepView.setPrefWidth(WIDTH);
        sleepView.setAlignment(Pos.CENTER);
        sleepView.setPadding(new Insets(60, 30, 30, 30));
        sleepView.getChildren().addAll(new Label("Time to Sleep (mins) :"), sleepSlider,
                sleepConfBtn);
    }

    private void configWalkView() {
        walkSlider = createActionSlider();

        walkConfBtn = createMenuButton("Walk Now!");

        walkView = new VBox();
        walkView.setSpacing(30);
        walkView.setPrefWidth(WIDTH);
        walkView.setAlignment(Pos.CENTER);
        walkView.setPadding(new Insets(60, 30, 30, 30));
        walkView.getChildren().addAll(new Label("Time to Walk (mins) :"), walkSlider,
                walkConfBtn);
    }

    public int getFoodSliderVal() { return (int) foodSlider.getValue(); }

    public int getWalkSliderVal() { return (int) walkSlider.getValue(); }

    public int getSleepSliderVal() { return (int) sleepSlider.getValue(); }

    public int getPetSliderVal() { return (int) petSlider.getValue(); }

    public Food getSelectedFood() {
        return Food.valueOf(foodGroup.getSelectedToggle().
                toString().split("\'")[1].toUpperCase());
    }

    private void configPetImgView() throws FileNotFoundException {
        petImgView = new ImageView(new Image(new
                FileInputStream("src/Images/bixby_pet.gif")));

        petImgView.setFitHeight(300);
        petImgView.setFitWidth(300);
        petImgView.setPreserveRatio(true);
    }

    public void updatePetImgView(String image) throws FileNotFoundException {
        petImgView = new ImageView(new Image(new
                FileInputStream("src/Images/" + image)));

        petImgView.setFitHeight(300);
        petImgView.setFitWidth(300);
        petImgView.setPreserveRatio(true);
    }

    public void updateDayLbl(int day) {
        dayLbl.setText("Day " + day);
        petAgeLbl.setText(day + " day");

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
        walkBtn = createActionButton("Walk");
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
        skipBtn = createActionButton("Skip Day");
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

    private Slider createActionSlider() {
        Slider actionSlider = new Slider(1, 10, 1);
        actionSlider.setShowTickMarks(true);
        actionSlider.setShowTickLabels(true);
        actionSlider.setMajorTickUnit(1);
        actionSlider.setBlockIncrement(1);

        return actionSlider;
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

    public ImageView getPetImgView() {
        return petImgView;
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

    public Button getFeedConfBtn() { return feedConfBtn; }

    public VBox getFeedView() { return feedView; }

    public VBox getWalkView() { return walkView; }

    public TextField getPetNameTxt() { return petNameTxt; }

    public StatBar getHungerStats() { return hungerStats; }

    public StatBar getHygieneStats() { return hygieneStats; }

    public StatBar getSleepStats() { return sleepStats; }

    public StatBar getHappinessStats() { return happinessStats; }

    public void setPetNameLbl(String petName) { this.petNameLbl.setText(petName); }

    public Button getWalkConfBtn() {
        return walkConfBtn;
    }

    public Button getSleepConfBtn() {
        return sleepConfBtn;
    }

    public Button getPetConfBtn() {
        return petConfBtn;
    }

    public VBox getSleepView() {
        return sleepView;
    }

    public VBox getPetView() {
        return petView;
    }
}
