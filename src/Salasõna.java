import java.security.SecureRandom;
import java.util.Random;

public class Salasõna implements Genereerija {
    private String salasõna;
    private static final String väikesedTähed = "abcdefghijklmnopqrstuvwxyz";
    private static final String suuredTähed = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String numbrid = "1234567890";
    private static final String muudSümbolid = "!@#$%^&*()_+-=[]{}|;':\\\"<>,.?/";
    public static final String kõikSümbolid = väikesedTähed + suuredTähed + numbrid + muudSümbolid;

    public Salasõna(String salasõna) {
        this.salasõna = salasõna;
    }
    public Salasõna() {
        this.salasõna = genereeri();
    }

    @Override
    public String genereeri() {
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

    @Override
    public String toString() {
        return salasõna;
    }
}
