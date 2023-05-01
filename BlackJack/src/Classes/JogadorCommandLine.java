package Classes;
import java.util.Scanner;

import Estados.JogadorState;

public class JogadorCommandLine extends JogadorAposta {
	
	private final static String HIT = "H";
	private final static String STAND = "S";
	private final static String MSG = "[H]it ou [S]tay";
	private final static String BET_MSG = "Apostar valor: [10] [50] ou [100]";
	private final static String BET_10 = "10";
	private final static String BET_50 = "50";
	private final static String BET_100 = "100";
	private final static String DOUBLEBET_MSG = "Dobrar aposta? [S]im ou [N]ão";
	private final static String DOUBLEBET_YES = "S";
	private final static String DOUBLEBET_NO = "N";
	private final static String DEFAULT = "invalido";

	public JogadorCommandLine(Mao mao, String nome,Banco banco) {
		super(mao, nome, banco);
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

	@Override
	protected void apostar() {
		while(true) {
			Console.INSTANCE.print(BET_MSG);
			String response = Console.INSTANCE.readInput(DEFAULT);
			
			if (response.equals(BET_10)) {
				getBanco().apostar10();
				return;
			}
			
			if (response.equals(BET_100)) {
				getBanco().apostar100();
				return;
			}
			
			if (response.equals(BET_50)) {
				getBanco().apostar50();
				return;
			}
		}
		
	}
	
	@Override
	protected boolean dobrarAposta() {
		while(true) {
			Console.INSTANCE.print(DOUBLEBET_MSG);
			String response = Console.INSTANCE.readInput(DEFAULT);
			
			if (response.equals(DOUBLEBET_YES)) {
				getBanco().dobrarAposta();
				return true;
			}
			
			if (response.equals(BET_100)) {
				return false;
			}
			
		
		}
		
	}

	@Override
	public JogadorState getCurrentState() {
		return estado_atual;
	}

	
	
	

}
