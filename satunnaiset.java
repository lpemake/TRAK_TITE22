import java.util.Random;
import java.util.Arrays;
import java.math.*;

public class satunnaiset {

    public static int binarySearch(int x, int[] luvut) {
        int low = 0;
        int high = luvut.length - 1;

        while (high >= low) {
            int middle = (high + low) / 2;
            if (luvut[middle] == x)
                return middle;
            if (luvut[middle] < x)
                low = middle + 1;
            if (luvut[middle] > x)
                high = middle - 1;
        }

        return -1;
    }

    public static int linearSearch(int x, int[] luvut) {

        for (int i = 0; i < luvut.length; i++) {
            if (luvut[i] == x)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        
        Random gen = new Random();

        int koko = 1000000;
        int[] luvut = new int[koko];

        for (int i = 0; i < koko; i++) {
            int luku = gen.nextInt(50) + 1;
            luvut[i] = luku;
        }
        Arrays.sort(luvut);

        long start1 = System.nanoTime();
        int x1 = linearSearch(767872, luvut);
        long end1 = System.nanoTime();
        long kesto1 = end1 - start1;
        System.out.println("linearSearch: " + kesto1);

        long start2 = System.nanoTime();
        int x2 = binarySearch(767872, luvut);
        long end2 = System.nanoTime();
        long kesto2 = end2 - start2;
        System.out.println("binarySearch: " + kesto2);

        long start3 = System.nanoTime();
        int x3 = java.util.Arrays.binarySearch(luvut, 767872);
        long end3 = System.nanoTime();
        long kesto3 = end3 - start3;
        System.out.println("valmis binarySearch: " + kesto3);        
        
        double mittaus = (double)kesto2 / kesto1;
        double teoria = (Math.log(1000000) / Math.log(2.0)) / 1000000;

        System.out.println("mittaus: " + mittaus);
        System.out.println("teoria: " + teoria);
    }
}
