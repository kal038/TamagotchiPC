package GUI;

import javafx.scene.control.ProgressBar;

public class StatBar {
    /**
     * Stores the value of the stat bar
     */
    private double value;

    /**
     * Label of the stat bar that appears on GUI
     */
    private String label;

    /**
     * The JavaFX progress bar that will be used as a
     * stat bar for this application
     */
    private ProgressBar statBarGUI;

    public StatBar(double initVal, String label) {
        this.value = initVal;
        this.label = label;
        ProgressBar statBarGUI = new ProgressBar(10);
        statBarGUI.setProgress(initVal);
    }
}
