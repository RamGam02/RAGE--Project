<<<<<<< HEAD
<<<<<<<< HEAD:Karten.java





public class Karten{
=======

public class Karten {
>>>>>>> 3a171f616ec1bd8669aa7626561351b7e315e238
    private String farbe;
    private String wert;




    public Karten(String pfarbe, String pWert){

        this.farbe = pfarbe;
        this.wert = pWert;

<<<<<<< HEAD
    }


    
}

//public class Special_Karten extends Karten 
========
public class Special_Karten {
    
}
>>>>>>>> 3a171f616ec1bd8669aa7626561351b7e315e238:Special_Karten.java
=======

        //Aktionskarten
        //  >Joker
        //      >Spieler sagt beliebige Farbe an, Karte wird zur höchsten Karte dieser Farbe
        //      >Joker kann auch Trumpf werden
        //      >bei 2 Joker in einem Stich, 2. Joker höher als 1.
        //      >bei Eröffnung mit Joker muss die angesagte Farbe bedient werden
        //  >+5/-5
        //      >

    }
}
public class Special_Karten extends Karten {
 
    public Special_Karten(String pFarbe, String aktion) {
        super(pFarbe, aktion);
    }
}

>>>>>>> 3a171f616ec1bd8669aa7626561351b7e315e238
