package org.example.Entities;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import org.example.WarehouseController;

import java.util.ArrayList;

public class CategoryPane extends TitledPane {

    private Category category;
    private final VBox productsVBox = new VBox();
    private ArrayList<ProductLabel> productLabels = new ArrayList<>();

    public CategoryPane(Category category) {
        super();
        this.category = category;
        this.setText(category.getName());
        this.updateDescriptionTip();
        this.addContextMenu();
    }

    public CategoryPane(Category category, ArrayList<ProductLabel> productLabels) {
        super();
        this.category = category;
        this.productLabels = productLabels;

        for (ProductLabel productLabel : this.productLabels)
            this.productsVBox.getChildren().add(productLabel);

        this.setText(category.getName());
        this.setContent(this.productsVBox);
        this.updateDescriptionTip();
        this.addContextMenu();
    }

    private void updateDescriptionTip() {
        this.setTooltip(new Tooltip(this.category.getDescription()));
    }

    public void addProduct(Product product) {
        ProductLabel productLabel = new ProductLabel(product);

        // TODO: Database callback
        addProductLabel(productLabel);
    }

    public void removeProduct(Product product) {
        ProductLabel productLabel = new ProductLabel(product);

        // TODO: Database callback
        removeProductLabel(productLabel);
    }

    public void editCategory(Category category) {
        // TODO: Database callback
        setCategory(category);
    }

    private void addContextMenu() {
        final ContextMenu menu = new ContextMenu();
        MenuItem add = new MenuItem("Add product");
        MenuItem edit = new MenuItem("Edit category");
        MenuItem remove = new MenuItem("Remove category");
        menu.getItems().addAll(add, edit, remove);

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("ADD");
            }
        });

        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("EDIT");
            }
        });

        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("REMOVE");
                WarehouseController.removeCategoryPane(CategoryPane.this);
            }
        });

        this.setContextMenu(menu);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        this.updateDescriptionTip();
    }

    public void addProductLabel(ProductLabel productLabel) {
        productsVBox.getChildren().add(productLabel);
        productLabels.add(productLabel);
    }

    public void removeProductLabel(ProductLabel productLabel) {
        productsVBox.getChildren().remove(productLabel);
        productLabels.add(productLabel);
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> res = new ArrayList<Product>();
        for (ProductLabel productLabel : this.productLabels)
            res.add(productLabel.getProduct());
        return res;
    }
}
