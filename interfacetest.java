import java.util.Random;

public class interfacetest {
    private interface SortingMethod {
        public void sort(int[] luvut);
    }
    
    private class SortMethodA implements SortingMethod {
        public void sort(int[] luvut) {
            System.out.println("sort method A");
        }
    }

    private class SortMethodB implements SortingMethod {
        public void sort(int[] luvut) {
            System.out.println("sort method B");
        }
    }    

    private class SortMethodC implements SortingMethod {
        public void sort(int[] luvut) {
            System.out.println("sort method C");
        }
    }    
    
    public static int[] makeRandomArray(int n)
    {
        int[] array = new int[n];
        Random gen = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = gen.nextInt(n);
        }
        return array;
    }

    public static void SortMethodTester(SortingMethod methodToBeTested, String methodName, int n)
    {
        // Tehdään satunnainen taulukko.
        // Oikeastaan taulukon luomismetodi (satunnainen, nouseva, laskeva)
        // voitaisiin antaa myös parametrina.
        int[] array = makeRandomArray(100000);

        // otetaan alkuaika
        long start = System.nanoTime();

        // Kutsutaan parametrina annettua testattavaa metodia.
        methodToBeTested.sort(array);

        // otetaan loppuaika
        long end = System.nanoTime();

        long kesto = end - start;

        // tulostetaan kestoaika
        System.out.println(methodName + ": " + kesto);
    }    

    public static void main(String[] args) {
        interfacetest olio = new interfacetest();
        SortingMethod methodA = olio.new SortMethodA();
        SortingMethod methodB = olio.new SortMethodB();
        SortingMethod methodC = olio.new SortMethodC();

        SortMethodTester(methodA, "method A", 1000);
        SortMethodTester(methodB, "method B", 1000);
        SortMethodTester(methodC, "method C", 1000);

        // voidaan käyttää myös taulukkoa
        SortingMethod[] methods = {methodA, methodB, methodC};

        for (SortingMethod sortingMethod : methods) {
            SortMethodTester(sortingMethod, "method A", 1000);
        }
    }
}
