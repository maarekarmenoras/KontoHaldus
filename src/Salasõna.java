public class Salasõna extends Genereerija{
    String salasõna;

    public Salasõna(String salasõna) {
        this.salasõna = salasõna;
    }
    public Salasõna() {
        this.salasõna = genereeri(); //loob kuidagi midagi
    }

    public void kontrolli(Salasõna salasõna) {
        //teeb oma kontrollimise maagiat, vb tarvilik integreerida genereerija klassi
        //arvutab parooli tugevust
        //väljastab nõuandeid
        //vaatab pikkust, kas sees on kasutajanimi või veebilehe nimi või osad, kas sees on special charactere, suuri-väikseid tähti, numbreid, võrdleb salasõna listiga, võrdleb teiste paroolidega
    }

    @Override
    public String genereeri() {
        return null;
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
    //aga mida see juurde annab et need asjad kõik eraldi klassis on

}
