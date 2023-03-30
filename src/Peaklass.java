import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Peaklass {
    public static void main(String[] args) throws IOException {
        String kasutajaSisend;
        Kasutajanimi kasutajanimi;
        Salasõna salasõna;
        String portaal;
        Kasutaja kasutaja;
        BufferedReader kasutajaSisendiLugeja = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("See on kontode haldamise programm.");
        System.out.println("Lisa uus konto: L");
        System.out.println("Lõpeta töö: E");
        while (true) {
            System.out.print("Sisesta käsk: ");
            kasutajaSisend = kasutajaSisendiLugeja.readLine();
            if (kasutajaSisend.equals("E")) {
                kasutajaSisendiLugeja.close();
                break;
            } else if (kasutajaSisend.equals("L")) {
                System.out.print("Sisestage kasutatav portaal: ");
                portaal = kasutajaSisendiLugeja.readLine();

                System.out.print("Sisestage kasutajanimi (tühja sisendi puhul genereeritakse automaatselt): ");
                kasutajaSisend = kasutajaSisendiLugeja.readLine();
                if (!Objects.equals(kasutajaSisend, "")) {
                    kasutajanimi = new Kasutajanimi(kasutajaSisend);
                }
                else {
                    kasutajanimi = new Kasutajanimi();
                }

                System.out.print("Sisestage salasõna (tühja sisendi puhul genereeritakse automaatselt): ");
                kasutajaSisend = kasutajaSisendiLugeja.readLine();
                if (!Objects.equals(kasutajaSisend, "")) {
                    salasõna = new Salasõna(kasutajaSisend);
                    kasutaja = new Kasutaja(kasutajanimi, salasõna, portaal);
                    kasutaja.kontrolliSalasõnaTugevust();
                } else {
                    salasõna = new Salasõna();
                    kasutaja = new Kasutaja(kasutajanimi, salasõna, portaal);
                } //TODO: lisa võimalus halva salasõna korral kas uus salasõna sisestada või genereerida.
                kasutaja.KirjutaFaili();
                System.out.println("Lisatud uus kasutaja: \n" + kasutaja.toString());
            }
            else {
                System.out.println("Tundmatu käsk. Proovi uuesti.");
            }
        }

    }
}