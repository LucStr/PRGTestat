package G16.aufgabe8;

import ch.hslu.prg.leds.proxy.LedService;
import static ch.hslu.prg.leds.proxy.LedService.MAX_COLUMNS;
import java.util.Scanner;

public class ClientApp {
	private static void showTriangle(LedService service, Scanner sc) {
		boolean status = false;
		
		while (status == false) {
			
			System.out.println("Höhe des Dreiecks von 3 bis und mit 8:");
			int top = sc.nextInt();
	        int hoeheDreieck = top * MAX_COLUMNS;
			
			if (top > 2 && top < 9) {
				status = true;
				
	            service.addLeds(hoeheDreieck);
	            int Start = MAX_COLUMNS -1;
	            int Start_2 = MAX_COLUMNS -1;
	            
	            for(int i = 0; i < top; i++) {
	            	
	            	service.stopExecutionFor(100);
	                service.turnLedOn(Start);

	                System.out.println("i: " + i);
	                System.out.println("Start: " + Start);
	                Start_2 = Start + MAX_COLUMNS;
	                
	                for (int j = 0; j < i; j++) {
	                    service.stopExecutionFor(100);
	                    service.turnLedOn(Start_2);
	                    
	                    Start_2 = Start_2 + MAX_COLUMNS;
	                    System.out.println("J: " + j);
	                    System.out.println("Start 2: " + Start_2);    
	                }
	                
	                Start = Start - 1;    
	            }
	            
	            Start = Start_2 - (MAX_COLUMNS *2 +1);
	            Start_2 = Start_2 - (MAX_COLUMNS *2 +1);
	            
	            for (int i = top; i >= 0; i--) {
	                service.stopExecutionFor(100);
	                service.turnLedOn(Start_2);
	                
	                Start_2 = Start;
	                
	                for (int j = 0; j < i; j++) {
	                    service.stopExecutionFor(100);
	                    service.turnLedOn(Start_2);
	                    
	                    Start_2 = Start_2 - 16;
	                    System.out.println("J2: " + j);
	                    System.out.println("Start 2 XX: " + Start_2);
	                }
	                
	                Start = Start - 17;
	            }
			}
			else {
				System.out.println("Falsche eingabe (zu klein/gross), nochmals...");
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
		showTriangle(service, sc);
	}
}
