import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Karten {
    private String farbe;
    private String number;

    public Karten(String farbe, String number) {
        this.farbe = farbe;
        this.number = number;
    }

    @Override
    public String toString() {
        return farbe + " " + number;
    }
}

public class Spiel {

    // Erstellt Variablen für die Klasse
    private final String Trumpf = "lol"; // für später

    public Spiel() {
        // Erstellen von Listen für Karten
        List<Karten> Karten_Liste = new ArrayList<>();

        // Hinzufügen von Farben zur Farben_Liste
        List<String> Farben_Liste = new ArrayList<>(Arrays.asList("Grün", "Gelb", "Rot", "Orange", "Lila", "Blau"));

        // Hinzufügen von Nummern zur Number_Liste
        List<String> Number_Liste = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"));

        List<String> Karte_Typ_Liste = new ArrayList<>(Arrays.asList("Plus 5", "Plus 5", "Plus 5", "Minus 5", "Minus 5", "Minus 5", "Trumpfwechsel", "Trumpfwechsel", "Trumpfwechsel", "Trumpfwechsel", "Kein Trumpf", "Kein Trumpf", "Kein Trumpf", "Kein Trumpf", "Joker", "Joker"));

        // Erstellen von Karten mit jeder Kombination aus Farbe und Nummer
        for (String farbe : Farben_Liste) {
            for (String number : Number_Liste) {
                Karten_Liste.add(new Karten(farbe, number));
                System.out.println(farbe + " " + number); // Ausgabe der erstellten Karte
            }
        }
        // Erstellt Besondere Karten
    }

    public static void main(String[] args) {
        new Spiel(); // Starten des Spiels
    }
}
