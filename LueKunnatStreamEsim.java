import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LueKunnatStreamEsim {
    public static void main(String[] args) {
        ArrayList<Kunta> kunnat = new ArrayList<>();

        try {
            // luetaan tiedosto listaan
            Files.lines(Paths.get("kunnat.txt"))
                // pilkotaan rivi osiin ";"-merkin kohdalta
                .map(rivi -> rivi.split("\t"))
                // poistetaan väärät rivit
                .filter(palaset -> palaset.length == 5)
                // tehdään palaset-taulukosta kuntia
                .map(palaset -> new Kunta(Integer.parseInt(palaset[0]),
                    palaset[1], palaset[2], Integer.parseInt(palaset[3]),
                    Double.parseDouble(palaset[4])))
                // käydään kunnat läpi
                .forEach(kunta -> kunnat.add(kunta));

        } catch (Exception e) {
            System.out.println("virhe " + e.getMessage());
        }

        kunnat.stream()
            .sorted((k1, k2) -> k1.getNimi().compareTo(k2.getNimi()))
            .forEach(k -> System.out.println(k));
    }
}
