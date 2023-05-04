package Classes;

import Estados.JogadorState;

public class JogadorFlip extends JogadorAposta{
	
	private boolean hit = false;
	private boolean hitUmaVez = false;
	
	public JogadorFlip(Mao mao, String nome, Banco banco) {
		super(mao, nome, banco);
	}
	
	@Override
	protected void apostar() {		
		getBanco().apostar10();
	}
	
	@Override
	protected boolean hit() {
		if (hitUmaVez && !hit) {
			hit = true;
			return true;
		}
		return false;
	}
	
	public void reset() {
		super.reset();
		hit = false;
		hitUmaVez = !hitUmaVez;
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
