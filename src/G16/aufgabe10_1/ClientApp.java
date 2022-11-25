package G16.aufgabe10_1;

import ch.hslu.prg.leds.proxy.LedService;
import static ch.hslu.prg.leds.proxy.LedService.MAX_NUMBER_OF_LEDS;
import ch.hslu.prg.leds.proxy.LedColor;

public class ClientApp {
	public static void countColors(LedService service) {
			// Alle LED'S hinzufügen und einschalten inkl. Farben
			int addLed = MAX_NUMBER_OF_LEDS; 
			service.addLeds(addLed, LedColor.RANDOM);
			
			for(int i = 0; i < 256; i++) {
				service.turnLedOn(i);
			}
			
			// Warten
			service.stopExecutionFor(2000);
			
			// LED Farben zählen
			int g = 0; 
			int r = 0; 
			int b = 0; 
			int y = 0; 
			
			for(int i = 0; i < 256; i++) {
				//System.out.println(service.color(i));
				LedColor n = service.color(i); 
				if(n.equals(LedColor.GREEN)) {
					g++; 
				}
				if(n.equals(LedColor.RED)) {
					r++; 
				}
				if(n.equals(LedColor.BLUE)) {
					b++; 
				}
				if(n.equals(LedColor.YELLOW)) {
					y++; 
				}
			}
			
			// Ausgabe
			System.out.println("GREEN:  " + g); 
			System.out.println("RED:    " + r); 
			System.out.println("BLUE:   " + b); 
			System.out.println("YELLOW: " + y);
	}
	
	public static void main(String[] args) {
		// Instanz der LEDService (Objekt)
		LedService service = new LedService();
				
		// Methode aufrufen und: Instanz übergeben
		countColors(service);
	}
}