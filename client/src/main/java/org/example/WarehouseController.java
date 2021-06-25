package org.example;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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
        Product p1 = new Product("PIVO", "pevko", "ukraina", 10d, 1d, 2);
        Product p2 = new Product("VODKA", "vodochka", "ukraina", 10d, 1d, 2);

        productLabels.add(new ProductLabel(p1));
        productLabels.add(new ProductLabel(p2));

        Category cat = new Category("Buhlo", "kak vodicka");

        CategoryPane pane = new CategoryPane(cat, productLabels);
        groupsUnitsVBox.getChildren().add(pane);


        ArrayList<ProductLabel> productLabels2 = new ArrayList<>();
        Product p12 = new Product("PIVO", "pevko", "ukraina", 10d, 1d, 2);
        Product p22 = new Product("VODKA", "vodochka", "ukraina", 10d, 1d, 2);

        productLabels2.add(new ProductLabel(p12));
        productLabels2.add(new ProductLabel(p22));

        Category cat2 = new Category("Buhlo2", "kak vodicka");

        CategoryPane pane2 = new CategoryPane(cat2, productLabels);
        groupsUnitsVBox.getChildren().add(pane2);
    }

    public static void removeCategoryPane(CategoryPane categoryPane) {
        groupsUnitsVBox.getChildren().remove(categoryPane);
    }
}