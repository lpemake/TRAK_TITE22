import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SuodataJono {
    public static void main(String[] args) {
        
        // tehdään jono
        Queue<Double> jono = new LinkedList<>(); 

        try {
            Scanner tiedosto = new Scanner(Paths.get("numbers.txt"));

            while (tiedosto.hasNextLine()) {
                String rivi = tiedosto.nextLine();
                double x = Double.parseDouble(rivi);
                //System.out.println(x);
                jono.add(x);
                if (jono.size() > 10)
                    jono.remove();
                double keskiarvo = 0;
                for (Double double1 : jono) {
                    keskiarvo += double1;
                }
                keskiarvo /= jono.size();
                System.out.println(x + " " + keskiarvo);
            }
        }
        catch (Exception e) {
            System.out.println("virhe");
        }

    }
}
