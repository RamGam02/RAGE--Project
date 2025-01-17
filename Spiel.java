import java.util.ArrayList;
import java.util.List;

public class Spiel{

    public Spiel() {
        
        List<String> Karten_Liste = new ArrayList<>();
        List<String> Farben_Liste = new ArrayList<>();
        List<String> Karte_Typ_Liste = new ArrayList<>();

        Farben_Liste.add("Grün");
        Farben_Liste.add("Gelb");
        Farben_Liste.add("Rot");
        Farben_Liste.add("Orange");
        Farben_Liste.add("Lilla");
        Farben_Liste.add("Blau");

        for (String farbe : Farben_Liste) {
            System.out.println(farbe);
            
        }
        
        //Spiel hat 10 Runden
        //Erste Runde 10 Karten, zweite Runde 9 Karten, dritte Runde 8 Karten,...

        //Erster Ausspieler ist random (Bei folgenden Runden weiter nach links verschoben)
        //Weiteres Ausspielen vom Spieler der den letzten Stich gemacht hat

        //2 Kartenstapel
        //  >Talon (Ziehstapel)
        //  >Ablagestapel (Jeder Spieler einen)
        //Nach dem Austeilen(automatisch), erste Karte vom Talon seperat ablegen (diese farbe ist Trumpf)
        //  >wenn es eine Aktionskarte ist, gilt die erste gespielte Karte als Trupffarbe

        //Spieler geben ihre Stichwette ab
        //  >0 Stiche sind auch valide
        //Ansagen werden notiert/angezeigt

        //Spielrichtung ist im Uhrzeigersinn

        //Es gilt Farbzwang, nur bei nicht besitzen der Farbe andere Karte gestattet
        //Man kann abwerchen, solange der Farbzwang nicht verletzt wird
        //Kein Trumpfzwang, 
        //  >solange man noch andere Karten außer Trumpf besitzt, muss auch nicht mit Trumpf gestochen werden

        //Den Stich gewinnt die höchste Karte in der aktuellen Trumpffarbe
        //  >Liegt kein Trumpf im Stich, gewinnt die höchste Karte in der zuerst gespielten Farbe
        //Gewonne Stiche kommen auf den Ablagestapel des Siegers

        //Bei Ende der Runde Punkteabrechnung
        //  >Richtige Wette +10 Punkte
        //  >Falsche Wette -5 Punkte
        //  >Jeder Stich +1 Punkt
        //  >Aktionskarte in Ablagestapel (+5 Punkte/-5 Punkte)

        //Alle Karten werden erneut gemischt
        //Jeder Spieler erhält eine Karte weniger als in der Vorrunde


    }
}
