package Classes;
public interface Dealer {
	
	public void hit(Jogador jogador);
	
	public void blackjack(Jogador jogador);
	public void estourou(Jogador jogador);
	public void passou(Jogador jogador);
	public void terminarAposta(Jogador jogador);
}
