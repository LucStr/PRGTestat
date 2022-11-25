package G16.aufgabe2;

import ch.hslu.prg.leds.proxy.LedService;
import java.util.Scanner; 

public class ClientApp {
	// Methode
	private static void switchEvenOdd(LedService service, int anzahlLED) {
		// Prüfung max 256 LED's und vielfaches von 16
		if(anzahlLED <= 256 && (anzahlLED % 16) == 0) {
			// LED's hinzufügen
			service.addLeds(anzahlLED);
			
			// Stop in ms
			service.stopExecutionFor(2000);
			
			int durchführen = 3;
			int f = 0;
			while(durchführen > f) {
				f++;
				
				// Einschalten von rechts nach links
				for(int i = 0; i < anzahlLED; i++) {
					
					// Einschalten der geraden Werte
					if((i % 2) == 0) {
						service.turnLedOn(i);
					}
					else {
						service.turnLedOff(i);
					}
					
					// Stop in ms
					service.stopExecutionFor(50);
				}
				
				// Stop in ms
				service.stopExecutionFor(1000);
				
				// Ausschalten von rechts nach links
				for(int i = 0; i < anzahlLED; i++) {
								
					// Einschalten der ungeraden Werte
					if((i % 2) == 0) {
						service.turnLedOff(i);
					}
					else {
						service.turnLedOn(i);
					}
								
					// Stop in ms
					service.stopExecutionFor(50);
				}
				
				// Stop in ms
				service.stopExecutionFor(1000);
	
				// Ausschalten aller LED's
				for(int i = 0; i < anzahlLED; i++) {
					service.turnLedOff(i);
				}
				
				// Stop in ms
				service.stopExecutionFor(1000); 
			}
			
			// Alles löschen = Standard
			service.removeAllLeds();
		}
		else {
			System.out.println("Anzahl LED's zu gross. Max 256 LED's!");
			System.out.println("Oder vielfaches von 16 nicht eingeben!");
			// Alles löschen = Standard
			service.removeAllLeds();
		}
	}
	
	public static void main(String[] args) {
		// Einlesen von der Tastatur
		System.out.println("Anzahl LED's (Vielfaches von 16):");
		Scanner sc = new Scanner(System.in);
		int anzahlLED = sc.nextInt();
		
		// Instanz der LEDService (Objekt)
		LedService service = new LedService();
		
		// Methode aufrufen und: Instanz übergeben, Anzahl LED's
		switchEvenOdd(service, anzahlLED);
	}
}
