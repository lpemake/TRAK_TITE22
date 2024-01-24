public class Ehdokas {
    private String etunimi;
    private String sukunimi;
    private String puolue;
    private int aanimaara;
    private double vertailuLuku;
    
    public Ehdokas(String etunimi, String sukunimi, String puolue, int aanimaara) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.puolue = puolue;
        this.aanimaara = aanimaara;
    }

    @Override
    public String toString() {
        return "Ehdokas [etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", puolue=" + puolue + ", aanimaara="
                + aanimaara + ", vertailuLuku=" + vertailuLuku + "]";
    }

    public int getAanimaara() {
        return aanimaara;
    }

    public double getVertailuLuku() {
        return vertailuLuku;
    }

    public void setVertailuLuku(double vertailuLuku) {
        this.vertailuLuku = vertailuLuku;
    }
}
