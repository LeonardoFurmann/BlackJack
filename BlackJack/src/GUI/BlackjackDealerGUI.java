package GUI;

import Classes.BlackJackDealer;
import Classes.Dealer;

public class BlackjackDealerGUI {
	
	Dealer dealer;
	
	
	private void setUp() {
	
	BlackJackDealer dealer = null;
	JogadorView v1 = null;
	JogadorView v2 = null;
	JogadorGUI humano = null;
	
	JogadorView[] views =  {v1, v2};
	
	addJogadores(views);
	dealer.addJogador(humano);
	addOptionView(humano, dealer);
	
	
	}

	private void addOptionView(JogadorGUI humano, BlackJackDealer dealer) {
		// TODO Auto-generated method stub
		
	}

	private void addJogadores(JogadorView[] views) {
		// TODO Auto-generated method stub
		
	}
	
}
