package com.ui.graafika;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

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
        vaataKontosidJuur.getChildren().add(bp);

        Scene vaataKontosidStseen = new Scene(vaataKontosidJuur, Color.WHITE);

        TableView<String[]> tabel = new TableView<>();
        ScrollPane sp = new ScrollPane();
        sp.setContent(tabel);

        //kujundus
        vaataKontosidJuur.setAlignment(Pos.TOP_CENTER);
        vaataKontosidJuur.setPadding(new Insets(10));

        sp.setFitToWidth(true);

        //tabel
        ObservableList<String[]> andmed = null;

        TableColumn<String[], String> portaal = new TableColumn<>("Portaal");
        portaal.setCellValueFactory(rida -> new SimpleStringProperty(rida.getValue()[0]));
        TableColumn<String[], String> kasutajanimi = new TableColumn<>("Kasutajanimi");
        kasutajanimi.setCellValueFactory(rida -> new SimpleStringProperty(rida.getValue()[1]));
        TableColumn<String[], String> salasõna = new TableColumn<>("Salasõna");
        salasõna.setCellValueFactory(rida -> new SimpleStringProperty(rida.getValue()[2]));

        try {
            andmed = loeKontod();
            tabel.setItems(andmed);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        tabel.getColumns().addAll(portaal, kasutajanimi, salasõna);

        if (tabel.getItems().isEmpty()) {
            Text sõnum = new Text("See programm ei ole veel ühegi konto infot salvestanud või on kõigi talletatud kontode info ära kustatud. Uue konto lisamiseks vajuta nupul 'Lisa konto'.");
            sõnum.setWrappingWidth(pealava.getWidth()-40);
            sõnum.setTextAlignment(TextAlignment.CENTER);
            vaataKontosidJuur.getChildren().add(sõnum);
        } else {
            vaataKontosidJuur.getChildren().add(sp);
        }

        pealava.setScene(vaataKontosidStseen);
        pealava.show();
    }

    private static ObservableList<String[]> loeKontod() throws Exception { //TODO: loe failist kontod
        ObservableList<String[]> andmed = FXCollections.observableArrayList();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("kasutajad.txt"), "utf-8"))) {
            String portaal = br.readLine();
            while (portaal != null) {
                String[] rida = new String[3];
                String kasutajanimi = br.readLine();
                String salasõna = br.readLine();
                rida[0] = portaal;
                rida[1] = kasutajanimi;
                rida[2] = salasõna;
                andmed.add(rida);
                portaal = br.readLine();
            }
            return andmed;
        }
    }
}