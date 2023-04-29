package Classes;
import java.util.Scanner;

import Estados.JogadorState;

public class JogadorHumano extends JogadorAposta {
	
	private final static String HIT = "H";
	private final static String STAND = "S";
	private final static String MSG = "[H]it or [S]tay";
	private final static String BET_MSG = "Apostar valor: [10] [50] or [100]";
	private final static String BET_10 = "10";
	private final static String BET_50 = "50";
	private final static String BET_100 = "100";
	private final static String DEFAULT = "invalido";

	public JogadorHumano(Mao mao, String nome,Banco banco) {
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
	public JogadorState getCurrentState() {
		return estado_atual;
	}
	
	

}
