package Controller;

import java.util.List;

import DAO.CentroDAO;
import DAO.DoacaoDAO;
import DAO.EstoqueCentroDAO;
import DAO.ItemDAO;
import dominio.Centro;
import dominio.Doacao;
import dominio.EstoqueCentros;

public class EstoqueCentroController {
	DoacaoDAO doacaoDAO = new DoacaoDAO();
	CentroDAO centroDAO = new CentroDAO();
	ItemDAO itemDAO = new ItemDAO();
	EstoqueCentroDAO estoqueCentroDAO = new EstoqueCentroDAO();
	
	public void opcaoListar() {
		System.out.println();
		
		System.out.println("Lista de itens no estoque:");
		List<EstoqueCentros> estoques = estoqueCentroDAO.listarTodos();
		for(EstoqueCentros estoque: estoques) {
			System.out.println(estoque);
		}
		System.out.println();
	}
	
	public void opcaoInserir(Doacao doacao) {
		EstoqueCentros estoque = new EstoqueCentros(null, doacao.getCentro(), doacao.getItem(), doacao.getQuantidade());
		estoqueCentroDAO.inserir(estoque);
		
	}

	

}
