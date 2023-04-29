package Classes;
import java.util.ArrayList;
import java.util.Iterator;
import Estados.JogadorState;
import Helpers.NotifyHelper;
import Listeners.JogadorListener;

public abstract class Jogador {
	
	private Mao mao;
	private String nome;
	private ArrayList listeners = new ArrayList();
	protected JogadorState estado_atual; 
	
	public Jogador(Mao mao, String nome) {
		super();
		this.mao = mao;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void addCarta(Carta carta) {
		mao.addCarta(carta);
		notifyListeners(new NotifyChanged());
	}
	
	public void jogar(Dealer dealer) {
		
		estado_atual.execute(dealer);

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
	
	public abstract JogadorState getCurrentState();

	public void setCurrentState(JogadorState jogadorState) {
		estado_atual = jogadorState;
	}
	
	public void addListener(JogadorListener  l) {
		listeners.add(l);
	}
	

	protected void notifyListeners(NotifyHelper helper) {
		Iterator i = listeners.iterator();
		while(i.hasNext()) {
			JogadorListener  pl = (JogadorListener )i.next();
			helper.notifyListener(pl);
		}
	}
	
	public void win() {
		notifyListeners(new NotifyWon());
	}
	
	public void lose() {
		notifyListeners(new NotifyLost());
	}
	
	public void standoff() {
		notifyListeners(new NotifyStandoff());
	}
	
	public void blackjack() {
		notifyListeners(new NotifyBlackjack());
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
	
	
public class NotifyBusted implements NotifyHelper{
	public void notifyListener(JogadorListener pl) {
		pl.jogadorEstourou(Jogador.this);
			
	}
}


public class NotifyBlackjack implements NotifyHelper{
	public void notifyListener(JogadorListener pl) {
		pl.jogadorBlackjack(Jogador.this);
			
	}
}

public class NotifyWon implements NotifyHelper{
	public void notifyListener(JogadorListener pl) {
		pl.jogadorGanhou(Jogador.this);
			
	}
}

public class NotifyLost implements NotifyHelper{
	public void notifyListener(JogadorListener pl) {
		pl.jogadorPerdeu(Jogador.this);
			
	}
}

public class NotifyChanged implements NotifyHelper{
	public void notifyListener(JogadorListener pl) {
		pl.jogadorMudou(Jogador.this);
			
	}
}

public class NotifyStanding implements NotifyHelper{
	public void notifyListener(JogadorListener pl) {
		pl.jogadorPassou(Jogador.this);
			
	}
}

public class NotifyStandoff implements NotifyHelper{
	public void notifyListener(JogadorListener pl) {
		pl.jogadorSaiu(Jogador.this);
			
	}
}
		
		

private class Waiting implements JogadorState{
	
	
	public void maoMudou() {
		notifyListeners(new NotifyChanged());
		
	}

	@Override
	public void maoJogavel() {
		setCurrentState(getPlayingState());
		
	}

	@Override
	public void maoBlackJack() {
		setCurrentState(getBlackJackState());
		notifyListeners(new NotifyBlackjack());
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
		notifyListeners(new NotifyBusted());	
	}

	@Override
	public void maoMudou() {
		notifyListeners(new NotifyChanged());
	}

	@Override
	public void execute(Dealer dealer) {
		if(hit()) {
			dealer.hit(Jogador.this);
		} else {
			setCurrentState(getStandingState());
			notifyListeners(new NotifyStanding());
		}
		
	}

}

}

