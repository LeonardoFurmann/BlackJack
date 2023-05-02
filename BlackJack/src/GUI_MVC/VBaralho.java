package GUI_MVC;

import Classes.Baralho;
import Classes.Carta;
import Classes.Naipe;
import Classes.Numero;

public class VBaralho extends Baralho {
	
	protected void buildCartas() {
		
		Carta [] baralho = new Carta[52];
		setDeck(baralho);
		
		baralho[0] = new VCarta(Numero.DOIS, Naipe.COPAS, "copas2");
		baralho[1] = new VCarta(Numero.TRES, Naipe.COPAS, "copas3");
		baralho[2] = new VCarta(Numero.QUATRO, Naipe.COPAS, "copas4");
		baralho[3] = new VCarta(Numero.CINCO, Naipe.COPAS, "copas5");
		baralho[4] = new VCarta(Numero.SEIS, Naipe.COPAS, "copas6");
		baralho[5] = new VCarta(Numero.SETE, Naipe.COPAS, "copas7");
		baralho[6] = new VCarta(Numero.OITO, Naipe.COPAS, "copas8");
		baralho[7] = new VCarta(Numero.NOVE, Naipe.COPAS, "copas9");
		baralho[8] = new VCarta(Numero.DEZ, Naipe.COPAS, "copas10");
		baralho[9] = new VCarta(Numero.VALETE, Naipe.COPAS, "copas11");
		baralho[10] = new VCarta(Numero.RAINHA, Naipe.COPAS, "copas12");
		baralho[11] = new VCarta(Numero.REI, Naipe.COPAS, "copas13");
		baralho[12] = new VCarta(Numero.AS, Naipe.COPAS, "copas14");
		
		baralho[13] = new VCarta(Numero.DOIS, Naipe.OUROS, "ouros2");
		baralho[14] = new VCarta(Numero.TRES, Naipe.OUROS, "ouros3");
		baralho[15] = new VCarta(Numero.QUATRO, Naipe.OUROS, "ouros4");
		baralho[16] = new VCarta(Numero.CINCO, Naipe.OUROS, "ouros5");
		baralho[17] = new VCarta(Numero.SEIS, Naipe.OUROS, "ouros6");
		baralho[18] = new VCarta(Numero.SETE, Naipe.OUROS, "ouros7");
		baralho[19] = new VCarta(Numero.OITO, Naipe.OUROS, "ouros8");
		baralho[20] = new VCarta(Numero.NOVE, Naipe.OUROS, "ouros9");
		baralho[21] = new VCarta(Numero.DEZ, Naipe.OUROS, "ouros10");
		baralho[22] = new VCarta(Numero.VALETE, Naipe.OUROS, "ouros11");
		baralho[23] = new VCarta(Numero.RAINHA, Naipe.OUROS, "ouros12");
		baralho[24] = new VCarta(Numero.REI, Naipe.OUROS, "ouros13");
		baralho[25] = new VCarta(Numero.AS, Naipe.OUROS, "ouros14");
		
		baralho[26] =new VCarta(Numero.DOIS, Naipe.ESPADAS, "espadas2");
		baralho[27] = new VCarta(Numero.TRES, Naipe.ESPADAS, "espadas3");
		baralho[28] = new VCarta(Numero.QUATRO, Naipe.ESPADAS, "espadas4");
		baralho[29] = new VCarta(Numero.CINCO, Naipe.ESPADAS, "espadas5");
		baralho[30] = new VCarta(Numero.SEIS, Naipe.ESPADAS, "espadas6");
		baralho[31] = new VCarta(Numero.SETE, Naipe.ESPADAS, "espadas7");
		baralho[32] = new VCarta(Numero.OITO, Naipe.ESPADAS, "espadas8");
		baralho[33] = new VCarta(Numero.NOVE, Naipe.ESPADAS, "espadas9");
		baralho[34] = new VCarta(Numero.DEZ, Naipe.ESPADAS, "espadas10");
		baralho[35] = new VCarta(Numero.VALETE, Naipe.ESPADAS, "espadas11");
		baralho[36] = new VCarta(Numero.RAINHA, Naipe.ESPADAS, "espadas12");
		baralho[37] = new VCarta(Numero.REI, Naipe.ESPADAS, "espadas13");
		baralho[38] = new VCarta(Numero.AS, Naipe.ESPADAS, "espadas14");

		baralho[39] = new VCarta(Numero.DOIS, Naipe.PAUS, "paus2");
		baralho[40] = new VCarta(Numero.TRES, Naipe.PAUS, "paus3");
		baralho[41] = new VCarta(Numero.QUATRO, Naipe.PAUS, "paus4");
		baralho[42] = new VCarta(Numero.CINCO, Naipe.PAUS, "paus5");
		baralho[43] = new VCarta(Numero.SEIS, Naipe.PAUS, "paus6");
		baralho[44] = new VCarta(Numero.SETE, Naipe.PAUS, "paus7");
		baralho[45] = new VCarta(Numero.OITO, Naipe.PAUS, "paus8");
		baralho[46] = new VCarta(Numero.NOVE, Naipe.PAUS, "paus9");
		baralho[47] = new VCarta(Numero.DEZ, Naipe.PAUS, "paus10");
		baralho[48] = new VCarta(Numero.VALETE, Naipe.PAUS, "paus11");
		baralho[49] = new VCarta(Numero.RAINHA, Naipe.PAUS, "paus12");
		baralho[50] = new VCarta(Numero.REI, Naipe.PAUS, "paus13");
		baralho[51] = new VCarta(Numero.AS, Naipe.PAUS, "paus14");
		
		
	}

	private void setDeck(Carta[] baralho) {
		// TODO Auto-generated method stub
		
	}

}
