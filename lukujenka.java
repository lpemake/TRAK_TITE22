import java.util.Scanner;
import java.util.Arrays;

public class lukujenka {
    public static void main(String[] args)
    {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Anna taulukon koko:");
        int koko = Integer.parseInt(lukija.nextLine());

        // luodaan taulukko
        int[] luvut = new int[koko];

        System.out.println("Anna luvut:");

        int i = 0;
        int summa = 0;
        while (i < koko) {
            int luku = Integer.parseInt(lukija.nextLine());
            luvut[i] = luku;
            summa += luku;
            i++;
        }

        Arrays.sort(luvut);
        System.out.println("Taulokon sisalto");
        for (int j = 0; j < luvut.length; j++) {
            System.out.println(luvut[j]);
        }

        double keskiarvo = (double)summa / koko;

        System.out.println("keskiarvo: " + keskiarvo);
    }
}
