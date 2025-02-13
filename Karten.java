public class Karten {    
    public int wert;
    public String Farbe;
    public Spieler spieler;

    public Karten(String pfarbe, int pWert){

        this.Farbe = pfarbe;
        this.wert = pWert;
        this.spieler = null;
    }
    public int getWert(){
        return wert;
    }
    public Spieler getBesitzer() {
        return spieler;
    }
    public String getFarbe() {
        return Farbe;
    }
    
}