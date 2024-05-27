package Controller;

import DAO.EstoqueCentroDAO;
import dominio.Centro;

public class CentroController {
	EstoqueCentroDAO estoqueCentroDAO = new EstoqueCentroDAO();
	EstoqueCentroController estoqueCentroController = new EstoqueCentroController();
	
	public void opcaoListarEstoque() {
		estoqueCentroController.opcaoListar();
	}
}
