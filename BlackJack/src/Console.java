import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console implements JogadorListener{
		
	public final static Console INSTANCE = new Console();
	
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public void print(String mensagem) {
		System.out.println(mensagem);
	}
	
	public String readInput(String default_mensagem) {
		String responseString;
		try {
			return in.readLine();
		} catch(IOException e) {
			return default_mensagem;
		}
	}

	@Override
	public void maoMudou(Jogador jogador) {
		print(jogador.toString());
		
	}
}
