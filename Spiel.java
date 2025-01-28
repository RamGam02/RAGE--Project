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
        
        //Spiel hat 10 Runden
        //Erste Runde 10 Karten, zweite Runde 9 Karten, dritte Runde 8 Karten,...

        //Erster Ausspieler ist random (Bei folgenden Runden weiter nach links verschoben)
        //Weiteres Ausspielen vom Spieler der den letzten Stich gemacht hat

        //2 Kartenstapel
        //  >Talon (Ziehstapel)
        //  >Ablagestapel (Jeder Spieler einen)
        //Nach dem Austeilen(automatisch), erste Karte vom Talon seperat ablegen (diese farbe ist Trumpf)
        //  >wenn es eine Aktionskarte ist, gilt die erste gespielte Karte als Trupffarbe

        //Spieler geben ihre Stichwette ab
        //  >0 Stiche sind auch valide
        //Ansagen werden notiert/angezeigt

        //Spielrichtung ist im Uhrzeigersinn

        //Es gilt Farbzwang, nur bei nicht besitzen der Farbe andere Karte gestattet
        //Man kann abwerchen, solange der Farbzwang nicht verletzt wird
        //Kein Trumpfzwang, 
        //  >solange man noch andere Karten außer Trumpf besitzt, muss auch nicht mit Trumpf gestochen werden

        //Den Stich gewinnt die höchste Karte in der aktuellen Trumpffarbe
        //  >Liegt kein Trumpf im Stich, gewinnt die höchste Karte in der zuerst gespielten Farbe
        //Gewonne Stiche kommen auf den Ablagestapel des Siegers

        //Bei Ende der Runde Punkteabrechnung
        //  >Richtige Wette +10 Punkte
        //  >Falsche Wette -5 Punkte
        //  >Jeder Stich +1 Punkt
        //  >Aktionskarte in Ablagestapel (+5 Punkte/-5 Punkte)

        //Alle Karten werden erneut gemischt
        //Jeder Spieler erhält eine Karte weniger als in der Vorrunde

        //Erstellt Besondere Karten

    }

    public static void main(String[] args) {
        new Spiel(); // Starten des Spiels
    }

    // Einen Trumpf aufdecken vom Ziehstapel (zu dem oben)


}
