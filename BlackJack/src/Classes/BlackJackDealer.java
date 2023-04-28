package Classes;
import java.util.ArrayList;
import java.util.Iterator;

import Estados.JogadorState;

public class BlackJackDealer extends Jogador implements Dealer{
	
	private Maco maco;
	private ArrayList jogadores = new ArrayList();
	private ArrayList estourou_jogadores = new ArrayList();
	private ArrayList blackjack_jogadores = new ArrayList();
	private ArrayList passou_jogadores = new ArrayList();
	private ArrayList jogadores_esperando = new ArrayList();
	
	private int jogador_index;
	
	public BlackJackDealer(Mao mao, String nome,Maco maco) {
		super(mao, nome);
		this.maco = maco;
	}
	
	@Override
	protected boolean hit() {
		if (getMao().total() <= 16) {
			return true;
		}
			return false;
	}
	
	@Override
	public void blackjack(Jogador jogador) {
		blackjack_jogadores.add(jogador);
		jogar(this);
	}

	@Override
	public void estourou(Jogador jogador) {
		estourou_jogadores.add(jogador);
		jogar(this);
	}

	@Override
	public void passou(Jogador jogador) {
		passou_jogadores.add(jogador);
		jogar(this);
	}
	
	protected JogadorState getBlackjackState() {
		return new DealerBlackjack();
	}
	
	protected JogadorState getBustedState() {
		return new DealerBusted();
	}
	
	protected JogadorState getStandingState() {
		return new DealerStanding();
	}
	
	protected JogadorState getWaitingState() {
		return new DealerWaiting();
	}
	
	
	public void hit(Jogador jogador) {
		jogador.addCarta(maco.viraCima());
	}
	

//	public void passaTurno() {
//		if(jogador_index != jogadores.size()) {
//			Jogador jogador = (Jogador) jogadores.get(jogador_index);
//			jogador_index++;
//			jogador.jogar(this);
//		} else {
//			this.jogar(this);
//		}
//	}
	
	
	public void addJogador(Jogador jogador) {
		jogadores.add(jogador);
	}
	
	public void jogar(Dealer dealer) {
		mostrarCartas();
		super.jogar(dealer);
	}
	
	public void novoJogo() {
		distribuiCartas();
		//passaTurno();
	}
	
	private void distribuiCartas() {
		maco.embaralhar();
		Jogador[] jogador = new Jogador [jogadores.size()];
		jogadores.toArray(jogador);
		
		for (int i = 0; i < jogador.length; i++) {
			jogador[i].reset();
			jogador[i].addCarta(maco.viraCima());
		}
		
		this.addCarta(maco.viraCima());
		
		for (int i = 0; i < jogador.length; i++) {
			jogador[i].addCarta(maco.viraCima());
		}
		
		this.addCarta(maco.viraBaixo());
	}
	
	public void paraJogar(Dealer dealer) {
	}
	
	private void mostrarCartas() {
		getMao().virarTodas();
		notifyChanged();
	}	
	
	
	
	private class DealerBusted implements JogadorState {
		
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
			
			Iterator i = passou_jogadores.iterator();
			
			while(i.hasNext()) {
				Jogador jogador = (Jogador) i.next();
				jogador.win();
			}
			
			i = blackjack_jogadores.iterator();
			
			while(i.hasNext()) {
				Jogador jogador = (Jogador) i.next();
				jogador.win();
			}
			
			i = estourou_jogadores.iterator();
			
			while(i.hasNext()) {
				Jogador jogador = (Jogador) i.next();
				jogador.lose();
			}
		}
	}
	
	private class DealerBlackjack implements JogadorState {
		
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
				notifyChanged();
			}
		
			@Override
			public void execute(Dealer dealer) {
				
				mostrarCartas();
				Iterator i = jogadores.iterator();
				
				while(i.hasNext()) {
					Jogador jogador = (Jogador) i.next();
					
					if (jogador.getMao().blackjack()) {
						jogador.standoff();
					} else {
						jogador.lose();
					}
				}
			}
		}
	
	private class DealerStanding implements JogadorState {
		
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
			
			Iterator i = passou_jogadores.iterator();
			
			while(i.hasNext()) {
				Jogador jogador = (Jogador) i.next();
				
				if (jogador.getMao().isEqual(getMao())) {
					jogador.standoff();
				} else if (jogador.getMao().isGreaterThan(getMao())) {
					jogador.win();
				} else {
					jogador.lose();
				}
			}
			
			i = blackjack_jogadores.iterator();
			
			while(i.hasNext()) {
				Jogador jogador = (Jogador) i.next();
				jogador.win();
			}
			
			i = estourou_jogadores.iterator();
			
			while(i.hasNext()) {
				Jogador jogador = (Jogador) i.next();
				jogador.lose();
			}
		}
	}
	
	private class DealerWaiting implements JogadorState {
		
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
				if (!jogadores_esperando.isEmpty()) {
					Jogador jogador = (Jogador) jogadores_esperando.get(0);
					jogadores_esperando.remove(jogador);
					jogador.jogar(dealer);					
				} else {
					setCurrentState(getPlayingState());
					mostrarCartas();
					getCurrentState().execute(dealer);
				}
			}
		
	private class DealerDealing implements JogadorState {
			
			@Override
			public void maoJogavel() {
				setCurrentState(getWaitingState());
			}
		
			@Override
			public void maoBlackJack() {
				setCurrentState(getBlackJackState());
				notifyBlackjack();
			}
		
			@Override
			public void maoEstourou() {		
			}
		
			@Override
			public void maoMudou() {
				notifyChanged();
			}
			
			@Override
			public void execute(Dealer dealer) {			
				distribuiCartas();
				getCurrentState().execute(dealer);
				
			}
		}	
	}
	
}

