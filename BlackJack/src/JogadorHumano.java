import java.util.Scanner;

public class JogadorHumano extends Jogador {
	
	private final static String HIT = "H";
	private final static String STAND = "S";
	private final static String MSG = "[H]it or [S]tay";
	private final static String DEFAULT = "invalido";

	public JogadorHumano(Mao mao, String nome) {
		super(mao, nome);
	}

	@Override
	protected boolean hit() {
		while(true) {
			Console.INSTANCE.print(MSG);
			String response = Console.INSTANCE.readInput(DEFAULT);
				if(response.equalsIgnoreCase(HIT)) {
					return true;
				} else if (response.equalsIgnoreCase(STAND)) {
					return false;
				}
		}
		
	}

}
