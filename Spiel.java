import java.util.*;

public class Spiel {

    private String Trumpf = null; // for later
    private List<Spieler> Spieler_Liste = new ArrayList<>();
    public List<Karten> Karten_Liste = new ArrayList<>();
    public List<Karten> Ziehstapel = new ArrayList<>(Karten_Liste);
    public List<Karten> ablagestapel = new ArrayList<>();
    public List<Karten> Stich = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    public Spiel() {
        Spieler_erstellen();
        Staple_erstellen();
        Spielstart();
        scanner.close();
    }
    public boolean GibtesdenNamen(String input){
        for (Spieler spieler : Spieler_Liste) {
            if (input.equals(spieler.Name))  { 
                return true;  
            }
        }
        return false;
    }
    
    public void Spieler_erstellen(){
        String input =null;
        while (true){
        System.out.println("Names des neuen Spielers:");
        while (true) { 
            input = scanner.nextLine();
            boolean nameExists = GibtesdenNamen(input);
            if (nameExists) {
                System.out.println("Der Name ist bereits vergeben. Bitte wähle einen anderen Namen.");
            }else {
            Spieler spieler = new Spieler(input, 0);
            Spieler_Liste.add(spieler);
            break;
            }
        } 
        System.out.println("Willst du einen neuen Spieler?y/n");
        input = scanner.nextLine();
        if (input.equals("y") || Spieler_Liste.size() < 2) {}
            if (Spieler_Liste.size() <2) {
                System.out.println("Es müssen mindestens 2 Spieler erstellt werden");
            }
        else if (input.equals("n")){
            break;
        }
        else {
            System.out.println("Ungültige Eingabe! Bitte 'y' oder 'n' eingeben.");
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
            System.out.println("Erstellte Karte: " + karteTyp );
        }
            
        }
    
    public void Spielstart() {
        Random random = new Random();
        Spieler ersterAusspieler = Spieler_Liste.get(random.nextInt(Spieler_Liste.size()));       
        System.out.println("Erster Ausspieler ist " + ersterAusspieler.Name);
        for (int runde = 1; runde > 0; runde--) {
            int kartenProSpieler = runde;
            System.out.println("Runde " + (11 - runde) + " beginnt mit " + kartenProSpieler + " Karten pro Spieler");
            Runde(kartenProSpieler, Karten_Liste, ersterAusspieler);
            display_score();
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
                ClearScreen();
            }
            aktuellerAusspieler = Stich_auswerten();
            aktuellerAusspieler.Stiche_gewonnen =+1;
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
            ZeigeTrumpf();
            spieler.Wetten();
            ClearScreen();
        }
        System.out.println("Wetten abgeschlossen");
    }

    public void Trumpf_Karte() {
        while(true){
            Karten erste_Karte = Ziehstapel.remove(0);
            if(erste_Karte instanceof Farbkarte){ 
                Trumpf = erste_Karte.farbe;
                break;
            }
        
        }
    }

    public void ZeigeTrumpf(){
        System.out.println("Der Trumpf ist: " + Trumpf);
    }

    public void Runde_Auswerten() {
        for (Spieler spieler : Spieler_Liste) {
            if (spieler.ist_Wette_geschafft()) {
                spieler.Punkte += 10 + spieler.Stiche_gewonnen;
                System.out.println("Spieler " + spieler.Name + " hat seine Wette geschafft und erhält 10 Punkte");
            }
            else {
                spieler.Punkte -=5 + spieler.Stiche_gewonnen;
                if (spieler.Punkte > 0){
                    System.out.println(spieler.Name + " hat seine Wette nicht geschafft, gewinnt dennoch " + spieler.Punkte + " Punkte!");
                } else{
                    System.out.println("Spieler " + spieler.Name + " hat seine Wette nicht geschafft und verliert " + (spieler.Punkte * (-1)) + " Punkte");
                }
                
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
            Spieler Gewinner;
            int i=0;
            while (i < Stich.size() && !(Stich.get(i) instanceof Farbkarte)) {
                i++;
            }
            
            if (i == Stich.size()) {
                Spieler ersterSpieler = Stich.get(0).getBesitzer();
                Gewinner = ersterSpieler;
                System.out.println("Keine Farbkarte im Stich. Erster Spieler bekommt den Stich: " + Gewinner.Name);
                
            }else{
                String angespielte_Farbe =null;
                for (Karten karte : Stich) {
                    if (karte instanceof Farbkarte) {
                        angespielte_Farbe = karte.getFarbe();
                        break;
                    }
                }
                for (Karten karte : Stich) {
                    if (karte.farbe.equals(Trumpf)) {
                        Trumpf_Liste.add(karte);
                    } 
                    else if(karte.farbe.equals(angespielte_Farbe) ) {
                        Angespielte_Liste.add(karte);
                    }
                }
                if (Trumpf_Liste.size() > 0) {
                    Trumpf_Liste.sort(Comparator.comparing(Karten::getWert));
                    Karten Stich_Gewinner = Trumpf_Liste.get(0);
                    Gewinner = Stich_Gewinner.getBesitzer();
                    System.out.println("Stich Gewinner (Trumpf): " + Gewinner.Name);
                } else {                                                                    // hier wird irgendwo nicht nach dem Wert Sortiert, niedrigerer Wert gewinnt --> falsch
                    Angespielte_Liste.sort(Comparator.comparing(Karten::getWert));
                    // System.out.println(Angespielte_Liste.get(0).getWert());           Wir haben da was mit Frau Reichgardt probiert
                    Karten Stich_Gewinner = Angespielte_Liste.get(0);
                    Gewinner = Stich_Gewinner.getBesitzer();
                    System.out.println("Stich Gewinner : " + Gewinner.Name);
                }
            }
            Stich.clear();
            for (Karten karte : Stich) {
                if (karte instanceof Plus5) {
                    Gewinner.Punkte += 5;
                    System.out.println("Plus 5 Karte gespielt. " + Gewinner.Name + " erhält 5 Punkte.");
                } else if (karte instanceof Minus5) {
                    Gewinner.Punkte -= 5;
                    System.out.println("Minus 5 Karte gespielt. " + Gewinner.Name + " verliert 5 Punkte.");
                }
            }
            return Gewinner;
        }
    

    public void ClearScreen() {
        System.out.println("Drücke Enter, um fortzufahren...");
            scanner.nextLine(); // Warten auf Enter-Taste
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    public void display_score(){
        for (Spieler spieler : Spieler_Liste) {
            System.out.println(spieler.Name + " hat " + spieler.Punkte + " Punkte");
        }
    }

    public static void main(String[] args) {
        new Spiel();
}
}



