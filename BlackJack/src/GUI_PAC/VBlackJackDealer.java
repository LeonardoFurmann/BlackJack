package GUI_PAC;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Classes.BlackJackDealer;
import Classes.Jogador;
import Classes.Maco;
import Classes.Mao;
import Listeners.JogadorListener;


public class VBlackJackDealer extends BlackJackDealer implements Displayable{
	
	private DealerView view;

	public VBlackJackDealer(Mao mao, String nome, Maco maco) {
		super(mao, nome, maco);
	}

	@Override
	public JComponent view() {
		if (view == null) {
			view = new DealerView((VMao)getMao());
			addListener(view);
		}
			
		return view;
	}
	
	
	private class DealerView extends JPanel implements JogadorListener{
		
		private TitledBorder border;
		
		public DealerView(VMao mao) {
			super(new FlowLayout(FlowLayout.LEFT));
			border = new TitledBorder(VBlackJackDealer.this.getNome());
			setBorder(border);
			setBackground(new Color(35,142,35));
			border.setTitleColor(Color.black);
			add(mao.view());
			repaint();
		}

		@Override
		public void jogadorMudou(Jogador jogador) {
			String nome = VBlackJackDealer.this.getNome();
			border.setTitle(nome);
			repaint();
		}

		@Override
		public void jogadorEstourou(Jogador jogador) {
			String nome = VBlackJackDealer.this.getNome();
			border.setTitle(nome + "ESTOUROU");
			repaint();
		}

		@Override
		public void jogadorBlackjack(Jogador jogador) {
			String nome = VBlackJackDealer.this.getNome();
			border.setTitle(nome + "BLACKJACK");
			repaint();
		}

		@Override
		public void jogadorPassou(Jogador jogador) {
			String nome = VBlackJackDealer.this.getNome();
			border.setTitle(nome + "Passou...");
			repaint();
		}

		@Override
		public void jogadorGanhou(Jogador jogador) {
			String nome = VBlackJackDealer.this.getNome();
			border.setTitle(nome + "GANHOU");
			repaint();
		}

		@Override
		public void jogadorPerdeu(Jogador jogador) {
			String nome = VBlackJackDealer.this.getNome();
			border.setTitle(nome + "Perdeu...");
			repaint();
		}

		@Override
		public void jogadorSaiu(Jogador jogador) {
			String nome = VBlackJackDealer.this.getNome();
			border.setTitle(nome + "Saiu...");
			repaint();
		}
		
	}
}
