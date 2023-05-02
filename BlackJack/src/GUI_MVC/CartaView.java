package GUI_MVC;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CartaView extends JLabel {
	
	private ImageIcon icon;
	
	public CartaView(VCarta carta) {
		getimagem(carta.getImagem());
		setIcon(icon);
		setBackground(Color.white);
		setOpaque(true);
	}

	private void getimagem(String imagem) {
		java.net.URL url = this.getClass().getResource(imagem);
		icon = new ImageIcon(url);
	}

}
