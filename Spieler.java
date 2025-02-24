import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Spieler {

    public String Name;
    public int Punkte;
    public int Wette;
    public int Stiche_gewonnen;
    public boolean Wette_geschafft;
    List<Karten> Handkarten = new ArrayList<>();
    List<Karten> ablagestapel = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Spieler(String pName, int pWette) {
        this.Name = pName;
        this.Punkte = 0;
        this.Wette = pWette;
        System.out.println("Spieler " + pName + " wurde erstellt.");
    }

    public void Wetten() {
        int i=1;
        for (Karten karte : Handkarten) {
            System.out.println(i + ": " + karte.getFarbe() + " " + karte.getWert());
            i++;
        }

        System.out.println(Name + ", wie viele Stiche möchtest du bekommen?");
            
            while (true) {
                try {                   
                    int input = Integer.parseInt(scanner.nextLine());
                    if (input >= 0) {
                        this.Wette = input;
                        System.out.println(Name + " hat " + Wette + " Stiche gewettet.");
                        break;
                    } else {
                        System.out.println("Bitte eine gültige Wette eingeben! (0 oder mehr)");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ungültige Eingabe!! Bitte eine Zahl eingeben!");
                }
            }
            
    }

    public int get_Wette() {
        System.out.println("Die aktuelle Wette von " + Name + " ist: " + Wette);
        return Wette;
    }

    public void Karte_Legen(Spiel spiel1) {
        System.out.println("Trumpf: " + spiel1.getTrumpf());
        System.out.println(Name + ", wähle eine Karte zum Ablegen:");
        int i =1;
        for (Karten karte : Handkarten) {
            System.out.println(i + ": " + karte.getFarbe() + " " + karte.getWert());
            i++;
        }
        int gewaehlteKarte =Integer.parseInt(scanner.nextLine());
        Karten karteZuLegen = null;
        karteZuLegen = Handkarten.get(gewaehlteKarte-1);

        if (karteZuLegen != null) {
            Handkarten.remove(karteZuLegen);
            spiel1.Stich.add(karteZuLegen);
            if (!(karteZuLegen instanceof Farbkarte)) {
                String kartenTyp = karteZuLegen.getFarbe(); 
                if (kartenTyp.equals("Trumpfwechsel")) {
                    karteZuLegen.ausfuehren(spiel1);
                } else if (kartenTyp.equals("KeinTrumpf")) {
                    karteZuLegen.ausfuehren(spiel1);
                } else if (kartenTyp.equals("Joker")) {
                    while (true) {
                        System.out.println("Willst du diesen Stich gewinnen? y/n");
                        String input = scanner.nextLine();
                        if (input.equals("y")) {
                            karteZuLegen.ausfuehren(true,spiel1.getTrumpf(),spiel1.Stich.get(0).getFarbe());
                            break;
                        } else if (input.equals("n")) {
                            karteZuLegen.ausfuehren(false,spiel1.getTrumpf(),spiel1.Stich.get(0).getFarbe());
                            break;
                        } else {
                            System.out.println("Falsche Eingabe");
                        }
                    }
                } else if (kartenTyp.equals("Plus 5")) {
                    karteZuLegen.ausfuehren(this);
                } else if (kartenTyp.equals("Minus 5")) {
                    karteZuLegen.ausfuehren(this);
            }
            ablagestapel.add(karteZuLegen);
            System.out.println(Name + " hat die Karte " + gewaehlteKarte + " gespielt!");
        }
    } 
        else {
            System.out.println("Ungültige Karte! Versuche es erneut.");
        }
        
    }

    public boolean ist_Wette_geschafft() {
        Wette_geschafft = (Stiche_gewonnen == Wette);
        System.out.println(Name + " hat die Wette " + (Wette_geschafft ? "geschafft!" : "nicht geschafft."));
        return Wette_geschafft;
    }

    public void Punkte_berrechen() {
        if (Wette_geschafft) {
            Punkte += Wette * 2; // Beispiel: Punkte verdoppeln, wenn Wette geschafft
        } else {
            Punkte -= Wette; // Beispiel: Punkte abziehen, wenn Wette nicht geschafft
        }
        System.out.println("Punkte für " + Name + " wurden gesetzt: " + Punkte);
    }

    public int getPunkte() {
        System.out.println(Name + " hat aktuell " + Punkte + " Punkte.");
        return Punkte;
    
    }
    public void set_Punkte(int punkte){
        this.Punkte = punkte;
    }
}

