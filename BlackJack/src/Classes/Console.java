package Classes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Listeners.JogadorListener;

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
	public void jogadorMudou(Jogador jogador) {
		print(jogador.toString());
		
	}
	
	public void jogadorEstourou(Jogador jogador) {
		print(jogador.toString() + "ESTOUROU");
		
	}
	
	public void jogadorBlackjack(Jogador jogador) {
		print(jogador.toString() + "21!");
		
	}
	
	public void jogadorFicou(Jogador jogador) {
		print(jogador.toString() + "FICOU");
		
	}
	public void jogadorGanhou(Jogador jogador) {
		print(jogador.toString() + "GANHOU");
		
	}
	
	public void jogadorPerdeu(Jogador jogador) {
		print(jogador.toString() + "PERDEU");
		
	}
	
	public void jogadorSaiu(Jogador jogador) {
		print(jogador.toString() + "SAIU");
		
	}
}
