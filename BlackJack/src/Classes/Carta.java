package Classes;

public class Carta {
	
	private Numero numero;
	private Naipe naipe;
	private boolean face_up;
	
	public Carta(Numero numero, Naipe naipe) {
		super();
		this.numero = numero;
		this.naipe = naipe;
	}

	public Numero getNumero() {
		return numero;
	}

	public Naipe getNaipe() {
		return naipe;
	}
	
	public void faceDown() {
		face_up = false;
	}
	
	public void faceUp() {
		face_up = true;
	}
	
	public String display() {
		return numero.toString() + naipe.toString(); 
	}

}
