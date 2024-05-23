package aplicativo;

import apresentacao.MenuPrincipal;
import config.CentrosInstantiation;

public class Programa {
	public static void main(String[] args) {
		
		CentrosInstantiation centroInstantiation = new CentrosInstantiation();
		centroInstantiation.instanciar();
		
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.menuFuncional();
		
		
	}
}
	