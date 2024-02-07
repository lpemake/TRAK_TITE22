import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Maakunta {
    
    private String nimi;
    private ArrayList<Kunta> kunnat;

    public Maakunta(String nimi) {
        this.nimi = nimi;
        kunnat = new ArrayList<>();
    }

    public void lisaaKunta(Kunta kunta) {
        kunnat.add(kunta);
    }

    public void jarjestaVakiluvunMukaan() {
        Comparator<Kunta> vakiluvunMukaan = (k1, k2) -> k1.getVakiluku() - k2.getVakiluku();
        Collections.sort(kunnat, vakiluvunMukaan);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nimi + "\n");

        for (Kunta kunta : kunnat) {
            sb.append(kunta.toString() + "\n");
        }

        return sb.toString();
    }

    public int getVakiluku() {
        int n = 0;
        for (Kunta kunta : kunnat) {
            n += kunta.getVakiluku();
        }
        return n;
    }

    public String getNimi() {
        return nimi;
    } 
}
