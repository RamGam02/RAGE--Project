import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Spiel {

    private String Trumpf = "lol"; // for later
    private final int Runde = 0; // for later
    private final int Spieler_Anzahl = 4; // for later
    private List<Spieler> Spieler_Liste = new ArrayList<>();
    public List<Karten> Karten_Liste = new ArrayList<>();
    public List<Karten> Ziehstapel = new ArrayList<>(Karten_Liste);
    public List<Karten> ablagestapel = new ArrayList<>();

    public Spiel() {
        Spieler_Anzahl_abfragen();
        Staple_erstellen();
        Spieler_erstellen();
        Spielstart(Spieler_Anzahl);
    }
    public void Spieler_Anzahl_abfragen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Spieler gibt es?")
        int Spieler_Anzahl_neu = scanner.nextLine()
        this.Spieler_Anzahl = Spieler_Anzahl_neu;
        
    }

    public void Staple_erstellen() {
        List<String> Farben_Liste = new ArrayList<>(Arrays.asList("Grün", "Gelb", "Rot", "Orange", "Lila", "Blau"));
        List<Integer> Number_Liste = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        List<String> Karte_Typ_Liste = new ArrayList<>(Arrays.asList("Plus 5", "Plus 5", "Plus 5", "Minus 5", "Minus 5", "Minus 5", "Trumpfwechsel", "Trumpfwechsel", "Trumpfwechsel", "Trumpfwechsel", "Kein Trumpf", "Kein Trumpf", "Kein Trumpf", "Kein Trumpf", "Joker", "Joker"));

        for (String farbe : Farben_Liste) {
            for (int number : Number_Liste) {
                Karten_Liste.add(new Karten(farbe, number));
                System.out.println("Erstellte Karte: " + farbe + " " + number); // Ausgabe der erstellten Karte
            }
        }

        for (String karteTyp : Karte_Typ_Liste) {
            if (karteTyp.equals("Trumpfwechsel")) {
            Trumpfwechsel trumpfwechsel = new Trumpfwechsel();
            Karten_Liste.add(trumpfwechsel);
            } else if (karteTyp.equals("KeinTrumpf")) {
            KeinTrumpf keinTrumpf = new KeinTrumpf();
            Karten_Liste.add(keinTrumpf);
            } else if (karteTyp.equals("Joker")) {
            Joker joker = new Joker();
            Karten_Liste.add(joker);
            } else if (kartenTyp.equals("Plus 5"))
            {
                Plus5 plus5 = new Plus5;
                Karten_Liste.add(plus5);
            } else if (kartenTyp.equals("Minus 5")){
                Minus5 minus5 = new Minus5;
                Karten_Liste.add(minus5);

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
        System.out.println("lol");
        Trumpf_Karte();
        Wetten(Ersterspieler);
        for (int i = 0; i < kartenProSpieler; i++) {
            for (Spieler spieler : Spieler_Liste) {
                spieler.Karte_Legen(this);
            }
        }
        Runde_Auswerten();
    }

    public void setTrumpf(String neuerTrumpf){

        Trumpf = neuerTrumpf;

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
        for (Spieler spieler : Spieler_Liste) {
            spieler.Wetten();
        }
        System.out.println("Wetten abgeschlossen");
    }

    public void Trumpf_Karte() {
        Karten erste_Karte = Ziehstapel.remove(0);
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

    public void Stich_auswerten(List<Karten> Stich) {
        List<Karten> Trumpf_Liste = new ArrayList<>();
        List<Karten> Angespielte_Liste = new ArrayList<>();

        
        while (!(Stich.get(0) instanceof Farbkarte)) {
            Stich.remove(0);
        }
        
        String angespielte_Farbe = Stich.get(0).getFarbe();
        for (Karten karte : Stich) {
            if (karte.farbe.equals(Trumpf)) {
                Trumpf_Liste.add(karte);
            } 
            if(karte.farbe.equals(angespielte_Farbe) ) {
                Angespielte_Liste.add(karte);
            }
        }
        if (Trumpf_Liste.size() > 0) {
            Trumpf_Liste.sort(Comparator.comparing(Karten::getWert));
            Karten Stich_Gewinner = Trumpf_Liste.get(0);
            Spieler Gewinner = Stich_Gewinner.getBesitzer();
            System.out.println("Stich Gewinner (Trumpf): " + Gewinner.Name);
        } else {
            Angespielte_Liste.sort(Comparator.comparing(Karten::getWert));
            Karten Stich_Gewinner = Angespielte_Liste.get(0);
            Spieler Gewinner = Stich_Gewinner.getBesitzer();
            System.out.println("Stich Gewinner : " + Gewinner.Name);
        }
    }

    public static void main(String[] args) {
        new Spiel();
    }
}
