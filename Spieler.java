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
    List<Karten> Handkarten = new ArrayList<>();
    
    
    

    public Spieler (String pName, int pWette){
        
        List<String> Karten_Liste = new ArrayList<>();
        this.Name = pName;
        this.Punkte = 0;
        this.Wette = pWette;
    }

    public void Wetten(){
        Scanner scanner = new Scanner(System.in);
    
        System.out.println(Name + ", wie viele Stiche möchtest du bekommen?");
        while(true){
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= 0){
                    int Wette = input;
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
    
    public int get_Wette(){
        return Wette;
    }
    
    public void Karte_Legen(){


        // Anzeigen der Handkarten
        // Auswahl der gewünschten Karte
        // Kontrolle der Karte
        // Ausgabe in die Runde
        // Nächster Zug (Spiel)
    }
    
    
    
    public boolean Wette_geschafft(){
        return false;
        // Wette gewonnen?
    
    }
    
    public void set_Punkte(){
    
    
    }    

    
   
    public void wette_geschaft(){
        //Wette gewonnen?
        
    }
    
    public int getPunkte(){
        
        return Punkte;}



    

    
    } 

