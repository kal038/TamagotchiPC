package GUI;

import javafx.scene.Node;

public class GUIController {
    private GUIView theView;

    private static final int START = 0;
    private static final int PET = 1;
    private static final int STATS = 2;
    private static final int MENU = 3;

    private int viewMode;

    public GUIController(GUIView theView) {
        this.theView = theView;

        viewMode = START;
        setRoot(theView.getStartView());

        theView.getNewGameBtn().setOnAction(event -> {
            viewMode = PET;
            setRoot(theView.getGameView());
            setView(theView.getPetView());
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
