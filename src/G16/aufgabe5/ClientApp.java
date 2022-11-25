package G16.aufgabe5;

import ch.hslu.prg.leds.proxy.LedService;
import static ch.hslu.prg.leds.proxy.LedService.MAX_NUMBER_OF_LEDS;
import static ch.hslu.prg.leds.proxy.LedService.MAX_COLUMNS;
import static ch.hslu.prg.leds.proxy.LedService.MAX_ROWS;

public class ClientApp {
	private static void showBorder(LedService service) {
		// Max LED's erzeugen
		service.addLeds(MAX_NUMBER_OF_LEDS);
		
		// Stop in ms
		service.stopExecutionFor(2000);
		
		// LED's einschalten Rahmen
		for(int i = 0; i < MAX_ROWS; i++) {
			for(int j = 0; j < MAX_COLUMNS; j++) {
				service.turnLedOn(j);
				service.stopExecutionFor(10);
			}
			service.turnLedOn(i*16);
			service.stopExecutionFor(100);
		}
		
		for(int i = 0; i < MAX_ROWS; i++) {
			for(int j = 0; j < MAX_COLUMNS; j++) {
				service.turnLedOn(j+240);
				service.stopExecutionFor(10);
			}
			service.turnLedOn((i*16)+15);
			service.stopExecutionFor(100);
		}
		
		// Stop in ms
		service.stopExecutionFor(5000);
		
		// LED's ausschalten Rahmen
		for(int i = 0; i < MAX_ROWS; i++) {
			for(int j = 0; j < MAX_COLUMNS; j++) {
				service.turnLedOff(j);
				service.stopExecutionFor(10);
			}
			service.turnLedOff(i*16);
			service.stopExecutionFor(100);
		}
		
		for(int i = 0; i < MAX_ROWS; i++) {
			for(int j = 0; j < MAX_COLUMNS; j++) {
				service.turnLedOff(j+240);
				service.stopExecutionFor(10);
			}
			service.turnLedOff((i*16)+15);
			service.stopExecutionFor(100);
		}
		
		// Stop in ms
		service.stopExecutionFor(2000);
		
		// Alles löschen = Standard
		service.removeAllLeds();
	}
	
	public static void main(String[] args) {
		LedService service = new LedService();
		
		showBorder(service);
	}
}
