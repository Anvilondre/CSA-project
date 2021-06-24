module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.RequestsManagers;
    opens org.example.RequestsManagers to javafx.fxml;
}