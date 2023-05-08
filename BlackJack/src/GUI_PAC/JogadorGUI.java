package GUI_PAC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Classes.Banco;
import Classes.BlackJackDealer;
import Classes.Dealer;
import Classes.Jogador;
import Classes.JogadorAposta;
import Classes.Mao;
import Estados.JogadorState;
import GUI_MVC.VCarta;
import Listeners.JogadorListener;

public  class JogadorGUI extends VJogadorAposta implements Displayable{
	
	public BlackJackDealer dealer;
	public JPanel view;
	
	public JogadorGUI(Mao mao, String nome, Banco banco, VBlackJackDealer vBlackJackDealer) {
		super(mao, nome, banco);
	}

	
	public JComponent view() {
		if (view == null) {
			view = new JPanel( new BorderLayout());
			JComponent pv = super.view();
			JogadorView Jview = new JogadorView();
			addListener(Jview);
			view.add(pv, BorderLayout.CENTER);
			view.add(Jview, BorderLayout.SOUTH);
			
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
	
	private class JogadorView extends JPanel implements JogadorListener, ActionListener{
		
		private JButton apostar10 = new JButton("$10");
		private JButton apostar50 = new JButton("$50");
		private JButton apostar100 = new JButton("$100");
		private JButton jogar = new JButton("Novo jogo");
		private JButton sair = new JButton("Sair");
		private JButton novaCarta = new JButton("Nova Carta");
		private JButton passar = new JButton("Passar");
		private JButton dobrar = new JButton("Dobrar Aposta");
		
		private final String NOVO_JOGO = "novo";
		private final String SAIR = "sair";
		private final String NOVA_CARTA = "NCarta";
		private final String PASSAR = "passar";
		private final String APOSTAR_10 = "apostar10";
		private final String APOSTAR_50 = "apostar50";
		private final String APOSTAR_100 = "apostar100";
		private final String DOBRAR = "dobrar";
		
		private final Color FORREST_GREEN = new Color(35,142,35);
		
		public JogadorView() {
			super(new BorderLayout());
			JogadorView.this.addListener(this);
			buildGUI();
		}

		private void buildGUI() {
			JPanel controleApostas = new JPanel();
			JPanel controleJogo= new JPanel();
			
			add(controleApostas, BorderLayout.NORTH);
			add(controleJogo, BorderLayout.SOUTH);
			
			controleApostas.setBackground(FORREST_GREEN);
			controleJogo.setBackground(FORREST_GREEN);
			jogar.setActionCommand(NOVO_JOGO);
			jogar.addActionListener(this);
			sair.setActionCommand(SAIR);
			sair.addActionListener(this);
			novaCarta.setActionCommand(NOVA_CARTA);
			novaCarta.addActionListener(this);
			passar.setActionCommand(PASSAR);
			passar.addActionListener(this);
			apostar10.setActionCommand(APOSTAR_10);
			apostar10.addActionListener(this);
			apostar50.setActionCommand(APOSTAR_50);
			apostar50.addActionListener(this);
			apostar100.setActionCommand(APOSTAR_100);
			apostar100.addActionListener(this);
			dobrar.setActionCommand(DOBRAR);
			dobrar.addActionListener(this);
			
			controleApostas.add(apostar10);
			controleApostas.add(apostar50);
			controleApostas.add(apostar100);
			controleJogo.add(jogar);
			controleJogo.add(novaCarta);
			controleJogo.add(passar);
			controleJogo.add(sair);
			controleJogo.add(dobrar);
			
			enableControleApostas(false);
			enableControleJogador(false);
			enableDobrarAPosta(false);
			//enableControleJogo(false);
			
		}

		private void enableDobrarAPosta(boolean b) {
			dobrar.setEnabled(b);
			
		}

		private void enableControleJogador(boolean b) {
			novaCarta.setEnabled(b);
			passar.setEnabled(b);
			
		}

		private void enableControleApostas(boolean b) {
			apostar10.setEnabled(b);
			apostar50.setEnabled(b);
			apostar100.setEnabled(b);
			
		}
		
		private void enableControleJogo(boolean b) {
			jogar.setEnabled(b);
			sair.setEnabled(b);
			
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals(SAIR)) {
				System.exit(0);
			}else if (event.getActionCommand().equals(NOVA_CARTA)) {
				enableDobrarAPosta(false);
				takeCarta();
			}else if (event.getActionCommand().equals(PASSAR)) {
				enableDobrarAPosta(false);
				ficar();
			}else if (event.getActionCommand().equals(NOVO_JOGO)) {
				enableDobrarAPosta(false);
				enableControleJogo(false);
				enableControleJogador(false);
				enableControleApostas(false);
				dealer.novoJogo();
			}else if (event.getActionCommand().equals(APOSTAR_10)) {
				enableDobrarAPosta(true);
				enableControleJogador(false);
				enableControleApostas(false);
				apostar10();
			}else if (event.getActionCommand().equals(APOSTAR_50)) {
				enableDobrarAPosta(true);
				enableControleJogador(false);
				enableControleApostas(false);
				apostar50();
			}else if (event.getActionCommand().equals(APOSTAR_100)) {
				enableDobrarAPosta(true);
				enableControleJogador(false);
				enableControleApostas(false);
				apostar100();
			}else if (event.getActionCommand().equals(DOBRAR)) {
				enableDobrarAPosta(false);
				enableControleJogador(false);
				dobrarAposta();
			}
				
			
		}

		@Override
		public void jogadorMudou(Jogador jogador) {	}

		@Override
		public void jogadorEstourou(Jogador jogador) {
			enableControleJogador(false);
			enableControleJogo(true);
			
		}

		@Override
		public void jogadorBlackjack(Jogador jogador) {
			enableDobrarAPosta(false);
			enableControleJogador(false);
			enableControleJogo(true);
			
		}

		@Override
		public void jogadorPassou(Jogador jogador) {
			enableControleJogador(false);
			enableControleJogo(true);
		}

		@Override
		public void jogadorGanhou(Jogador jogador) {
			enableControleJogador(false);
			enableControleJogo(true);
		}

		@Override
		public void jogadorPerdeu(Jogador jogador) {
			enableControleJogador(false);
			enableControleJogo(true);
			enableDobrarAPosta(false);
		}

		@Override
		public void jogadorSaiu(Jogador jogador) {
			enableControleJogador(false);
			enableControleJogo(true);
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

	@Override
	protected boolean hit() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public JogadorState getCurrentState() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
