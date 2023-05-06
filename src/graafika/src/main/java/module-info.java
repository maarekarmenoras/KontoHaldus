module com.ui.graafika {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ui.graafika to javafx.fxml;
    exports com.ui.graafika;
}