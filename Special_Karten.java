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

import java.util.*; 

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
    public Spieler getBesitzer()
    { 
        return spieler;
    }
}

class Farbkarte extends Karten {
    public Farbkarte(String farbe, int wert) {
        super(farbe, wert);
    }
}

class Trumpfwechsel extends Karten {
    public Trumpfwechsel() {
        super("Trumpfwechsel", 0);
    }

    public void ausfuehren(Spiel spiel, List<Karten> nachziehstapel, String aktuellerTrumpf) {
        Karten gezogeneKarte = nachziehstapel.get(0);
        while (!(gezogeneKarte instanceof Farbkarte)) {
            spiel.Ziehstapel.remove(0);
            gezogeneKarte = nachziehstapel.get(0);
        }
        spiel.setTrumpf(gezogeneKarte.getFarbe());
    }
}

class KeinTrumpf extends Karten {
    public KeinTrumpf() {
        super("Kein Trumpf", 0);
    }

    public void ausfuehren(Spiel spiel) {
        // Für den aktuellen Stich gibt es keinen Trumpf
        spiel.setTrumpf(null);
    }
}

class Joker extends Karten {
    public Joker() {
        super("Joker", 0);
    }

    public void ausfuehren() {
        this.wert = 20; // Setze den Wert auf den höchsten möglichen Wert
        // Future me problem
    }
}



     