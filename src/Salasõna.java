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
    }
    //aga mida see juurde annab et need asjad kõik eraldi klassis on

}
