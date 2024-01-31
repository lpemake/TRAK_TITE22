import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class LueKunnat {
    public static void main(String[] args) {
        // lista kuntia varten

        ArrayList<Kunta> kunnat = new ArrayList<>();

        try {
            Scanner tiedosto = new Scanner(Paths.get("kunnat.txt"));

            while (tiedosto.hasNextLine()) {
                String rivi = tiedosto.nextLine();
                
                String[] palaset = rivi.split("\\s+");

                int koodi = Integer.parseInt(palaset[0]);
                String nimi = palaset[1];
                String maakunnat = palaset[2];
                int vakiluku = Integer.parseInt(palaset[3]);
                double pintaAla = Double.parseDouble(palaset[4]);

                // tee Kunta-olio

                // lisää olio listaan

            }

            // tee järjestämismetodit

            // järjestä

        } catch (Exception e) {
            System.out.println("virhe");
        }
    }
}
