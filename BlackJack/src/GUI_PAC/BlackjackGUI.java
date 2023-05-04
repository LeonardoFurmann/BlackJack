package GUI_PAC;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Classes.Banco;
import Classes.Jogador;
import Classes.JogadorSeguro;
import Classes.Mao;

public class BlackjackGUI extends JFrame{
	
	VJogadorFactory factory = new VJogadorFactory();
	
	private JPanel jogadores = new JPanel(new GridLayout(0,1));
	
	public void setUp() {
		
		VBlackJackDealer dealer = factory.getDealer();
		JogadorGUI jogador = factory.getJogador();
		JogadorGUI jogadorSeguro = (JogadorGUI) factory.getJogadorSeguro();
		
		dealer.addJogador(jogador);
		dealer.addJogador(jogadorSeguro);
		jogadores.add(dealer.view());
		jogadores.add(jogador.view());
		getContentPane().add(jogadores, BorderLayout.CENTER);
	}
	
	

}
