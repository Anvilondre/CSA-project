package org.example.Entities;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public class ProductLabel extends Button {
    private Product product;

    public ProductLabel(Product product) {
        super();
        this.product = product;
        this.update();
    }

    public void setProduct(Product product) {
        this.product = product;
        this.update();
    }

    public Product getProduct() {
        return product;
    }

    private void update() {
        this.updateText();
        this.updateDescriptionTip();
    }

    private void updateDescriptionTip() {
        this.setTooltip(new Tooltip("Description: " + product.getDescription() +
                                     "\nProducer" + getProduct().getProducer()));
    }

    private void updateText() {
        this.setText(product.getName() + '[' + product.getAmount() + "pcs, " + product.getPrice() + "$]");
    }
}