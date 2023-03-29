import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Kasutajanimi extends Genereerija{
    String kasutajanimi;

    public Kasutajanimi(String kasutajanimi) {
        this.kasutajanimi = kasutajanimi;
    }
    public Kasutajanimi() throws IOException {
        this.kasutajanimi = genereeri();
    }


    @Override
    public String genereeri() throws IOException {
        // Kasutame nimede genereerimiseks randommer.io APId.
        URL url = new URL("https://randommer.io/api/Name?nameType=firstname&quantity=1");
        HttpURLConnection ühendus = (HttpURLConnection) url.openConnection(); // Loome ühenduse
        ühendus.setRequestMethod("GET");
        ühendus.setRequestProperty("X-Api-Key", "061ef808d9e24012b050e6875bc44285"); // Anname vajaliku headeri
        BufferedReader in = new BufferedReader(new InputStreamReader(ühendus.getInputStream()));
        String kasutajanimi = in.readLine(); // Loeme vastuse
        in.close();
        return kasutajanimi;
    }

    @Override
    public void loeFailist() {

    }

    @Override
    public void kirjutaFaili() {

    }

    @Override
    public void tühjendaFail() {

    }
}
