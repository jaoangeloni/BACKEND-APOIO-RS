package aplicativo;

import DAO.CentroDAO;
import dominio.Centro;

public class Programa {
	public static void main(String[] args) {
		Centro centroTeste = new Centro(null, "teste", "teste");
		CentroDAO centroDAO = new CentroDAO();
		
		centroDAO.inserir(centroTeste);
		
	}
}
	