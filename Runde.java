public class Runde{

    private int Anzahl_Runde;
    private int Anzahl_Karten;          // Variablen für die Klasse
    public String Trumpf;
    public String ausgespielteFarbe;
    


    public Runde(){

        this.Anzahl_Karten = 0;
        this.Anzahl_Runde = 0;                   // Konstruktor
        this.Trumpf = null;
        this.ausgespielteFarbe = null;

    }

   

}



// Zuweisung von Zahlen für Anzahl_Karten und Anzahl_Runde:
// for (i = 1, i < 11, i++){               (i = Anzahl_Runde)
// Anzahl_Karten = 10           (nicht fertig)
//