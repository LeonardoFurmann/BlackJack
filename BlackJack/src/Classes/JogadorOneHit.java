package Classes;

import Estados.JogadorState;

public class JogadorOneHit extends JogadorAposta{
	
	private boolean hitUmaVez = false;

	public JogadorOneHit(Mao mao, String nome, Banco banco) {
		super(mao, nome, banco);
	}

	@Override
	protected void apostar() {
		getBanco().apostar10();	
	}

	@Override
	protected boolean hit() {
		if (!hitUmaVez) {
			hitUmaVez = true;
		}	
		return false;
	}
	
	public void reset() {
		super.reset();
		hitUmaVez = false;
	}

	@Override
	public JogadorState getCurrentState() {
		return null;
	}

	@Override
	protected boolean dobrarAposta() {
		return false;
	}
}
