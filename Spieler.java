import java.util.ArrayList;
import java.util.List;

public class Spieler {

    // array mit handkarten
 

    // Handkarten zuweisen

    // Karte Legen

        // Anzeigen der Hand Karten
        // Auswahl der Gewünschten Karte
        // Kontrolle der Karte 
        // Ausgabe in die Runde auf den Ablagestapel  
        // nächste Zug (Spiel) bzw. nächster Spieler




    // Anzeigen der Hand Karten
        // Liste mit Karten (10 am Anfang)


        // for (i=0, i<=Handkarten.length(),i++):
            // print(Handkarte.farbe+)

        // gibt alle elemente Liste mit index +1
        // nimmt input
        // gibt Karte zurück

    // Kontrolle der Karte 
        // (Kriterium 1-1000)
        //                     
        // Runde.ausgespielteFarbe == gelegteKarte;                    Kriterium, ob gelegte Karte ausgespielter Farbe entspricht
        // Handkarten == ausgespielteFarbe;                            Kriterium, ob Handkarten ausgespielte Farbe enthalten





      // Auswertung:
      //  if (Wette_geschafft == true){
      // Punkte = Punkte + 10 + Anzahl_Stiche;
      //} else {
      //Punkte = Punkte -5 + Anzahl_Stiche;
      //}
      //  if (Spezial_Karte == true){
      // Punkte = Punkte + 5/- 5;
      // }










    private String Name;
    private int Punkte;
    private int Wette;                    // Variablen für die Klasse
    private int Anzahl_Stiche;
    private boolean Wette_geschafft;
    //private boolean Spezial_Karte;               Ausbaufähig wegen Auswertung
    
    

    public Spieler (String pName){
        
        List<String> Karten_Liste = new ArrayList<>();
        this.Name = pName;                                          // Konstruktor
        this.Punkte = 0;
        this.Wette = 0;
        this.Anzahl_Stiche = 0;
        this.Wette_geschafft = false;
        //this.Spezial_Karte = false;               Ausbaufähig wegen Auswertung
        
    }

    
    } 

