import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Korttipakka {
    private ArrayList<Kortti> pakka;

    public Korttipakka() {

    }

    public void luoPakka()
    {
        this.pakka = new ArrayList<>();
        for (Maa maa : Maa.values()) {
            for (int j = 1; j <= 13; j++) {
                Kortti k = new Kortti(maa, j);
                this.pakka.add(k);
            }
        }
    }

    public List<Kortti> jaa(int n)
    {   // palautetaan jaettu käsi
        // tehdään uusi arraylist, johon otetaan n korttia pakan päältä
        List<Kortti> kasi = new ArrayList<>(this.pakka.subList(0, n));

        // poistetaan kortit pakasta
        this.pakka.removeAll(kasi);

        return kasi;
    }

    public void Sekoita()
    {
        Collections.shuffle(pakka);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Kortti kortti : pakka) {
            s.append(kortti.toString());
            s.append("\n");
        }

        return s.toString();
    } 
}
