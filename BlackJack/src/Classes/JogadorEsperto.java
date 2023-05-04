package Classes;

import Estados.JogadorState;

public class JogadorEsperto extends JogadorAposta{

	public JogadorEsperto(Mao mao, String nome, Banco banco) {
		super(mao, nome, banco);
	}

	@Override
	protected void apostar() {
		getBanco().apostar10();
	}

	@Override
	protected boolean hit() {
		if (getMao().total() > 11) {
			return false;
		}
			return true;
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
