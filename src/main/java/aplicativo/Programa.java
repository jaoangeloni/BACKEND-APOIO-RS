package aplicativo;

import dominio.CentroDeDistribuicao;
import model.dao.DaoAbrigos;
import model.dao.DaoFactory;

public class Programa {
	public static void main(String[] args) {
		
		CentroDeDistribuicao centros = new CentroDeDistribuicao();
		centros.inserirCentros();
		Abrigos abrigo = new Abrigos();
		abrigo.inserirTeste();
		
		DaoAbrigos daoAbrigo = DaoFactory.createDaoAbrigo();
		
		
	}
}
