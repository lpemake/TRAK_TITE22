import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

            int menetelma = 4;
            Comparator<Ehdokas> vertailija = null; 

            switch (menetelma) {
                case 1: // Sukunimen ja etunimen mukaan
                    vertailija = (e1, e2 ) -> {
                        int ret = e1.getSukunimi().compareTo(e2.getSukunimi());
                        if (ret == 0)
                            ret = e1.getEtunimi().compareTo(e2.getEtunimi());
                        return ret;
                    };
                break;
                case 2: // Puolueen, sukunimen ja etunimen mukaan
                    vertailija = (e1, e2 ) -> {
                    int ret = e1.getPuolue().compareTo(e2.getPuolue());
                    if (ret == 0)
                        ret = e1.getSukunimi().compareTo(e2.getSukunimi());
                        if (ret == 0)
                            ret = e1.getEtunimi().compareTo(e2.getEtunimi());
                    return ret;
                };
                break;   
                case 3: // Äänimäärän mukaan
                    vertailija = (e1, e2) -> e1.getAanimaara() - e2.getAanimaara();
                break; 
                case 4: // Puolueen ja äänimäärän mukaan
                    // tehdään toisella tavalla
                    vertailija = Comparator
                        .comparing(Ehdokas::getPuolue)
                        .thenComparing(Ehdokas::getAanimaara).reversed();
                break;                 
                case 5: // Vertailuluvun mukaan
                    vertailija = (e1, e2) -> {
                        if (e1.getVertailuLuku() > e2.getVertailuLuku())
                            return 1;
                        else if (e1.getVertailuLuku() < e2.getVertailuLuku())
                            return -1;
                        else
                            return 0;
                    };
                break;                 
            
                default:
                    break;
            }
            Collections.sort(ehdokkaat, vertailija);

            for (Ehdokas ehdokas : ehdokkaat) {
                System.out.println(ehdokas.toString());
            }

        } catch (Exception e) {
            System.out.println("virhe");
        }
    }
}
