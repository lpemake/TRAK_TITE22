import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class numerotlistaan {
    public static void main(String[] args) {
        
        ArrayList<Double> luvut = new ArrayList<>();

        try {
            Scanner tiedosto = new Scanner(Paths.get("numbers.txt"));

            while (tiedosto.hasNextLine()) {
                String rivi = tiedosto.nextLine();
                luvut.add(Double.parseDouble(rivi));
            }

            double sum = 0.0;
            for (int i = 0; i < luvut.size(); i++) {
                sum += luvut.get(i);
            }
            double avg = sum / luvut.size();

            Collections.sort(luvut);
            double median = luvut.get(luvut.size()/2);

            double min = Collections.min(luvut);

            System.out.println("sum = " + sum);
            System.out.println("avg = " + avg);
            System.out.println("median = " + median);
            System.out.println("min = " + min);
        } catch (Exception e) {
            System.out.println("virhe");
        }
    }
}
