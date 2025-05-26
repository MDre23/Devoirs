module com.example.tp_poo2_gestiondesevenements {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.json;
    requires com.fasterxml.jackson.databind;

    opens com.example.tp_poo2_gestiondesevenements to javafx.fxml;
    exports com.example.tp_poo2_gestiondesevenements;
}