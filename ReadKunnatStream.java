import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadKunnatStream {
    public static void main(String[] args) {
        
        ArrayList<Kunta> kuntalista = new ArrayList<>();
        HashMap<String, Maakunta> maakunnat = new HashMap<>();

        try {
            Files.lines(Paths.get("kunnat.txt"))
                .map(rivi -> rivi.split("\t"))
                .filter(palaset -> palaset.length == 5)
                .map(palaset -> new Kunta(
                    Integer.parseInt(palaset[0]),
                    palaset[1],
                    palaset[2],
                    Integer.parseInt(palaset[3]),
                    Double.parseDouble(palaset[4])))
                .forEach(kunta -> {
                    kuntalista.add(kunta);
                    if (!maakunnat.containsKey(kunta.getMaakunta()))
                    {
                        maakunnat.put(kunta.getMaakunta(),
                            new Maakunta(kunta.getMaakunta()));
                    }
                    maakunnat.get(kunta.getMaakunta())
                        .lisaaKunta(kunta);
                });

            System.out.println("Kuntalista -----------------------------------");
            kuntalista.stream()
                .sorted((k1, k2) -> k1.getVakiluku() - k2.getVakiluku())
                .forEach(k -> System.out.println(k));

            System.out.println("Maakuntien hajautustaulu ----------------------");
            maakunnat.values().stream()
                .sorted((m1, m2) -> m1.getVakiluku() - m2.getVakiluku())
                .forEach(m -> System.out.println(m));

        } catch (Exception e) {
            System.out.println("virhe " + e.getMessage());
        }
    }
}
