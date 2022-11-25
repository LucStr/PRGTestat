package G16.aufgabe4;

import ch.hslu.prg.leds.proxy.LedService;
import java.util.Scanner;
import java.lang.Integer;

public class ClientApp {
	// Methode
	public static void showBinary(LedService service) {
		// Eingabe
		System.out.println("Positive Zahl eingeben"); 
		Scanner sc = new Scanner(System.in);
		int scanner = sc.nextInt(); 
		
		service.setDelayInMillis(200);
		
		if(scanner > 0) {
			// Binär
			String string = Integer.toBinaryString(scanner); 
			System.out.println("Binär: " + string); 
			
			// LED's hinzufügen
			int length = string.length();
			service.addLeds(length);
			
			// Korrektur Länge
			int position = length - 1; 
			
			// Ausführung
			for(int i = 0; i < string.length(); i++) {
				
				char a = string.charAt(i);
				int q = Character.getNumericValue(a); 
				
				if(q == 1 ) {
					service.turnLedOn(position);
					System.out.println("Binär: 1 - Position: " + position);
					position--; 
				}
				else {
					System.out.println("Binär: 0 - Position: " + position);
					position--; 
				}
			}
			
			service.stopExecutionFor(2000);
			service.removeAllLeds();
		}
		else {
			System.out.println("Keine positive Zahl!");
		}	
	}
	
	public static void main(String[] args) {				
		// Instanz der LEDService (Objekt)
		LedService service = new LedService();
		
		// Methode aufrufen und: Instanz übergeben
		showBinary(service);
	}
}
