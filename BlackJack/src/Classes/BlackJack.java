package Classes;

public class BlackJack {
		
	public static void main(String [] args) {
		
		Maco maco = new Maco();
		
		for (int i = 0; i < 4; i++) {
			maco.embaralhar();
			Baralho baralho = new Baralho();
			baralho.addToStack(maco);
			maco.embaralhar();
		}
		
		Mao dealer_mao = new Mao();
		BlackJackDealer dealer = new BlackJackDealer(dealer_mao, "Dealer", maco);
		Mao humano_mao = new Mao();
		Jogador jogador = new JogadorHumano(humano_mao, "Leo", new Banco(1000));
		dealer.addListener(Console.INSTANCE);
		jogador.addListener(Console.INSTANCE);
		dealer.addJogador(jogador);
		dealer.novoJogo();
		
		
	}
}
