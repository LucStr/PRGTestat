package G16.aufgabe1;

import ch.hslu.prg.leds.proxy.LedService;
import java.util.Scanner; 

public class ClientApp {
	// Methode
	private static void ledsOnOff(LedService service, int anzahlLED) {
		// Prüfung max 256 LED's
		if(anzahlLED <= 256) {
			// LED's hinzufügen 
			service.addLeds(anzahlLED);
			
			// Stop in ms
			service.stopExecutionFor(2000);
			
			int durchführen = 3;
			for(int f = 0; f < durchführen; f++) {
				// Einschalten von rechts nach links
				for(int i = 0; i < anzahlLED; i++) {
					service.turnLedOn(i);
					
					// Stop in ms
					service.stopExecutionFor(250);
				}
				
				// Stop in ms
				service.stopExecutionFor(250);
				
				// Ausschalten von links nach rechts
				for(int i = anzahlLED; i >= 0; i--) {
					service.turnLedOff(i);
								
					// Stop in ms
					service.stopExecutionFor(250);
				}
				
				// Stop in ms
				service.stopExecutionFor(250);
			}
			
			// Stop in ms
			service.stopExecutionFor(2000);
			
			// Alles löschen = Standard
			service.removeAllLeds();
		}
		else {
			System.out.println("Anzahl LED's zu gross. Max 256 LED's!");
			// Alles löschen = Standard
			service.removeAllLeds();
		}
	}
	
	public static void main(String[] args) {
		// Einlesen von der Tastatur
		System.out.println("Anzahl LED's:");
		Scanner sc = new Scanner(System.in);
		int anzahlLED = sc.nextInt();
		
		// Instanz der LEDService (Objekt)
		LedService service = new LedService();
		
		// Methode aufrufen und: Instanz übergeben, Anzahl LED's
		ledsOnOff(service, anzahlLED);
	}
}
