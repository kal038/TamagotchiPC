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
            // check if the pet is alive
//            if (myGame.getMyPet().getHappiness() == 0 || myGame.getMyPet().getHunger() == 0 || myGame.getMyPet().getHygiene() == 0 || myGame.getMyPet().getSleep() == 0 ) {
//                System.out.println("Your pet is dead, GAME OVER");
//            }

            try {
                theView.updatePetView(myGame.getMyPet().getPetImage());// from neal's function
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            setView(theView.getPetView());


            /**
             * Skip functionality (HALF-DONE, need to decrease the stat bars)
             */
            // decrease stats by 5 everyday
            try {
                myGame.getMyPet().decreaseHappiness(10);
                myGame.getMyPet().decreaseHunger(10);
                myGame.getMyPet().decreaseSleep(10);
                myGame.getMyPet().decreaseHygiene(10);
                theView.getHappinessStats().setStatValue(myGame.getMyPet().getHappiness() / 100.0);
                theView.getHungerStats().setStatValue(myGame.getMyPet().getHunger() / 100.0);
                theView.getHygieneStats().setStatValue(myGame.getMyPet().getHygiene() / 100.0);
                theView.getSleepStats().setStatValue(myGame.getMyPet().getSleep() / 100.0);
            } catch (Exception e) {
                System.out.println("Your pet is dead");;
            }


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
