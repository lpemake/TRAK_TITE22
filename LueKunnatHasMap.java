import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class LueKunnatHasMap {
    public static void main(String[] args) {
        // lista kuntia varten 
        ArrayList<Kunta> kunnat = new ArrayList<>();

        HashMap<String, Integer> maakunnat = new HashMap<>();

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
                        maakunnat.put(maakunta, 0);
                    }
                    // haetaan maakunta hajautustaulusta
                    int value = maakunnat.get(maakunta);
                    maakunnat.put(maakunta, ++value);

                }
                catch (Exception e)
                {
                    System.out.println("virhe rivillä " + rivi);
                }
            }

            // käydään maakunnat läpi
            // Onko Javassa mahdollista käydä avaimet ja arvot pareittain läpi (C# KeyValuePair)
            for (String m : maakunnat.keySet()) {
                int lukumaara = maakunnat.get(m);
                System.out.println(m + ": " + lukumaara);
            }

        } catch (Exception e) {
            System.out.println("virhe");
        }
    }
}
