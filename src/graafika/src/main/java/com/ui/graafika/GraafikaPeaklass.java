package com.ui.graafika;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GraafikaPeaklass extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage pealava) throws Exception {

        Group juur = new Group();
        Scene stseen = new Scene(juur, Color.WHITE);

        Text tekst = new Text("Kontohalduse programm");
        tekst.setX(50);
        tekst.setY(50); //TODO: tee tekst akna liigutamisele vastavaks

        juur.getChildren().add(tekst);

        //TODO: lisa ikoon

        pealava.setWidth(400); //suvalised arvud, tarvilik hiljem muuta
        pealava.setHeight(250);
        pealava.setTitle("Kontohaldus");

        pealava.setScene(stseen);
        pealava.show();
    }
}
