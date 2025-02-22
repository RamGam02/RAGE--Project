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

    public Spieler(String pName, int pWette) {
        this.Name = pName;
        this.Punkte = 0;
        this.Wette = pWette;
        System.out.println("Spieler " + pName + " wurde erstellt.");
    }

    public void Wetten() {
        try (Scanner scanner = new Scanner(System.in)) {
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
        scanner.close();
    }

    public int get_Wette() {
        System.out.println("Die aktuelle Wette von " + Name + " ist: " + Wette);
        return Wette;
    }

    public void Karte_Legen(Spiel spiel) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Name + ", wähle eine Karte zum Ablegen: " + Handkarten);
        String gewaehlteKarte = scanner.nextLine();
        Karten karteZuLegen = null;
        for (Karten karte : Handkarten) {
            if (karte.toString().equals(gewaehlteKarte)) {
                karteZuLegen = karte;
                break;
            }
        }
        if (karteZuLegen != null) {
            Handkarten.remove(karteZuLegen);
            spiel.Stich.add(karteZuLegen);
            if !(karteZuLegen instanceof Farbkarte)
                {
                    if (karteTyp.equals("Trumpfwechsel")) {
                        karteZuLegen.ausfuehren(spiel, spiel.nachziehstapel, )
                        
                        } else if (karteTyp.equals("KeinTrumpf")) {
                            karteZuLegen.ausfuehren(spiel);
                        
                        } else if (karteTyp.equals("Joker")) {
                            while(true){
                            System.out.println("Willst du diese Stich gewinnen? y/n")
                            String input = scanner.nextline();
                            if input.equals("y"){
                                karteZuLegen.ausfuehren(true)
                                break;
                            }
                            else if input.equals("n"){
                                karteZuLegen.ausfuehren(false)
                                break;
                            }
                            else {"falsche Eingabe"}
                            }
                        } else if (kartenTyp.equals("Plus 5"))
                        {
                          karteZuLegen.ausfuehren(this);
                        } else if (kartenTyp.equals("Minus 5")){
                            karteZuLegen.ausfuehren(this);
                        } else {System.out.println("Fehler beim Auspielen von Spezial Karten")}
                }
            ablagestapel.add(karteZuLegen);
            System.out.println(Name + " hat die Karte " + gewaehlteKarte + " gespielt!");
        } else {
            System.out.println("Ungültige Karte! Versuche es erneut.");
        }
        scanner.close();
        // Nächster Zug (Spiel)
    }

    public boolean ist_Wette_geschafft() {
        Wette_geschafft = (Stiche_gewonnen == Wette);
        System.out.println(Name + " hat die Wette " + (Wette_geschafft ? "geschafft!" : "nicht geschafft."));
        return Wette_geschafft;
    }

    public void set_Punkte() {
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
}

