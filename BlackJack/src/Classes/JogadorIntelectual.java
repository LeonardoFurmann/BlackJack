package Classes;

import Estados.JogadorState;

public class JogadorIntelectual extends JogadorAposta {
	
	public Dealer dealer;
	
	public JogadorIntelectual(Mao mao, String nome, Banco banco) {
		super(mao, nome, banco);
	}

	@Override
	protected void apostar() {
		getBanco().apostar10();	
	}
	
	@Override
	protected boolean hit() {
		
		Carta carta = dealer.cartaAberta();
		
		if (getMao().total() > 15) {
			return false;
		} else if (getMao().total() == 11) {
			return true;
		} else if (getMao().total() <= 15 || getMao().total() > 11 ) {
			
			if (carta.getNumero().getRank() > 7) {
				return true;
			} else {
				return false;
			}
		}
		
		
		return false;
	}
	
	
	

	@Override
	public JogadorState getCurrentState() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected boolean dobrarAposta() {
		if (getMao().total() == 10 || getMao().total() == 11 ) {
			return true;			
		} else {		
		return false;	
		}
	}

}