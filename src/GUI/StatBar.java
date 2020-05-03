package GUI;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class StatBar {

    /**
     * The JavaFX progress bar that will be used as a
     * stat bar for this application
     */
    private ProgressBar statProgressBar;

    private Label statLbl;

    public StatBar(StatTypes type) {
        statProgressBar = new ProgressBar();
        statProgressBar.setStyle("-fx-accent: " + type.getColor() + ";");
        statProgressBar.setPrefHeight(30);
        statProgressBar.setPrefWidth(300);
        statProgressBar.setProgress(1.0);

        statLbl = new Label(type.getLabel());
    }

    public ProgressBar getStatProgressBar() {
        return statProgressBar;
    }

    public Label getStatLbl() { return statLbl; }

    /**
     * The statbar value is scaled out of 1.0, with 1.0 being to fullest and 0 being empty
     * @param value
     */
    public void setStatValue(double value) {
        statProgressBar.setProgress(value);
    }

    public double getStatValue() { return statProgressBar.getProgress(); }
}
