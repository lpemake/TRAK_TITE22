public class Kortti {
    private Maa maa;
    private int arvo;
    
    public Kortti(Maa maa, int arvo) {
        this.maa = maa;
        this.arvo = arvo;
    }

    @Override
    public String toString() {
        return maa + " " + arvo;
    }
}