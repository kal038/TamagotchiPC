package GUI;

import Pet.Game;
import Pet.PetMain;
import javafx.scene.Node;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class GUIController {
    private GUIView theView;
    private PetMain myPet;
    private Game myGame;

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
            myPet = new PetMain(petName);
            // initialize the game instance
            myGame = new Game(myPet);
            System.out.println(myGame.getMyPet().getName());
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
             * Clean functionality
             */
        });

        theView.getWalkConfBtn().setOnAction(event -> {
            // Walk Now button handler
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

        theView.getPetConfBtn().setOnAction(event -> {
            // Pet Now button handler
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

        theView.getSleepConfBtn().setOnAction(event -> {
            // Sleep now button handler
        });

        theView.getSkipBtn().setOnAction(event -> {
            // check if the pet is alive
//            if (myGame.getMyPet().getHappiness() == 0 || myGame.getMyPet().getHunger() == 0 || myGame.getMyPet().getHygiene() == 0 || myGame.getMyPet().getSleep() == 0 ) {
//                System.out.println("Your pet is dead, GAME OVER");
//            }

            try {
                theView.updatePetImgView("bixby_pet.gif");// from neal's function
                viewMode = MAIN;
                theView.updatePetImgView(myGame.getMyPet().getPetImage());// from neal's function
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            setView(theView.getPetImgView());


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
                setRoot(theView.getDeadPetView());
//                System.out.println("Your pet is dead");
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
