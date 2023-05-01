package Classes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Numero {
	
	public static final Numero DOIS = new Numero(2, "2");
	public static final Numero TRES = new Numero(3, "3");
	public static final Numero QUATRO = new Numero(4, "4");
	public static final Numero CINCO = new Numero(5, "5");
	public static final Numero SEIS = new Numero(6, "6");
	public static final Numero SETE = new Numero(7, "7");
	public static final Numero OITO = new Numero(8, "8");
	public static final Numero NOVE = new Numero(9, "9");
	public static final Numero DEZ = new Numero(10, "10");
	public static final Numero VALETE = new Numero(10, "J");
	public static final Numero RAINHA = new Numero(10, "Q");
	public static final Numero REI = new Numero(10, "K");
	public static final Numero AS = new Numero(11, "A");
	
	private static final Numero[] VALORES = 
		{DOIS,TRES,QUATRO,CINCO,SEIS,SETE,OITO,
				NOVE,DEZ,VALETE,RAINHA,REI,AS};
	
	//lista não modificavel
	public static final ArrayList NUMEROS = (ArrayList) Collections.unmodifiableList(Arrays.asList(VALORES));
	
	private final int rank;
	private final String display;
	
	public Numero(int rank, String display) {
		this.rank = rank;
		this.display = display;
	}
	
	public int getRank() {
		return rank;
	}
	
	public String toString() {
		return display;
	}
}
