package GUI_MVC;

import Classes.Carta;
import Classes.Naipe;
import Classes.Numero;

public class VCarta extends Carta{
	
	String imagem;
	
	public VCarta(Numero numero, Naipe naipe,String imagem) {
		super(numero, naipe);
		this.imagem = imagem;
	}
	
	public String getImagem() {
		if (isFaceUp()) {
			return imagem;
		} else {
			return "/empty_pile.png";
		}
	}

}
