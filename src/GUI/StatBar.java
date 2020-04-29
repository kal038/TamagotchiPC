package GUI;

import javafx.scene.control.ProgressBar;

public class StatBar {

    /**
     * The JavaFX progress bar that will be used as a
     * stat bar for this application
     */
    private ProgressBar statBarGUI;

    public StatBar(StatTypes type) {
        ProgressBar statBarGUI = new ProgressBar();
        statBarGUI.setStyle("-fx-accent: " + type.getColor() + ";");
        statBarGUI.setProgress(1.0);
    }

    public ProgressBar getStatBarGUI() {
        return statBarGUI;
    }
}
