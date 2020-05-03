package GUI;

import Pet.Game;
import Pet.PetMain;
import javafx.scene.Node;

import java.io.FileNotFoundException;

public class GUIController {
    private GUIView theView;
    private PetMain myPet;
    private Game myGame;
    private static final int PET = 0;
    private static final int STATS = 1;
    private static final int FEED = 2;
    private static final int MENU = 3;

    private int viewMode;

    public GUIController(GUIView theView) {
        this.theView = theView;

        setRoot(theView.getStartView());

        theView.getNewPetBtn().setOnAction(event -> {
            viewMode = PET;
            /**
             * Initialize pet here (DONE) (I initialized a pet using the Game instance)
             *
             */
            String petName = theView.getPetNameTxt().getText();
            myPet = new PetMain(petName);
            // initialize the game instance
            myGame = new Game(myPet);
            System.out.println(myGame.getMyPet().getName());
            theView.setPetNameLbl(petName);
            setRoot(theView.getGameView());
            setView(theView.getPetView());
        });

        theView.getLoadPetBtn().setOnAction(event -> {
            /**
             * load functionality
             */
        });

        theView.getMenuBtn().setOnAction(event -> {
            if (viewMode == MENU) {
                viewMode = PET;
                setView(theView.getPetView());
            } else {
                viewMode = MENU;
                setView(theView.getMenuView());
            }
        });

        theView.getStatsBtn().setOnAction(event -> {
            if (viewMode == STATS) {
                viewMode = PET;
                setView(theView.getPetView());
            } else {
                viewMode = STATS;
                setView(theView.getStatsView());
            }
        });

        theView.getFeedBtn().setOnAction(event -> {
            if (viewMode == FEED) {
                viewMode = PET;
                setView(theView.getPetView());
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
            /**
             * Clean functionality
             */
        });

        theView.getPetBtn().setOnAction(event -> {
            /**
             * Pet functionality
             */
        });

        theView.getSleepBtn().setOnAction(event -> {
            /**
             * Sleep functionality
             */
        });

        theView.getSkipBtn().setOnAction(event -> {
            try {
                theView.updatePetView(myGame.getMyPet().getPetImage());// from neal's function
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            setView(theView.getPetView());

            // helper method to update day
            theView.updateDayLbl(2);
            /**
             * Skip functionality (HALF-DONE, need to decrease the stat bars)
             */

            // helper method to update day/age label
            myGame.advanceGameTime(1);
            theView.updateDayLbl(myGame.getMyPet().getAge());

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
