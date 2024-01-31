import java.util.ArrayList;
import java.util.HashMap;

public class Hajautustaulu {
    public static void main(String[] args) {
        HashMap<String, String> postinumerot = new HashMap<>();
        postinumerot.put("00710", "Helsinki");
        postinumerot.put("90014", "Oulu");
        postinumerot.put("33720", "Tampere");
        postinumerot.put("33014", "Tampere");

        // väärin
        for(String postinumero : postinumerot.keySet()) {
            System.out.println(postinumerot.get(postinumero));
        }                

        for (String kunta : postinumerot.values()) {
            System.out.println(kunta);
        }        

        for(String postinumero : postinumerot.keySet()) {
            System.out.println(postinumero);
        }



        System.out.println(postinumerot.get("00710"));

        // väkiluku kunnittain
        HashMap<String, Integer> kunnat = new HashMap<>();
        kunnat.put("Seinäjoki", 66000);
        kunnat.put("Ilmajoki", 12000);

    }
}
