public class Karten {    
    public int wert;
    public String farbe;
    public Spieler spieler;
    public String typ;

    public Karten(String pfarbe, int pWert){

        this.farbe = pfarbe;
        this.wert = pWert;
        this.spieler = null;
    }

    public Karten(String pfarbe, String pwert, String ptyp) {
        this.farbe = pfarbe;
        this.wert = Integer.parseInt(pwert);
        this.typ = ptyp;
    }

    public String getTyp() {
        return typ;
    }

    public int getWert(){
        return wert;
    }
    public Spieler getBesitzer() {
        return spieler;
    }
    public String getFarbe() {
        return farbe;
    }
    
}