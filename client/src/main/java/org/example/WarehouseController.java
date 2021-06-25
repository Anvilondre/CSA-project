package org.example;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import org.example.Entities.Category;
import org.example.Entities.CategoryPane;
import org.example.Entities.Product;
import org.example.Entities.ProductLabel;

public class WarehouseController {

    @FXML
    private TextField searchUnitTextField;

    @FXML
    private Button searchUnitButton;

    @FXML
    private Button addGroupButton;

    @FXML
    private ScrollPane groupsScrollPane;

    private static VBox groupsUnitsVBox;

    @FXML
    private void searchUnitByName() {
        System.out.println("Search button!");
    }

    @FXML
    public void initialize() {
        groupsUnitsVBox = new VBox();
        groupsScrollPane.setContent(groupsUnitsVBox);
    }

    @FXML
    private void addGroupButton() {
        System.out.println("Add group button!");
        ArrayList<ProductLabel> productLabels = new ArrayList<>();
        Product p1 = new Product("PIVO", "pikvo", "ukraina", 10d, 1d, 2);
        Product p2 = new Product("VODKA", "pikvo", "ukraina", 10d, 1d, 2);

        productLabels.add(new ProductLabel(p1));
        productLabels.add(new ProductLabel(p2));

        Category cat = new Category("Buhlo", "kak vodicka");

        CategoryPane pane = new CategoryPane(cat, productLabels);
        groupsUnitsVBox.getChildren().add(pane);
    }

    public static void removeCategoryPane(CategoryPane categoryPane) {
        groupsUnitsVBox.getChildren().remove(categoryPane);
    }
}