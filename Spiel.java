import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

class Karten {
    private String farbe;
    private String number;

    public Karten(String farbe, String number) {
        this.farbe = farbe;
        this.number = number;
    }

    public String toString() {
        return farbe + " " + number;
    }
}

public class Spiel {

    // Erstellt Variablen für die Klasse
    private final String Trumpf = "lol"; // für später
    private final int Runde =0; // für später
    private final int Spieler_Anzahl = 4; // für später
    // Erstellen von Listen für Spieler
    private List<Spieler> Spieler_Liste = new ArrayList<>();
    // Erstellen von Listen für Karten
    private List<Karten> Karten_Liste = new ArrayList<>();
    List<Karten> Ziehstapel = new ArrayList<>(Karten_Liste);
    List<Karten> ablagestapel = new ArrayList<>();

    public Spiel() {

        // Erstellen von Karten
        Staple_erstellen();
    }

    private void Staple_erstellen() {        

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

            //for (String karte_typ : Karte_Typ_Liste) {
            //    Karten_Liste.add(new Karten(farbe, karte_typ));
            //    System.out.println(farbe + " " + karte_typ); // Ausgabe der erstellten Karte
        //}
        
    }    


    public void Spielstart(int Spieler_Anzahl) {
        Spieler ersterAusspieler = Spieler_Liste. get( (int) (Math.random() * Spieler_Anzahl)); 
        System.out.println("Erster Ausspieler ist Spieler " + ersterAusspieler); //Füge die Klasse Speiler hinzu
        for (int runde = 10; runde > 0; runde--) {
                // Erste Runde 10 Karten, zweite Runde 9 Karten, dritte Runde 8 Karten,...
                int kartenProSpieler = runde;
                Runde(kartenProSpieler, Karten_Liste, ersterAusspieler);
            }
        }
 
        public void Runde (int kartenProSpieler, List<Karten> Karten_Liste, Spieler Ersterspieler) {
                
                Mischen(Ziehstapel);
                Austeilen(kartenProSpieler, Ziehstapel);
                Wetten(Ersterspieler);
                for (int i = 0; i < kartenProSpieler; i++) {
                    for (Spieler spieler : Spieler_Liste) {
                        spieler.Karte_Legen(); // Methode Karte_Legen in Klasse Spieler pls someone do that make that happen
                    }
                }
                Auswerten();


        }
        public void Mischen(List<Karten> Ziehstapel) {
            // Karten werden gemischt
            Collections.shuffle(Ziehstapel);
        }
        public void Austeilen(int kartenProSpieler, List<Karten> Ziehstapel) {
            // Karten werden ausgeteilt
            for (int i = 0; i < kartenProSpieler; i++) {
                for (Spieler spieler : Spieler_Liste) {
                    spieler.Handkarten.add(Ziehstapel.remove(0)); // Methode Handkarten in Klasse Spieler pls someone do that make that happen
                }
            }
        }    
        public void Wetten(Spieler StartSpieler){
            // Wetten werden abgegeben   
        }
        public void erste_Karte() {
            // Erste Karte wird aufgedeckt          
        }
        public void Auswerten() {
            // Auswertung der Runde
        }

    public static void main(String[] args) {
        new Spiel(); // Starten des Spiels
    }

    // Einen Trumpf aufdecken vom Ziehstapel (zu dem oben)


}
