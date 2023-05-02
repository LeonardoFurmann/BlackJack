package GUI_PAC;

import javax.swing.JComponent;

import Classes.Carta;
import Classes.Naipe;
import Classes.Numero;


import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class VCarta extends Carta implements Displayable{
	
	String imagem;
	private CartaView view;
	
	
	public VCarta(Numero numero, Naipe naipe,String imagem) {
		super(numero, naipe);
		this.imagem = imagem;
		view = new CartaView(getImagem());
	}

	private String getImagem() {
		if (isFaceUp()) {
			return imagem;
		}else {
			return "/empty_pile.png";
		}
	}
	

	public void setFaceUp(boolean up) {
		super.faceUp();
		view.changed();
	}
	
	public JComponent view() {
		return view;
	}
	
	private class CartaView extends JLabel {
		
		public CartaView(String imagem) {
			setImagem(imagem);
			setBackground(Color.white);
			setOpaque(true);
		}
		
		public void changed() {
			setImagem(getImagem());
		}
		
		private void setImagem(String imagem) {
			java.net.URL url = this.getClass().getResource(imagem);
			ImageIcon icon = new ImageIcon(url);
			setIcon(icon);
		}

	}

	
	
}