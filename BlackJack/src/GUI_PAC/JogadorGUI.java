package GUI_PAC;

import java.awt.Component;

import Classes.Banco;
import Classes.Dealer;
import Classes.JogadorAposta;
import Classes.Mao;
import Estados.JogadorState;
import Helpers.NotifyHelper;
import Listeners.JogadorListener;

public class JogadorGUI extends JogadorAposta{
	
	Dealer dealer;

	public JogadorGUI(Mao mao, String nome, Banco banco, VBlackJackDealer vBlackJackDealer) {
		super(mao, nome, banco);
	}

	@Override
	protected void apostar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean dobrarAposta() {
		setCurrentState(getDobrarApostaState());
		getCurrentState().execute(dealer);
		return false;
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

	public Component view() {
		// TODO Auto-generated method stub
		return null;
	}
}
