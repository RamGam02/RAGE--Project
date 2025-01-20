
public class Karten{
    private String farbe;
    private String wert;




    public Karten(String pfarbe, String pWert){

        this.farbe = pfarbe;
        this.wert = pWert;


        //Aktionskarten
        //  >Joker
        //      >Spieler sagt beliebige Farbe an, Karte wird zur höchsten Karte dieser Farbe
        //      >Joker kann auch Trumpf werden
        //      >bei 2 Joker in einem Stich, 2. Joker höher als 1.
        //      >bei Eröffnung mit Joker muss die angesagte Farbe bedient werden
        //  >+5/-5
        //      >
public class Karten{


    private String Farbe;
    private String Wert;




    public Karten(String pFarbe, String pWert){

        this.Farbe = pFarbe;                      // Konstruktor
        this.Wert = pWert;

    }


    
}


public class Special_Karten extends Karten 
//public class Special_Karten extends Karten (nur kurz rauskommentiert, kann danach weitergearbeitet werden)
