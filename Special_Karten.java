public class Karten {    
    public int wert;
    public string Farbe;

    public Karten(String pfarbe, int pWert){

        this.Farbe = pfarbe;
        this.wert = pWert;
    }
    public int getWert(){
        return wert;
    }

    
}

//public class Special_Karten extends Karten 

//public class Special_Karten {
    


        //Aktionskarten
        //  >Joker
        //      >Spieler sagt beliebige Farbe an, Karte wird zur höchsten Karte dieser Farbe
        //      >Joker kann auch Trumpf werden
        //      >bei 2 Joker in einem Stich, 2. Joker höher als 1.
        //      >bei Eröffnung mit Joker muss die angesagte Farbe bedient werden
        //  >+5/-5
        //      >

  //  }
//}
//public class Special_Karten extends Karten {
 
    //public Special_Karten(String pFarbe, String aktion) {
        //super(pFarbe, aktion);
    //}
//}
