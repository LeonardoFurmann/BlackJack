package Classes;
import java.util.Iterator;

public class Baralho {
	
	private Carta[] baralho;
	private int index;
	
	public Baralho() {
		buildCartas();
	}
	
	public void addToStack(Maco stack) {
		stack.addCartas(baralho);
	}
	
	protected void buildCartas() {
		
		baralho = new Carta[52];
		
		Iterator<Naipe> naipes = (Iterator<Naipe>) Naipe.NAIPES;
		
		int contador  = 0;
		
		while(naipes.hasNext()) {
			Naipe naipe = (Naipe) naipes.next();
			Iterator numeros = (Iterator) Numero.NUMEROS;
			while(numeros.hasNext()) {
				Numero numero = (Numero) numeros.next();
				baralho[contador] = new Carta(numero,naipe);
				contador++;
			}
		}
	}

}
