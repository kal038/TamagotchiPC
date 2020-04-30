package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

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
}
