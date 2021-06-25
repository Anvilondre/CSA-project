package org.example.Entities;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class AddSubtractAmount extends Dialog<Double> {
    public AddSubtractAmount(boolean add, Double currentAmount) {
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
                try {
                    Double amountValue = Double.parseDouble(amount.getText());
                    if ((add ? amountValue : -amountValue) + currentAmount < 0)
                        throw new IllegalArgumentException("amount can't be negative");
                    return Double.parseDouble(amount.getText());
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Wrong parameters!\n(" + e.getMessage() + ")");
                    alert.showAndWait();
                }
            }
            return null;
        });
    }

}
