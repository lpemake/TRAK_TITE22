import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ReadCities {
    public static void main(String[] args) {
        
        try {
            HashMap<String, ArrayList<String>> osavaltiot = new HashMap<>();

            Scanner tiedosto = new Scanner(Paths.get("cities.txt"));

            while (tiedosto.hasNextLine())
            {
                String line = tiedosto.nextLine();
                String[] palaset = line.split(";");
                String kaupunki = palaset[0];
                String osavaltio = palaset[1];

                if (!osavaltiot.containsKey(osavaltio))
                { // ei löytynyt, lisätään lista hajautustauluun
                    osavaltiot.put(osavaltio, new ArrayList<>());
                }
                // lisätään kaupunki osavaltion arraylistiin
                ArrayList<String> k = osavaltiot.get(osavaltio);
                k.add(kaupunki);

                //System.out.println(kaupunki + " " + osavaltio);
            }

            // tulostetaan kaupungit osavaltioittain
            for (String o : osavaltiot.keySet()) {
                System.out.println("Osavaltio " + o);
                for (String k : osavaltiot.get(o)) {
                    System.out.println(k);
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("virhe");
        }
    }
}
