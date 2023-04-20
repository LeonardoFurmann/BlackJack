import java.util.ArrayList;
import java.util.Iterator;

public class Mao {
	
	private ArrayList cartas = new ArrayList();
	private static final int BLACKJACK = 21;
	
	public void addCarta(Carta carta) {
		cartas.add(cartas);
	}
	
	public boolean estourou() {
		if(total() > BLACKJACK) {
			return true;
		}
		return false;
	}
	
	public void reset() {
		cartas.clear();
	}

	public void virarTodas() {
		Iterator i = cartas.iterator();
		while(i.hasNext()) {
			Carta carta = (Carta) i.next();
			carta.faceUp();
		}
	}
	
	public String toString() {
		Iterator i = cartas.iterator();
		String string = "";
		while(i.hasNext()) {
			Carta carta = (Carta) i.next();
			string += " " + carta.toString();
		}
		
		return string;
		
	}
	
	public int total() {
		int total = 0;
		Iterator i = cartas.iterator();
		while(i.hasNext()) {
			Carta carta = (Carta) i.next();
			total +=  carta.getNumero().getRank();
		}
		return total;
	}
}
