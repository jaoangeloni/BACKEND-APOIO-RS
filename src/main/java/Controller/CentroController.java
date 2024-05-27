package Controller;

import DAO.EstoqueCentroDAO;

public class CentroController {
	EstoqueCentroDAO estoqueCentroDAO = new EstoqueCentroDAO();
	EstoqueCentroController estoqueCentroController = new EstoqueCentroController();
	
	public void opcaoListarEstoque() {
		estoqueCentroController.opcaoListar();
	}
}
