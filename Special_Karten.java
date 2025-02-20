        //Aktionskarten
        //  >Joker
        //      >Spieler sagt beliebige Farbe an, Karte wird zur höchsten Karte dieser Farbe
        //      >Joker kann auch Trumpf werden
        //      >bei 2 Joker in einem Stich, 2. Joker höher als 1.
        //      >bei Eröffnung mit Joker muss die angesagte Farbe bedient werden
        //  >+5/-5
        //      >Wer den Stich gewinnt bekommt die Punkte angerechnet
        //  >Trumpfwechsel
        //      >Karte vom Nachziehstapel wird gezogen
        //      >erste Farbkarte neuer Trumpf
        //      >Trumpffareb kann auch gleich bleiben
        //  >Kein Trumpf
        //      >für aktuellen Stich gibt es dann keinen Trumpf
        //      >wenn danach Trumpfwechsel gelegt wird gilt dann der neue Trumpf

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Karten {
    protected String farbe;
    protected int wert;
    protected Spieler spieler;

    public Karten(String farbe, int wert) {
        this.farbe = farbe;
        this.wert = wert;
    }
    public String getFarbe() {
        return farbe;
    }



    public int getWert() {
        return wert;
    }
    public void setWert(int wert) {
        this.wert = wert;
    }
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
    public String toString() {
        return farbe + " " + wert;
    }
    public Spieler getBesitzer() {
        return spieler;
}

public class Special_Karten extends Karten {
    public String Aktion;
    public String spezielleFarbe;
 
    public Special_Karten(String pFarbe, String aktion) {
        super(pFarbe, 0);
        this.Aktion = aktion;
        this.spezielleFarbe = pFarbe;

        List<String> Karte_Typ_Liste = new ArrayList<>(Arrays.asList("Plus 5", "Plus 5", "Plus 5", "Minus 5", "Minus 5", "Minus 5", "Trumpfwechsel", "Trumpfwechsel", "Trumpfwechsel", "Trumpfwechsel", "Kein Trumpf", "Kein Trumpf", "Kein Trumpf", "Kein Trumpf", "Joker", "Joker"));
    
        for(String karteTyp : Karte_Typ_Liste){
            if(karteTyp.equals("Trumpfwechsel")){
                
            }
        }
    
    }
}
}
