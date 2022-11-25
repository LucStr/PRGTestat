import java.util.Random;
import java.util.Scanner;
import ch.hslu.prg.leds.proxy.LedColor;
import ch.hslu.prg.leds.proxy.LedService;

/*
 * Gruppenarbeit der Gruppe 15 BSCWI_HS_2022@HSLU_Rotkreuz
 *
 * Teilnehmer:
 * Ruben Thalmann
 * Sandro Troxler
 * Edwin Goustov
 *
 */
public class G15 {
    public static void main(String[] args) {
        /* Teilaufgabe1.1 & 1.2 ausgeben */
        G15.ledsOnOff();
        /* Teilaufgabe 2.1 & 2.2 ausgeben */
        G15.SwtichEvendOdd();
        /* Teilaufgabe 3.1 & 3.2 ausgeben */
        G15.switchRandom();
        /* Teilaufgabe 4.1 & 4.2 ausgeben */
        G15.showBinary();
        /* Teilaufgabe 5.1 & 5.2 ausgeben */
        G15.showBorder();
        /* Teilaufgabe 6.1 & 6.2 ausgeben */
        G15.topLeft();
        /* Aufgabe 7 ausgeben */
        G15.showRectangle();
        /*Aufgabe 8.1 ausgeben */
        G15.showTriangle();
        /* Aufgabe 9 ausgeben */
        G15.siebDesErasthenes();
        /* Teilaufgabe 10.1 ausgeben */
        G15.countColors();
        /* Teilaufgabe 10.2 ausgeben */
        G15.countColorsExt();
    }

    /* Private Variabeln definieren */
    private static int eingeleseneLeds = 0;
    private static int gesteckteLeds;
    private static int berechneteLeds = 2;
    private static int fancyNumber;
    private static int i;
    private static int j;
    private static int k;
    private static int l;
    private static int eingeleseneFarbe;
    private static int hoehe;
    private static int breite = 2;
    private static int hypothenuse;
    private static int topLeft;
    private static int bottomRight;
    private static int quotient;
    private static int remainder;
    private static Long digit;
    private static Long temp;
    private static int red;
    private static int green;
    private static int blue;
    private static int yellow;

    /* Setter Methoden definieren */
    public void setEingeleseneLeds(int eingeleseneLeds) {
        G15.eingeleseneLeds = eingeleseneLeds;
    }

    public void setGesteckteLeds(int gesteckteLeds) {
        G15.gesteckteLeds = gesteckteLeds;
    }

    public void setBerechneteLeds(int berechneteLeds) {
        G15.berechneteLeds = berechneteLeds;
    }

    public void setFancyNumber(int fancyNumber) {
        G15.fancyNumber = fancyNumber;
    }

    public void setI(int i) {
        G15.i = i;
    }

    public void setJ(int j) {
        G15.j = j;
    }

    public void setK(int k) {
        G15.k = k;
    }

    public void setL(int l) {
        G15.l = l;
    }

    public void setEingeleseneFarbe(int eingeleseneFarbe) {
        G15.eingeleseneFarbe = eingeleseneFarbe;
    }

    public void setHoehe(int hoehe) {
        G15.hoehe = hoehe;
    }

    public void setBreite(int breite) {
        G15.breite = breite;
    }

    public void setHypothenuse(int hypothenuse) {
        G15.hypothenuse = hypothenuse;
    }

    public void setTopLeft(int topLeft) {
        G15.topLeft = topLeft;
    }

    public void setBottomRight(int bottomRight) {
        G15.bottomRight = bottomRight;
    }

    public void setQuotient(int quotient){
        G15.quotient = quotient;
    }

    public void setRemainder(int remainder) {
        G15.remainder = remainder;
    }

    public void setDigit(Long digit) {
        G15.digit = digit;
    }

    public void setTemp(Long temp) {
        G15.temp = temp;
    }

    public void setRed(int red) {
        G15.red = red;
    }

    public void setGreen(int green) {
        G15.green = green;
    }

    public void setBlue(int blue) {
        G15.blue = blue;
    }

    public void setYellow(int yellow) {
        G15.yellow = yellow;
    }

    /* Getter Methoden definieren */
    public int getEingeleseneLeds() {
        return eingeleseneLeds;
    }

    public int getGesteckteLeds() {
        return gesteckteLeds;
    }

    public int getBerechneteLeds() {
        return berechneteLeds;
    }

    public int getFancyNumber() {
        return fancyNumber;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getK() {
        return k;
    }

    public int getL() {
        return l;
    }
    public int getEingeleseneFarbe() {
        return eingeleseneFarbe;
    }

    public int getHoehe() {
        return hoehe;
    }

    public int getBreite() {
        return breite;
    }

    public int getHypothenuse() {
        return hypothenuse;
    }

    public int getTopLeft() {
        return topLeft;
    }

    public int getBottomRight() {
        return bottomRight;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getRemainder() {
        return remainder;
    }

    public Long getDigit() {
        return digit;
    }

    public Long getTemp() {
        return temp;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getYellow() {
        return yellow;
    }

    /* Aufgabe 1 */
    public static void ledsOnOff() {
        /* Anzahl Lampen einlesen in Loop Funktion falls Bedingungen nicht erfüllt sind */
        while(LedService.MAX_NUMBER_OF_LEDS < eingeleseneLeds || eingeleseneLeds <= 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Geben Sie eine ganze Zahl ein, die kleiner als 257 ist, aber grösser als 0: ");
            eingeleseneLeds = sc.nextInt();
            /* Fehlermeldung Prompten wenn Bedingungen nicht erfüllt sind */
            if (LedService.MAX_NUMBER_OF_LEDS < eingeleseneLeds|| eingeleseneLeds <= 0){
                System.out.println("Die Zahl entspricht nicht dem angegebenen Zahlenraum!");
            }
        }
        /* LED Instanz erstellen und eingegebene anzahl Lampen erstellen */
        LedService lampe = new LedService();
        lampe.addLeds(eingeleseneLeds, LedColor.RANDOM);
        gesteckteLeds = eingeleseneLeds;
        /* Methode für 2 Sekunden anhalten */
        lampe.stopExecutionFor(2000);
        i = 0;
        j = 1;
        /* While Schlaufe fuer mehrfaches ein und ausschalten der Lampen */
        while (j < 4) {
            /*
             * While Schlaufe implementieren fuer Lampen einschalten von der tiefsten
             * Lampen-ID zur hoechsten Lampen-ID
             *
             */
            while (i < gesteckteLeds) {
                lampe.turnLedOn(i);
                lampe.stopExecutionFor(50);
                i++;
            }
            /* Pausieren für 250 Millisekunden bis es weitergeht */
            lampe.stopExecutionFor(250);
            /*
             * While Schlaufe implementieren fuer Lampen ausschalten von der hoechsten
             * Lampen-ID zur tiefsten Lampen-ID
             *
             */
            while (i >= 0) {
                lampe.turnLedOff(i);
                lampe.stopExecutionFor(50);
                i--;
            }
            j++;
        }
        /* Pausieren fuer 2 Sekunden */
        lampe.stopExecutionFor(2000);
        /* Alle Lampen entfernen */
        lampe.removeAllLeds();
    }

    /* Aufgabe 2 */
    public static void SwtichEvendOdd() {
        /* Variabeln definieren */
        i = 0;
        j = 1;
        eingeleseneLeds = 0;
        /* Wert einlesen bis Bedingungen erfuellt sind */
        while(eingeleseneLeds <= 0 || eingeleseneLeds > 16){
            Scanner sc = new Scanner(System.in);
            System.out.println("Geben Sie eine ganze Zahl von 1 bis 16 ein. Diese wird anschliessend mit 16 multipliziert: ");
            eingeleseneLeds = sc.nextInt();
            /* Ueberpruefen ob eingegebene Zahl von 1-16 entspricht */
            if (eingeleseneLeds <= 0 || eingeleseneLeds > 16) {
                System.out.println("Die Zahl entspricht nicht dem angegebenen Zahlenraum!");
            }
        }
        /*
         * Mit Zahl 16 multiplizieren und diese Zahl dann für die Anzahl zu steckende
         * Lampen verwenden.
         *
         */
        berechneteLeds = eingeleseneLeds * 16;
        LedService lampe = new LedService();
        lampe.addLeds(berechneteLeds, LedColor.BLUE);
        lampe.stopExecutionFor(2000);
        /* Schlaufe fuer dreifachen Durchgang */
        while (j < 4) {
            /* Schlaufe fuer gerade Lampen zum Einschalten und ungerade auszuschalten */
            while (i <= berechneteLeds) {
                if (i % 2 == 0) {
                    lampe.turnLedOn(i);
                    lampe.setDelayInMillis(5);
                }
                else {
                    lampe.turnLedOff(i);
                    lampe.setDelayInMillis(5);
                }
                i++;
            }
            lampe.stopExecutionFor(1000);
            /* Schlaufe fuer ungerade Lampen zum Einschalten und gerade auszuschalten */
            while (i >= 0) {
                if (i % 2 == 0) {
                    lampe.turnLedOff(i);
                    lampe.setDelayInMillis(5);
                }
                else {
                    lampe.turnLedOn(i);
                    lampe.setDelayInMillis(5);
                }
                i--;
            }
            lampe.stopExecutionFor(1000);
            j++;
        }
        /* Ausgangszustand erstellen */
        lampe.removeAllLeds();
    }

    /*
     *  Aufgabe 3
     *
     * Da noch weitere Aufgaben mit dem Umgang von Arrays kommen, wird in dieser Aufgabe bewusst auf den Einsatz dieser verzichtet.
     * Die Logik dies ohne Array zu loesen ist deutlich weniger Komplex unserer Erachtens und kann mittels einer einfachen abfrage umgesetzt werden.
     *
     */
    public static void switchRandom() {
        /* Variabeln definieren */
        i = 0;
        eingeleseneLeds = 0;
        /* Wert einlesen bis Bedingungen erfuellt sind. */
        while (eingeleseneLeds <= 0 || eingeleseneLeds > 16){
            Scanner sc = new Scanner(System.in);
            System.out.println("Geben Sie eine ganze Zahl von 1 bis 16 ein. Diese wird anschliessend mit 16 multipliziert: ");
            eingeleseneLeds = sc.nextInt();
            /* Ueberpruefen ob eingegebene Zahl von 1-16 entspricht */
            if (eingeleseneLeds <= 0 || eingeleseneLeds > 16) {
                System.out.println("Die Zahl entspricht nicht dem angegebenen Zahlenraum!");
            }
        }
        /*
         * Mit Zahl 16 multiplizieren und diese Zahl dann für die anzahl zusteckende
         * Lampen verwenden
         *
         */
        berechneteLeds = eingeleseneLeds * 16;
        LedService lampe = new LedService();
        lampe.addLeds(berechneteLeds, LedColor.RANDOM);
        lampe.stopExecutionFor(2000);
        /* Es sollen nur die haelfte der Lichter brennen */
        j = berechneteLeds / 2;
        /* Schlaufe fuer dreifachen Durchgang */
        for (k = 1; k <= 4; k++) {
            i = 0;
            /* Schlaufe fuer zufaellige Lampen einzuschlaten */
            while (j > i) {
                /* Zufallsgenerator waehlt Lampen zum Leuchten aus */
                Random randomNum = new Random();
                fancyNumber = randomNum.nextInt(berechneteLeds);
                if (lampe.isOn(fancyNumber) == false) {
                    lampe.turnLedOn(fancyNumber);
                    i++;
                }
            }
            lampe.stopExecutionFor(1000);
            i = 0;
            /* Schlaufe fuer eingeschaltete auszuschalten und umgekehrt */
            while (i < berechneteLeds) {
                if (lampe.isOn(i) == true) {
                    lampe.turnLedOff(i);
                }
                else {
                    lampe.turnLedOn(i);
                }
                i++;
            }
            lampe.stopExecutionFor(1000);
            i = 0;
            /* Schlaufe um alle Lampen auszuschalten */
            while (i < berechneteLeds) {
                if (lampe.isOn(i) == true) {
                    lampe.turnLedOff(i);
                }
                i++;
            }
            lampe.stopExecutionFor(1000);
        }
        lampe.removeAllLeds();
    }

    /* Aufgabe 4 */
    public static void showBinary() {
        /* Variabel definieren */
        eingeleseneLeds = 0;
        /* Bedingungen setzen fuer maximale Integer Zahl, da Zeichenbeschraenkung von Long bei Binaerer darstellung.*/
        while(eingeleseneLeds <=0 || eingeleseneLeds > 524287) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Geben Sie eine beliebige positive ganze Zahl kleiner als 524'287 ein: ");
            eingeleseneLeds = sc.nextInt();
            if(eingeleseneLeds <=0) {
                System.out.println("Sie haben keine positive ganze Zahl eingegeben");
            }
            if(eingeleseneLeds > 524287) {
                System.out.println("Diese Zahl ist leider nicht mehr handelbar mit dem Long-Datentyp als Binär-Zahl!");
            }
        }
        /* Binaereumrechnung aufrufen */
        G15.binaryString();
        /* Anzahl Steckplaetze berechnen */
        gesteckteLeds = (int) (Math.log10(binaryString()) + 1);
        /* Anzahl Lampen auf 8 erhoehen je Zahl in Binaerer Sicht */
        while (gesteckteLeds % 8 > 0) {
            gesteckteLeds++;
        }
        /* Lampen erstellen und hinzufuegen */
        LedService lampe = new LedService();
        lampe.addLeds(gesteckteLeds);
        /* Variabeln definieren */
        i = 0;
        digit = binaryString();
        temp = digit;
        /* Schlaufe fuer Lampen einschalten erstellen */
        while (i <= gesteckteLeds) {
            digit = temp % 10;
            if (digit == 1) {
                lampe.turnLedOn(i);
            }
            temp = temp / 10;
            i++;
        }
        lampe.stopExecutionFor(2000);
        lampe.removeAllLeds();
    }

    /* Unteraufgabe 2 der Teilaufgabe 4.1 */
    public static Long binaryString() {
        /* String erstellen */
        StringBuilder binaryNumber = new StringBuilder();
        quotient = eingeleseneLeds;
        /* Schlaufe fuer Binaerrechnung und berechnete Zahl in String hinzufuegen */
        while (quotient > 0) {
            remainder = quotient % 2;
            binaryNumber.append(remainder);
            quotient /= 2;
        }
        /* String umdrehen um binaere Leseart zu erhalten */
        binaryNumber = binaryNumber.reverse();
        /* String zu Long konventieren */
        return Long.valueOf(binaryNumber.toString());
    }

    /* Aufgabe 5 */
    public static void showBorder() {
        LedService lampe = new LedService();
        lampe.addLeds(LedService.MAX_NUMBER_OF_LEDS, readColor());
        /*
         * Da verschachtelte Schlaufe gewuenscht wurde, wurde dies mittels einer for und einer while Schlaufe umgesetzt.
         * Die for-Schlaufe ist allerdings unnoetiger Stuff, da nicht wie im Video die linke und rechte Seite gleichzeitig hochgezogen wird.
         * Sondern dies im Uhrzeigersinn eingeschaltet wird aus aestehtischen Gruenden.
         * Entsprechend verschachtelte Schlaufenvorgabe eingehalten, wenn auch in einem ineffizienten Verfahren.
         *
         */
        for (j = 0; j <= 1; j++) {
            i = 0;
            /* Schlaufe fuer unterste Border-Linie */
            while (i < 16) {
                if(j == 0) {
                    lampe.turnLedOn(i);
                }
                else {
                    lampe.turnLedOff(i);
                }
                lampe.stopExecutionFor(25);
                i++;
            }
            /* Korrektur von i */
            i--;
            /* Schlaufe fuer linke Border-Linie */
            while (i <= 255) {
                if(j==0) {
                    lampe.turnLedOn(i);
                }
                else {
                    lampe.turnLedOff(i);
                }
                lampe.stopExecutionFor(25);
                i = i + 16;
            }
            /* Korrektur von i */
            i= i-16;
            /* Schlaufe fuer oberste Border-Linie */
            while (i > 240) {
                if(j==0) {
                    lampe.turnLedOn(i);
                } else {
                    lampe.turnLedOff(i);
                }
                lampe.stopExecutionFor(25);
                i--;
            }
            /* Schlaufe fuer rechte Border-Linie */
            while (i >= 0) {
                if(j==0) {
                    lampe.turnLedOn(i);
                } else {
                    lampe.turnLedOff(i);
                }
                lampe.stopExecutionFor(25);
                i = i - 16;
            }
            lampe.stopExecutionFor(2000);
        }
        lampe.removeAllLeds();
    }
    /* Methode fuer Farbenwahl von Aufgabe 5 */
    private static LedColor readColor() {
        /* Abfrage fuer Border-Frage mit Default Value, falls der Benutzer keine Lust hat die Frage zu beantworten*/
        System.out.println(
                "Waehlen Sie ihre Farbe aus! \nFuer GRUEN die 1, ROT die 2, GELB die 3, BLAU die 4 und ZUFAELLIG die 5:");
        Scanner sc = new Scanner(System.in);
        eingeleseneFarbe = sc.nextInt();
        /* Variable definieren*/
        LedColor color = null;
        /*Switch Case fuer Farbenwahl anhand eingabe. Alternative waere else if*/
        switch (eingeleseneFarbe) {
            case 1:
                color = LedColor.GREEN;
                break;
            case 2:
                color = LedColor.RED;
                break;
            case 3:
                color = LedColor.YELLOW;
                break;
            case 4:
                color = LedColor.BLUE;
                break;
            case 5:
                color = LedColor.RANDOM;
                break;
            default:
                System.out.println(
                        "Sie haben keine der vordefinierten Farben eingegeben, es wird nun mit der Default-Farbe weitergearbeitet!");
                color = LedColor.RED;
        }
        return color;
    }

    /* Aufgabe 6 */
    public static void topLeft() {
        LedService lampe = new LedService();
        lampe.addLeds(LedService.MAX_NUMBER_OF_LEDS);
        /* Variabeln definieren */
        topLeft = 0;
        breite = 0;
        /* Loop bedingung definieren, falls der Benutzer nicht faehig ist korrkete Eingaben zu machen */
        while (topLeft%16 + 1< breite || topLeft / 16 +1< breite || breite < 1 || breite > 16) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Geben Sie anhand des Steckboardes den TopLeft Corner ein: ");
            topLeft = sc.nextInt();
            System.out.println("Geben Sie die Seitenlänge des Quadrates ein:");
            breite = sc.nextInt();
            /* Eingaben ueberpruefen und sonst ausgeben, dass Eingaben nicht korrekt sind */
            if(topLeft%16 +1 < breite || topLeft/16 +1< breite || breite < 1 || breite > 16) {
                System.out.println("Versuchen Sie es erneut! \nDas Quadrat muss innherhalb des Steckboardes zu liegen kommen und kann nicht ueber den Rand hinaus gezeichnet werden!");
            }
        }
        /* Diagonale berechnen */
        hypothenuse = breite - 2;
        /* Schlaufe fuer oberster Border */
        for (i = 1; i < breite ; i++) {
            lampe.turnLedOn(topLeft);
            topLeft--;
        }
        /* Schlaufe fuer rechten Border */
        for (i = 1; i< breite; i++) {
            lampe.turnLedOn(topLeft);
            topLeft = topLeft-16;
        }
        /* Schlaufe fuer untersten Border */
        for (i= 1; i < breite; i++) {

            lampe.turnLedOn(topLeft);
            topLeft++;
        }
        /* Schlaufe fuer linken Border */
        for (i = 1; i < breite; i++) {
            lampe.turnLedOn(topLeft);
            topLeft = topLeft+16;
        }
        /* Schlaufe fuer Diagonale oben links bis unten rechts */
        for (i = 1; i<= hypothenuse; i++) {
            topLeft = topLeft -17;
            lampe.turnLedOn(topLeft);
        }
        /* Korrektur fuer neue Startposition */
        topLeft = topLeft + 16 * (breite -3);
        /* Schlaufe fuer Diagonale oben rechts bis unten links */
        for (i = 1; i<= hypothenuse; i++) {
            lampe.turnLedOn(topLeft);
            topLeft = topLeft -15;
        }
        lampe.stopExecutionFor(5000);
        lampe.removeAllLeds();
    }
    /* Aufgabe 7 */
    public static void showRectangle() {
        /* Variabeln definieren */
        topLeft = 0;
        bottomRight = 2;
        LedService lampe = new LedService();
        lampe.addLeds(LedService.MAX_NUMBER_OF_LEDS);
        /*Loop fuer eingabe, falls falsche Eingaben gemacht werden*/
        while (topLeft%16 + 1 < bottomRight%16 || topLeft <= 0 && topLeft > 256 || bottomRight <= 0 && bottomRight > 256 || topLeft / 16 == bottomRight / 16) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Geben Sie anhand des Steckboardes den TopLeft Corner ein: ");
            topLeft = sc.nextInt();
            System.out.println("Geben Sie anhand des Steckboardes den BottomRight Corner ein: : ");
            bottomRight = sc.nextInt();
            /* Ueberpruefung ob ein Rechteck gezeichnet werden kann, ohne ueber den Rand zu malen */
            if (topLeft%16 +1< bottomRight%16) {
                System.out.println("Der TopLeft Corner und BottomRight Corner erlauben kein Rechteck zu zeichnen!"
                        + "\nVersuchen Sie es erneut!");
            }
            /*
             * Kein Else if, da die obere Bedingung auch mit Eingaben ausserhalb des Steckboardes zutreffen koennte.
             * Auf ein Else wurde allerdings verzichtet
             *
             * Ueberpruefung ob der TopLeft Corner im Steckboard sich befindet
             *
             */
            if (topLeft < 0 || topLeft > 255 ) {
                System.out.println("Der TopLeft Corner befindet sich ausserhalb des Steckboardes!");
            }
            /* Falls der TopLeft Corner in Ordnung ist, dann den BottomRight Corner ueberpruefen */
            else if (bottomRight < 0 || bottomRight > 255) {
                System.out.println("Der BottomRight Corner befindet sich ausserhalb des Steckboardes!");
            }
            /* Falls der TopLeft Corner in Ordnung ist und der BottomRigth in Ordnung ist, dann ueberpruefe ob es in derselben Spalte liegt */
            else if (topLeft / 16 == bottomRight / 16) {
                System.out.println("Eine vertikale Strecke ist kein Rechteck!");
            }
        }
        /* Breite berechnen */
        breite = (topLeft%16 + 1) - (bottomRight%16);
        /* Hoehe berechnen */
        hoehe = (topLeft / 16) - (bottomRight / 16)+1;
        /* Originalhoehe in anderer Variabel zwischenspeichern, fuer spaetere weiterbenutzung */
        j = hoehe;
        /* Einzuschaltender Bereich einschalten mit Do while Loop */
        do{
            for (l = 1; l <= breite; l++) {
                lampe.turnLedOn(bottomRight);
                bottomRight++;
            }
            /* Korrektur BottomRight Variabel */
            bottomRight = bottomRight+16 - breite;
            /*Korrektur Hoehe Variabel */
            hoehe--;
        }while (hoehe>0);
        lampe.stopExecutionFor(3000);
        /* Korrektur Breite fuer auszuschaltender Bereich */
        breite = breite -2;
        /* Korrektur Startpunkt zum ausschalten */
        bottomRight = bottomRight -31;
        /* Korrektur Hoehe fuer auszuschaltenden Bereich */
        hoehe = j -2;
        /* Ueberpruefen ob es ueberhaupt etwas zum ausschalten gibt */
        if (breite > 2) {
            /* Auszuschaltender Bereich ausschalten */
            while(hoehe >= 1) {
                for (l = 1; l <= breite; l++) {
                    lampe.turnLedOff(bottomRight);
                    bottomRight++;
                }
                /* Korrektur BottomRight Variabel */
                bottomRight = bottomRight -16 - breite;
                /* Korrektur Hoehe Variabel */
                hoehe--;
            }
        }
        lampe.stopExecutionFor(3000);
        lampe.removeAllLeds();
    }
    public static void showTriangle() {
        /*
         * Grundueberlegung zur Berechnung des Dreiecks:
         *
         * Basisbreite = HE * 2 - 1
         * Hoehe Basis 0 + 1 = 2
         *
         */
        /* Variabeln definieren */
        hoehe = 0;
        i= 0;
        j = 15;
        /* Schlaufe fuer Hoehe, falls der Benutzer falsche Angaben macht */
        while (hoehe <= 1 || hoehe > 8){
            Scanner sc = new Scanner(System.in);
            System.out.println("Geben Sie die Hoehe des Gleichschengkligen Dreiecks ein: "
                    +"\nBeachten Sie, dass die Hoehe mindestens Zwei betraegt und nicht beliebig hoch sein kann!");
            hoehe = sc.nextInt();
            /* Kein If-Statement vorhanden, weil die Begruendung fuer erneute Eingabe bereits in der Ausgabe vorhanden ist */
        }
        LedService lampe = new LedService();
        /* Benoetigte Lampen berechnen */
        berechneteLeds = hoehe * 16;
        /* Breite aus Hoehe berechnen gemaess Grundueberlegung */
        breite = hoehe * 2 - 1;
        /* Lampen der Farbe Blau hinzufuegen */
        lampe.addLeds(berechneteLeds, LedColor.BLUE);
        /* Schlaufe zum Lampen einschalten, die Teil des Dreieckes sind */
        for (k = 0; k < hoehe; k++) {
            /* Reihe einschalten */
            while ( i < breite ) {
                lampe.turnLedOn(j);
                j--;
                i++;
                lampe.stopExecutionFor(15);
            }
            /* Reseten der Variabel um Breite einzuhalten */
            i = 0;
            /* Korrektur Position der Lampen */
            j = j + 16 + breite - 1;
            /* Korrektur der Breite fuer darueberliegende Zeile */
            breite = breite - 2;
        }
        lampe.stopExecutionFor(5000);
    }
    public static void moveTriangle() {
        /*
         * No Solution found
         *
         * Potentielle Moeglichkeit:
         *
         * showTriangle ausfuehren
         * Bei der Spitze starten und ausschalten, dann links die jeweils aeusserste Lampe ausschalten.
         * Ursprungsbreite + 1 verwenden um dann die rechts angrenzende Lampe wieder einzuschalten bis und mit Spitze.
         *
         */
    }
    public static void siebDesErasthenes() {
        LedService lampe = new LedService();
        lampe.addLeds(LedService.MAX_NUMBER_OF_LEDS);
        /* Schlaufe um alle Lampen einzuschalten */
        for (i = 0; i <=255; i++) {
            lampe.turnLedOn(i);
        }
        lampe.stopExecutionFor(2000);
        i = 0;
        /* Loop fuer erste zwei Lampen und ab Lampe ID 2 mit Modulo zu arbeiten */
        while (i<=2) {
            /* Ueberpruefen ob Lampen eingeschaltet sind */
            if (lampe.isOn(i) == true) {
                /* Erste zwei Lampen per Default ausschalten */
                if (i <= 1) {
                    lampe.turnLedOff(i);
                    lampe.stopExecutionFor(50);
                }
                /* Fuer alle anderen mit Modulo ueberpruefen ob man Lampen ausschalten kann */
                else {
                    /* Ab Ziffer Zwei bis Ziffer 19 nur mit denjenigen, die noch brennen Modulo operationen ausfuehren */
                    for (j = 0; j<=19; j++) {
                        /* Ueberpruefen ob Lampen eingeschaltet sind sonst j++ */
                        if (lampe.isOn(j) == true) {
                            /* Loop fuer Steckboard zu ueberpruefen wo Modulo == 0 ergibt */
                            for (k = 0; k<=255; k++) {
                                while (k%j == 0) {
                                    /* Falls J und K dieselbe Zahl ist, dies ignorieren, sonst ausschalten */
                                    if (k > j) {
                                        lampe.turnLedOff(k);
                                        lampe.stopExecutionFor(75);
                                    }
                                    k++;
                                }
                            }
                        }
                    }
                }
            }
            i++;
        }
        lampe.stopExecutionFor(3000);
        lampe.removeAllLeds();
    }
    /*
     * Aufgabe 10
     *
     * Frage 1: addLeds(Zahl, LedColor.FARBE);
     *
     * Frage 2: color(Zahl); Antwort RED, BLUE, GREEN, YELLOW
     *
     */
    public static void countColors() {
        /* Variabeln definieren */
        green = 0;
        red = 0;
        blue = 0;
        yellow = 0;
        /* Mit zufaelliger Farben alle Lampen setzen */
        LedService lampe = new LedService();
        lampe.addLeds(LedService.MAX_NUMBER_OF_LEDS, LedColor.RANDOM);
        /* Alle Lampen einschalten */
        for (i =0; i <= 255;i++) {
            lampe.turnLedOn(i);
        }
        /* Alle Lampen ueberpruefen auf Farbe */
        for (i = 0; i<= 255; i++) {
            /* Wenn Lampe rot, dann erhoehe Variabel rot */
            if(lampe.color(i) == LedColor.RED) {
                red++;
            }
            /* Wenn Lampe gruen, dann erhoehe Variabel gruen */
            else if(lampe.color(i) == LedColor.GREEN){
                green++;
            }
            /* Wenn Lampe blau, dann erhoehe Variabel blau */
            else if(lampe.color(i) == LedColor.BLUE) {
                blue++;
            }
            /* Wenn Lampe Gelb, dann erhoehe Variabel gelb */
            else if (lampe.color(i) == LedColor.YELLOW) {
                yellow++;
            }
            /* Fuer den Fall, dass es eine andere Farbe geben sollte, ausprinten Farbe unbekannt */
            else {
                System.out.println(i+" hat keine bekannte Farbe!!!!");
            }
        }
        /* Ausgabe wieviele Lampen je Farben gesteckt waren */
        System.out.println("Gruen: " + green + " LEDs");
        System.out.println("Rot: " + red + " LEDs");
        System.out.println("Blau: " + blue + " LEDs");
        System.out.println("Gelb: " + yellow + " LEDs");
        lampe.stopExecutionFor(5000);
        lampe.removeAllLeds();
    }
    /* Aufgabe 10.2 */
    public static void countColorsExt() {
        /* Array definieren */
        int [] redArr = {30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30};
        int [] greenArr = {30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30};
        int [] blueArr = {30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30};
        int [] yellowArr = {30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30};

        LedService lampe = new LedService();
        lampe.addLeds(LedService.MAX_NUMBER_OF_LEDS, LedColor.RANDOM);
        /* Alle Lampen einschalten */
        for(i=0; i<256; i++) {
            lampe.turnLedOn(i);
        }
        i = 0;
        lampe.stopExecutionFor(6000);
        /* Schlaufen fuer Lampen zaehlen pro Farbe je Zeile */
        for (j = 0; j <= 15; j++) {
            /* Reseten der Farbvariabeln je neue Zeile */
            green = 0;
            red = 0;
            blue = 0;
            yellow = 0;
            /* Schlaufe fuer die Breite der Zeile zu definieren zum Auslesen */
            while ( i >= 16*j && i < 16* (j+1)) {
                if (lampe.color(i) == LedColor.RED) {
                    red++;
                }
                else if (lampe.color(i) == LedColor.GREEN){
                    green++;
                }
                else if (lampe.color(i) == LedColor.BLUE){
                    blue++;
                }
                else if (lampe.color(i) == LedColor.YELLOW){
                    yellow++;
                }
                i++;
            }
            /* Ermittelte Werte in Array einpflegen */
            redArr [j] = red;
            greenArr [j] = green;
            blueArr [j] = blue;
            yellowArr [j] = yellow;
        }
        /*
         *  Array auslesete
         */
        /* Farbvariabeln auf ersten Arraywert initialisieren */
        red = redArr[0];
        green = greenArr[0];
        blue = blueArr[0];
        yellow = yellowArr[0];
        /* Print out wie die Zeilen fuer die Benutzer zu verstehen sind */
        System.out.println("Zeile-Nummer ist Null-Basiert (die unterste Zeile hat die Nr. 0):");
        /* Hoechste Zahl des roten Lampen Arrays ermitteln und Position im Array ermitteln */
        for ( i = 0; i < 16; i++) {
            if (red <=redArr[i]) {
                red = redArr[i];
                k = i;
            }
        }
        /* Ergebnis ausgeben fuer rotes Array */
        System.out.println("Rot: "+ red + " Leds in Zeile " + k);
        /* Hoeschte Zahl des gruenen Lampen Arrays ermitteln und Potition im Array ermitteln */
        for ( i = 0; i < 16; i++) {
            if (green <=greenArr[i]) {
                green = greenArr[i];
                k = i;
            }
        }
        /* Ergebnis ausgeben fuer gruenes Array */
        System.out.println("Gruen: "+ green + " Leds in Zeile " + k);
        /* Hoechste Zahl des blauen Lampen Arrays ermitteln und Position im Array ermitteln */
        for ( i = 0; i < 16; i++) {
            if (blue <=blueArr[i]) {
                blue = blueArr[i];
                k = i;
            }
        }
        /* Ergebnis ausgeben fuer blaues Array */
        System.out.println("Blau: " + blue + " Leds in Zeile " + k);
        /* Hoechste Zahl des gelben Lampen Arrays ermitteln und Position im Array ermitteln */
        for ( i = 0; i < 16; i++) {
            if (yellow <=yellowArr[i]) {
                yellow = yellowArr[i];
                k = i;
            }
        }
        /* Ergebnis ausgeben fuer gelbes Array */
        System.out.println("Gelb: " + yellow + " Leds in Zeile " + k);
    }
}