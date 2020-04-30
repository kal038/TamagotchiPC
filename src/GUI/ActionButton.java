package GUI;

import javafx.scene.control.Button;

public class ActionButton {

    private Button actionButton;

    public ActionButton(ActionTypes type) {
        actionButton = new Button(type.name());
        actionButton.setPrefHeight(50);
        actionButton.setPrefWidth(100);
    }

    public Button getActionButton() {
        return actionButton;
    }
}
