module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.RequestsManagers;
    exports org.example.Entities;
    opens org.example.RequestsManagers to javafx.fxml;
}