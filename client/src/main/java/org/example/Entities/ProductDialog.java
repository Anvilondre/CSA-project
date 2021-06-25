package org.example.Entities;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ProductDialog extends Dialog<Product> {

    // For new items
    public ProductDialog (int categoryId) {
        super();
        this.setTitle("Edit product");

        DialogPane dialogPane = this.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        TextField name = new TextField();
        TextField description = new TextField();
        TextField producer = new TextField();
        TextField amount = new TextField();
        TextField price = new TextField();

        dialogPane.setContent(new VBox(10,
                new Label("name"), name,
                new Label("description"), description,
                new Label("producer"), producer,
                new Label("amount"), amount,
                new Label("price"), price));

        this.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.OK) {
                return new Product(name.getText(), description.getText(),
                        producer.getText(), Double.parseDouble(amount.getText()),
                        Double.parseDouble(price.getText()), categoryId);
            }
            return null;
        });

    }

    // For edits
    public ProductDialog (int categoryId, Product product) {
        super();
        this.setTitle("Edit product");

        DialogPane dialogPane = this.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CANCEL);

        TextField name = new TextField(product.getName());
        TextField description = new TextField(product.getDescription());
        TextField producer = new TextField(product.getProducer());
        TextField amount = new TextField(product.getAmount().toString());
        TextField price = new TextField(product.getPrice().toString());

        dialogPane.setContent(new VBox(8,
                new Label("name"), name,
                new Label("description"), description,
                new Label("producer"), producer,
                new Label("amount"), amount,
                new Label("price"), price));

        this.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.APPLY) {
                return new Product(name.getText(), description.getText(),
                        producer.getText(), Double.parseDouble(amount.getText()),
                        Double.parseDouble(price.getText()), categoryId);
            }
            return null;
        });
    }


}
