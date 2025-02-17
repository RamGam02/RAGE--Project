import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Spieler {

    // arrray mit handkarten


    // Handkarten zuweisen

    //Karte Legen

        // Anzeigen der Hand Karten
        // Auswahl der Gewünschten Karte
        // Kontrolle der Karte 
        //Ausgabe in die Runde 
        // nächste Zug (Spiel)




    // Anzeigen der Hand Karten
        // Liste mit Karten (10 am Anfang)


        // for (i=0, i<=Handkarten.length(),i++):
            //print(Handkarte.farbe+)

        // gibt alle elemente Liste mit index +1
        // nimmt input
        // gibt Karte zurück

    //Kontrolle der Karte 
        //Kriterium 1-1000


    public String Name;
    public int Punkte;
    public int Wette;
    public int Stiche_gewonnen;
    public boolean Wette_geschafft;
    List<Karten> Handkarten = new ArrayList<>();
    List<String> ablagestapel = new ArrayList<>();
    
    
    

    public Spieler (String pName, int pWette){
        
        this.Name = pName;
        this.Punkte = 0;
        this.Wette = pWette;
    }

    public void Wetten(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(Name + ", wie viele Stiche möchtest du bekommen?");
            while(true){
                try {
                    int input = Integer.parseInt(scanner.nextLine());
                    if (input >= 0){
                        this.Wette = input;
                        System.out.println(Name + " hat " + Wette + " Stiche gewettet.");
                        break;
                    }else{
                        System.out.println("Bitte eine gültig Wette eingeben! (0 oder mehr)");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ungültige Eingabe!! Bitte eine Zahl eingeben!");
                }
            }
        }
    }
    
    public int get_Wette(){
        return Wette;
    }
    
    
    
    
    
    public boolean Wette_geschafft(){
        
        Wette_geschafft = (Stiche_gewonnen == Wette);
        return Wette_geschafft;
    }
    
      

    public void Karte_Legen(){

        Scanner scanner = new Scanner(System.in);
        System.out.println(Name +", wähle eine Karte zum Ablegen: " + Handkarten);
        String gewaehlteKarte = scanner.nextLine();
        if (Handkarten.contains(gewaehlteKarte)) {
            Handkarten.remove(gewaehlteKarte);
            ablagestapel.add(gewaehlteKarte);  
            System.out.println(Name + " hat die Karte "+ gewaehlteKarte + " gespielt!");
        } else {
            System.out.println("Ungültige Karte! Versuche es erneut.");
        }
        
        // (nächste Zug (Spiel))        muss das nicht in spiel???
    }
    
    public void wette_geschaft(){
        //Wette gewonnen?
        
    }
    public int getPunkte(){
        
        return Punkte;}

    
    } 

