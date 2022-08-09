module com.example.dsa2assignment1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dsa2assignment1 to javafx.fxml;
    exports com.example.dsa2assignment1;
}