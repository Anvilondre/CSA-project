package org.example.Entities;

import javafx.scene.control.Label;

public class ProductLabel extends Label {
    private Product product;

    public ProductLabel(Product product) {
        super();
        this.product = product;
        this.updateText();
    }

    public void setProduct(Product product) {
        this.product = product;
        this.updateText();
    }

    public Product getProduct() {
        return product;
    }

    private void updateText() {
        this.setText(product.getName() + '[' + product.getAmount() + "pcs, " + product.getPrice() + "$]");
    }
}