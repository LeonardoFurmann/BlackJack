package Classes;

import GUI_PAC.VMao;

public class BlackjackSim {

	public static void main(String[] args) {
		
		
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
		BlackJackDealer delaer = new BlackJackDealer(mao_dealer, "Dealer", maco);
		
	}

}
