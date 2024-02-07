import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LueKunnat {
    public static void main(String[] args) {
        // lista kuntia varten

        ArrayList<Kunta> kunnat = new ArrayList<>();

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
                }
                catch (Exception e)
                {
                    System.out.println("virhe rivillä " + rivi);
                }
            }

            // tee järjestämismetodit
                // Kunnan koodin mukaan
                Comparator<Kunta> koodinMukaan = (k1, k2) -> k1.getKoodi() - k2.getKoodi();

                // Kunnan nimen mukaan
                Comparator<Kunta> nimenMukaan = (k1, k2) -> k1.getNimi().compareTo(k2.getNimi());

                // Maakunnan ja kunnan nimen mukaan
                Comparator<Kunta> maakunnanJaNimenMukaan = (k1, k2) -> {
                    int ret = k1.getMaakunta().compareTo(k2.getMaakunta());
                    if (ret == 0)
                        k1.getNimi().compareTo(k2.getNimi());
                    return ret;
                };

                // Väkiluvun mukaan (int)
                Comparator<Kunta> vakiluvunMukaan = (k1, k2) -> k1.getVakiluku() - k2.getVakiluku();

                // Pinta-alan mukaan (double)
                Comparator<Kunta> pintaAlanMukaan = (k1, k2) -> {
                    return Double.compare(k1.getPintaAla(), k2.getPintaAla());
                    /*
                    if (k1.getPintaAla() > k2.getPintaAla())
                        return 1;
                    else if (k1.getPintaAla() < k2.getPintaAla())
                        return -1;
                    else
                        return 0;*/
                };
            // järjestä
            Collections.sort(kunnat, vakiluvunMukaan);
            // järjestä streamien avulla
            kunnat.stream().sorted(vakiluvunMukaan);

            for (Kunta kunta : kunnat) {
                System.out.println(kunta);
            }

        } catch (Exception e) {
            System.out.println("virhe");
        }
    }
}
