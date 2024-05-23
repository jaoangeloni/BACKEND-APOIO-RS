package Controller;

import java.util.List;

import DAO.CentroDAO;
import apresentacao.MenuCentro;
import dominio.Centro;

public class CentrosController {
	CentroDAO centroDAO = new CentroDAO();
	MenuCentro menuCentro = new MenuCentro();
	
	public void opcaoListar() {
		List<Centro> centros = centroDAO.listarTodos();
		for(Centro centro : centros) {
			System.out.println(centro);
		}
	}
	
	public void opcaoAssumir(Integer id){
		Centro centro = new Centro();
		centro = centroDAO.listarPorId(id);
		menuCentro.menu(centro);
	}
}
