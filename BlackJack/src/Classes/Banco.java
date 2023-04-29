package Classes;

public class Banco {
	
	private int total;
	private int aposta;
	
	public Banco(int valor) {
		total = valor;
	}
	
	public void apostar100() {
		apostar(100);
	}
	
	public void apostar50() {
		apostar(50);
	}
	
	public void apostar10() {
		apostar(10);
	}
	
	public void win() {
		total += (2 * aposta);
		aposta = 0;
	}
	
	public void lose() {
		aposta = 0;
	}
	
	public void blackjack() {
		total += (((3 * aposta) / 2) + aposta);
		aposta = 0;
	}
	
	public void standoff() {
		total += aposta;
		aposta = 0;
	}
	
	private void apostar(int valor) {
		aposta = valor;
		total -=aposta;
	}
	
	public String toString() {
		return ("$" + total);
	}

}
