package G16.aufgabe3;

import ch.hslu.prg.leds.proxy.LedService;
import java.util.Scanner; 
import java.util.Random;

public class ClientApp {
	// Methode
	public static void switchRandom(LedService service) {
		System.out.println("Zahl von 1 - 16"); 
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt(); 
		
		service.setDelayInMillis(200);
		b = b*16; 
		service.addLeds(b);

		
		for(int j = 0; j<3; j++) {
			
		
		Random a = new Random(); 
		
		int c = b; 
		
		int length = c/2; 
		
		int[] array = new int[length]; 
	
		for(int i = 0; i < array.length; i++) {
			array[i] = a.nextInt(c); 
		}
		
		for(int i = 0; i<array.length; i++) {
			service.turnLedOn(array[i]);
		}
		
		service.stopExecutionFor(100);
		
		for(int i = 0; i < b; i++) {
			if(service.isOn(i)) {
				service.turnLedOff(i);
			}
			else {
				service.turnLedOn(i);
			}
		}
		
		service.stopExecutionFor(100);
		
		for(int i = 0; i < b; i++) {
			if(service.isOn(i)) {
				service.turnLedOff(i);
			}
			
		}
		
		service.stopExecutionFor(100);
		
		}
		
		service.removeAllLeds();
		
	}
	
	public static void main(String[] args) {
		// Instanz der LEDService (Objekt)
		LedService service = new LedService();

		
		// Methode aufrufen und: Instanz übergeben, Anzahl LED's
		switchRandom(service);
	}
	
}
