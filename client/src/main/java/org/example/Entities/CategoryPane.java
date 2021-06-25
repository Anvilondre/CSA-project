package org.example.Entities;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
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

    public CategoryPane(Category cat, ArrayList<ProductLabel> productLabels) {
        super();
        this.category = cat;

        for (ProductLabel productLabel : productLabels) {
            this.productsVBox.getChildren().add(new CategoryProductLabel(productLabel));
            productLabel.toFront();
        }

        this.setText(category.getName());
        this.setContent(this.productsVBox);
        this.updateDescriptionTip();
        this.addContextMenu();
    }


    private void addProduct() {

        // ProductLabel productLabel = new ProductLabel(product);

        // TODO: Database callback
        // addProductLabel(productLabel);
    }

    private void editCategory() {

        // TODO: Database callback
        // setCategory(category);
    }

    private void removeCategory() {

        // TODO: Database callback
        WarehouseController.removeCategoryPane(this);
    }

    private void addContextMenu() {
        ContextMenu menu = new ContextMenu();
        MenuItem add = new MenuItem("Add product");
        MenuItem edit = new MenuItem("Edit category");
        MenuItem remove = new MenuItem("Remove category");
        menu.getItems().addAll(add, edit, remove);

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CategoryPane.this.addProduct();
            }
        });

        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CategoryPane.this.editCategory();
            }
        });

        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CategoryPane.this.removeCategory();
            }
        });
        this.setContextMenu(menu);
    }

    private void update() {
        updateName();
        updateDescriptionTip();
    }

    private void updateName() {
        this.setText(category.getName());
    }

    private void updateDescriptionTip() {
        this.setTooltip(new Tooltip("Description: " + category.getDescription()));
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        this.update();
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

    /** Class for units inside category list **/

    public class CategoryProductLabel extends ProductLabel {

        public CategoryProductLabel(Product product) {
            super(product);
            addContextMenu();
        }

        public CategoryProductLabel(ProductLabel productLabel) {
            super(productLabel.getProduct());
            addContextMenu();
        }


        private void addAmount() {
            // TODO: Database callback
        }

        private void reduceAmount() {
            // TODO: Database callback
        }

        private void editProduct() {
            // TODO: Database callback
        }

        private void removeProduct() {

            // TODO: Database callback
            removeProductLabel(this);
        }

        private void addContextMenu() {
            ContextMenu menu = new ContextMenu();
            MenuItem add = new MenuItem("Add amount");
            MenuItem reduce = new MenuItem("Reduce amount");
            MenuItem edit = new MenuItem("Edit product");
            MenuItem remove = new MenuItem("Remove product");
            menu.getItems().addAll(add, reduce, edit, remove);

            add.setOnAction(new EventHandler<>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    CategoryProductLabel.this.addAmount();
                }
            });

            reduce.setOnAction(new EventHandler<>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    CategoryProductLabel.this.reduceAmount();
                }
            });

            edit.setOnAction(new EventHandler<>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    CategoryProductLabel.this.editProduct();
                }
            });

            remove.setOnAction(new EventHandler<>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    CategoryProductLabel.this.removeProduct();
                }
            });
            this.setContextMenu(menu);
        }

    }
}
