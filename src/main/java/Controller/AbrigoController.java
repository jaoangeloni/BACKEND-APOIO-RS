package Controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAO.EstoqueAbrigoDAO;
import DAO.ItemDAO;
import DAO.PedidoDAO;
import dominio.Abrigo;
import dominio.Item;

public class AbrigoController {
	EstoqueAbrigoDAO estoqueAbrigoDAO = new EstoqueAbrigoDAO();

	private static boolean validaEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	private static boolean validaTelefone(String telefone) {
		String phoneRegex = "^[0-9]{10,11}$";
		Pattern pattern = Pattern.compile(phoneRegex);
		Matcher matcher = pattern.matcher(telefone);
		return matcher.matches();
	}

	ItemDAO itemDAO = new ItemDAO();
	PedidoDAO pedidoDAO = new PedidoDAO();

	public void listarItensEstoque() {
		estoqueAbrigoDAO.listarTodos();
	}

	public void fazerPedido() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o ID do abrigo: ");
		int abrigoId = sc.nextInt();

		System.out.println("Digite o ID do item que deseja pedir: ");
		int itemId = sc.nextInt();
		Item item = itemDAO.getItemById(itemId);

		System.out.println("Digite a quantidade desejada: ");
		int quantidade = sc.nextInt();

		pedidoDAO.criarPedido(abrigoId, item, quantidade);
		System.out.println("Pedido realizado com sucesso!");
	}

	public void transferirItens() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o ID do item a ser transferido: ");
		int itemId = sc.nextInt();
		System.out.println("Digite a quantidade a ser transferida: ");
		int quantidade = sc.nextInt();
		System.out.println("Digite o local de origem (centro/abrigo): ");
		String localOrigem = sc.next();
		System.out.println("Digite o local de destino (centro/abrigo): ");
		String localDestino = sc.next();

		itemDAO.transferirItens(itemId, quantidade, localOrigem, localDestino);
		System.out.println("Transferência realizada com sucesso!");
	}

	public void verificarAlertas() {
		itemDAO.verificarAlertas();
	}
	
	public static void validar(Abrigo abrigo) throws IllegalArgumentException {
		if (abrigo.getNome() == null || abrigo.getNome().isEmpty()) {
			throw new IllegalArgumentException("Nome não pode estar vazio.");
		}

		if (abrigo.getEndereco() == null || abrigo.getEndereco().isEmpty()) {
			throw new IllegalArgumentException("Endereço não pode estar vazio.");
		}

		if (abrigo.getEmail() == null || !validaEmail(abrigo.getEmail())) {
			throw new IllegalArgumentException("Email inválido.");
		}

		if (abrigo.getCapacidade() <= 0) {
			throw new IllegalArgumentException("Capacidade deve ser maior que zero.");
		}

		if (abrigo.getOcupacao() == null || abrigo.getOcupacao().isEmpty()) {
			throw new IllegalArgumentException("Ocupação não pode estar vazia.");
		}

		if (abrigo.getResponsavel() == null || abrigo.getResponsavel().isEmpty()) {
			throw new IllegalArgumentException("Responsável não pode estar vazio.");
		}

		if (abrigo.getTelefone() == null || !validaTelefone(abrigo.getTelefone())) {
			throw new IllegalArgumentException("Telefone inválido.");
		}
	}
}