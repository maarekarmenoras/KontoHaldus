package com.ui.graafika;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VaataKontosidSündmus implements EventHandler {
    private Stage pealava;
    private HBox hbox;

    public VaataKontosidSündmus(Stage pealava, HBox hbox) {
        this.pealava = pealava;
        this.hbox = hbox;
    }

    @Override
    public void handle(Event event) {

        //struktuur
        VBox vaataKontosidJuur = new VBox();
        BorderPane bp = new BorderPane();
        bp.setTop(hbox);
        Scene vaataKontosidStseen = new Scene(vaataKontosidJuur, Color.WHITE);

        TableView<String> tabel = new TableView<>();
        ScrollPane sp = new ScrollPane();
        sp.setContent(tabel);

        //kujundus
        vaataKontosidJuur.setAlignment(Pos.TOP_CENTER);
        vaataKontosidJuur.setPadding(new Insets(10));

        vaataKontosidJuur.getChildren().add(bp);
        vaataKontosidJuur.getChildren().add(tabel);

        //tabel
        TableColumn<String, String> portaal = new TableColumn<>("Portaal");
        TableColumn<String, String> kasutajanimi = new TableColumn<>("Kasutajanimi");
        TableColumn<String, String> salasõna = new TableColumn<>("Salasõna");
        tabel.getColumns().addAll(portaal, kasutajanimi, salasõna);

        //loeKontod();

        pealava.setScene(vaataKontosidStseen);
        pealava.show();
    }

    /*private static void loeKontod() { //TODO: loe failist kontod
    }*/
}
