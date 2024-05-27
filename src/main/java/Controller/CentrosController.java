package Controller;

import java.util.List;

import DAO.CentroDAO;
import apresentacao.MenuCentro;
import dominio.Centro;

public class CentrosController {
	CentroDAO centroDAO = new CentroDAO();
	MenuCentro menuCentro = new MenuCentro();
	
	public void opcaoListar() {
		System.out.println();
		System.out.println("Lista de centros:");
		List<Centro> centros = centroDAO.listarTodos();
		for(Centro centro : centros) {
			System.out.println(centro);
		}
		System.out.println();
	}
	
	public void opcaoSelecionar(Integer id){
		Centro centro = new Centro();
		centro = centroDAO.listarPorId(id);
		menuCentro.receberCentro(centro);
		menuCentro.menuFuncional(centro);
	}
}
