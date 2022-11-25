package G16.aufgabe7;

import ch.hslu.prg.leds.proxy.LedService;
import static ch.hslu.prg.leds.proxy.LedService.MAX_NUMBER_OF_LEDS;
import java.util.Scanner;
import java.lang.Math;

public class ClientApp {
	private static void showRectangle(LedService service, Scanner sc) {
		// Alle LED's hinzufügen
		service.addLeds(MAX_NUMBER_OF_LEDS);
		
		int topLeft;
		int bottomRight;
		boolean status = false;
		
		while (status == false) {
			System.out.println("Nummer des LED's, fungiert als 'topLeft':");
			topLeft = sc.nextInt();
			
			System.out.println("Nummer des LED's, fungiert als 'bottomRight':");
			bottomRight = sc.nextInt();
			
			if(topLeft < 256 && topLeft > 15 && bottomRight < 240 && bottomRight > 0) {
				status = true;
				
				// Distanz y zwischen den LED's
				int bottomLefty = (int) Math.floor(bottomRight/16);
				int topLefty = (int) Math.floor(topLeft/16);
				int distanzy = topLefty - bottomLefty;
				System.out.println("Distanz y: " + distanzy);
						
				// Distanz x zwischen den LED's
				int bottom = bottomRight;
				int top = topLeft;

				while(top >= 16) {
					top = top - 16;
				}
				
				while(bottom >= 16) {
					bottom = bottom - 16;
				}
				
				int distanzx = top - bottom + 1;
				System.out.println("Distanz x: " + distanzx);
				
				// Zeichnen, erste Reihe
				for(int i = bottomRight; i < (bottomRight+distanzx); i++) {
				 	service.turnLedOn(i);
				}
				
				// Zeichnen, restliche Reihen
				for(int z = 0; z < distanzy; z++) {
					bottomRight = bottomRight +16;
					for(int j = bottomRight; j < (bottomRight+distanzx); j++) {
					 	service.turnLedOn(j);
					}
				}
				System.out.println(topLeft);
				
				
				// Stop in ms
				service.stopExecutionFor(3000);
				
				// Zeichnen, löschen innerhalb
				for(int z = 0; z < distanzy-1; z++) {
					topLeft = topLeft -16;
					for(int j = topLeft-1; j > (topLeft-distanzx+1); j--) {
					 	service.turnLedOff(j);
					}
				}
				
				// Stop in ms
				service.stopExecutionFor(3000);
				
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
		showRectangle(service, sc);
	}
}
