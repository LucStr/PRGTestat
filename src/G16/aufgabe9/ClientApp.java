package G16.aufgabe9;

import ch.hslu.prg.leds.proxy.LedService;
import static ch.hslu.prg.leds.proxy.LedService.MAX_NUMBER_OF_LEDS;

public class ClientApp {
	private static void siebDesEratosthenes(LedService service) {
		// Alle LED's hinzufügen und einschalten
		service.addLeds(MAX_NUMBER_OF_LEDS);
		
		for(int i = 0; i < MAX_NUMBER_OF_LEDS; i++) {
			service.turnLedOn(i);
			//service.stopExecutionFor(20);
		}
		service.stopExecutionFor(1000);
		
		service.turnLedOff(0);
		service.turnLedOff(1);
		
		// Vielfaches von 2. Rest ausschalten
		for(int i = 3; i<256; i++) {
			if(i%2 == 0) {
				service.turnLedOff(i);
			}
		}
		
		// Ausgabe der LED's welche ON sind
		for(int i= 3; i < 256; i++) {
			if(service.isOn(i)) {
				System.out.println("1. Sieb ON: " + i);
			}
		}
		service.stopExecutionFor(1000);
		
		// Vielfaches von 3. Rest ausschalten
		for(int i = 4; i<256; i++) {
			if(i%3 == 0) {
				service.turnLedOff(i);
			}
		}
				
		// Ausgabe der LED's welche ON sind
		for(int i= 4; i < 256; i++) {
			if(service.isOn(i)) {
				System.out.println("2. Sieb ON: " + i);
			}
		}
		service.stopExecutionFor(1000);
		
		// Vielfaches von 5. Rest ausschalten
		for(int i = 6; i<256; i++) {
			if(i%5 == 0) {
				service.turnLedOff(i);
			}
		}
						
		// Ausgabe der LED's welche ON sind
		for(int i= 4; i < 256; i++) {
			if(service.isOn(i)) {
				System.out.println("3. Sieb ON: " + i);
			}
		}
		service.stopExecutionFor(1000);
		
		// Vielfaches von 7. Rest ausschalten
		for(int i = 8; i<256; i++) {
			if(i%7 == 0) {
				service.turnLedOff(i);
			}
		}
								
		// Ausgabe der LED's welche ON sind
		for(int i= 8; i < 256; i++) {
			if(service.isOn(i)) {
				System.out.println("4. Sieb ON: " + i);
			}
		}
		service.stopExecutionFor(1000);
		
		// Vielfaches von 11. Rest ausschalten
		for(int i = 12; i<256; i++) {
			if(i%11 == 0) {
				service.turnLedOff(i);
			}
		}
								
		// Ausgabe der LED's welche ON sind
		for(int i= 12; i < 256; i++) {
			if(service.isOn(i)) {
				System.out.println("5. Sieb ON: " + i);
			}
		}
		service.stopExecutionFor(1000);
		
		// Vielfaches von 13. Rest ausschalten
		for(int i = 14; i<256; i++) {
			if(i%13 == 0) {
				service.turnLedOff(i);
			}
		}
								
		// Ausgabe der LED's welche ON sind
		for(int i= 14; i < 256; i++) {
			if(service.isOn(i)) {
				System.out.println("6. Sieb ON: " + i);
			}
		}
		
		System.out.println("Ende der Prüfung: " + 17*17);
		
		// Ausgabe der LED's welche ON sind bzw. der Primzahlen
		for(int i= 0; i < 256; i++) {
			if(service.isOn(i)) {
				System.out.println("Primzahlen: " + i);
			}
		}
	}
	
	public static void main(String[] args) {
		// Instanz der LEDService (Objekt)
		LedService service = new LedService();
				
		// Methode aufrufen und: Instanz übergeben
		siebDesEratosthenes(service);
	}
}
