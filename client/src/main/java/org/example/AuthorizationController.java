package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AuthorizationController {
    
    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private void login() throws IOException {
        App.goToWarehouse(loginTextField.getText(), passwordTextField.getText());
    }
}
