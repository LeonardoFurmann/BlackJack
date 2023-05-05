
package Classes;

import Estados.JogadorState;

public class JogadorPerfeito extends JogadorAposta {
	
	public Dealer dealer;
	Carta carta = dealer.cartaAberta();
	
	public JogadorPerfeito(Mao mao, String nome, Banco banco) {
		super(mao, nome, banco);
	}

	@Override
	protected void apostar() {
		getBanco().apostar10();	
	}
	
	@Override  // dealer deve vir como parametro
	protected boolean hit() {
		
		if (getMao().total() >= 17) {
	
			return false;
			
		} 
		
		if (getMao().total() == 16) {
				
			if (carta.getNumero().getRank() >= 7 && carta.getNumero().getRank() <= 9) {
				return true;
			} else {
				return false;
			}
			
		} 
		
		if (getMao().total() >= 13 && getMao().total() <= 15){
			
			if (carta.getNumero().getRank() >= 2 && carta.getNumero().getRank() <= 6) {
				return false;
			} else {
				return true;
			}
			
		} 
		
		if (getMao().total() == 12) {
			
			if (carta.getNumero().getRank() >= 4 && carta.getNumero().getRank() <= 6) {
				return false;
			} else {
				return true;
			}
			
		} 
		
		if (getMao().total() <= 11) {
			return true;		
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
		
		if (getMao().total() == 11 ) {
			
			return true;		
		} else if (getMao().total() == 10) {
			
			if (carta.getNumero().getRank() == 10 || carta.getNumero() == carta.getNumero().AS) {
				return true;
			} else {
				return false;
			}
			
		} else if (getMao().total() == 9) {
			
			if (carta.getNumero().getRank() >= 2 && carta.getNumero().getRank() <= 6) {
				return true;
			} else {
				return false;
			}
	} else {
		
			return false;
		}
	}
}

