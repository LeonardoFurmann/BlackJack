package Classes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Maco {
	
	private ArrayList stack = new ArrayList();
	private int index;
	private Random aleatorio = new Random();
	
	public void addCartas(Carta[] cartas) {
		for(int i= 0; i < cartas.length; i++) {
			stack.add(cartas[i]);
		}
	}
	
	public void embaralhar() {
		reset();
		randomize();
		randomize();
		randomize();
		randomize();
		randomize();
	}
	
	private void randomize() {
		int num_cartas = stack.size();
		for (int i = 0; i < num_cartas; i++) {
			int index = aleatorio.nextInt(num_cartas);
			Carta carta_i = (Carta) stack.get(i);
			Carta carta_index = (Carta) stack.get(index);
			stack.set(i, carta_index);
			stack.set(i, carta_i);
		}
		
	}

	private void reset() {
		index = 0;
		
		Iterator i = stack.iterator();
		
		while(i.hasNext()) {
			Carta carta = (Carta) i.next();
			carta.faceDown();
		}	
	}
	
	private Carta deal() {
		if(index != stack.size()) {
			Carta carta = (Carta) stack.get(index);
			index++;
			return carta;
		}
		return null;
	}
	

	public Carta viraBaixo() {
		Carta carta = deal();
		if(carta != null) {
			carta.faceDown();
		}
		
		return carta;
	}
	

	public Carta viraCima() {
		Carta carta = deal();
		if(carta != null) {
			carta.faceUp();
		}
		return carta;
	}
	
	

}
