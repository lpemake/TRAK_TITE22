import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadNamesStream {
    public static void main(String[] args) {
        ArrayList<String> nimet = new ArrayList<>();

        try {
            Files.lines(Paths.get("names.txt"))
                .forEach(rivi -> nimet.add(rivi));

            nimet.stream()
                .filter(rivi -> rivi.length() >= 10)
                .sorted()
                .distinct()
                .forEach(s -> System.out.println(s));

            double avg = nimet.stream()
                .filter(rivi -> rivi.length() >= 10)
                .mapToInt(rivi -> rivi.length())
                .average()
                .getAsDouble();

            System.out.println(avg);

        } catch (Exception e) {
            System.out.println("virhe");
        }
    }
}
