import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Kasutaja {
    private Kasutajanimi kasutajanimi;
    private Salasõna salasõna;
    private String portaal;
    private static final String väikesedTähed = "abcdefghijklmnopqrstuvwxyz";
    private static final String suuredTähed = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String numbrid = "1234567890";
    private static final String muudSümbolid = "!@#$%^&*()_+-=[]{}|;':\\\"<>,.?/";

    public Kasutaja(Kasutajanimi kasutajanimi, Salasõna salasõna, String portaal) {
        this.kasutajanimi = kasutajanimi;
        this.salasõna = salasõna;
        this.portaal = portaal;
    }

    public void kontrolliSalasõnaTugevust() throws IOException {
        // Kontrollime ega salasõna pole 100000 enim kasutatud salasõna seas.
        String[] kõigeKasutatavamadSalasõnad = new String[100000];
        File fail = new File("kõigeEnimKasutatudSalasõnad.txt");
        BufferedReader lugeja = new BufferedReader(new FileReader(fail));
        for (int i = 0; i < 100000; i++) {
            kõigeKasutatavamadSalasõnad[i] = lugeja.readLine();
        }
        lugeja.close();
        if (Arrays.asList(kõigeKasutatavamadSalasõnad).contains(salasõna.toString())) {
            System.out.println("Teie salasõna on üks kõige enim kasutatud salasõnadest. Soovitame tugevalt seda muuta.");
            return;
        }

        // Arvutame salasõna entroopia valemiga pikkus * log2(sümbolite hulga pikkus)
        // https://en.wikipedia.org/wiki/Password_strength
        int väikesteTähtedeHulk = 0;
        int suurteTähtedeHulk = 0;
        int numbriteHulk = 0;
        int muudeSümbolitHulk = 0;
        double entroopia = 0;
        for (String liige : salasõna.toString().split("")) {
            if (väikesedTähed.contains(liige)) väikesteTähtedeHulk++;
            else if (suuredTähed.contains(liige)) suurteTähtedeHulk++;
            else if (numbrid.contains(liige)) numbriteHulk++;
            else if (muudSümbolid.contains(liige)) muudeSümbolitHulk++;
        }
        entroopia += väikesteTähtedeHulk * (Math.log(väikesedTähed.length() / Math.log(2)));
        entroopia += suurteTähtedeHulk * (Math.log(suuredTähed.length() / Math.log(2)));
        entroopia += numbriteHulk * (Math.log(numbrid.length() / Math.log(2)));
        entroopia += muudeSümbolitHulk * (Math.log(muudSümbolid.length() / Math.log(2)));
        System.out.println("Sisestatud salasõna entroopia on " + entroopia);

        // TODO: Kontrollida, ega salasõna ei sisalda endas kasutajanime või portaali juppe.
        // TODO: Anda kasutajale mõistetavamat tagasisidet salasõna tugevuse kohta.
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
