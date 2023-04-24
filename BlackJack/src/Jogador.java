import java.util.ArrayList;
import java.util.Iterator;

public abstract class Jogador {
	
	private Mao mao;
	private String nome;
	private ArrayList listeners = new ArrayList();
	
	public Jogador(Mao mao, String nome) {
		super();
		this.mao = mao;
		this.nome = nome;
	}
	
	public void addCarta(Carta carta) {
		mao.addCarta(carta);
		notifyListeners();
	}
	
	public void jogar(Dealer dealer) {
		while( !(estourou() &&hit())) {
			dealer.hit(this);
		}
		paraJogar(dealer);
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
	
	protected void paraJogar(Dealer dealer) {
		dealer.passaTurno();
	}
	
	public void addListener(JogadorListener  l) {
		listeners.add(l);
	}
	
	protected void notifyListeners() {
		Iterator i = listeners.iterator();
		while(i.hasNext()) {
			JogadorListener  pl = (JogadorListener )i.next();
			pl.maoMudou(this);
		}
	}
	

}
