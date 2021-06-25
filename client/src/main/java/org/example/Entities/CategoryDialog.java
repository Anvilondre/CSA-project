package org.example.Entities;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class CategoryDialog extends Dialog<Category> {

    // For new items
    public CategoryDialog () {
        super();
        this.setTitle("Add category");
        DialogPane dialogPane = this.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextField name = new TextField();
        TextField description = new TextField();
        dialogPane.setContent(new VBox(5,
                                        new Label("name"),
                                        name,
                                        new Label("description"),
                                        description));

        this.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.OK) {
                return new Category(name.getText(), description.getText());
            }
            return null;
        });    }

    // For edits
    public CategoryDialog (Category category) {
        super();
        this.setTitle("Edit category");

        DialogPane dialogPane = this.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CANCEL);

        TextField name = new TextField(category.getName());
        TextField description = new TextField(category.getDescription());

        dialogPane.setContent(new VBox(5,
                new Label("name"), name,
                new Label("description"), description));

        this.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.APPLY) {
                return new Category(name.getText(), description.getText());
            }
            return null;
        });
    }
}
