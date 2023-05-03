package GUI_PAC;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Iterator;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Classes.Banco;
import Classes.Jogador;
import Classes.JogadorAposta;
import Classes.Mao;
import Estados.JogadorState;
import Listeners.JogadorListener;

public abstract class VJogadorAposta extends JogadorAposta implements Displayable{
	
	private ApostaView view;
	

	public VJogadorAposta(Mao mao, String nome, Banco banco) {
		super(mao, nome, banco);
	}

	@Override
	public JComponent view() {
		
		if (view == null) {
			view = new ApostaView((VMao)getMao());
			addListener(view);
		}
			
		return view;
	}

	private class ApostaView extends JPanel implements JogadorListener{
		
		private TitledBorder border;
		
		public ApostaView(VMao mao) {
			super(new FlowLayout(FlowLayout.LEFT));
			buildGUI(mao.view());
		}

		@Override
		public void jogadorMudou(Jogador jogador) {
			String nome = VJogadorAposta.this.getNome();
			border.setTitle(nome);
			repaint();
		}

		@Override
		public void jogadorEstourou(Jogador jogador) {
			String nome = VJogadorAposta.this.getNome();
			border.setTitle(nome + "ESTOUROU");
			repaint();
		}

		@Override
		public void jogadorBlackjack(Jogador jogador) {
			String nome = VJogadorAposta.this.getNome();
			border.setTitle(nome + "BLACKJACK");
			repaint();
		}

		@Override
		public void jogadorPassou(Jogador jogador) {
			String nome = VJogadorAposta.this.getNome();
			border.setTitle(nome + "Passou...");
			repaint();
		}

		@Override
		public void jogadorGanhou(Jogador jogador) {
			String nome = VJogadorAposta.this.getNome();
			border.setTitle(nome + "GANHOU");
			repaint();
		}

		@Override
		public void jogadorPerdeu(Jogador jogador) {
			String nome = VJogadorAposta.this.getNome();
			border.setTitle(nome + "Perdeu...");
			repaint();
		}

		@Override
		public void jogadorSaiu(Jogador jogador) {
			String nome = VJogadorAposta.this.getNome();
			border.setTitle(nome + "Saiu...");
			repaint();
		}
		
		private void buildGUI(JComponent mao) {
			border = new TitledBorder(VJogadorAposta.this.getNome());
			setBorder(border);
			setBackground(new Color(35,142,35));
			border.setTitleColor(Color.black);
			add(mao);
		}
		
	}

}
