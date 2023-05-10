package com.ui.graafika;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Random;

//Tuuduri vana kood
public class Genereerija {
    private static final String väikesedTähed = "abcdefghijklmnopqrstuvwxyz";
    private static final String suuredTähed = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String numbrid = "1234567890";
    private static final String muudSümbolid = "!@#$%^&*()_+-=[]{}|;':\\\"<>,.?/";
    public static final String kõikSümbolid = väikesedTähed + suuredTähed + numbrid + muudSümbolid;

    public String genereeriSalasõna() {
        StringBuilder salasõna = new StringBuilder();
        Random randomizer = new SecureRandom();
        int salasõnaPikkus = randomizer.nextInt(5) + 15; // genereerime pikkuse vahemikus 16-20.
        for (int i = 0; i < salasõnaPikkus; i++) {
            // Valime igaks salasõna liikmeks suvalise elemendi "kõikSümbolid" listist.
            salasõna.append(kõikSümbolid.charAt(randomizer.nextInt(kõikSümbolid.length())));
        }
        return salasõna.toString();

        // TODO: muuda generatsiooni nii, et salasõnas oleks alati vähemalt 3 liiget igast kategooriast.
    }

    public String genereeriKasutajanimi() throws IOException {
        // Kasutame nimede genereerimiseks randommer.io APId
        URL url = new URL("https://randommer.io/api/Name?nameType=firstname&quantity=1");
        HttpURLConnection ühendus = (HttpURLConnection) url.openConnection(); // Loome ühenduse
        ühendus.setRequestMethod("GET");
        ühendus.setRequestProperty("X-Api-Key", "061ef808d9e24012b050e6875bc44285"); // Anname vajaliku headeri
        BufferedReader in = new BufferedReader(new InputStreamReader(ühendus.getInputStream()));
        String kasutajanimi = in.readLine(); // Loeme vastuse
        in.close();
        return kasutajanimi.substring(2, kasutajanimi.length() - 2);
    }
}
