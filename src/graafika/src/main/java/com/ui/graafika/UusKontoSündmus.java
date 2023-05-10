package com.ui.graafika;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.Arrays;
import java.util.Optional;

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
        Genereerija genereerija = new Genereerija();

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

        //uue konto lisamine
        lisaUusKonto.setOnAction(e -> {
            String portaalSisend = portaal.getText();
            String kasutajanimiSisend = kasutajanimi.getText();
            String salasõnaSisend = salasõna.getText();

            try {
                kontrolliSalasõnaTugevust(salasõnaSisend);
                salvestaKonto(portaal.getText(), kasutajanimi.getText(), salasõna.getText());
            } catch (NõrkSalasõnaErind ne) {
                if (näitaHoiatust(ne.getMessage() + " Kas te soovite jätkata?")) {
                    salvestaKonto(portaal.getText(), kasutajanimi.getText(), salasõna.getText());
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        genereeriKasutajanimi.setOnAction(e -> {
            try {
                String genereeritudKasutajanimi = genereerija.genereeriKasutajanimi();
                kasutajanimi.setText(genereeritudKasutajanimi);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        genereeriSalasõna.setOnAction(e -> {
            try {
                String genereeritudSalasõna = genereerija.genereeriSalasõna();
                salasõna.setText(genereeritudSalasõna);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

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
    //Tuuduri vana kood
    public void kontrolliSalasõnaTugevust(String salasõna) throws IOException, NõrkSalasõnaErind {
        String väikesedTähed = "abcdefghijklmnopqrstuvwxyz";
        String suuredTähed = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbrid = "1234567890";
        String muudSümbolid = "!@#$%^&*()_+-=[]{}|;':\\\"<>,.?/";
        String kõikSümbolid = väikesedTähed + suuredTähed + numbrid + muudSümbolid;

        // Kontrollime ega salasõna pole 100000 enim kasutatud salasõna seas.
        String[] kõigeKasutatavamadSalasõnad = new String[100000];
        File fail = new File("kõigeEnimKasutatudSalasõnad.txt");
        BufferedReader lugeja = new BufferedReader(new FileReader(fail));
        for (int i = 0; i < 100000; i++) {
            kõigeKasutatavamadSalasõnad[i] = lugeja.readLine();
        }
        lugeja.close();
        if (Arrays.asList(kõigeKasutatavamadSalasõnad).contains(salasõna.toString())) {
            throw new NõrkSalasõnaErind("Teie salasõna on üks kõige enim kasutatud salasõnadest. Soovitame tugevalt seda muuta.");
        }
    }
    public static boolean näitaHoiatust(String sõnum) {
        Alert hoiatus = new Alert(Alert.AlertType.WARNING);
        hoiatus.setHeaderText("Hoiatus");
        hoiatus.setTitle("");
        hoiatus.setContentText(sõnum);

        ButtonType jah = new ButtonType("Jah");
        ButtonType ei = new ButtonType("Ei");

        hoiatus.getButtonTypes().setAll(jah, ei);

        Optional<ButtonType> tulemus = hoiatus.showAndWait();
        hoiatus.hide();
        if (tulemus.get() == jah) {
            return true;
        } else {
            return false;
        }
    }

    public static void näitaTeavitust(String pealkiri, String sõnum) {
        Alert teavitus = new Alert(Alert.AlertType.CONFIRMATION);
        teavitus.setHeaderText(pealkiri);
        teavitus.setTitle("");
        teavitus.setContentText(sõnum);

        ButtonType ok = new ButtonType("OK");

        teavitus.getButtonTypes().setAll(ok);
        teavitus.showAndWait();
    }
    public static void salvestaKonto(String portaal, String kasutajanimi, String salasõna) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("kasutajad.txt", true), "utf-8") )) {
            bw.write(portaal);
            bw.newLine();
            bw.write(kasutajanimi);
            bw.newLine();
            bw.write(salasõna);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        näitaTeavitust("Konto lisatud.", "Teie konto on lisatud salvestatud kontode nimekirja ja on nähtaval salvestatud kontode tabelis.");
    }
}