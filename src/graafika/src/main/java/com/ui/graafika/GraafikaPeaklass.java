package com.ui.graafika;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GraafikaPeaklass extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage pealava) throws Exception {

        //üldine kujundus
        StackPane juur = new StackPane();
        BorderPane menüü = new BorderPane();
        Scene algStseen = new Scene(menüü, Color.WHITE);

        pealava.setWidth(500); //suvalised arvud, tarvilik hiljem muuta
        pealava.setHeight(300);
        pealava.setTitle("Kontohaldus");

        //nupud
        Button lisaKonto = new Button("Lisa uus konto");
        Button vaataKontosid = new Button("Vaata salvestatud kontosid");
        Button lahku  = new Button("Lahku");

        //menüü
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(lisaKonto, vaataKontosid, lahku);
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setPadding(new Insets(10));
        HBox.setHgrow(hbox, Priority.ALWAYS);
        menüü.setTop(hbox);

        //nuppude töö
        lisaKonto.setOnAction(e -> {
            new UusKontoSündmus(pealava, hbox).handle(e);
        });

        vaataKontosid.setOnAction(e -> {
            new VaataKontosidSündmus(pealava, hbox).handle(e);
        });

        lahku.setOnAction(e -> Platform.exit());

        pealava.setScene(algStseen);
        pealava.show();
    }
}
