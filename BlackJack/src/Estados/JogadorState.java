package Estados;
import Classes.Dealer;
import Listeners.MaoListener;

public interface JogadorState extends MaoListener{
	
	public void execute(Dealer dealer);
}
