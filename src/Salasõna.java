public class Salasõna implements Genereerija {
    private String salasõna;

    public Salasõna(String salasõna) {
        this.salasõna = salasõna;
    }
    public Salasõna() {
        this.salasõna = genereeri();
    }

    public void kontrolli() {
        //teeb oma kontrollimise maagiat, vb tarvilik integreerida genereerija klassi
        //arvutab parooli tugevust
        //väljastab nõuandeid
        //vaatab pikkust, kas sees on kasutajanimi või veebilehe nimi või osad, kas sees on special charactere, suuri-väikseid tähti, numbreid, võrdleb salasõna listiga, võrdleb teiste paroolidega
    }

    @Override
    public String genereeri() {
        return null;
    }

    public String getSalasõna() {
        return salasõna;
    }
}
