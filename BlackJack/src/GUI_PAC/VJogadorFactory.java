package GUI_PAC;

import Classes.Banco;
import Classes.Baralho;
import Classes.Jogador;
import Classes.JogadorAposta;
import Classes.JogadorSeguro;
import Classes.Maco;
import Classes.Mao;
import GUI_PAC.VBaralho;

public class VJogadorFactory {
	
	private VBlackJackDealer dealer;
	private JogadorGUI jogador;
	private Maco maco;
	
	public VBlackJackDealer getDealer() {
		if (dealer == null) {
			VMao dealer_mao = getMao();
			Maco cartas = getCartas();
			dealer = new VBlackJackDealer(dealer_mao, "Dealer", cartas);
		}
		return dealer;
	}
	
	private Maco getCartas() {
		if (maco == null) {
			maco = new Maco();
			for (int i = 0; i < 4; i++) {
				maco.embaralhar();
				Baralho baralho = new VBaralho();
				baralho.addToStack(maco);
				maco.embaralhar();
				
			}
		}
		return maco;
	}

	public JogadorGUI getJogador() {
		if (jogador == null) {
			VMao jogador_mao = getMao();
			Banco banco = new Banco(1000);
			jogador = new JogadorGUI(jogador_mao, "leo", banco ,getDealer());
		}
		return jogador;
	}
	
	public Jogador getJogadorSeguro() {
		Mao mao_segura = new Mao();
		Banco banco_seguro = new Banco(1000);
		return new JogadorSeguro(mao_segura, "Safe", banco_seguro);
		
	}

	private VMao getMao() {
		return new VMao();
	}
}
