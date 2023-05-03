package GUI_PAC;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Classes.Carta;
import Classes.Mao;

public class VMao extends Mao implements Displayable{
	
	private MaoView view = new MaoView();
	
	public JComponent view() {
		return view;
	}
	
	public void addCarta(Carta carta) {
		super.addCarta(carta);
		view.mudou();
	}
	
	public void reset() {
		super.reset();
		view.mudou();
	}
	
	private class MaoView extends JPanel {
		
		public MaoView() {
			super(new FlowLayout(FlowLayout.LEFT));
			setBackground(new Color(35,142,35));
		}
		
		public void mudou() {
			removeAll();
			Iterator i = getCatas();
			while(i.hasNext()) {
				VCarta carta = (VCarta) i.next();
				add(carta.view());
			}
			
			revalidate();
		}
	}

}
