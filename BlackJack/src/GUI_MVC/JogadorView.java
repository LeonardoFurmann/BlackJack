package GUI_MVC;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Classes.Carta;
import Classes.Jogador;
import Classes.Mao;

public class JogadorView extends JPanel{
	
	private ArrayList<JLabel> cartas = new ArrayList();
	
	public void jogadorMudou(Jogador jogador) {
		//border.setTitle(jogador.getNome());
		cartas.removeAll(cartas);
		
		Mao mao = jogador.getMao();
		Iterator i = mao.getCatas();
		
		while(i.hasNext()) {
			VCarta vcarta = (VCarta) i.next();
			JLabel carta = new CartaView(vcarta);
			cartas.add(carta);
		}
		revalidate();
		repaint();
	}
	
	public void jogadorEstourou(Jogador jogador) {
		//border.setTitle(jogador.getNome() + "ESTOUROU");
		//cartas.repaint();
	}
	
	public void jogadorBlackjack(Jogador jogador) {
		//border.setTitle(jogador.getNome() + "BLACKJACK");
		//cartas.repaint();
	}

}
