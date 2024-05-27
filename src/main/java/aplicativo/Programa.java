package aplicativo;


import Controller.EstoqueCentroController;
import apresentacao.MenuPrincipal;
import config.CentrosInstantiation;
import config.ItemInstantiation;
import database.DatabaseCleaner;

public class Programa {
	public static void main(String[] args) {
		DatabaseCleaner databaseCleaner = new DatabaseCleaner();
		databaseCleaner.clearDatabase();
		
		//EstoqueCentroController ecc = new EstoqueCentroController();
		//ecc.opcaoListar();
		
		CentrosInstantiation centroInstantiation = new CentrosInstantiation();
		centroInstantiation.instanciar();
		ItemInstantiation itemInstantiation = new ItemInstantiation();
		itemInstantiation.instanciar();
		
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.menuFuncional();
		
		
	}
}
		

       
