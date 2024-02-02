import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class LueKunnatHasMap2 {
    public static void main(String[] args) {
        // lista kuntia varten 
        ArrayList<Kunta> kunnat = new ArrayList<>();

        HashMap<String, Maakunta> maakunnat = new HashMap<>();

        try {
            Scanner tiedosto = new Scanner(Paths.get("kunnat.txt"));

            while (tiedosto.hasNextLine()) {
                String rivi = tiedosto.nextLine();
                
                String[] palaset = rivi.split("\t");

                try {
                    if (palaset.length != 5)
                        throw new Exception();
                    int koodi = Integer.parseInt(palaset[0]);
                    String nimi = palaset[1];
                    String maakunta = palaset[2];
                    int vakiluku = (int)Double.parseDouble(palaset[3]);
                    double pintaAla = Double.parseDouble(palaset[4]);

                    // tee Kunta-olio
                    Kunta k = new Kunta(koodi, nimi, maakunta, vakiluku, pintaAla);

                    // lisää olio listaan
                    kunnat.add(k);

                    // katsotaan löytyykö kuntaa vastaava maakunta hajautustaulusta
                    if (!maakunnat.containsKey(maakunta)) {
                        // lisätään maakunta hajautustauluun
                        maakunnat.put(maakunta, new Maakunta(nimi));
                    }
                    // haetaan maakunta hajautustaulusta
                    Maakunta m = maakunnat.get(maakunta);
                    // lisätään kunta maakunta-olion listaan
                    m.lisaaKunta(k);

                }
                catch (Exception e)
                {
                    System.out.println("virhe rivillä " + rivi);
                }
            }

            // käydään maakunnat läpi
            for (Maakunta maakunta : maakunnat.values()) {
                System.out.println(maakunta.toString());
                System.out.println("---------------S");
            }

        } catch (Exception e) {
            System.out.println("virhe");
        }
    }
}
