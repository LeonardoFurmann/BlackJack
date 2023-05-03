package GUI_PAC;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BlackjackGUI extends JFrame{
	
	VJogadorFactory factory = new VJogadorFactory();
	
	private JPanel jogadores = new JPanel(new GridLayout(0,1));
	
	public void setUp() {
		
		VBlackJackDealer dealer = factory.getDealer();
		JogadorGUI jogador = factory.getJogador();
		
		dealer.addJogador(jogador);
		jogadores.add(dealer.view());
		jogadores.add(jogador.view());
		getContentPane().add(jogadores, BorderLayout.CENTER);
	}

}
