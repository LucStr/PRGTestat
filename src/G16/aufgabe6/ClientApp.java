package G16.aufgabe6;

import ch.hslu.prg.leds.proxy.LedService;
import static ch.hslu.prg.leds.proxy.LedService.MAX_NUMBER_OF_LEDS;
import java.util.Scanner;

public class ClientApp {
	private static void showSquare(LedService service, Scanner sc) {
		// Alle LED's hinzufügen
		service.addLeds(MAX_NUMBER_OF_LEDS);
		
		
		boolean status = false;
		
		while (status == false) {
			System.out.println("Nummer des LED's, fungiert als 'topLeft':");
			int topLeft = sc.nextInt();
			
			System.out.println("Länge des Quadrates eingeben:");
			int squareLenght = sc.nextInt();
			
			// Endpunkte Quadrat 
			int topRight = topLeft - (squareLenght - 1);
			int botLeft = topLeft - ((squareLenght - 1) * 16);
			int botRight = botLeft - (squareLenght - 1);
			
			// Prüfung 
			int top_left_mod = 1 + topLeft % 16;
			
			if(top_left_mod - squareLenght >= 0 && botLeft > 0) {
				status = true;
				
				// Quadrat zeichnen
				for(int i = topLeft; i > topRight; i--) {
					service.turnLedOn(i);
				}
				
				for(int i = 0; i < squareLenght; i++) {
					service.turnLedOn(topLeft - (i * 16));
				}
				
				for(int i = 0; i < squareLenght; i++) {
					service.turnLedOn(topRight - (i * 16));
				}
				
				for(int i = botLeft; i > botRight; i--) {
					service.turnLedOn(i);
				}
					
				// Stop in ms
				service.stopExecutionFor(5000);
				
				// Alles löschen = Standard
				service.removeAllLeds();
			}
			else {
				System.out.println("Falsche eingabe, nochmals...");
				status = false;
			}
			
		}
	}
	
	public static void main(String[] args) {
		// Einlesen von der Tastatur
		Scanner sc = new Scanner(System.in);
						
		// Instanz der LEDService (Objekt)
		LedService service = new LedService();
				
		// Methode aufrufen und: Instanz übergeben
		showSquare(service, sc);
	}
}
