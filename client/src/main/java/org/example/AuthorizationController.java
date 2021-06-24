package org.example;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.example.RequestsManagers.SignInRequest.doSignInRequest;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class AuthorizationController {


    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private void login() throws IOException {
        try {
            if(doSignInRequest(loginTextField.getText(), passwordTextField.getText()) == 200){
                App.goToWarehouse(loginTextField.getText(), passwordTextField.getText());
            }
            else {
                // TODO: Add exception please
                System.out.println("Error");
            }
        } catch (URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
