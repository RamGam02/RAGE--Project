
public class Karten{


    private String farbe;
    private String wert;




    public Karten(String pfarbe, String pWert){

        this.farbe = pfarbe;
        this.wert = pWert;

    }


    
}

//public class Special_Karten extends Karten 

public class Special_Karten {
    


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

    }

    
public class Special_Karten extends Karten {
 
    public Special_Karten(String pFarbe, String aktion) {
        super(pFarbe, aktion);
    }
}
