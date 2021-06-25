package org.example.Entities;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class AddSubtractAmount extends Dialog<Double> {
    public AddSubtractAmount(boolean add) {
        super();
        Label addLabel;
        if (add) {
            this.setTitle("Add amount");
            addLabel = new Label("How much do you want to add?");
        }
        else {
            this.setTitle("Subtract amount");
            addLabel = new Label("How much do you want to subtract?");
        }

        DialogPane dialogPane = this.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CANCEL);

        TextField amount = new TextField();

        dialogPane.setContent(new VBox(5, addLabel, amount));

        this.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.APPLY) {
                return Double.parseDouble(amount.getText());
            }
            return null;
        });
    }

}
