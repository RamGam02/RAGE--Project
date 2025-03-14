import java.util.*;

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
        int i = 1;
        for (Karten karte : Handkarten) {
            System.out.println(i + ": " + karte.getFarbe() + " " + karte.getWert());
            i++;
        }
        System.out.println(Name + ", wie viele Stiche möchtest du bekommen?");
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= 0 && input <= Handkarten.size()) {
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
        boolean farbzwang = false;
        System.out.println("Trumpf: " + spiel1.getTrumpf());
        System.out.println("Aktueller Stich:");
        if (spiel1.Stich.isEmpty()) {
            System.out.println("Keine Karten im Stich.");
        } else {
            for (Karten karte : spiel1.Stich) {
                System.out.println(karte.getFarbe() + " " + karte.getWert());
            }
        }
        System.out.println(Name + ", wähle eine Karte zum Ablegen:");
        int i = 1;
        if (!spiel1.Stich.isEmpty()) {
            for (Karten karte : Handkarten) {
                if (karte.getFarbe().equals(spiel1.Stich.get(0).getFarbe()) && !farbzwang) {
                    farbzwang = true;
                    System.out.println("Du hast eine Karte der gleichen Farbe.");
                    break;
                }
            }
            if (!farbzwang ) {
                System.out.println("Du hast keine Karte der gleichen Farbe.");
            }
        }
        for (Karten karte : Handkarten) { // zeigt Handkarten an
            System.out.println(i + ": " + karte.getFarbe() + " " + karte.getWert());
            i++;
        }

        int gewaehlteKarte;
        Karten karteZuLegen = null;
        while (true) {
            try {
                gewaehlteKarte = Integer.parseInt(scanner.nextLine());
                if (gewaehlteKarte < 1 || gewaehlteKarte > Handkarten.size()) {
                    System.out.println("Ungültige Karte! Versuche es erneut.");
                    continue;
                }
                karteZuLegen = Handkarten.get(gewaehlteKarte - 1);
                if (!spiel1.Stich.isEmpty() && !karteZuLegen.getFarbe().equals(spiel1.Stich.get(0).getFarbe()) && farbzwang) {
                    System.out.println("Farbzwang! Du musst eine Karte der gleichen Farbe spielen.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe! Bitte eine Zahl eingeben.");
            }
        }

        if (karteZuLegen != null) {
            Handkarten.remove(karteZuLegen);
            spiel1.Stich.add(karteZuLegen);
            String kartenTyp = karteZuLegen.getFarbe();

            if (farbzwang == false && !karteZuLegen.getFarbe().equals(spiel1.Stich.get(0).getFarbe())) {
                System.out.println("Farbzwang! Du musst eine Karte der gleichen Farbe spielen.");
                Handkarten.add(karteZuLegen); // Karte zurück auf die Hand legen
                return; // Methode verlassen, um eine neue Karte zu wählen
            } 
            if (!(karteZuLegen instanceof Farbkarte)) {
                if (kartenTyp.equals("Trumpfwechsel")) {
                    karteZuLegen.ausfuehren(spiel1);
                } else if (kartenTyp.equals("KeinTrumpf")) {
                    karteZuLegen.ausfuehren(spiel1);
                } else if (kartenTyp.equals("Joker")) {
                    while (true) {
                        System.out.println("Willst du diesen Stich gewinnen? y/n");
                        String input = scanner.nextLine();
                        if (input.equals("y")) {
                            karteZuLegen.ausfuehren(true, spiel1.getTrumpf(), spiel1.Stich.get(0).getFarbe());
                            break;
                        } else if (input.equals("n")) {
                            karteZuLegen.ausfuehren(false, spiel1.getTrumpf(), spiel1.Stich.get(0).getFarbe());
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
            }

            ablagestapel.add(karteZuLegen);
            System.out.println(Name + " hat die Karte " + gewaehlteKarte + " gespielt!");

        } else {
            System.out.println("Ungültige Karte! Versuche es erneut.");
        }
    }

    public boolean ist_Wette_geschafft() {
        Wette_geschafft = (Stiche_gewonnen == Wette);
        if (Wette_geschafft == true) {
            System.out.println(Name + " hat die Wette geschafft!");
        } else {
            System.out.println(Name + " hat die Wette nicht geschafft!");
        }
        return Wette_geschafft;
    }

    public int getPunkte() {
        System.out.println(Name + " hat aktuell " + Punkte + " Punkte.");
        return Punkte;
    }

    public void set_Punkte(int punkte) {
        this.Punkte = punkte;
    }
}
