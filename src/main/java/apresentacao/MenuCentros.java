package apresentacao;

import java.util.Scanner;

import Controller.CentrosController;
import DAO.CentroDAO;
import dominio.Centro;
import enums.OpcoesMenuCentros;

public class MenuCentros {
	CentrosController centrosController = new CentrosController();
	
	public OpcoesMenuCentros menu() {
		Scanner sc = new Scanner(System.in);

		System.out.println("CENTROS DE DISTRIBUIÇÃO");
		System.out.println("1. Listar centros disponíveis");
		System.out.println("2. Selecionar centro");
		System.out.println("3. Voltar para o menu principal");

		int op = sc.nextInt();

		switch (op) {
		case 1:
			return OpcoesMenuCentros.OP_LISTAR_CENTROS;
		case 2:
			return OpcoesMenuCentros.OP_SELECIONAR_CENTRO;
		case 3:
			return OpcoesMenuCentros.OP_SAIR;
		}

		return OpcoesMenuCentros.OP_NAO_SELECIONADA;
	}
	
	public void menuFuncional() {

		CentroDAO centroDAO = new CentroDAO();
		
		Scanner sc = new Scanner(System.in);

		OpcoesMenuCentros opcao = OpcoesMenuCentros.OP_NAO_SELECIONADA;
		
		while (opcao != OpcoesMenuCentros.OP_SAIR) {
			opcao = menu();
			
			switch (opcao) {
			case OP_LISTAR_CENTROS:
				
				centrosController.opcaoListar();
				
				break;
			case OP_SELECIONAR_CENTRO:
				
				System.out.println("Digite o id do centro: ");
				Integer id = sc.nextInt();
				centrosController.opcaoSelecionar(id);
				
				break;
			case OP_SAIR:
				
				System.out.println("Voltando para o menu principal...");
				
				break;
			default:
				System.out.println("Opção não selecionada");
			}

		}
	}
}
