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
    public void setBesitzer(Spieler neuerspieler){
        this.spieler = neuerspieler;
    }
    public void ausfuehren(Spiel spiel) {
        // Leer aber wichtig nicht löschen
    }

    public void ausfuehren(boolean gewinnen, String Trumpf, String angespeilteKarte) {
        // Leer aber wichtig nicht löschen
    }

    public void ausfuehren(Spieler spieler) {
        // Leer aber wichtig nicht löschen
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

    @Override
    public void ausfuehren(Spiel spiel) {
        Karten gezogeneKarte = spiel.Ziehstapel.get(0);
        while (!(gezogeneKarte instanceof Farbkarte)) {
            spiel.Ziehstapel.remove(0);
            gezogeneKarte = spiel.Ziehstapel.get(0);
        }
        spiel.setTrumpf(gezogeneKarte.getFarbe());
    }
}
class KeinTrumpf extends Karten {
    public KeinTrumpf() {
        super("Kein Trumpf", 0);
    }
    @Override
    public void ausfuehren(Spiel spiel) {
        // Für den aktuellen Stich gibt es keinen Trumpf
        spiel.setTrumpf(null);
        System.out.println("Keinen Trumpf mehr");
    }
}
class Joker extends Karten {
    public Joker() {
        super("Joker", 0);
    }
    @Override
    public void ausfuehren(boolean gewinnen, String Trumpf,String angespeilteKarte) {
        this.wert = 20; 
        if (gewinnen){
            this.wert =20;
            this.farbe=Trumpf;
        }
        else if (!gewinnen){
            this.wert= -1;
            this.farbe= angespeilteKarte;

        }
        // Future me problem 
    }
}
class Plus5 extends Karten {
    public Plus5 (){
        super("Plus5", 0);
    }
    @Override
    public void ausfuehren(Spieler spieler){
        spieler.set_Punkte(spieler.getPunkte() + 5);
    }

}
class Minus5 extends Karten {
    public Minus5(){
        super("Plus5", 0);
    }
    @Override
    public void ausfuehren(Spieler spieler){
        spieler.set_Punkte(spieler.getPunkte()-5);
    }

}


     