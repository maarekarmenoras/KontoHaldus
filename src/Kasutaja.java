import java.util.ArrayList;
import java.util.List;

public class Kasutaja {
    Kasutajanimi kasutajanimi;
    Salasõna salasõna;
    String portaal;
    List<Kasutaja> kasutajaList = new ArrayList<>();
    public Kasutaja(Kasutajanimi kasutajanimi, Salasõna salasõna, String portaal) {
        this.kasutajanimi = kasutajanimi;
        this.salasõna = salasõna;
        this.portaal = portaal;
    }
    public void talletaKasutaja(Kasutaja kasutaja) {
        kasutajaList.add(kasutaja);
        System.out.println("Kasutaja lisatud.");
    }
    public void väljastaKasutajad() {
        for (Kasutaja kasutaja : kasutajaList) {
            System.out.println(kasutaja.toString());
        }
    }

    @Override
    public String toString() {
        return "Kasutaja kohas " + portaal + ": \n" +
                "kasutajanimi = " + kasutajanimi.toString() +
                ", salasõna = " + salasõna.toString();
    }
}
