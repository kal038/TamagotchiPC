package GUI;

import Pet.PetMain;
import javafx.scene.Node;

import java.io.FileNotFoundException;

public class GUIController {
    private GUIView theView;

    private static final int PET = 0;
    private static final int STATS = 1;
    private static final int MENU = 2;

    private int viewMode;

    public GUIController(GUIView theView) {
        this.theView = theView;

        setRoot(theView.getStartView());

        theView.getNewPetBtn().setOnAction(event -> {
            viewMode = PET;
            /**
             * Initialize pet here (DONE)
             *
             */
            String petName = theView.getPetNameTxt().getText();
            PetMain myPet = new PetMain(petName);
            System.out.println(petName);
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
            /**
             * Feed Functionality
             */
        });

        theView.getCleanBtn().setOnAction(event -> {
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
                theView.updatePetView();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            setView(theView.getPetView());
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
