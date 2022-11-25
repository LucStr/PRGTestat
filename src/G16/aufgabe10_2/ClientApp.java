package G16.aufgabe10_2;

import ch.hslu.prg.leds.proxy.LedService;
import static ch.hslu.prg.leds.proxy.LedService.MAX_NUMBER_OF_LEDS;
import ch.hslu.prg.leds.proxy.LedColor;

public class ClientApp {
	private static void countColorsExt(LedService service) {
		// Alle LED'S einschalten inkl. Farben
		int addLed = MAX_NUMBER_OF_LEDS; 
		service.addLeds(addLed, LedColor.RANDOM);
		
		for(int i = 0; i < 256; i++) {
			service.turnLedOn(i);
		}
		
		// Warten
		service.stopExecutionFor(2000);
		
		
		//GREEN
		// Farbe pro Zeile gesamt
		int g1 = 0; 
		int p = 0; 
		int[] g2 = new int[16]; 
		
		for(int j = 0; j < 256; j += 16) {
			for(int i = j ; i < (j+ 16); i++) {
				LedColor n = service.color(i); 
				if(n.equals(LedColor.GREEN)) {
					g1++; 
				}
			}
			
			// Zeile
			g2[p] = g1; 
			p++;
		}
		
		// Farben pro Zeile berechnen effektiv
		int[] g3 = new int[16]; 
		for(int i = 0; i < 15; i++) {
			g3[i+1] = g2[i+1] - g2[i];
		}
		g3[0] = g2[0]; 
		
		// Auswertung pro Zeile effektiv
		int max = 0; 
		int index = 0; 
		
		for(int i = 0; i < 16; i++) {
			int value = g3[i]; 
			
			if(value >= max) {
				max = value; 
				index = i; 
			}
		}
		
		//RED
		// Farbe pro Zeile gesamt
		int r1 = 0; 
		int p2 = 0; 
		int[] r2 = new int[16]; 
		
		for(int j = 0; j < 256; j+= 16) {
		for(int i = j ;i< j+ 16; i++) {
			LedColor n = service.color(i); 
			if(n.equals(LedColor.RED)) {
				r1++ ; 
				}
			}
	
			r2[p2] = r1; 
			p2++; 
		}
		
		// Farben pro Zeile berechnen effektiv
		int[] r3 = new int[16]; 
		for(int i = 0; i< 15; i++) {
			r3[i+1] = r2[i+1] - r2[i]; 
		}
		r3[0] = r2[0]; 
		
		// Auswertung pro Zeile effektiv
		int maxr = 0; 
		int indexr = 0; 
		
		for(int i = 0; i < 16; i++) {
			int value = r3[i]; 
			if(value >= maxr) {
				maxr = value; 
				indexr = i; 
			}
		}
		
		//YELLOW
		// Farbe pro Zeile gesamt
		int y1 = 0; 
		int p3 = 0; 
		int[] y2 = new int[16]; 
		
		for(int j = 0; j < 256; j+= 16) {
		for(int i = j ;i< j+ 16; i++) {
			//System.out.println(service.color(i));
			LedColor n = service.color(i); 
			if(n.equals(LedColor.YELLOW)) {
				y1++ ; 
				}
			}
	
			y2[p3] = y1; 
			p3++; 
		}
		
		// Farben pro Zeile berechnen effektiv
		int[] y3 = new int[16]; 
		for(int i = 0; i< 15; i++) {
			y3[i+1] = y2[i+1] - y2[i]; 
		}
		y3[0] = y2[0];
		
		// Auswertung pro Zeile effektiv
		int maxy = 0; 
		int indexy = 0; 
		
		for(int i = 0; i < 16; i++) {
			int value = y3[i]; 
			if(value >= maxy) {
				maxy = value; 
				indexy = i; 
			}
		}
		
		//BLUE
		// Farbe pro Zeile gesamt
		int b1 = 0; 
		int p4 = 0; 
		int[] b2 = new int[16]; 
		
		for(int j = 0; j < 256; j+= 16) {
		for(int i = j ;i< j+ 16; i++) {
			LedColor n = service.color(i); 
			if(n.equals(LedColor.BLUE)) {
				b1++ ; 
				}
			}
	
			b2[p4] = b1; 
			p4++; 
		}
		
		// Farben pro Zeile berechnen effektiv
		int[] b3 = new int[16]; 
		for(int i = 0; i< 15; i++) {
			b3[i+1] = b2[i+1] - b2[i]; 
		}
		b3[0] = b2[0];
		
		// Auswertung pro Zeile effektiv
		int maxb = 0; 
		int indexb = 0; 
		
		for(int i = 0; i < 16; i++) {
			int value = b3[i]; 
			if(value >= maxb) {
				maxb = value; 
				indexb = i; 
			}
		}
		
		// Ausgabe der Werte
		System.out.println("-------------------");
		System.out.println("BLUE   " + maxb +" LEDS"); 
		System.out.println("In der Zeile-Nr " + indexb); 
		System.out.println("-------------------"); 
		System.out.println("GREEN  " + max +" LEDS"); 
		System.out.println("In der Zeile-Nr " + index);
		System.out.println("-------------------");
		System.out.println("RED    " + maxr +" LEDS"); 
		System.out.println("In der Zeile-Nr " + indexr);
		System.out.println("-------------------");
		System.out.println("YELLOW " + maxy +" LEDS"); 
		System.out.println("In der Zeile-Nr " + indexy);
		System.out.println("-------------------");
		System.out.println("BLUE   " + maxb +" LEDS"); 
		System.out.println("In der Zeile-Nr " + indexb);
		System.out.println("-------------------");
	}
	
	public static void main(String[] args) {
		// Instanz der LEDService (Objekt)
		LedService service = new LedService();
						
		// Methode aufrufen und: Instanz übergeben
		countColorsExt(service);
	}
}
