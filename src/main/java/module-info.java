module org.example.myjavaprojects {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.myjavaprojects to javafx.fxml;
    exports org.example.myjavaprojects;
}