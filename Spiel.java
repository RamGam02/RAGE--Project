import java.util.ArrayList;
import java.util.Arrays;
import java.util.*; 

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
        Spiel_auswerten();
    }

    public void Runde (int kartenProSpieler, List<Karten> Karten_Liste, Spieler Ersterspieler) {
                
        Mischen(Ziehstapel);
        Austeilen(kartenProSpieler, Ziehstapel);
        Trumpf_Karte();
        Wetten(Ersterspieler);
        for (int i = 0; i < kartenProSpieler; i++) {
            for (Spieler spieler : Spieler_Liste) {
                    spieler.Karte_Legen(); // Methode Karte_Legen in Klasse Spieler pls someone do that make that happen
            }
        }
        Runde_Auswerten();


    }
    public void Mischen(List<Karten> Ziehstapel) {
            // Karten werden gemischt
            Collections.shuffle(Ziehstapel);
    }
    public void Austeilen(int kartenProSpieler, List<Karten> Ziehstapel) {
            // Karten werden ausgeteilt
            for (int i = 0; i < kartenProSpieler; i++) {
                for (Spieler spieler : Spieler_Liste) {
                    spieler.Handkarten.add(Ziehstapel.remove(0)); // Methode Handkarten in Klasse Spieler pls someone do that :(
                }
            }
    }    
    public void Wetten(Spieler StartSpieler){ // add sorting for forst player
            // Wetten werden abgegeben   
            for (Spieler spieler : Spieler_Liste) {
                spieler.Wetten(); // Methode Wetten in Klasse Spieler pls someone do that ?? :(
            }
    }
    public void Trumpf_Karte() {
            // Erste Karte wird aufgedeckt   
            Karten erste_Karte = Ziehstapel.remove(0);    
            //if erste_Karte.Farbe != special
            //   Trumpf = erste_Karte.Farbe

    }
    public void Runde_Auswerten() {
            // Auswertung der Runde
        for (Spieler spieler : Spieler_Liste) {
            if (spieler.wette_geschaft = true ){ //plllllllllllllllllllllllsssss add 
                spieler.Punkte += 10;
            }
        }
    }
    public void Spiel_auswerten() {
        // Auswertung des Spiels
        Spieler_Liste.sort(Comparator.comparing(Spieler::getPunkte));
        System.err.println("Der Gewinner ist " + Spieler_Liste.get(0).Name);
    }
    public void Stich_auswerten(List<Karten> Stich) {
        // Auswertung des Stichs
        List<Karten> Trumpf_Liste = new ArrayList<>();        
        List<Karten> Nicht_Trumpf_Liste = new ArrayList<>();
        for (Karten karte : Stich) {
            if (karte.Farbe == Trumpf) {
                // Trumpf
                Trumpf_Liste.add(karte);

            } else {
                // Kein Trumpf
                Nicht_Trumpf_Liste.add(karte);               
            }
        }
        // add special card stuff und joker
        if (Trumpf_Liste.size() > 0) {
            // Trumpf gewinnt
            Trumpf_Liste.sort(Comparator.comparing(Karten::getWert));
            Karten Stich_Gewinner = Trumpf_Liste.get(0);
            Spieler Gewinner = Stich_Gewinner.getBesitzer();
        } else {
            // Kein Trumpf gewinnt
            Nicht_Trumpf_Liste.sort(Comparator.comparing(Karten::getWert));
            Karten Stich_Gewinner = Nicht_Trumpf_Liste.get(0);
            Spieler Gewinner = Stich_Gewinner.getBesitzer();    
        }
        
    }

    public static void main(String[] args) {
        new Spiel(); // Starten des Spiels
    }

    // Einen Trumpf aufdecken vom Ziehstapel (zu dem oben)


}
