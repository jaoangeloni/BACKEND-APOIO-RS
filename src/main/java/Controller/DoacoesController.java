package Controller;

import java.util.List;
import java.util.Scanner;

import DAO.CentroDAO;
import DAO.DoacaoDAO;
import DAO.ItemDAO;
import dominio.Centro;
import dominio.Doacao;
import dominio.Item;

public class DoacoesController {
	DoacaoDAO doacaoDAO = new DoacaoDAO();
	CentroDAO centroDAO = new CentroDAO();
	ItemDAO itemDAO = new ItemDAO();
	
	EstoqueCentroController estoqueCentroController = new EstoqueCentroController();
	
	public void opcaoListarItens() {
		System.out.println();
		System.out.println("Lista de itens:");
		List<Item> itens = itemDAO.listarTodos();
		for(Item item : itens) {
			System.out.println(item);
		}
		System.out.println();
	}
	
	public void opcaoListar() {
		System.out.println();
		System.out.println("Lista de doações:");
		List<Doacao> doacoes = doacaoDAO.listarTodos();
		for(Doacao doacao : doacoes) {
			System.out.println(doacao);
		}
		System.out.println();
	}
	
	public void opcaoInserir() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Digite o ID do centro que deseja doar:");
		Integer idCentro = sc.nextInt();
		Centro centro = centroDAO.listarPorId(idCentro);
		
		System.out.println("Digite o ID do Item que deseja doar:");
		Integer idItem = sc.nextInt();
		Item item = itemDAO.listarPorId(idItem);
		
		System.out.println("Digite a quantidade que deseja doar:");
		Integer quantidade = sc.nextInt();
		System.out.println();
		Doacao doacao = new Doacao(null, centro, item, quantidade);

		doacaoDAO.inserir(doacao);
		estoqueCentroController.opcaoInserir(doacao);
		
		System.out.println();
	}
	
	public void opcaoAlterar() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Digite o ID da doacão que deseja alterar:");
		Integer idDoacao = sc.nextInt();
		
		System.out.println("Digite o novo ID do centro que deseja doar:");
		Integer idCentro = sc.nextInt();
		Centro centro = centroDAO.listarPorId(idCentro);
		
		System.out.println("Digite o novo ID do Item que deseja doar:");
		Integer idItem = sc.nextInt();
		Item item = itemDAO.listarPorId(idItem);
		
		System.out.println("Digite a nova quantidade que deseja doar:");
		Integer quantidade = sc.nextInt();
		Doacao doacao = new Doacao(null, centro, item, quantidade);

		doacaoDAO.alterarPorId(idDoacao, doacao);
		
		System.out.println();
	}
	
	public void opcaoDeletar() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Digite o ID da doação que deseja deletar:");
		Integer idDoacao = sc.nextInt();
		doacaoDAO.excluirPorId(idDoacao);
		System.out.println();
	}
}
