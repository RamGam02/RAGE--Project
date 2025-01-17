import java.util.ArrayList;
import java.util.List;

public class Spiel{
public Spiel() {
        
        List<String> Karten_Liste = new ArrayList<>();
        List<String> Farben_Liste = new ArrayList<>();
        List<String> Karte_Typ_Liste = new ArrayList<>();

        Farben_Liste.add("Grün");
        Farben_Liste.add("Gelb");
        Farben_Liste.add("Rot");
        Farben_Liste.add("Orange");
        Farben_Liste.add("Lilla");
        Farben_Liste.add("Blau");

        for (String farbe : Farben_Liste) {
            System.out.println(farbe);
            
        }
    }
}
