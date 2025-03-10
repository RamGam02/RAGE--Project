# RAGE--Project
This is our project for our programming class


TO DO LISTE:

Spezial Karten Implementieren 
    Karten erstellung
    Auswertung von Stichen+


GUI
    Model Karten?
    welches Model




Input Spieler anzahl (hopefully fixed no test)
Spwzial karten beim auspeilen (done no test)
besitzer bei karten hinzufügen (done no test) 
beim erstellen der Spezial karten haben die alle den gleichen namen (muss das so )
else if (kartenTyp.equals("Joker")) {
while (true) {
                        System.out.println("Willst du diesen Stich gewinnen? y/n");
                        String input = scanner.nextLine();
                        if (input.equals("y")) {
                            karteZuLegen.ausfuehren(true, spiel1.getTrumpf(), !spiel1.Stich.isEmpty() ? spiel1.Stich.get(0).getFarbe() : null);
                            break;
                        } else if (input.equals("n")) {
                            karteZuLegen.ausfuehren(false,spiel1.getTrumpf(),!spiel1.Stich.isEmpty() ? spiel1.Stich.get(0).getFarbe() : null);
                            break;
                        } else {
                            System.out.println("Falsche Eingabe");
                        }
                    }

                    
                    
                } 