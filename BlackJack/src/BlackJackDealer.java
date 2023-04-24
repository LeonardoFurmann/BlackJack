import java.util.ArrayList;

public class BlackJackDealer extends Jogador implements Dealer{
	
	
	private Maco maco;
	private ArrayList jogadores = new ArrayList();
	private int jogador_index;
	
	public BlackJackDealer(Mao mao, String nome,Maco maco) {
		super(mao, nome);
		this.maco = maco;
	}
	
	
	public void hit(Jogador jogador) {
		jogador.addCarta(maco.viraCima());
	}
	
	@Override
	public void passaTurno() {
		if(jogador_index != jogadores.size()) {
			Jogador jogador = (Jogador) jogadores.get(jogador_index);
			jogador_index++;
			jogador.jogar(this);
		} else {
			this.jogar(this);
		}
	}
	
	public void addJogador(Jogador jogador) {
		jogadores.add(jogador);
	}
	
	public void jogar(Dealer dealer) {
		mostrarCartas();
		super.jogar(dealer);
	}
	
	public void novoJogo() {
		distribuiCartas();
		passaTurno();
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


	@Override
	protected boolean hit() {
		if (getMao().total() <= 16) {
			return true;
		}
			return false;
	}
	
	private void mostrarCartas() {
		getMao().virarTodas();
		notifyListeners();
	}
	
	
}
