import java.util.Scanner;
import java.util.Random;
import ch.hslu.prg.leds.proxy.LedService;
import ch.hslu.prg.leds.proxy.LedColor;

public class G02 {

    // Methode Main mit Aufrufen
    public static void main(String[] args) {
        //G02.ledsOnOff();
        //G02.switchEvenOdd();
        //G02.switchRandom();
        //G02.showBinary();
        //G02.showBorder();
        //G02.showSquare();
        //G02.showRectangle();
        //G02.showTriangle();
        //G02.siebDesEratosthenes();
        //Aufruf Aufgabe 10.1
        G02.countColors();
        //Aufruf Aufgabe 10.2
        G02.countColorsExt();
        G02.rowAndNumberChecker(LedColor.RED);
        G02.rowAndNumberChecker(LedColor.GREEN);
        G02.rowAndNumberChecker(LedColor.BLUE);
        G02.rowAndNumberChecker(LedColor.YELLOW);

    }

    private static void ledsOnOff() {

        // Aufgabe 1.1
        LedService service = new LedService();

        // 1) Anzahl LED einlesen und Zahlenbereich prüfen
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben Sie die Anzahl der zu erstellenden LEDs ein (1-256): ");
        int anzahlLeds = sc.nextInt();
        while (anzahlLeds > LedService.MAX_NUMBER_OF_LEDS || anzahlLeds <= 0) {
            System.out.println("Die Zahl ist nicht möglich. Bitte geben Sie erneut eine Zahl zwischen 1 und 256 ein: ");
            anzahlLeds = sc.nextInt();
        }

        // Aufgabe 1.2
        //		ClientAppAll.readLedColor();
        // 2) LEDs dem Steckboard hinzufügen mit Methode LedService()
        service.addLeds(anzahlLeds);

        // 3) Ausführung der Methode ledOnOff für 2 Sekunden anhalten
        service.stopExecutionFor(2000);

        // 8) Schritte 4, 5, 6, und 7 drei Mal durchführen
        for (int j = 0; j < 3; j++) {

            // 4) LEDs von rechts nach links verzögert einschalten
            for (int i = 0; i < anzahlLeds; i++) {
                service.turnLedOn(i);
                service.stopExecutionFor(300);
            }

            // 5) Ausführung der Methode ledOnOff für 250 Millisekunden anhalten
            service.stopExecutionFor(250);

            // 6) LEDs in umgekehrter Reihenfolge (rechts nach links) ausschalten
            for (int i = anzahlLeds - 1; i >= 0; i--) {
                service.turnLedOff(i);
                service.stopExecutionFor(300);
            }

            // 7) Ausführung der Methode ledOnOff für 250 Millisekunden anhalten
            service.stopExecutionFor(250);
        }

        // 9) Ausführung der Methode ledsOnOff für 2 Sekunden anhalten
        service.stopExecutionFor(2000);

        // 10) Anzeige zurücksetzen
        service.reset();
    }


    // Aufgabe 2
    private static void switchEvenOdd() {
        LedService service = new LedService();
        // 1) Anzahl LEDs über Tastatur einlesen. Muss ein Vielfaches von 16 sein
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben Sie die Anzahl der zu erstellenden LEDs ein (1-256). Die Zahl sollte ein Vielfaches von 16 sein: ");
        int anzahlLeds = sc.nextInt();

        while (anzahlLeds > LedService.MAX_NUMBER_OF_LEDS || anzahlLeds <= 0 || anzahlLeds % 16 != 0) {
            System.out.println("Die Zahl ist nicht möglich. Bitte geben Sie erneut eine Zahl zwischen 1 und 256 ein, die durch 16 teilbar ist: ");
            anzahlLeds = sc.nextInt();
        }

        // 2.1) Gewünschte Anzahl LEDs dem Steckboard hinzufuegen
        service.addLeds(anzahlLeds, LedColor.BLUE);

        // 2.2) Ausfuehrung der Methode switchEvenOdd fuer 2 Sekunden anhalten
        service.stopExecutionFor(2000);

        // 8) Schritte 3, 4, 5, 6, und 7 insgesamt 3 Mal wiederholen
        for (int j = 0; j < 3; j++) {

            // 3) Nur Lampen mit gerader Zahl einschalten
            for (int i = 0; i < anzahlLeds; i++) {
                if (i % 2 == 0) {
                    service.turnLedOn(i);
                } else continue;
            }

            // 4) Ausfuehrung der Methode switchEvenodd fuer 1 Sekunde anhalten
            service.stopExecutionFor(1000);

            // 5) Umschalten
            for (int i = 0; i < anzahlLeds; i++) {
                if (service.isOn(i) == true) {
                    service.turnLedOff(i);
                    service.stopExecutionFor(10);
                } else {
                    service.turnLedOn(i);
                    service.stopExecutionFor(10);
                }
            }

            // 6) Ausfuehrung der Methode switchEvenOdd fuer 1 Sekunde anhalten
            service.stopExecutionFor(1000);

            // 7.1) Alle LEDs ausschalten
            for (int i = 0; i < anzahlLeds; i++) {
                if (service.isOn(i) == true) {
                    service.turnLedOff(i);
                } else continue;
            }

            // 7.2) Ausfuehrung der Methode switchEvenOdd fuer 1 Sekunde anhalten
            service.stopExecutionFor(1000);
        }
        // 9) Anzeige zurücksetzen
        service.reset();
    }

    // Aufgabe 3
    public static void switchRandom () {

        // 3.1.1
        Scanner sc = new Scanner (System.in);
        System.out.print("Geben Sie die Anzahl Leds ein: ");
        int anzahlLeds = sc.nextInt();
        while (anzahlLeds > LedService.MAX_NUMBER_OF_LEDS || anzahlLeds <= 0 || anzahlLeds % 16 != 0) {
            System.out.println("Die Zahl ist nicht möglich. Bitte geben Sie erneut eine Zahl zwischen 1 und 256 ein, die durch 16 teilbar ist: ");
            anzahlLeds = sc.nextInt();
        }

        // 3.1.2
        LedService service = new LedService();
        Random random = new Random ();

        service.addLeds(anzahlLeds);
        service.stopExecutionFor(2000);

        //3.1.8
        for (int k = 0; k < 3; k++) {

            //3.1.3
            int [] randomZahl = new int [anzahlLeds / 2];
            for (int i = 0; i < randomZahl.length; i++ ) {
                randomZahl[i] = random.nextInt(anzahlLeds);
            }

            for (int i : randomZahl) {
                service.turnLedOn(i);
                service.stopExecutionFor(10);
            }

            //3.1.4
            service.stopExecutionFor(1000);

            //3.1.5
            for (int h = 0; h < anzahlLeds; h++) {
                if (service.isOn(h)) {
                    service.turnLedOff(h);
                    service.stopExecutionFor(10);
                } else {
                    service.turnLedOn(h);
                    service.stopExecutionFor(10);
                }
            }

            //3.1.6
            service.stopExecutionFor(1000);

            //3.1.7
            for (int i=0; i < anzahlLeds; i++) {
                service.turnLedOff(i);
            }
            service.stopExecutionFor(1000);
        }


        // 3.1.9
        service.reset();

    }

    // Aufgabe 4
    public static void showBinary() {

        //4.1.1
        Scanner sc = new Scanner (System.in);
        System.out.println("Bitte geben Sie eine postive ganze Zahl ein: ");

        //Variablen
        int zahl = sc.nextInt();
        while (zahl < 0) {
            System.out.println("Die Zahl ist nicht möglich. Bitte geben Sie erneut eine Zahl zwischen 1 und 256 ein, die durch 16 teilbar ist: ");
            zahl = sc.nextInt();
        }

        String binaryString;
        LedService service = new LedService();
        StringBuilder sb = new StringBuilder ();

        //4.1.3
        // Zahl in Binaerzahl umwandeln
        binaryString = Integer.toBinaryString(zahl);
        // Länge der Binaerzahl auslesen
        service.addLeds(binaryString.length());

        char positionString;
        // Werte von binaryString wird in Instanz sb abgelegt
        sb.append(binaryString);
        // Werte der Instanz sb werden gespiegelt
        sb = sb.reverse();

        for (int i = 0; i < sb.length(); i++) {
            positionString = sb.charAt(i);
            if (positionString == '1') {
                service.turnLedOn(i);
            }
        }
        service.stopExecutionFor(5000);

    }

    // Aufgabe 5
    // Aufgabe 5.2) Methode zur Wahl der Farbe
    private static void readLedColor() {
        // Message ausgeben, dass Farbe Rot, Grün, Blau, Gelb und "Random" gewählt werden kann.
        System.out.println("Wählen sie die Farbe des Led. \n 1 für Rot \n 2 für Grün \n 3 für Blau \n 4 für Gelb \n 5 für Zufällig");
        Scanner sc = new Scanner(System.in);
        int zahlFarbe = sc.nextInt();

        // maximale Anzahl LEDs hinzufügen
        LedService service = new LedService();

        if (zahlFarbe == 1) {
            service.addLeds(LedService.MAX_NUMBER_OF_LEDS, LedColor.RED);
        } else if (zahlFarbe == 2) {
            service.addLeds(LedService.MAX_NUMBER_OF_LEDS, LedColor.GREEN);
        } else if (zahlFarbe == 3) {
            service.addLeds(LedService.MAX_NUMBER_OF_LEDS, LedColor.BLUE);
        } else if (zahlFarbe == 4) {
            service.addLeds(LedService.MAX_NUMBER_OF_LEDS, LedColor.YELLOW);
        } else if (zahlFarbe == 5) {
            service.addLeds(LedService.MAX_NUMBER_OF_LEDS, LedColor.RANDOM);
        } else {
            System.out.println("Falsche Eingabe");
        }
    }

    // Aufgabe 5.1) Hauptmethode
    public static void showBorder() {
        LedService service = new LedService();
        readLedColor();

        // 2 Sekunden anhalten
        service.stopExecutionFor(2000);

        // Schleife zum einschalten aller Lampen am Rand
        service.setDelayInMillis(20);
        for (int i = 0; i < LedService.MAX_NUMBER_OF_LEDS; i++) {
            if (i < 16) {
                service.turnLedOn(i);
            } else if ((i) % 16 == 0) {
                service.turnLedOn(i);
            } else if ((i + 1) % 16 == 0) {
                service.turnLedOn(i);
            } else if (i > 240) {
                service.turnLedOn(i);
            } else
                continue;
        }

        // Anhalten für 5 Sekunden
        service.stopExecutionFor(5000);

        // Alle Lampen ausschalten
        for (int i = 0; i < LedService.MAX_NUMBER_OF_LEDS; i++) {
            service.turnLedOff(i);
        }

        // Anhalten für 2 Sekunden
        service.stopExecutionFor(2000);

        // Anzeige zurücksetzen
        service.reset();
    }

    // Aufgabe 6

    public static void showSquare() {

        // maximale Anzahl LEDs hinzufügen
        LedService service = new LedService();
        service.addLeds(LedService.MAX_NUMBER_OF_LEDS);

        // Led der linken obere Ecke Einlesen
        System.out.println("lesen sie das LED ein, das die linke obere Ecke darstellt.");
        Scanner sc = new Scanner(System.in);
        int ledTopLeft = sc.nextInt();

        // Ist die Eingabe korrekt?
        while (ledTopLeft > 256) {
            System.out.println("Die Zahl ist zu gross. Bitte geben Sie erneut eine Zahl ein");
            ledTopLeft = sc.nextInt();
        }
        while (ledTopLeft <= 0) {
            System.out.println("Zu klein");
            ledTopLeft = sc.nextInt();
        }

        // Led linke obere Ecke einschalten
        service.turnLedOn(ledTopLeft);

        // Länge der Seite des Quadrats in der Tastatur einlesen
        System.out.println("lesen sie die länge der Seite des Quadrats ein.");

        // Länge des Quadrats einlesen
        int laengeQuadrat = sc.nextInt();

        // Ist die Eingabe kleiner als 16?
        // Ist der Abstand von rechten Rand zu Lampe grösser als Eingabe?
        //Ist der Abstand vom unteren Rand zu Lampe grösser als Eingabe?
        while (laengeQuadrat > LedService.MAX_COLUMNS || laengeQuadrat >= ledTopLeft % 16 || ledTopLeft < ((laengeQuadrat - 1) * 16)){
            System.out.println("Die Zahl ist zu gross. Bitte geben Sie erneut eine Zahl ein.");
            laengeQuadrat = sc.nextInt();
        }

        while (laengeQuadrat <= 0) {
            System.out.println("Zu klein");
            laengeQuadrat = sc.nextInt();
        }

        //Variablen definieren
        int ledTopRight = ledTopLeft - laengeQuadrat + 1;
        int ledBottomRight = ledTopRight - (laengeQuadrat-1)*16;
        int ledBottomLeft = ledBottomRight + (laengeQuadrat-1);

        // Schleife zum Einschalten der Lampen
        // Linke obere Ecke nach rechte obere Ecke
        for (int i = ledTopLeft; i > ledTopRight; i--) {
            service.turnLedOn(i);
        }

        // Rechte obere Ecke nach rechte untere Ecke
        int i = ledTopRight;
        while (i > ledBottomRight) {
            service.turnLedOn(i);
            i = i - 16;
        }
        // Rechte untere Ecke nach linke untere Ecke
        for (i = ledBottomRight; i <= ledBottomLeft; i++) {
            service.turnLedOn(i);
        }
        // Linke untere Ecke nach linke obere Ecke
        int j = ledBottomLeft;
        while (j < ledTopLeft) {
            service.turnLedOn(j);
            j = j + 16;
        }

        // Anhalten für 5 Sekunden
        service.stopExecutionFor(5000);

        // Anzeige zurücksetzen
        service.reset();
    }

    // Aufgabe 7 (Rechteck anhand von zwei definierten Punkten anzeigen lassen)
    public static void showRectangle() {

        // maximale mögliche Anzahl LEDs hinzufügen
        LedService ledServ = new LedService();

        ledServ.addLeds(LedService.MAX_NUMBER_OF_LEDS);

        // Nummer LED “topLeft“ einlesen
        Scanner sc = new Scanner(System.in);
        System.out.print("Bitte eine ganze Zahl für TopLeft eingeben: ");
        int topLeft = sc.nextInt();

        // Nummer LED bottomRight einlesen
        System.out.print("Bitte eine ganze Zahl für BottomRight eingeben: ");
        int bottomRight = sc.nextInt();

        // Spalte von topLeft herausfinden
        int anzahlSpalten = LedService.MAX_COLUMNS;
        int linkeSpalte = topLeft % anzahlSpalten;
        // Spalte von bottomRight herausfinden
        int rechteSpalte = bottomRight % anzahlSpalten;
        // Breite des Rechtecks berechnen
        int breiteRechteck = linkeSpalte - rechteSpalte + 1;

        // Rechteck aufzeichnen und alle LED vom Rechteck einschalten
        int topLeftAussen = topLeft;

        while (topLeftAussen > bottomRight) {
            for (int i = topLeftAussen; i >= topLeftAussen - breiteRechteck + 1; i--) {
                ledServ.turnLedOn(i);
                ledServ.setDelayInMillis(50);
            }
            topLeftAussen = topLeftAussen - anzahlSpalten;
            continue;
        }

        // Ausführung für 3 Sekunden anhalten
        ledServ.stopExecutionFor(3000);

        // Alle LEDs im Innern des Rechtecks ausschalten (gibt einen Rahmen/Kontur)
        int topLeftInnen = topLeft - anzahlSpalten - 1;
        int bottomRightInnen = bottomRight + anzahlSpalten + 1;

        while (topLeftInnen >= bottomRightInnen) {
            for (int i = topLeftInnen; i >= topLeftInnen - breiteRechteck + 3; i--) {
                ledServ.turnLedOff(i);
                ledServ.setDelayInMillis(50);
            }
            topLeftInnen = topLeftInnen - anzahlSpalten;
            continue;
        }

        // Ausführung für 3 Sekunden anhalten
        ledServ.stopExecutionFor(3000);

        // Anzeige zurücksetzen
        ledServ.reset();
    }

    // Aufgabe 8 (Dreieck anhand von max. Hoehe generieren lassen)
    public static void showTriangle() {

        // Hoehe des Dreicks einlesen, inkl. Kontrolle
        Scanner sc = new Scanner(System.in);
        System.out.print("Bitte eine ganze Zahl für die Höhe eingeben: ");
        int heightTriangle = sc.nextInt();

        while (heightTriangle > 8 || heightTriangle <= 2) {
            System.out.println("Das Dreieck kann nicht gezeichnet werden. Bitte neu eingeben.");
            System.out.print("Bitte eine ganze Zahl für die Höhe eingeben: ");
            heightTriangle = sc.nextInt();
        }

        // LEDs auf dem Steckbord hinzufuegen (Anzahl Spalten * Hoehe)
        LedService ledServ = new LedService();
        int anzahlSpalten = ledServ.MAX_COLUMNS;
        int anzahlLeds = heightTriangle * anzahlSpalten;
        ledServ.addLeds(anzahlLeds);

        // Dreieck aufzeichnen
        int startLed = anzahlSpalten - 1;
        int x = 0;

        for (int i = 0; i < 2 * heightTriangle - 1; i++) {
            ledServ.turnLedOn(startLed - i);
            ledServ.setDelayInMillis(50);
            int j = startLed - i;

            if (i < heightTriangle && i != 0) {

                while (j <= startLed - i + i * anzahlSpalten) {
                    ledServ.turnLedOn(j);
                    ledServ.setDelayInMillis(50);
                    j = j + anzahlSpalten;
                }
            } else if (i >= heightTriangle) {

                x = x + 1;
                int k = heightTriangle - x;

                while (j < startLed - i + (heightTriangle - x) * anzahlSpalten) {
                    ledServ.turnLedOn(j);
                    ledServ.setDelayInMillis(50);
                    j = j + anzahlSpalten;
                }
            } else {
                continue;
            }
        }

        // Ausführung für 5 Sekunden anhalten
        ledServ.stopExecutionFor(5000);

        // Anzeige zurücksetzen
        ledServ.reset();

    }

    // Aufgabe 9
    public static void siebDesEratosthenes() {

        // maximale Anzahl LEDs hinzufügen
        LedService service = new LedService();
        service.addLeds(LedService.MAX_NUMBER_OF_LEDS);

        //Alle LEDs einschalten
        for (int i = 0; i < LedService.MAX_NUMBER_OF_LEDS; i++) {
            service.turnLedOn(i);
            service.stopExecutionFor(20);
        }

        //LEDs die durch 2 Teilbar sind ausschalten / Wir starten ab der Zahl 2
        for (int i = 0; i < LedService.MAX_NUMBER_OF_LEDS; i++) {
            // 0 und 1 ausschalten)
            for ( ; i < 2; i++) {
                service.turnLedOff(i);
                service.stopExecutionFor(20);
            }
            // 2 eingeschaltet lassen
            if (i == 2) {
                i++;
            }
            // Alle durch 2 teilbare Zahlen ausschalten
            if (i % 2 == 0) {
                service.turnLedOff(i);
                service.stopExecutionFor(20);
            }
        }
        int ersteEingeschalteteLed = 0;
        //1. eingeschaltetes LED wird gesucht und ausgegeben
        for (int i = 2; i < LedService.MAX_NUMBER_OF_LEDS; i ++) {
            if (service.isOn(i) == true) {
                System.out.println(i);
                ersteEingeschalteteLed = i;
                // LEDs ausschalten, deren Nummer (j) ein Vielfaches dieser Nummer (i) ist.
                for (int j = ersteEingeschalteteLed + 1; j < LedService.MAX_NUMBER_OF_LEDS; j++) {
                    if (j % i == 0) {
                        service.turnLedOff(j);
                        service.stopExecutionFor(20);
                    }
                }
            }
        }

        // Vortsetzung für 1 Sekunde unterbrechen
        service.stopExecutionFor(1000);

        service.reset();
    }


    /*
     * Fragen zur API-Dokumentation: 1. Mit welcher Methode können LEDs dem
     * Steckboard hinzugefügt werden, wobei die LED Farbe explizit angegeben werden
     * kann?
     *
     * public void addLeds(int anzahl, LedColor ledColor) (Fügt die angegebene
     * Anzahl von LEDs mit der spezifizierten Farbe dem Steckboard hinzu.)
     *
     *
     * 2. Mit welcher Methode kann die Farbe eines beliebigen LEDs abgefragt werden?
     * Was liefert diese Methode zurück?
     *
     * public LedColor color(int ledNumber) Liefert die Farbe des LEDs für die
     * spezifizierte LED Nummer zurück.
     *
     */

    // Aufgabe 10.1
    public static void countColors() {

        // max. Anzahl LEDs dem Steckbord hinzufügen
        LedService ledServ = new LedService();
        int maxAnzahlLeds = ledServ.MAX_NUMBER_OF_LEDS;
        LedColor ledrandom = LedColor.RANDOM;

        ledServ.addLeds(maxAnzahlLeds, ledrandom);

        // Alle LEDs einschalten
        for (int i = 0; i < maxAnzahlLeds; i++) {
            ledServ.turnLedOn(i);
            ledServ.setDelayInMillis(20);
        }

        // Ausführung für zwei Sekunden anhalten
        ledServ.stopExecutionFor(2000);

        // Anzahl LEDs der jeweiligen LED Farbe bestimmen
        int red = 0;
        int blue = 0;
        int green = 0;
        int yellow = 0;

        for (int i = 0; i < maxAnzahlLeds; i++) {

            if (ledServ.color(i) == LedColor.RED) {
                red = ++red;
            } else if (ledServ.color(i) == LedColor.BLUE) {
                blue = ++blue;
            } else if (ledServ.color(i) == LedColor.GREEN) {
                green = ++green;
            } else {
                yellow = ++yellow;
            }

        }

        // Ausgabe auf Bildschirm
        System.out.println("» RED:\t\t" + red + " LEDs");
        System.out.println("» BLUE:\t\t" + blue + " LEDs");
        System.out.println("» GREEN:\t" + green + " LEDs");
        System.out.println("» YELLOW:\t" + yellow + " LEDs");

    }

    // Aufgabe 10.2
    public static void countColorsExt() {

        LedService ledServ = new LedService();
        int maxAnzahlLeds = ledServ.MAX_NUMBER_OF_LEDS;
        LedColor ledrandom = LedColor.RANDOM;

        ledServ.addLeds(maxAnzahlLeds, ledrandom);

        for (int i = 0; i < maxAnzahlLeds; i++) {
            ledServ.turnLedOn(i);
            ledServ.setDelayInMillis(20);
        }

        ledServ.stopExecutionFor(2000);

    }

    public static void rowAndNumberChecker (Enum LedColor) {

        LedService ledServ = new LedService();

        int maxAnzahlLeds = ledServ.MAX_NUMBER_OF_LEDS;
        int meisteAnzahl = 0;
        int vergleich = 0;
        int row = 0;

        for (int i = 16; i < i + 16 && i <= maxAnzahlLeds; i += 16) {

            for (int j = i - 16; j < i; j++) {

                if (ledServ.color(j) == LedColor) {
                    vergleich = ++vergleich;
                } else {
                    continue;
                }

                if (vergleich >= meisteAnzahl) {
                    meisteAnzahl = vergleich;
                    row = i % 15;
                } else {
                    continue;
                }

            }

            vergleich = 0;
        }

        System.out.println("» "+LedColor+": " + meisteAnzahl + " LEDs in der Zeile-Nr. " + row);

    }
}



