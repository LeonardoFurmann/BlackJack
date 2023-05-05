package Classes;

import GUI_PAC.VMao;

public class BlackjackSim {

	public static void main(String[] args) {
		
		int contador = 0;
		
		Console.INSTANCE.print("Quer jogar quantas vezes");
		String resposta = Console.INSTANCE.readInput("invalido");
		int jogos = Integer.parseInt(resposta);
		
		Maco maco = new Maco();
		
		for (int i = 0; i < 4; i++) {
			maco.embaralhar();
			Baralho baralho = new Baralho();
			baralho.addToStack(maco);
			maco.embaralhar();
		}
		
		Mao mao_dealer = new Mao();
		BlackJackDealer dealer = new BlackJackDealer(mao_dealer, "Dealer", maco);
		
		Jogador flip = new JogadorFlip(new Mao(), "Flip", new Banco(1000));
		Jogador safe = new JogadorSeguro(new Mao(), "Safe", new Banco(1000));
		Jogador smart = new JogadorEsperto(new Mao(), "Flip", new Banco(1000));
		Jogador oneHit = new JogadorOneHit(new Mao(), "Flip", new Banco(1000));
		
		dealer.addListener(Console.INSTANCE);
		flip.addListener(Console.INSTANCE);
		smart.addListener(Console.INSTANCE);
		oneHit.addListener(Console.INSTANCE);
		safe.addListener(Console.INSTANCE);
		
		dealer.addJogador(flip);
		dealer.addJogador(smart);
		dealer.addJogador(oneHit);
		dealer.addJogador(safe);

		while(contador < jogos) {
			dealer.novoJogo();
			contador++;
		}
		
	}

}
