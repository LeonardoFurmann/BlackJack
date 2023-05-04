package Classes;

import Estados.JogadorState;

public class JogadorSeguro extends JogadorAposta{

	public JogadorSeguro(Mao mao, String nome, Banco banco) {
		super(mao, nome, banco);
	}

	@Override
	protected void apostar() {
		getBanco().apostar10();	
	}

	@Override
	protected boolean hit() {	
		return false;
	}

	
	@Override
	protected boolean dobrarAposta() {
		return false;
	}

	
	@Override
	public JogadorState getCurrentState() {
		return null;
	}
	
	
}
