import java.awt.List;
import java.util.Arrays;
import java.util.Collections;

public class Naipe {
	
	public static final Naipe OUROS = new Naipe((char)4);
	public static final Naipe COPAS = new Naipe((char)3);
	public static final Naipe  ESPADAS = new Naipe((char)6);
	public static final Naipe PAUS = new Naipe((char)5);
	
	public static final Naipe[] VALORES= {OUROS,COPAS,ESPADAS,PAUS};
	
	public static final List NAIPES = (List) Collections.unmodifiableList(Arrays.asList(VALORES));
	
	private final char display;
	
	private Naipe(char display) {
		this.display = display;
	}
	
	public String toString() {
		return String.valueOf(display);
	}

}
