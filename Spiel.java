import java.util.ArrayList;
import java.util.List;

public class Spiel {

    public Spiel() {
        // Erstellen von Listen für Karten, Farben, Nummern und Kartentypen
        List<String> Karten_Liste = new ArrayList<>();
        List<String> Farben_Liste = new ArrayList<>();
        List<String> Number_Liste = new ArrayList<>();
        List<String> Karte_Typ_Liste = new ArrayList<>();

        // Hinzufügen von Farben zur Farben_Liste
        Farben_Liste.add("Grün");
        Farben_Liste.add("Gelb");
        Farben_Liste.add("Rot");
        Farben_Liste.add("Orange");
        Farben_Liste.add("Lila");
        Farben_Liste.add("Blau");

        // Hinzufügen von Nummern zur Number_Liste
        Number_Liste.add("0");
        Number_Liste.add("1");
        Number_Liste.add("2");
        Number_Liste.add("3");
        Number_Liste.add("4");
        Number_Liste.add("5");
        Number_Liste.add("6");
        Number_Liste.add("7");
        Number_Liste.add("8");
        Number_Liste.add("9");
        Number_Liste.add("10");
        Number_Liste.add("11");
        Number_Liste.add("12");
        Number_Liste.add("13");
        Number_Liste.add("14");
        Number_Liste.add("15");

        // Erstellen von Karten mit jeder Kombination aus Farbe und Nummer
        for (String farbe : Farben_Liste) {
            for (String number : Number_Liste) {
                new Karten(farbe, number);
                System.out.println(farbe + " " + number); // Ausgabe der erstellten Karte
            }
        }
    }

    public static void main(String[] args) {
        new Spiel(); // Starten des Spiels
    }
}
