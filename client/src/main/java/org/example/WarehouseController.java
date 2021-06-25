package org.example;

import java.util.ArrayList;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import org.example.Entities.*;

public class WarehouseController {

    @FXML
    private TextField searchUnitTextField;

    @FXML
    private TextArea generalStatisticsText;

    @FXML
    private Button searchUnitButton;

    @FXML
    private Button addCategoryButton;

    @FXML
    private void addCategory() {
        CategoryDialog dialog = new CategoryDialog();
        Optional<Category> results = dialog.showAndWait();
        results.ifPresent((Category result) -> {
            // TODO: Database callback
            addCategoryPane(new CategoryPane(result));
        });
    }

    @FXML
    private ScrollPane groupsScrollPane;

    private static VBox groupsUnitsVBox;

    private ArrayList<CategoryPane> categoryPanes = new ArrayList<>();

    @FXML
    public void initialize() {
        groupsUnitsVBox = new VBox();
        groupsScrollPane.setContent(groupsUnitsVBox);
    }

    @FXML
    private void searchUnitByName() {
        for (CategoryPane pane : categoryPanes)
            pane.seekSubName(searchUnitTextField.getText());
    }

    private void addCategoryPane(CategoryPane categoryPane) {
        categoryPanes.add(categoryPane);
        groupsUnitsVBox.getChildren().add(categoryPane);
    }

    public static void removeCategoryPane(CategoryPane categoryPane) {
        groupsUnitsVBox.getChildren().remove(categoryPane);
    }

}