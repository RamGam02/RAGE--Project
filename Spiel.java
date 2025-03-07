import java.util.*;

public class Spiel {

    private String Trumpf = null; // for later
    private int Runde = 0; // for later
    private int Spieler_Anzahl = 4; // for later
    private List<Spieler> Spieler_Liste = new ArrayList<>();
    public List<Karten> Karten_Liste = new ArrayList<>();
    public List<Karten> Ziehstapel = new ArrayList<>(Karten_Liste);
    public List<Karten> ablagestapel = new ArrayList<>();
    public List<Karten> Stich = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    public Spiel() {

        
        Spieler_Anzahl_abfragen();
        Staple_erstellen();
        Spieler_erstellen();
        Spielstart(Spieler_Anzahl);
        scanner.close();
    }
    
    public void Spieler_Anzahl_abfragen(){

        
        System.out.println("Wie viele Spieler gibt es?");
        while (true) {
            
            int Spieler_Anzahl_neu = Integer.parseInt(scanner.nextLine());
            if (Spieler_Anzahl_neu >= 2 && Spieler_Anzahl_neu <= 10) {
                this.Spieler_Anzahl = Spieler_Anzahl_neu;
                break;
            } else {
                System.out.println("Ungültige Spieleranzahl! Bitte eine Zahl zwischen 2 und 10 eingeben.");
            }  
    }
}
    
    public String getTrumpf(){

        return Trumpf;
    }
    
    public void Staple_erstellen() {
        List<String> Farben_Liste = new ArrayList<>(Arrays.asList("Grün", "Gelb", "Rot", "Orange", "Lila", "Blau"));
        List<Integer> Number_Liste = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        List<String> Karte_Typ_Liste = new ArrayList<>(Arrays.asList("Plus 5", "Plus 5", "Plus 5", "Minus 5", "Minus 5", "Minus 5", "Trumpfwechsel", "Trumpfwechsel", "Trumpfwechsel", "Trumpfwechsel", "Kein Trumpf", "Kein Trumpf", "Kein Trumpf", "Kein Trumpf", "Joker", "Joker"));

        for (String farbe : Farben_Liste) {
            for (int number : Number_Liste) {
                Karten_Liste.add(new Farbkarte(farbe, number));
                System.out.println("Erstellte Karte: " + farbe + " " + number); // Ausgabe der erstellten Karte
            }
        }

        for (String karteTyp : Karte_Typ_Liste) {
            if (karteTyp.equals("Trumpfwechsel")) {
            Trumpfwechsel trumpfwechsel = new Trumpfwechsel();
            Karten_Liste.add(trumpfwechsel);
            } else if (karteTyp.equals("Kein Trumpf")) {
            KeinTrumpf keinTrumpf = new KeinTrumpf();
            Karten_Liste.add(keinTrumpf);
            } else if (karteTyp.equals("Joker")) {
            Joker joker = new Joker();
            Karten_Liste.add(joker);
            } else if (karteTyp.equals("Plus 5")){
                Plus5 plus5 = new Plus5();
                Karten_Liste.add(plus5);
            } else if (karteTyp.equals("Minus 5")){
                Minus5 minus5 = new Minus5();

            } else {System.out.println("Fehler beim erstellen von Spezial Karten");}
        }
        }
    
    public void Spieler_erstellen() {

        for (int i = 0; i < Spieler_Anzahl; i++) {
            Spieler spieler = new Spieler("Spieler " + (i + 1), 0);
            Spieler_Liste.add(spieler);
        }

    }

    public void Spielstart(int Spieler_Anzahl) {
        Spieler ersterAusspieler = Spieler_Liste.get((int) (Math.random() * Spieler_Anzahl));
        
        System.out.println("Erster Ausspieler ist " + ersterAusspieler.Name);
        for (int runde = 10; runde > 0; runde--) {
            int kartenProSpieler = runde;
            System.out.println("Runde " + (11 - runde) + " beginnt mit " + kartenProSpieler + " Karten pro Spieler");
            Runde(kartenProSpieler, Karten_Liste, ersterAusspieler);
        }
        Spiel_auswerten();
    }

    public void Runde(int kartenProSpieler, List<Karten> Karten_Liste, Spieler Ersterspieler) {
        Ziehstapel.clear();
        Ziehstapel.addAll(Karten_Liste);
        Mischen(Ziehstapel);
        System.out.println(kartenProSpieler);
        Austeilen(kartenProSpieler, Ziehstapel);
        Trumpf_Karte();
        Wetten(Ersterspieler);
        Spieler aktuellerAusspieler = Ersterspieler;
        for (int i = 0; i < kartenProSpieler; i++) {
            String angespielteFarbe = null;
            for (int j = 0; j < Spieler_Liste.size(); j++) {
                Spieler spieler = Spieler_Liste.get((Spieler_Liste.indexOf(aktuellerAusspieler) + j) % Spieler_Liste.size());
                while (true) {
                    int initialStichSize = Stich.size();
                    spieler.Karte_Legen(this);
                    Karten gespielteKarte = Stich.get(Stich.size() - 1);
                    if (angespielteFarbe == null) {
                        angespielteFarbe = gespielteKarte.getFarbe();
                    }
                    if (initialStichSize < Stich.size()) {
                        break;
                    } else {
                        System.out.println("Ungültiger Zug! Bitte erneut versuchen.");
                    }
                }
                // Nach dem Legen des Spielers leere Zeilen einfügen
                System.out.println("Drücke Enter, um fortzufahren...");
                scanner.nextLine(); // Warten auf Enter-Taste
                for (int k = 0; k < 50; k++) { // 50 leere Zeilen einfügen
                    System.out.println();
                }
            }
            aktuellerAusspieler = Stich_auswerten();
        }
        Runde_Auswerten();
    }

    public void setTrumpf(String neuerTrumpf){

        Trumpf = neuerTrumpf;
        System.out.println("Trumpf gesetzt auf: " + neuerTrumpf);

    }

    public void Mischen(List<Karten> Ziehstapel) {
        Collections.shuffle(Ziehstapel);
        System.out.println("Ziehstapel gemischt");
    }

    public void Austeilen(int kartenProSpieler, List<Karten> Ziehstapel) {
        for (int i = 0; i < kartenProSpieler; i++) {
            
            for (Spieler spieler : Spieler_Liste) {
                Ziehstapel.get(0).setBesitzer(spieler);
                spieler.Handkarten.add(Ziehstapel.get(0));
                Ziehstapel.remove(0);
                
            }
        }
        System.out.println("Karten ausgeteilt");
    }

    public void Wetten(Spieler StartSpieler) {
        int startIndex = Spieler_Liste.indexOf(StartSpieler);
        for (int i = 0; i < Spieler_Liste.size(); i++) {
            Spieler spieler = Spieler_Liste.get((startIndex + i) % Spieler_Liste.size());
            spieler.Wetten();
            // Nach dem Wetten des Spielers leere Zeilen einfügen
            System.out.println("Drücke Enter, um fortzufahren...");
            scanner.nextLine(); // Warten auf Enter-Taste
            for (int j = 0; j < 50; j++) { // 50 leere Zeilen einfügen
                System.out.println();
            }
        }
        System.out.println("Wetten abgeschlossen");
    }

    public void Trumpf_Karte() {
        Karten erste_Karte = Ziehstapel.remove(0);
        Trumpf = erste_Karte.farbe;
        System.out.println("Trumpfkarte gezogen: " + erste_Karte.farbe );
    }

    public void Runde_Auswerten() {
        for (Spieler spieler : Spieler_Liste) {
            if (spieler.ist_Wette_geschafft()) {
                spieler.Punkte += 10;
                System.out.println("Spieler " + spieler.Name + " hat seine Wette geschafft und erhält 10 Punkte");
            }
        }
    }

    public void Spiel_auswerten() {
        Spieler_Liste.sort(Comparator.comparing(Spieler::getPunkte).reversed());
        System.out.println("Der Gewinner ist " + Spieler_Liste.get(0).Name);
    }

    public Spieler Stich_auswerten() {
        List<Karten> Trumpf_Liste = new ArrayList<>();
        List<Karten> Angespielte_Liste = new ArrayList<>();
        List<Karten> Joker_Liste = new ArrayList<>();

        String angespielte_Farbe = null;

        for (Karten karte : Stich) {
            if (karte instanceof Joker) {
                Joker_Liste.add(karte);
            } else if (karte.farbe.equals(Trumpf)) {
                Trumpf_Liste.add(karte);
            } else if (angespielte_Farbe == null && karte instanceof Farbkarte) {
                angespielte_Farbe = karte.getFarbe();
                Angespielte_Liste.add(karte);
            } else if (karte.farbe.equals(angespielte_Farbe)) {
                Angespielte_Liste.add(karte);
            } 
        }

        // Wenn keine Farbkarte im Stich ist, setze die angespielte Farbe auf die erste Farbkarte
        if (angespielte_Farbe == null && !Angespielte_Liste.isEmpty()) {
            angespielte_Farbe = Angespielte_Liste.get(0).getFarbe();
        }

        Karten Stich_Gewinner;
        if (!Joker_Liste.isEmpty()) {
            if (Joker_Liste.size() == 1) {
                Stich_Gewinner = Joker_Liste.get(0);
            } else {
                for (Karten joker : Joker_Liste) {
                    Spieler besitzer = joker.getBesitzer();
                    System.out.println(besitzer.Name + ", möchtest du den Stich gewinnen? (y/n)");
                    while (true) {
                        String input = scanner.nextLine();
                        if (input.equalsIgnoreCase("y")) {
                            Stich_Gewinner = joker;
                            Spieler Gewinner = Stich_Gewinner.getBesitzer();
                            System.out.println("Stich Gewinner: " + Gewinner.Name);
                            Stich.clear();
                            return Gewinner;
                        } else if (input.equalsIgnoreCase("n")) {
                            break;
                        } else {
                            System.out.println("Ungültige Eingabe! Bitte 'y' oder 'n' eingeben.");
                        }
                    }
                }
                // Wenn keiner den Stich gewinnen möchte, gewinnt der erste Joker
                Stich_Gewinner = Joker_Liste.get(0);
            }
        } else if (!Trumpf_Liste.isEmpty()) {
            Trumpf_Liste.sort(Comparator.comparing(Karten::getWert).reversed());
            Stich_Gewinner = Trumpf_Liste.get(0);
        } else {
            Angespielte_Liste.sort(Comparator.comparing(Karten::getWert).reversed());
            Stich_Gewinner = Angespielte_Liste.get(0);
        }

        Spieler Gewinner = Stich_Gewinner.getBesitzer();
        System.out.println("Stich Gewinner: " + Gewinner.Name);
        Stich.clear();
        return Gewinner;
    }

    public static void main(String[] args) {
        new Spiel();
}
}



