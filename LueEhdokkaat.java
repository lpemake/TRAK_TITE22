import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

public class LueEhdokkaat {
    public static void main(String[] args) {
        ArrayList<Ehdokas> ehdokkaat = new ArrayList<>();

        try {
            Scanner tiedosto = new Scanner(Paths.get("ehdokkaat.txt"));

            while (tiedosto.hasNextLine())
            {
                String rivi = tiedosto.nextLine();
                // palastellaan rivi
                String[] palaset = rivi.split("\\s+");

                String en = palaset[0];
                String sn = palaset[1];
                String puolue = palaset[2];
                int aanimaara = Integer.parseInt(palaset[3]);
                // luodaan olio
                Ehdokas e = new Ehdokas(en, sn, puolue, aanimaara);
                // lisätään listaan
                ehdokkaat.add(e);
            }

            for (Ehdokas ehdokas : ehdokkaat) {
                System.out.println(ehdokas.toString());
            }

        } catch (Exception e) {
            System.out.println("virhe");
        }
    }
}
