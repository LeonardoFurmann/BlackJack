package Listeners;
import Classes.Jogador;


public interface JogadorListener {
	
	
	public void jogadorMudou(Jogador jogador);
	
	public void jogadorEstourou(Jogador jogador);
	
	public void jogadorBlackjack(Jogador jogador);
	
	public void jogadorPassou(Jogador jogador);
	
	public void jogadorGanhou(Jogador jogador);
	
	public void jogadorPerdeu(Jogador jogador);
	
	public void jogadorSaiu(Jogador jogador);

}
