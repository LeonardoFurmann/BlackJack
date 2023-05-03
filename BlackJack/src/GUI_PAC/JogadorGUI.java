package GUI_PAC;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Classes.Banco;
import Classes.Dealer;
import Classes.Jogador;
import Classes.JogadorAposta;
import Classes.Mao;
import Estados.JogadorState;
import GUI_MVC.VCarta;
import Listeners.JogadorListener;

public abstract class JogadorGUI extends JogadorAposta implements Displayable{
	
	Dealer dealer;
	JogadorView view;
	
	public JogadorGUI(Mao mao, String nome, Banco banco, VBlackJackDealer vBlackJackDealer) {
		super(mao, nome, banco);
	}

	
	public JComponent view() {
		if (view == null) {
			view = new JogadorView((VMao)getMao());
			addListener(view);
		}
			
		return view;
	}

	
	@Override
	protected void apostar() {
	
	}

	@Override
	protected boolean dobrarAposta() {
		setCurrentState(getDobrarApostaState());
		getCurrentState().execute(dealer);
		return false;
	}

	
	
	public void apostar10() {
		getBanco().apostar10();
		setCurrentState(getWaitingState());
		dealer.terminarAposta(this);
	}
	
	public void apostar50() {
		getBanco().apostar50();
		setCurrentState(getWaitingState());
		dealer.terminarAposta(this);
	}
	
	public void apostar100() {
		getBanco().apostar100();
		setCurrentState(getWaitingState());
		dealer.terminarAposta(this);
	}
	
	public void takeCarta() {
		dealer.hit(this);
	}
	
	public void ficar() {
		setCurrentState(getStandingState());
		notifyListeners(new NotifyStanding());
		getCurrentState().execute(dealer);
	}
	
	protected JogadorState getPlayingState() {
		return new Playing();
		
	}
	
	protected JogadorState getApostaState() {
		return new Aposta();
		
	}
	
	private class JogadorView extends JPanel implements JogadorListener{
		
		private TitledBorder border;
		
		private ArrayList<VCarta> cartas = new ArrayList();

		public JogadorView(VMao mao) {
			super(new FlowLayout(FlowLayout.LEFT));
			border = new TitledBorder(JogadorGUI.this.getNome());
			setBorder(border);
			setBackground(new Color(35,142,35));
			border.setTitleColor(Color.black);
			add(mao.view());
			repaint();
		}
		
		@Override
		public void jogadorMudou(Jogador jogador) {
			String nome = JogadorGUI.this.getNome();
			border.setTitle(nome);
			repaint();
		}

		@Override
		public void jogadorEstourou(Jogador jogador) {
			String nome = JogadorGUI.this.getNome();
			border.setTitle(nome + "ESTOUROU");
			repaint();
		}

		@Override
		public void jogadorBlackjack(Jogador jogador) {
			String nome = JogadorGUI.this.getNome();
			border.setTitle(nome + "BLACKJACK");
			repaint();
		}

		@Override
		public void jogadorPassou(Jogador jogador) {
			String nome = JogadorGUI.this.getNome();
			border.setTitle(nome + "Passou...");
			repaint();
		}

		@Override
		public void jogadorGanhou(Jogador jogador) {
			String nome = JogadorGUI.this.getNome();
			border.setTitle(nome + "GANHOU");
			repaint();
		}

		@Override
		public void jogadorPerdeu(Jogador jogador) {
			String nome = JogadorGUI.this.getNome();
			border.setTitle(nome + "Perdeu...");
			repaint();
		}

		@Override
		public void jogadorSaiu(Jogador jogador) {
			String nome = JogadorGUI.this.getNome();
			border.setTitle(nome + "Saiu...");
			repaint();
		}
		
		
	}
	
	private class Playing implements JogadorState {
		

		@Override
		public void maoJogavel() {		
		}
	
		@Override
		public void maoBlackJack() {
			setCurrentState(getBlackJackState());
			notifyListeners(new NotifyBlackjack());
			getCurrentState().execute(dealer);
		}
	
		@Override
		public void maoEstourou() {
			setCurrentState(getBustedState());
			notifyListeners(new NotifyBusted());
			getCurrentState().execute(dealer);
		}
	
		@Override
		public void maoMudou() {
			notifyListeners(new NotifyChanged());
			
		}
	
		@Override
		public void execute(Dealer dealer) {
		}
	}
	
	private class Aposta implements JogadorState{
		
		@Override
		public void maoJogavel() {
		
		}
	
		@Override
		public void maoBlackJack() {
		
		}
	
		@Override
		public void maoEstourou() {
		
		}
	
		@Override
		public void maoMudou() {	
		}
	
		@Override
		public void execute(Dealer dealer) {
		}
	}

	
}
