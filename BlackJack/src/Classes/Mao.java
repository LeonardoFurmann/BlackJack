package Classes;
import java.util.ArrayList;
import java.util.Iterator;

import Listeners.MaoListener;

public class Mao {
	
	private ArrayList cartas = new ArrayList();
	private static final int BLACKJACK = 21;
	private MaoListener maoListener;
	private int n;
	
	
	public Mao() {
		setMaoListener(
			new MaoListener() {
								
				public void maoMudou() {}
				
				public void maoJogavel() {}
				
				public void maoEstourou() {}
				
				public void maoBlackJack() {}

			}								
		);
	}
	
	
	private void setMaoListener(MaoListener maoListener) {
		this.maoListener=maoListener;
	}
	
	public Iterator getCatas() {
		return cartas.iterator();
	}
	
	public void addCarta(Carta carta) {
		cartas.add(cartas);
		
		maoListener.maoMudou();
		
		if (carta.getNumero() == Numero.AS) {
			n++;
		}
		
		if (blackjack()) {
			maoListener.maoBlackJack();
			return;
		}
		
		if (estourou()) {
			maoListener.maoEstourou();
			return;
		}
		
		if (cartas.size() >= 2) {
			maoListener.maoJogavel();
			return;
		}	
	}
	
	public boolean isEqual(Mao mao) {
		if(mao.total() == this.total()) {
			return true;
		} 
		
		return false;
	}
	
	public boolean isGreaterThan(Mao mao) {
		return this.total() > mao.total();
	}
	
	public boolean blackjack() {
		if(cartas.size() == 2 && total() == BLACKJACK) {
			return true;
		} 	
		return false;
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
		
		int j = n;
		while(total > BLACKJACK &&  j > 0) {
			total = total - 10;
			j--;
		}
		return total;
	}


	public boolean podeDobrar() {
		if (total() + 1 >= BLACKJACK) {
			return true;
		} else {
			return false;
		}		
	}
}
