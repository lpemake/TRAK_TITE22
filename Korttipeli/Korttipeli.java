import java.util.List;

public class Korttipeli {
    public static void main(String[] args) {
        Korttipakka pakka = new Korttipakka();
        pakka.luoPakka();
        pakka.Sekoita();
        //pakka.JarjestaMaanMukaan();

        System.out.println(pakka.toString());

        System.out.println("-------------");
        List<Kortti> kasi = pakka.jaa(5);

        for (Kortti kortti : kasi) {
            System.out.println(kortti);
        }

        System.out.println("-------------");
        System.out.println(pakka.toString());
    }
}
