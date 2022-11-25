import ch.hslu.prg.leds.proxy.LedService;
import ch.hslu.prg.leds.proxy.LedColor;

import java.util.Scanner;

public class G05 {

	public static void main(String[] args) {
		
		//Scanner initialisieren
		Scanner sc = new Scanner(System.in);
		
		//neues Objekt der Klasse LedService initialisieren
		LedService service = new LedService();
		
		//setzt die Anzeige zurück.
		service.reset();		
		
		//definiert, wann die Abfrage "Welche Methode?" abgebrochen wird.
		boolean abbruch = false;
		
		while (abbruch == false) {
			System.out.println("Welche Methode möchten Sie ausführen?");
			System.out.println("(1) ledsOnOff");
			System.out.println("(2) switchEvenOdd");
			System.out.println("(3) switchRandom");
			System.out.println("(4) showBinary");
			System.out.println("(5) showBorder");
			System.out.println("(6) showSquare");
			System.out.println("(7) showRectangle");
			System.out.println("(8) showTriangle");
			System.out.println("(9) siebDesEratosthenes");
			System.out.println("(10) countColors");
			System.out.println("(11) countColorsExt");
			System.out.println("(12) Abbruch");
			System.out.println("==> ");
		
			int auswahl = sc.nextInt();
			
			if (auswahl > 0 & auswahl < 13) {
				//Selektion um passende Anzahl LEDs zu erhalten
				switch (auswahl) {
				case 1:
					ledsOnOff(service);
					continue;
				case 2:
					switchEvenOdd(service);
					continue;
				case 3:
					switchRandom(service);
					continue;
				case 4:
					showBinary(service);
					continue;
				case 5:
					showBorder(service);
					continue;
				case 6:
					showSquare(service);
					continue;
				case 7:
					showRectangle(service);
					continue;
				case 8:
					showTriangle(service);
					continue;
				case 9:
					siebDesEratosthenes(service);
					continue;
				case 10:
					countColors(service);
					continue;
				case 11:
					countColorsExt(service);
					continue;
				case 12:
					abbruch = true;
					System.out.println("Programm wurde abgebrochen...");
					break;
				}
			}
			else {
				System.out.println("!Eingabe ungültig! (muss zwischen 0 und 12 sein)");
			}
		}


	}
	//Aufgabe 1
	public static void ledsOnOff (LedService service) {
		
		//Scanner initialisieren
		Scanner sc = new Scanner(System.in);
		
		int anzahlLeds;
		//wiederholende Abfrage, um korrekte Eingabe der LEDs zu erhalten
		while (true) {
			System.out.println("Geben Sie die Anzahl LEDs ein: ");
			anzahlLeds = sc.nextInt();
			//Selektion um passende Anzahl LEDs zu erhalten
			if (anzahlLeds > 0 & anzahlLeds <= LedService.MAX_NUMBER_OF_LEDS ) {
				//fügt eingegebene Anzahl LEDs hinzu und verlässt While-Schleife
				service.addLeds(anzahlLeds);
				break;
			}
			else {
			System.out.println("!Eingabe ungültig! (Bedingung: Anzahl LEDs <= 256 LEDs)\n");
			}
		}
		
		//hält die Ausführung für 2 Sekunden an
		service.stopExecutionFor(2000);
		
		//wiederholt die Schritte 4, 5, 6,7 drei Mal
		for (int i = 0; i < 3 ; i++) {
	
			//schaltet die LEDs von rechts nach links ein
			for (int j = 0; j < anzahlLeds ; j++) {
				
				//hält die Ausführung für 100 Millisekunde an
				service.stopExecutionFor(100);
				//schaltet das Angegebene LED ein
				service.turnLedOn(j);
			}
			//hält die Ausführung für 1 Sekunde an
			service.stopExecutionFor(1000);
	
			//schaltet die LEDs von links nach rechts aus (Init-Wert -1, damit höchstes LED angesteuert wird)
			for (int y = anzahlLeds ; y >= 0 ; y--) {
				
				//hält die Ausführung für 100 Millisekunde an
				service.stopExecutionFor(100);
				//schaltet das Angegebene LED aus
				service.turnLedOff(y);
			}
			
			//hält die Ausführung für 1 Sekunde an
			service.stopExecutionFor(1000);
		}
		//hält die Ausführung für 2 Sekunden an
		service.stopExecutionFor(2000);
		
		//setzt die Anzeige zurück.
		service.reset();

}
	//Aufgabe 2
	public static void switchEvenOdd (LedService service) {
		
		//Scanner initialisieren
		Scanner sc = new Scanner(System.in);
		
		int anzahlLeds;
		//wiederholende Abfrage, um korrekte Eingabe der LEDs zu erhalten
		while (true) {
			System.out.println("Geben Sie die Anzahl LEDs ein: ");
			anzahlLeds = sc.nextInt();
			//Selektion um passende Anzahl LEDs zu erhalten
			if (anzahlLeds > 0 & anzahlLeds <= LedService.MAX_NUMBER_OF_LEDS & anzahlLeds %16 == 0) {
				//fügt eingegebene Anzahl LEDs hinzu und verlässt While-Schleife
				service.addLeds(anzahlLeds);
				break;
			}
			else {
			System.out.println("!Eingabe ungültig! (Bedingung: Anzahl LEDs <= 256 LEDs & Vielfaches von 16)\n");
			}
		}
		
		//hält die Ausführung für 2 Sekunden an
		service.stopExecutionFor(2000);
		
		//wiederholt die Schritte 4, 5, 6,7 drei Mal
		for (int i = 0; i < 3 ; i++) {
	
			//schaltet die LEDs von rechts nach links ein
			for (int j = 0; j < anzahlLeds ; j++) {
				
				//schaltet alle LEDs ein deren Nummer gerade ist
				if(j % 2 == 0) {
				//hält die Ausführung für 100 Millisekunde an
				service.stopExecutionFor(100);
				//schaltet das Angegebene LED ein
				service.turnLedOn(j);
				}
			}
			//hält die Ausführung für 1 Sekunde an
			service.stopExecutionFor(1000);
			
			//if-Schleife in for-Schleife verschachtelt, weil für jedes einzelnes Licht überprüft werden muss,
			for (int y = 0; y < anzahlLeds; y++) {
				//ist dieses Licht eingeschaltet oder nicht -> Mit Methode isOn.
				if (service.isOn(i) == true) {
					service.turnLedOff(i);
				}		
				else {
					service.turnLedOn(i);
				}
			}

			
			//hält die Ausführung für 1 Sekunde an
			service.stopExecutionFor(1000);
		}
		
		//setzt die Anzeige zurück.
		service.reset();

}
	//Aufgabe 3
	public static void switchRandom (LedService service) {
			
			//Scanner initialisieren
			Scanner sc = new Scanner(System.in);
			
			int anzahlLeds;
			//wiederholende Abfrage, um korrekte Eingabe der LEDs zu erhalten
			while (true) {
				System.out.println("Geben Sie die Anzahl LEDs ein: ");
				anzahlLeds = sc.nextInt();
				//Selektion um passende Anzahl LEDs zu erhalten
				if (anzahlLeds > 0 & anzahlLeds <= LedService.MAX_NUMBER_OF_LEDS & anzahlLeds %16 == 0) {
					//fügt eingegebene Anzahl LEDs hinzu und verlässt While-Schleife
					service.addLeds(anzahlLeds);
					break;
				}
				else {
				System.out.println("!Eingabe ungültig! (Bedingung: Anzahl LEDs <= 256 LEDs & Vielfaches von 16)\n");
				}
			}
			
			//hält die Ausführung für 2 Sekunden an
			service.stopExecutionFor(2000);
			
			//wiederholt die Schritte 4, 5, 6,7 drei Mal
			for (int i = 0; i < 3 ; i++) {
				
				//Initialisiert die Variablen "min" und "maxNummerLeds", die den Definitionsbereich der Random-Nummer abbilden
				int min = 0;
				int maxNummerLeds = anzahlLeds - 1;
				
				//initialisiere neues Array
				int [] randomNumberArray = new int [(anzahlLeds/2)];
		
				//zufällige Zahlenwerte werden ins Array gespeichert
				for (int j = 0; j < anzahlLeds/2 ; j++) {
					
					//Maximum und Minimum sind inklusive bei dieser zufälligen Zahl
					randomNumberArray[j] = (int)Math.floor(Math.random()*(maxNummerLeds-min+1)+min);
				}
				
				//For-Schleife für Abgleich ob, gleiche Werte gesetzt wurden
				for (int n = 0; n < randomNumberArray.length ; n++) {
					for (int m = n+1; m < randomNumberArray.length ; m++) {
						
						//vergleicht Index n mit Index m
						if (randomNumberArray[n] == randomNumberArray[m]) {
							
							//falls gleicher Wert => setzt neuen Random Wert
							randomNumberArray[m] = (int)Math.floor(Math.random()*(maxNummerLeds-min+1)+min);
							
							//erneuter Abgleich um gleich gesetzten Random Wert zu verhindern
							for (int o = 0; o < randomNumberArray.length ; o++) {
								for (int p = o+1; p < randomNumberArray.length ; p++) {
									
									//vergleicht Index n mit Index m
									if (randomNumberArray[o] == randomNumberArray[p]) {
										
										//falls gleicher Wert => setzt neuen Random Wert
										randomNumberArray[p] = (int)Math.floor(Math.random()*(maxNummerLeds-min+1)+min);
									}
								}
							}
						}
					}
				}
					
				//schaltet die LEDs von rechts nach links ein, anhand der Zahlen im Array "randomNumberArray"
				for (int j = 0; j < randomNumberArray.length ; j++) {
					
					service.turnLedOn(randomNumberArray[j]);
				}
				
				//hält die Ausführung für 1 Sekunde an
				service.stopExecutionFor(1000);
				
				//alle eingeschalteten LEDs => aus & alle ausgeschalteten LEDs => ein
				int j = 0;
				while (j < anzahlLeds) {
					
					//schaltet alle LEDs aus die eingeschaltet waren
					if(service.isOn(j) == true) {
					
					//hält die Ausführung für 100 Millisekunde an
					service.stopExecutionFor(100);
					//schaltet das angegebene LED aus
					service.turnLedOff(j);
					}
					//schaltet alle LEDs ein die ausgeschaltet waren
					else {
						//hält die Ausführung für 100 Millisekunde an
						service.stopExecutionFor(100);
						//schaltet das Angegebene LED ein
						service.turnLedOn(j);
					}
					j++;
				}
				
				//hält die Ausführung für 1 Sekunde an
				service.stopExecutionFor(1000);
				
			}
			
			//setzt die Anzeige zurück.
			service.reset();
	}
	//Aufgabe 4
	public static void showBinary(LedService service) {
			
			//Scanner initialisieren
			Scanner sc = new Scanner(System.in);
			
			int positivInteger;
			//wiederholende Abfrage, um korrekte Eingabe der LEDs zu erhalten
			while (true) {
				System.out.println("Geben Sie eine Zahl ein: ");
				positivInteger = sc.nextInt();
				//Selektion um passende Anzahl LEDs zu erhalten
				if (positivInteger > 0) {
					break;
				}
				else {
				System.out.println("!Eingabe ungültig! (Geben Sie eine ganze, positive Zahl ein) \n");
				}
			}
			
			String zahlBinär = "";

			// Mit Do While Schleife int Zahlen in ein String umgewandelt welche mit
			// folgender Berechnung Binär umgewandelt wird.
			do {
				zahlBinär = positivInteger % 2 + zahlBinär;
				positivInteger = positivInteger / 2;
			} while (positivInteger != 0);

			service.addLeds(zahlBinär.length());

			// Mit charAt String verglichen, dann jede Position, die == 1 einschalten
			for (int i = 0; i < zahlBinär.length(); i++) {
				if (zahlBinär.charAt(i) == '1') {
					// Die Länge der String minus 1 (für Index) und - i, damit es "von hinten" anfängt.
					service.turnLedOn(zahlBinär.length() - 1 -i);
				}	
		}
	
	}
	//Aufgabe 5
	public static void showBorder(LedService service) {
		
		//maximale Anzahl LEDs hinzufügen
		service.addLeds(LedService.MAX_NUMBER_OF_LEDS);
		//hält die Ausführung für 2 Sekunden an
		service.stopExecutionFor(2000);

		// Mit 4 for-Schleifen einzeln alle LEDs am Rand einschalten (jede for-Schleife eine Seite)
		for (int i = 0; i < LedService.MAX_ROWS; i++) {
			service.turnLedOn(i);
		}
		for (int i = 0; i < LedService.MAX_NUMBER_OF_LEDS; i++) {
			service.turnLedOn(i * 16);
		}
		for (int i = 0; i < LedService.MAX_NUMBER_OF_LEDS; i++) {
			service.turnLedOn((i * 16) - 1);
		}
		for (int i = 256; i > LedService.MAX_NUMBER_OF_LEDS - 16; i--) {
			service.turnLedOn(i);
		}
		service.stopExecutionFor(5000);
		service.turnLedOff(LedService.MAX_NUMBER_OF_LEDS);
		service.stopExecutionFor(2000);

		// Mit 4 for-Schleifen einzeln alle LEDs am Rand ausschalten.
		for (int i = 0; i < LedService.MAX_ROWS; i++) {
			service.turnLedOff(i);
		}
		for (int i = 0; i < LedService.MAX_ROWS; i++) {
			service.turnLedOff(i * 16);
		}
		for (int i = 0; i < LedService.MAX_ROWS; i++) {
			service.turnLedOff((i * 16) - 1);
		}
		for (int i = LedService.MAX_NUMBER_OF_LEDS; i > LedService.MAX_NUMBER_OF_LEDS-16; i--) {
			service.turnLedOff(i);
		}
		service.stopExecutionFor(2000);
		
		//setzt die Anzeige zurück.
		service.reset();
	}
	//Aufgabe 6
	public static void showSquare(LedService service) {
		
		//Scanner initialisieren
		Scanner sc = new Scanner(System.in);
		
		//maximale Anzahl LEDs hinzufügen
		service.addLeds(LedService.MAX_NUMBER_OF_LEDS);
		
		int topLeft;
		//wiederholende Abfrage, um korrekte Eingabe topLeft-Punktes zu erhalten
		while (true) {
			System.out.println("Geben Sie den topLeft-Punkt ein: ");
			topLeft = sc.nextInt();
			if (topLeft > 0 & topLeft < LedService.MAX_NUMBER_OF_LEDS & topLeft > LedService.MAX_ROWS & topLeft % 16 != 0 ) {
				//fügt eingegebene Anzahl LEDs hinzu und verlässt While-Schleife
				break;
			}
			else {
			System.out.println("!Eingabe ungültig! (Bedingung: topLeft-Punkt <= 256 LEDs & nicht letzte Reihe unten und rechts) \n");
			}
		}
			
		int laengeQuadrat;
		//wiederholende Abfrage, um korrekte Eingabe der Länge des Quadrates zu erhalten
		while (true) {
			System.out.println("Geben Sie die Länge des Quadrates ein: ");
			laengeQuadrat = sc.nextInt();
			//Bedingung: laengeQuadrat <= Distanz zum rechten Rand & laengeQuadrat <= Distanz zum unteren Rand & laengeQuadrat < 256 LEDs & laengeQuadrat > 0
			if (laengeQuadrat > 0 & laengeQuadrat <= (LedService.MAX_ROWS - 1) & laengeQuadrat <= ((topLeft % LedService.MAX_ROWS)+1) & laengeQuadrat <= ((topLeft / LedService.MAX_ROWS)+1)) {
				//verlässt While-Schleife
				break;
			}
			else {
			System.out.println("!Eingabe ungültig! (Bedingung: laengeQuadrat <= Distanz zum rechten Rand & laengeQuadrat <= Distanz zum unteren Rand & laengeQuadrat < 256 LEDs & laengeQuadrat > 0 )\n");
			}
		}
		
		
		//dies wird getan, weil der topLeft-Punkt bereits zur Länge dazugehört
		laengeQuadrat = laengeQuadrat-1;
			
		//folgende Befehle zeichnen das Quadrat
		//erstellt Quadrat Reihe oben
		for (int i = topLeft; i >= (topLeft - laengeQuadrat); i--) {
			service.turnLedOn(i);
		}
		//erstellt Quadrat Reihe unten
		for (int i = (topLeft - laengeQuadrat * LedService.MAX_ROWS)-1; i >= ((topLeft - laengeQuadrat * LedService.MAX_ROWS)-laengeQuadrat); i--) {
			service.turnLedOn(i);
		}
		//erstellt Quadrat Reihe links
		for (int i = topLeft - LedService.MAX_ROWS; i >= (topLeft - laengeQuadrat * LedService.MAX_ROWS);i--) {
			service.turnLedOn(i);
			i = i - (LedService.MAX_ROWS-1);
		}
		//erstellt Quadrat Reihe rechts
		for (int i = (topLeft - LedService.MAX_ROWS) - laengeQuadrat; i >= (topLeft - (laengeQuadrat - 1) * LedService.MAX_ROWS) - laengeQuadrat;i--) {
			service.turnLedOn(i);
			i = i - (LedService.MAX_ROWS-1);
		}
		
		//hält die Ausführung für 5 Sekunden an
		service.stopExecutionFor(5000);
			
		//setzt die Anzeige zurück.
		service.reset();
	}
		
		//Aufgabe 7
		public static void showRectangle(LedService service) {
			
			//Scanner initialisieren
			Scanner sc = new Scanner(System.in);
			
			//maximale Anzahl LEDs hinzufügen
			service.addLeds(LedService.MAX_NUMBER_OF_LEDS);
			
			int topLeft;
			//wiederholende Abfrage, um korrekte Eingabe topLeft-Punktes zu erhalten
			while (true) {
				System.out.println("Geben Sie den topLeft-Punkt ein: ");
				topLeft = sc.nextInt();
				if (topLeft < LedService.MAX_NUMBER_OF_LEDS & topLeft > LedService.MAX_ROWS & topLeft % 16 != 0 ) {
					//verlässt While-Schleife
					break;
				}
				else {
				System.out.println("!Eingabe ungültig! (Bedingung: topLeft-Punkt <= 256 LEDs & nicht letzte Reihe unten und rechts) \n");
				}
			}
				
			int bottomRight;
			//wiederholende Abfrage, um korrekte Eingabe bottomRight-Punktes zu erhalten
			while (true) {
				System.out.println("Geben Sie den bottomRight-Punkt ein: ");
				bottomRight = sc.nextInt();
				if (bottomRight >= 0 & bottomRight < topLeft) {
					//verlässt While-Schleife
					break;
				}
				else {
				System.out.println("!Eingabe ungültig! (Bedingung: laengeQuadrat <= Distanz zum rechten Rand & laengeQuadrat <= Distanz zum unteren Rand & laengeQuadrat < 256 LEDs & laengeQuadrat > 0 )\n");
				}
			}
			
			//Berechnung Länge des Rechtecks (topLeft nach rechts)
			int laenge = (topLeft - bottomRight) % LedService.MAX_ROWS;
			
			//Berechnung Breite des Rechtecks (topLeft nach unten)
			int breite = ((topLeft - bottomRight) - laenge) / LedService.MAX_ROWS;
				
			//zuerst wird Spalte mit i gesetzt (geschachtelte Schleife)
			for (int i = topLeft; i >= topLeft - laenge ; i--) {
				int j = i;
				//danach, jedes LED in Spalte gemäss Breite angeschaltet
				while (j >= i - (breite * LedService.MAX_ROWS)) {
					service.turnLedOn(j);
					//von j 16 abziehen um zur nächsten Zeile zu springen
					j = j - LedService.MAX_ROWS;
				}
			}
			
			//hält die Ausführung für 3 Sekunden an
			service.stopExecutionFor(3000);
			
			//von Länge und Breite 1 abziehen, da Rahmen angezeigt bleiben soll
			int laengeInnen = laenge -1;
			
			int breiteInnen = breite -1;
			
			//zuerst wird Spalte mit i gesetzt (geschachtelte Schleife)
			for (int i = topLeft - 1; i >= topLeft - laengeInnen ; i--) {
				int j = i - LedService.MAX_ROWS;
				//danach, jedes LED in Spalte gemäss Breite angeschaltet
				while (j >= i - (breiteInnen * LedService.MAX_ROWS)) {
					service.turnLedOff(j);
					//von j 16 abziehen um zur nächsten Zeile zu springen
					j = j - LedService.MAX_ROWS;
				}
			}
			
			//hält die Ausführung für 3 Sekunden an
			service.stopExecutionFor(3000);
				
			//setzt die Anzeige zurück.
			service.reset();
		}
		
		//Aufgabe 8
		public static void showTriangle(LedService service) {
			
			//Scanner initialisieren
			Scanner sc = new Scanner(System.in);
			
			
			
			int hoehe;
			//wiederholende Abfrage, um korrekte Eingabe topLeft-Punktes zu erhalten
			while (true) {
				System.out.println("Geben Sie die Höhe des Dreieckes ein: ");
				hoehe = sc.nextInt();
				if (hoehe > 1 & hoehe < 9 ) {
					//verlässt While-Schleife
					break;
				}
				else {
				System.out.println("!Eingabe ungültig! (Bedingung: hoehe > 1 & hoehe < 9 ) \n");
				}
			}
			
			//LEDs hinzufügen gemäss Höhe * 16
			service.addLeds(hoehe * LedService.MAX_ROWS);
			
			//in dieser Variable wird der höchste Wert des Dreiecks gespeichert
			int hoechsteNummer = 0;
			
				//erstellt für jede Reihe ein Array mit 1+ Speicherplatz
				for (int i = 1; i <= hoehe; i++) {
				int ledWert = LedService.MAX_ROWS;
				int[]  arrayproReihe = new int[i];
				//ledWert der untersten LEDs (15, 14, 13, ...)
				ledWert = ledWert - i;
				int j = 0;
				//weist aktuellem Array (Reihe) Werte zu
				while (j < i) {
					arrayproReihe[j] = ledWert;
					ledWert = ledWert + 16;
					j++;
				}
				
				//hält die Ausführung für 250 Millisekunden an
				service.stopExecutionFor(250);
				
				//
				for (int  element : arrayproReihe) {
					service.turnLedOn(element);
					}
				//höchster Wert des Arrays wird in Variable geschrieben
				hoechsteNummer = arrayproReihe[j-1];
			}
			
				//
				for (int u = hoehe-1; u >= 1; u--) {
					hoechsteNummer = hoechsteNummer - 17;
					int ledWertAbsteigend = hoechsteNummer;
					int[]  arrayproReiheAbsteigend = new int[u];
					int p = 0;
					while (p < u) {
						arrayproReiheAbsteigend[p] = ledWertAbsteigend;
						ledWertAbsteigend = ledWertAbsteigend - 16;
						p++;
					}
					
					//hält die Ausführung für 250 Millisekunden an
					service.stopExecutionFor(250);
					
					for (int  element : arrayproReiheAbsteigend) {
						service.turnLedOn(element);
						}
				}
	
			//hält die Ausführung für 5 Sekunden an
			service.stopExecutionFor(5000);
				
			//setzt die Anzeige zurück.
			service.reset();
		}
		
		//Aufgabe 9
		public static void siebDesEratosthenes(LedService service) {
			
			//maximale Anzahl LEDs hinzufügen
			service.addLeds(LedService.MAX_NUMBER_OF_LEDS);
			
			//schaltet alle LEDs ein
			for (int i = 0; i <= LedService.MAX_NUMBER_OF_LEDS; i++) {
				service.turnLedOn(i);
			}
			
			
			//bis 16 da 16*16=256
			for (int i = 2; i < 16; i++) { 
				//Zähler damit erstes eingeschaltetes LED nicht ausgeschaltet wird = Primzahl
				int zaehler = 1;
				//sucht nächstes LED das eingeschaltet ist
				if (service.isOn(i) == true) {
					
					//alle LEDs aus, deren Nummer ein Vielfaches der Variable i sind
					for (int j = i; j < LedService.MAX_NUMBER_OF_LEDS; j++) { 
						
						if (j % i == 0 & zaehler != 1) {
							service.turnLedOff(j);
						}
						zaehler++;
					}
					
				}
				
			}
			//LED-Nummer 0,1 ausschalten, weil keine Primzahl, gemäss Aufgabenstellung nicht ausgeschalten
			service.turnLedOff(0);
			service.turnLedOff(1);
		
			//hält die Ausführung für 10 Sekunden an
			service.stopExecutionFor(10000);
				
			//setzt die Anzeige zurück.
			service.reset();
			
		}
		
		//Aufgabe 10.1
				public static void countColors(LedService service) {
					
					//maximale Anzahl LEDs hinzufügen mit zufälligen Farben
					service.addLeds(LedService.MAX_NUMBER_OF_LEDS, LedColor.RANDOM);
					
					//schaltet alle LEDs ein
					for (int i = 0; i <= LedService.MAX_NUMBER_OF_LEDS; i++) {
						service.turnLedOn(i);
					}
					
					//Variablen um die Anzahl verschieden farbenen LEDs zu speichern
					int anzahlRed = 0;
					int anzahlGreen = 0;
					int anzahlBlue = 0;
					int anzahlYellow = 0;
					
					//Schleife geht jedes LED durch, entscheidet welche Farbe und rechnet bei der Entsprechenden 1+
					for (int i = 0; i < LedService.MAX_NUMBER_OF_LEDS; i++) {
						
						if (service.color(i) == LedColor.RED) {
							
							anzahlRed++;
							
						}
						
						else if (service.color(i) == LedColor.GREEN) {
							
							anzahlGreen++;
							
						}
						
						else if (service.color(i) == LedColor.BLUE) {
							
							anzahlBlue++;
							
						}

						else if (service.color(i) == LedColor.YELLOW) {

							anzahlYellow++;

						}
					}
					
					//Ausgabe
					System.out.println("\n» RED:     " +anzahlRed +" LEDs\n");
					System.out.println("» GREEN:   " +anzahlGreen +" LEDs\n");
					System.out.println("» BLUE:    " +anzahlBlue +" LEDs\n");
					System.out.println("» YELLOW:  " +anzahlYellow +" LEDs\n");
					
					
					//hält die Ausführung für 10 Sekunden an
					service.stopExecutionFor(10000);
						
					//setzt die Anzeige zurück.
					service.reset();
					
				}
				
				//Aufgabe 10.2
				public static void countColorsExt(LedService service) {
					
					
					//maximale Anzahl LEDs hinzufügen mit zufälligen Farben
					service.addLeds(LedService.MAX_NUMBER_OF_LEDS, LedColor.RANDOM);
					
					//schaltet alle LEDs ein
					for (int i = 0; i <= LedService.MAX_NUMBER_OF_LEDS; i++) {
						service.turnLedOn(i);
					}
					
					////Variablen zum speichern der Zeile mit der maximalen Anzahl LEDs
					int zeileMaxRed = 0;
					int zeileMaxGreen = 0;
					int zeileMaxBlue = 0;
					int zeileMaxYellow = 0;
					
					//Variablen zum speichern der maximalen Anzahl LEDs
					int maxRed = 0;
					int maxGreen = 0;
					int maxBlue = 0;
					int maxYellow = 0;
					
					//Arrays initialisieren mit 16 Stellen, für jede Zeile eine
					int[] arrRed = new int[LedService.MAX_ROWS];
					int[] arrGreen = new int[LedService.MAX_ROWS];
					int[] arrBlue = new int[LedService.MAX_ROWS];
					int[] arrYellow = new int[LedService.MAX_ROWS];
					
					//Variablen für die while und for Schleife, mit diesen wird navigiert
					int zeilenAnfang = 0;
					int zeilenEnde = 15;
					int zeilenNummer = 0;
					
					//geht jede Zeile einzeln durch
					while(zeilenEnde < LedService.MAX_NUMBER_OF_LEDS) {
						
						//wiederholt Abfrage für jedes LED einzeln
						for (int i = zeilenAnfang; i <= zeilenEnde; i++) {
							
							//if - else if - selektion zur Entscheidung welche Farbe
							if (service.color(i) == LedColor.RED) {
								
								arrRed[zeilenNummer]++;
								
							}
							
							else if (service.color(i) == LedColor.GREEN) {
								
								arrGreen[zeilenNummer]++;
								
							}
							
							else if (service.color(i) == LedColor.BLUE) {
								
								arrBlue[zeilenNummer]++;
								
							}

							else if (service.color(i) == LedColor.YELLOW) {
	
								arrYellow[zeilenNummer]++;
	
							}
						}
						
						//erhöht Variablen "zeilenAnfang" und "zeilenEnde" um 16 und zeilenNummer um 1+ ==> Sprung zur nächsten Zeile
						zeilenAnfang = zeilenAnfang + LedService.MAX_ROWS;
						zeilenEnde = zeilenEnde + LedService.MAX_ROWS;
						zeilenNummer++;
					}
					
					
					//vergleicht Werte jeder Zeile innerhalb des Arrays, schreibt höchsten in "maxRed" und speichert aktuelle Zeile in "zeileMaxRed"
					for(int i = 0; i < arrRed.length; i++) {
						
						if(maxRed < arrRed[i]) {
							
							maxRed = arrRed[i];
							
							zeileMaxRed = i;
							
						}
					}
					
					for(int i = 0; i < arrRed.length; i++) {
						
						if(maxRed <= arrRed[i]) {
							
							maxRed = arrRed[i];
							
							zeileMaxRed = i;
							
						}
					}
					
					for(int i = 0; i < arrGreen.length; i++) {
						
						if(maxGreen <= arrGreen[i]) {
							
							maxGreen = arrGreen[i];
							
							zeileMaxGreen = i;
							
						}
					}
					
					for(int i = 0; i < arrBlue.length; i++) {
						
						if(maxBlue <= arrBlue[i]) {
							
							maxBlue = arrBlue[i];
							
							zeileMaxBlue = i;
							
						}
					}
					
					for(int i = 0; i < arrYellow.length; i++) {
						
						if(maxYellow <= arrYellow[i]) {
							
							maxYellow = arrYellow[i];
							
							zeileMaxYellow = i;
							
						}
					}
					
					//Ausgabe der gesammelten Variablen
					System.out.println("\nZeile-Nummer ist Null-Basiert (die unterste Zeile hat die Nr. 0):\n");
					System.out.println("» RED:     " +maxRed +" LEDs in der Zeile-Nr. " +zeileMaxRed +"\n");
					System.out.println("» Green:   " +maxGreen +" LEDs in der Zeile-Nr. " +zeileMaxGreen +"\n");
					System.out.println("» BLUE:    " +maxBlue +" LEDs in der Zeile-Nr. " +zeileMaxBlue +"\n");
					System.out.println("» YELLOW:  " +maxYellow +" LEDs in der Zeile-Nr. " +zeileMaxYellow +"\n");

				
					//hält die Ausführung für 10 Sekunden an
					service.stopExecutionFor(10000);
						
					//setzt die Anzeige zurück.
					service.reset();
					
				}
}
