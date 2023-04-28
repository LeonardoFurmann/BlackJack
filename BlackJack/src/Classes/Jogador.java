package Classes;
import java.util.ArrayList;
import java.util.Iterator;
import Estados.JogadorState;
import Listeners.JogadorListener;

public abstract class Jogador {
	
	private Mao mao;
	private String nome;
	private ArrayList listeners = new ArrayList();
	private JogadorState estado_atual; 
	
	public Jogador(Mao mao, String nome) {
		super();
		this.mao = mao;
		this.nome = nome;
	}
	
	public void addCarta(Carta carta) {
		mao.addCarta(carta);
		notifyChanged();
	}
	
	public void jogar(Dealer dealer) {
		
		estado_atual.execute(dealer);
		
//		while( !(estourou() &&hit())) {
//			dealer.hit(this);
//		}
//		paraJogar(dealer);
	}
	
	protected abstract boolean hit();
	

	public void reset() {
		mao.reset();
	}
	
	public boolean estourou() {
		return mao.estourou();
	}
	
	public String toString() {
		return (nome + ":" + mao.toString());
	}
	
	protected Mao getMao() {
		return mao;
	}
	
//	protected void paraJogar(Dealer dealer) {
//		dealer.passaTurno();
//	}
	
	public JogadorState getCurrentState(){
		return estado_atual;
	}
	
	public void setCurrentState(JogadorState jogadorState) {
		estado_atual = jogadorState;
	}
	
	public void addListener(JogadorListener  l) {
		listeners.add(l);
	}
	
	protected void notifyChanged() {
		Iterator i = listeners.iterator();
		while(i.hasNext()) {
			JogadorListener  pl = (JogadorListener )i.next();
			pl.jogadorMudou(this);
		}
	}
	
	protected void notifyBusted() {
		Iterator i = listeners.iterator();
		while(i.hasNext()) {
			JogadorListener  pl = (JogadorListener )i.next();
			pl.jogadorEstourou(this);
		}
	}
	
	protected void notifyBlackjack() {
		Iterator i = listeners.iterator();
		while(i.hasNext()) {
			JogadorListener  pl = (JogadorListener )i.next();
			pl.jogadorBlackjack(this);
		}
	}
	
	protected void notifyWin() {
		Iterator i = listeners.iterator();
		while(i.hasNext()) {
			JogadorListener  pl = (JogadorListener )i.next();
			pl.jogadorGanhou(this);
		}
	}
	
	protected void notifyLose() {
		Iterator i = listeners.iterator();
		while(i.hasNext()) {
			JogadorListener  pl = (JogadorListener )i.next();
			pl.jogadorPerdeu(this);
		}
	}
	
	protected void notifyStandoff() {
		Iterator i = listeners.iterator();
		while(i.hasNext()) {
			JogadorListener  pl = (JogadorListener )i.next();
			pl.jogadorSaiu(this);
		}
	}
	
	protected void notifyStanding() {
		Iterator i = listeners.iterator();
		while(i.hasNext()) {
			JogadorListener  pl = (JogadorListener )i.next();
			pl.jogadorFicou(this);
		}
	}
	
	protected void notifyListeners() {
		Iterator i = listeners.iterator();
		while(i.hasNext()) {
			JogadorListener  pl = (JogadorListener )i.next();
			
			
			pl.jogadorFicou(this);
		}
	}
	
	public void win() {
		notifyWin();
	}
	
	public void lose() {
		notifyLose();
	}
	
	public void standoff() {
		notifyStandoff();
	}
	
	public void blackjack() {
		notifyBlackjack();
	}
	
	protected JogadorState getBustedState() {
		return new Busted();
	}
	
	protected JogadorState getStandingState() {
		return new Standing();
	}
	
	protected JogadorState getWaitingState() {
		return new Waiting();
	}
	
	protected JogadorState getBlackJackState() {
		return new Blackjack();
	}
	
	protected JogadorState getPlayingState() {
		return new Playing();
	}
	
	protected JogadorState getInitialState() {
		return new Waiting();
	}
	

private class Waiting implements JogadorState{
	
	
	public void maoMudou() {
		notifyChanged();
		
	}

	@Override
	public void maoJogavel() {
		setCurrentState(getPlayingState());
		
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
	public void execute(Dealer dealer) {
		
	}
	
	}

private class Busted implements JogadorState{
	
	

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
		dealer.estourou(Jogador.this);
	}
}

private class Blackjack implements JogadorState{

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
		dealer.blackjack(Jogador.this);
	}
}

private class Standing implements JogadorState{

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
		
		dealer.passou(Jogador.this);
		
	}

}

private class Playing implements JogadorState{

	@Override
	public void maoJogavel() {
	}

	@Override
	public void maoBlackJack() {
	}

	@Override
	public void maoEstourou() {
		setCurrentState(getBustedState());
		notifyBusted();	
	}

	@Override
	public void maoMudou() {
		notifyChanged();
	}

	@Override
	public void execute(Dealer dealer) {
		if(hit()) {
			dealer.hit(Jogador.this);
		} else {
			setCurrentState(getStandingState());
			notifyStanding();
		}
		
	}

}

}

