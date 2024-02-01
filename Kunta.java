public class Kunta {
    private int koodi;
    private String nimi;
    private String maakunta;
    private int vakiluku;
    private double pintaAla;

    public Kunta(int koodi, String nimi, String maakunta, int vakiluku, double pintaAla) {
        this.koodi = koodi;
        this.nimi = nimi;
        this.maakunta = maakunta;
        this.vakiluku = vakiluku;
        this.pintaAla = pintaAla;
    }

    @Override
    public String toString() {
        return "Kunta [koodi=" + koodi + ", nimi=" + nimi + ", maakunta=" + maakunta + ", vakiluku=" + vakiluku
                + ", pintaAla=" + pintaAla + "]";
    }

    public int getKoodi() {
        return koodi;
    }

    public String getNimi() {
        return nimi;
    }

    public String getMaakunta() {
        return maakunta;
    }

    public int getVakiluku() {
        return vakiluku;
    }

    public double getPintaAla() {
        return pintaAla;
    }

    
    
}
