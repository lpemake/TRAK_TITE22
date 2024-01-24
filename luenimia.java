import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class luenimia {
    public static void main(String[] args) {
        ArrayList<String> nimet = new ArrayList<>();

        Scanner lukija = new Scanner(System.in);

        while (true) {
            System.out.println("Anna nimi:");
            String nimi = lukija.nextLine();
            if (nimi.length() < 1)
                break;
            nimet.add(nimi);
        }

        Collections.sort(nimet);
        for (String nimi : nimet) {
            System.out.println(nimi);
        }
    }
}
