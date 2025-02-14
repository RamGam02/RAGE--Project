import java.util.ArrayList;
import java.util.List;

public class Spieler {

    // arrray mit handkarten


    // Handkarten zuweisen

    //Karte Legen

        // Anzeigen der Hand Karten
        // Auswahl der Gewünschten Karte
        // Kontrolle der Karte 
        //Ausgabe in die Runde 
        // nächste Zug (Spiel)




    // Anzeigen der Hand Karten
        // Liste mit Karten (10 am Anfang)


        // for (i=0, i<=Handkarten.length(),i++):
            //print(Handkarte.farbe+)

        // gibt alle elemente Liste mit index +1
        // nimmt input
        // gibt Karte zurück

    //Kontrolle der Karte 
        //Kriterium 1-1000


    public String Name;
    public int Punkte;
    public int Wette;
    public int Stiche_gewonnen;
    List<Karten> Handkarten = new ArrayList<>();
    
    

    public Spieler (String pName, int pPunkte, int pWette){
        
        List<String> Karten_Liste = new ArrayList<>();
        this.Name = pName;
        this.Punkte = pPunkte;
        this.Wette = pWette;
    }

        

    public void Karte_Legen(){
        // Anzeigen der Hand Karten
        // Auswahl der Gewünschten Karte
        // Kontrolle der Karte 
        //  Ausgabe in die Runde 
        // nächste Zug (Spiel)
    }
    public void Wetten(){
        //Wette abgeben
    }
    public void wette_geschaft(){
        //Wette gewonnen?
        
    }
    public void setPunkte(int punkte) {
        this.Punkte = punkte;
    }
    public int getPunkte(){
        
        return Punkte;}

    
    } 

