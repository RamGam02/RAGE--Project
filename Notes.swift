// Spieler geben ihre Stichwette ab
            //  >=0 Stiche sind auch valide
            // Erster Ausspieler ist random (Bei folgenden Runden weiter nach links verschoben)
            // Weiteres Ausspielen vom Spieler der den letzten Stich gemacht hat

            // Ansagen werden notiert/angezeigt
            // 2 Kartenstapel
                //  >Ziehstapel (alle Karten)
                //  >Ablagestapel (Jeder Spieler einen)

            // Spielrichtung ist im Uhrzeigersinn

            // Es gilt Farbzwang, nur bei nicht besitzen der Farbe andere Karte gestattet
            // Man kann abwerchen, solange der Farbzwang nicht verletzt wird
            // Kein Trumpfzwang, 
            //  >solange man noch andere Karten außer Trumpf besitzt, muss auch nicht mit Trumpf gestochen werden

            // Den Stich gewinnt die höchste Karte in der aktuellen Trumpffarbe
            //  >Liegt kein Trumpf im Stich, gewinnt die höchste Karte in der zuerst gespielten Farbe
            // Gewonne Stiche kommen auf den Ablagestapel des Siegers
            // Spieler geben ihre Stichwette ab
            //  >0 Stiche sind auch valide
            // Bei Ende der Runde Punkteabrechnung
            //  >Richtige Wette +10 Punkte
            //  >Falsche Wette -5 Punkte
            //  >Jeder Stich +1 Punkt
            //  >Aktionskarte in Ablagestapel (+5 Punkte/-5 Punkte)

            // Alle Karten werden erneut gemischt
            // Jeder Spieler erhält eine Karte weniger als in der Vorrunde

            // Erstellen von Karten für die nächste Runde