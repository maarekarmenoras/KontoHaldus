import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Peaklass {
    public static void main(String[] args) throws IOException {
        String kasutajaSisend;
        Kasutajanimi kasutajanimi;
        Salasõna salasõna;
        String portaal;
        BufferedReader kasutajaSisendiLugeja = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Sisestage kasutajanimi (tühja sisendi puhul genereeritakse automaatselt): ");
        kasutajaSisend = kasutajaSisendiLugeja.readLine();
        if (kasutajaSisend != null) {
            kasutajanimi = new Kasutajanimi(kasutajaSisend);
        } else {
            kasutajanimi = new Kasutajanimi();
        }
        System.out.print("Sisestage salasõna (tühja sisendi pihul genereeritakse automaatselt: )");
        kasutajaSisend = kasutajaSisendiLugeja.readLine();
        if (kasutajaSisend != null) {
            salasõna = new Salasõna(kasutajaSisend);
        } else {
            salasõna = new Salasõna();
        }
        System.out.println("Sisestage kasutatav portaal ");
        portaal = kasutajaSisendiLugeja.readLine();
        kasutajaSisendiLugeja.close();

        salasõna.kontrolli();
        Kasutaja kasutaja = new Kasutaja(kasutajanimi, salasõna, portaal);
        kasutaja.KirjutaFaili();
    }
}