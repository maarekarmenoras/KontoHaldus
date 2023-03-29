public class Kasutaja {
    private Kasutajanimi kasutajanimi;
    private Salasõna salasõna;
    private String portaal;

    public Kasutaja(Kasutajanimi kasutajanimi, Salasõna salasõna, String portaal) {
        this.kasutajanimi = kasutajanimi;
        this.salasõna = salasõna;
        this.portaal = portaal;
    }

    public void KirjutaFaili() {

    }

    @Override
    public String toString() {
        return "Kasutaja kohas " + portaal + ": \n" +
                "kasutajanimi = " + kasutajanimi.toString() +
                ", salasõna = " + salasõna.toString();
    }
}
