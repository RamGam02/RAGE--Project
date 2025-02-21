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
import java.util.Stack;

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

    public void ausfuehren(Stack<Karten> nachziehstapel, String aktuellerTrumpf) {
        Karten gezogeneKarte = nachziehstapel.pop();
        if (gezogeneKarte instanceof Farbkarte) {
            aktuellerTrumpf = gezogeneKarte.getFarbe();
        }
        // Trumpffarbe bleibt unverändert, wenn keine Farbkarte gezogen wird
    }
}

class KeinTrumpf extends Karten {
    public KeinTrumpf() {
        super("Kein Trumpf", 0);
    }

    public void ausfuehren(String aktuellerTrumpf) {
        // Für den aktuellen Stich gibt es keinen Trumpf
        aktuellerTrumpf = null;
    }
}

class Joker extends Karten {
    public Joker() {
        super("Joker", 0);
    }

    public void ausfuehren(String angesagteFarbe) {
        this.farbe = angesagteFarbe;
        this.wert = Integer.MAX_VALUE; // Setze den Wert auf den höchsten möglichen Wert
    }
}


public class Special_Karten {
    public Special_Karten() { //(WHY das muss ein konstructer sein)
        List<String> Karte_Typ_Liste = new ArrayList<>(Arrays.asList("Plus 5", "Plus 5", "Plus 5", "Minus 5", "Minus 5", "Minus 5", "Trumpfwechsel", "Trumpfwechsel", "Trumpfwechsel", "Trumpfwechsel", "Kein Trumpf", "Kein Trumpf", "Kein Trumpf", "Kein Trumpf", "Joker", "Joker"));
        Stack<Karten> nachziehstapel = new Stack<>();
        String aktuellerTrumpf = Spiel.Trumpf_Karte();
        String angesagteFarbe = ; // Farbe, die angesagt wird, wenn Joker gespielt wird
        for (String karteTyp : Karte_Typ_Liste) {
            if (karteTyp.equals("Trumpfwechsel")) {
                Trumpfwechsel trumpfwechsel = new Trumpfwechsel();
                trumpfwechsel.ausfuehren(nachziehstapel, aktuellerTrumpf);
            } else if (karteTyp.equals("Kein Trumpf")) {
                KeinTrumpf keinTrumpf = new KeinTrumpf();
                keinTrumpf.ausfuehren(aktuellerTrumpf);
            } else if (karteTyp.equals("Joker")) {
                Joker joker = new Joker();
                joker.ausfuehren(angesagteFarbe); 
            }
        }
    }
}
     