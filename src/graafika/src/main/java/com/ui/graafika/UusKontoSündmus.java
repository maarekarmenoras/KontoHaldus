package com.ui.graafika;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UusKontoSündmus implements EventHandler {
    private Stage pealava;
    private HBox hbox;
    public UusKontoSündmus(Stage lava, HBox hbox) {
        this.pealava = lava;
        this.hbox = hbox;
    }
    @Override
    public void handle(Event event) {

        //struktuur
        VBox uusKontoJuur = new VBox();
        BorderPane bp = new BorderPane();
        bp.setTop(hbox);
        Scene uusKontoStseen = new Scene(uusKontoJuur, Color.WHITE);
        GridPane ruudustik = new GridPane();

        //kujundus
        uusKontoJuur.setAlignment(Pos.TOP_CENTER);
        uusKontoJuur.setPadding(new Insets(10));

        uusKontoJuur.getChildren().add(bp);
        uusKontoJuur.getChildren().add(ruudustik);

        ruudustik.setAlignment(Pos.TOP_CENTER);
        ruudustik.setPadding(new Insets(10));
        ruudustik.setHgap(10);
        ruudustik.setVgap(10);

        //ruudustik ja tema elemendid
        TextField portaal = new TextField();
        TextField kasutajanimi = new TextField();
        TextField salasõna = new TextField();

        Button genereeriKasutajanimi = new Button("Genereeri");
        Button genereeriSalasõna = new Button("Genereeri");
        Button lisaUusKonto = new Button("Lisa konto");

        ruudustik.add(new Label("Lisa uus konto"), 0, 0);

        ruudustik.add(new Label("Portaal:"), 0, 1);
        ruudustik.add(portaal, 1, 1);

        ruudustik.add(new Label("Kasutajanimi:"), 0, 2);
        ruudustik.add(kasutajanimi, 1, 2);
        ruudustik.add(genereeriKasutajanimi, 2, 2);

        ruudustik.add(new Label("Salasõna"), 0, 3);
        ruudustik.add(salasõna, 1, 3);
        ruudustik.add(genereeriSalasõna, 2, 3);

        ruudustik.add(lisaUusKonto, 0, 4);

        //lava
        //TODO: tee nii et see uus stseen millegipärast paremale ei nihkuks
        pealava.setScene(uusKontoStseen);
        pealava.show();
    }
}
