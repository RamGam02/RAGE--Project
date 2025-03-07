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
    private String angespielteFarbe;
    List<Karten> ablagestapel = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Spieler(String pName, int pWette) {
        this.Name = pName;
        this.Punkte = 0;
        this.Wette = pWette;
        System.out.println("Spieler " + pName + " wurde erstellt.");
    }
    public String getName(){
        return Name;
    }

    public void Wetten() {
        int i=1;
        for (Karten karte : Handkarten) {
            System.out.println(i + ": " + karte.getFarbe() + " " + karte.getWert());
            i++;
        }

        System.out.println(Name + ", wie viele Stiche möchtest du bekommen?");
            
            while (true) {
                                  
                    int input = Integer.parseInt(scanner.nextLine());
                    if (input >= 0 && input <= Handkarten.size()) {
                        this.Wette = input;
                        System.out.println(Name + " hat " + Wette + " Stiche gewettet.");
                        break;
                    } else {
                        System.out.println("Bitte eine gültige Wette eingeben! (0 oder mehr)");
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
        int i = 1;
        for (Karten karte : Handkarten) {
            System.out.println(i + ": " + karte.getFarbe() + " " + karte.getWert());
            i++;
        }

        Karten karteZuLegen = null;
        while (karteZuLegen == null) {
            
            while (true){
                try {
                    

            int gewaehlteKarte = Integer.parseInt(scanner.nextLine());
            if (gewaehlteKarte > 0 && gewaehlteKarte <= Handkarten.size()) {
                karteZuLegen = Handkarten.get(gewaehlteKarte - 1);
                break;
            } else {
                System.out.println("Ungültige Auswahl! Bitte wähle eine gültige Karte.");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Ungültige Eingabe! Bitte eine Zahl eingeben.");
        } 
    }
        }
        

        if (karteZuLegen != null) {
            String angespielteFarbe = spiel1.Stich.isEmpty() ? null : spiel1.Stich.get(0).getFarbe();
            boolean farbzwangErfuellt = false;

            if (angespielteFarbe != null) {
            for (Karten karte : Handkarten) {
                if (karte.getFarbe().equals(angespielteFarbe)) {
                farbzwangErfuellt = true;
                break;
                }
            }
            }

            if (angespielteFarbe != null && farbzwangErfuellt && !karteZuLegen.getFarbe().equals(angespielteFarbe)) {
            System.out.println("Farbzwang! Du musst eine Karte der gleichen Farbe spielen.");
            return; // Methode verlassen, um eine neue Karte zu wählen
            }

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
                    karteZuLegen.ausfuehren(true, spiel1.getTrumpf(), angespielteFarbe);
                    break;
                } else if (input.equals("n")) {
                    karteZuLegen.ausfuehren(false, spiel1.getTrumpf(), angespielteFarbe);
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
            else {
                System.out.println("Ungültige Karte! Versuche es erneut.");
            }
            }
            }

            ablagestapel.add(karteZuLegen);
            System.out.println(Name + " hat die Karte " + karteZuLegen.getFarbe() + " " + karteZuLegen.getWert() + " gespielt!");
        } 

        public boolean ist_Wette_geschafft() {
        Wette_geschafft = (Stiche_gewonnen == Wette);
        System.out.println(Name + " hat die Wette " + (Wette_geschafft ? "geschafft!" : "nicht geschafft."));
        return Wette_geschafft;
    }

    public void Punkte_berrechen() {
        if (Wette_geschafft) {
            Punkte += 10; // Beispiel: Punkte verdoppeln, wenn Wette geschafft
        } else {
            Punkte -= 5; // Beispiel: Punkte abziehen, wenn Wette nicht geschafft
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

