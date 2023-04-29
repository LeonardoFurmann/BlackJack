package Classes;

import Classes.Jogador.NotifyChanged;
import Estados.JogadorState;

public abstract class JogadorAposta extends Jogador{
	
	private Banco banco;

	public JogadorAposta(Mao mao, String nome, Banco banco) {
		super(mao, nome);
		this.banco = banco;
	}

	
	public String toString() {
		return(getNome() + ": " + getMao().toString() + "\n" + banco.toString());
	}
	
	public void win() {
		banco.win();
		super.win();
	}
	
	public void lose() {
		banco.lose();
		super.lose();
	}
	
	public void standoff() {
		banco.standoff();
		super.standoff();
	}
	
	public void blackjack() {
		banco.blackjack();
		banco.blackjack();
	}
	
	protected final Banco getBanco() {
		return banco;
	}
	
	protected abstract void apostar();
	
	protected abstract boolean dobrarAposta();
	
	protected JogadorState getEstadoInicial() {
		return getApostaState();
	}	
	
	protected JogadorState getApostaState() {
		return new Aposta();
	}
	
	protected JogadorState getDobrarApostaState() {
		return new DobrarAposta();
	}
	
	private class Aposta implements JogadorState {
		

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
			apostar();
			setCurrentState(getWaitingState());
			dealer.terminarAposta( JogadorAposta.this);
		}
	}
	
private class DobrarAposta implements JogadorState {
		

		@Override
		public void maoJogavel() {	
			setCurrentState(getStandingState());
			notifyListeners(new NotifyStanding());
		}
	
		@Override
		public void maoBlackJack() {	
		}
	
		@Override
		public void maoEstourou() {
			setCurrentState(getBustedState());
			notifyListeners(new NotifyBusted());
		}
	
		@Override
		public void maoMudou() {
			notifyListeners(new NotifyChanged());
		}
	
		@Override
		public void execute(Dealer dealer) {
			banco.dobrarAposta();
			dealer.hit(JogadorAposta.this);
			getCurrentState().execute(dealer);
		}
	}

private class ContinuarJogando implements JogadorState {
	

		@Override
		public void maoJogavel() {	
		}
	
		@Override
		public void maoBlackJack() {	
		}
	
		@Override
		public void maoEstourou() {
			setCurrentState(getBustedState());
			notifyListeners(new NotifyBusted());
		}
	
		@Override
		public void maoMudou() {
			notifyListeners(new NotifyChanged());
		}
	
		@Override
		public void execute(Dealer dealer) {
			if(getMao().podeDobrar() && dobrarAposta()) {
				setCurrentState(getDobrarApostaState());
				getCurrentState().execute(dealer);
			}
			
			if(hit()) {
				dealer.hit(JogadorAposta.this);
			} else {
				setCurrentState(getStandingState());
				notifyListeners(new NotifyStanding());
			}
			
			getCurrentState().execute(dealer);
			
		}
	}
}
