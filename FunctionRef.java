// https://www.gregorygaines.com/blog/how-to-use-function-pointers-in-java/
import java.util.Random;
public class FunctionRef {


    public static int[] makeRandomArray(int n)
    {
        int[] array = new int[n];
        Random gen = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = gen.nextInt(n);
        }
        return array;
    }

    public static void printArray(int[] array)
    {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void sortMethodA(int[] arr)
    {
        System.out.println("sort method A");
    }

    public static void sortMethodB(int[] arr)
    {
        System.out.println("sort method B");
    }    

    public static void sortMethodC(int[] arr)
    {
        System.out.println("sort method C");
    }    

    private interface FunctionPointer {
        // Method signatures of pointed method
        void methodSignature(int[] arr);
    }

    public static void SortMethodTester(FunctionPointer methodToBeTested, String methodName, int n)
    {
        // Tehdään satunnainen taulukko.
        // Oikeastaan taulukon luomismetodi (satunnainen, nouseva, laskeva)
        // voitaisiin antaa myös parametrina.
        int[] array = makeRandomArray(100000);

        // otetaan alkuaika
        long start = System.nanoTime();

        // Kutsutaan parametrina annettua testattavaa metodia.
        methodToBeTested.methodSignature(array);

        // otetaan loppuaika
        long end = System.nanoTime();

        long kesto = end - start;

        // tulostetaan kestoaika
        System.out.println(methodName + ": " + kesto);
    }

    public static void main(String[] args) {

        // nämä voisivat olla taulukossa
        FunctionPointer methodA = FunctionRef::sortMethodA;
        FunctionPointer methodB = FunctionRef::sortMethodB;
        FunctionPointer methodC = FunctionRef::sortMethodC;
        
        // ja näitä voisi kutsua silmukassa
        SortMethodTester(methodA, "Method A", 100000);
        SortMethodTester(methodB, "Method B", 100000);
        SortMethodTester(methodC, "Method C", 100000);

        // https://www.gregorygaines.com/blog/how-to-use-function-pointers-in-java/
    }
}
