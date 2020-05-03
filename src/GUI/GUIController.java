package GUI;

import Pet.PetMain;
import javafx.scene.Node;

import java.io.FileNotFoundException;

public class GUIController {
    private GUIView theView;

    private static final int MAIN = 0;
    private static final int STATS = 1;
    private static final int FEED = 2;
    private static final int WALK = 3;
    private static final int SLEEP = 4;
    private static final int PET = 5;
    private static final int MENU = 6;

    private int viewMode;

    public GUIController(GUIView theView) {
        this.theView = theView;

        setRoot(theView.getStartView());

        theView.getNewPetBtn().setOnAction(event -> {
            viewMode = MAIN;
            /**
             * Initialize pet here (DONE)
             *
             */
            String petName = theView.getPetNameTxt().getText();
            PetMain myPet = new PetMain(petName);
            System.out.println(petName);
            theView.setPetNameLbl(petName);
            setRoot(theView.getGameView());
            setView(theView.getPetImgView());
        });

        theView.getLoadPetBtn().setOnAction(event -> {
            /**
             * load functionality
             */
        });

        theView.getMenuBtn().setOnAction(event -> {
            if (viewMode == MENU) {
                viewMode = MAIN;
                setView(theView.getPetImgView());
            } else {
                viewMode = MENU;
                setView(theView.getMenuView());
            }
        });

        theView.getStatsBtn().setOnAction(event -> {
            if (viewMode == STATS) {
                viewMode = MAIN;
                setView(theView.getPetImgView());
            } else {
                viewMode = STATS;
                setView(theView.getStatsView());
            }
        });

        theView.getFeedBtn().setOnAction(event -> {
            if (viewMode == FEED) {
                viewMode = MAIN;
                setView(theView.getPetImgView());
            } else {
                viewMode = FEED;
                setView(theView.getFeedView());
            }
            /**
             * Feed Functionality
             */
        });

        theView.getFeedConfBtn().setOnAction(event -> {
            System.out.println(theView.getFoodSliderVal());
            System.out.println(theView.getSelectedFood());
        });

        theView.getWalkBtn().setOnAction(event -> {
            if (viewMode == WALK) {
                viewMode = MAIN;
                setView(theView.getPetImgView());
            } else {
                viewMode = WALK;
                setView(theView.getWalkView());
            }
            /**
             * Walk functionality
             */
        });

        theView.getPetBtn().setOnAction(event -> {
            if (viewMode == PET) {
                viewMode = MAIN;
                setView(theView.getPetImgView());
            } else {
                viewMode = PET;
                setView(theView.getPetView());
            }
            /**
             * Pet functionality
             */
        });

        theView.getSleepBtn().setOnAction(event -> {
            if (viewMode == SLEEP) {
                viewMode = MAIN;
                setView(theView.getPetImgView());
            } else {
                viewMode = SLEEP;
                setView(theView.getSleepView());
            }
            /**
             * Sleep functionality
             */
        });

        theView.getSkipBtn().setOnAction(event -> {
            try {
                theView.updatePetImgView("bixby_pet.gif");// from neal's function
                viewMode = MAIN;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            setView(theView.getPetImgView());

            // helper method to update day
            theView.updateDayLbl(2);
            /**
             * Skip functionality
             */
        });

        theView.getSaveExitBtn().setOnAction(event -> {
            /**
             * Save functionality here
             */
            System.exit(0);
        });
    }

    private void setView(Node view) {
        theView.getMainDisplay().getChildren().clear();
        theView.getMainDisplay().getChildren().add(view);
    }

    private void setRoot(Node view) {
        theView.getRoot().getChildren().clear();
        theView.getRoot().getChildren().add(view);
    }
}
