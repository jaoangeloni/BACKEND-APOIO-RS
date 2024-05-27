package apresentacao;

import java.util.Scanner;

import Controller.DoacoesController;
import enums.OpcoesMenuDoacoes;

public class MenuDoacoes {
	DoacoesController doacoesController = new DoacoesController();
	
	public OpcoesMenuDoacoes menu() {
		Scanner sc = new Scanner(System.in);

		System.out.println("DOAÇÕES");
		System.out.println("1. Listar itens que podem ser doados");
		System.out.println("2. Listar registro de doações");
		System.out.println("3. Doar novo item");
		System.out.println("4. Alterar doação existente");
		System.out.println("5. Deletar doação existente");
		System.out.println("6. Sair");

		int op = sc.nextInt();

		switch (op) {
		case 1:
			return OpcoesMenuDoacoes.OP_LISTAR_ITENS;
		case 2:
			return OpcoesMenuDoacoes.OP_LISTAR_DOACOES;
		case 3:
			return OpcoesMenuDoacoes.OP_DOAR_ITEM;
		case 4:
			return OpcoesMenuDoacoes.OP_ALTERAR_DOACAO;
		case 5:
			return OpcoesMenuDoacoes.OP_DELETAR_DOACAO;
		case 6:
			return OpcoesMenuDoacoes.OP_SAIR;
		}

		return OpcoesMenuDoacoes.OP_NAO_SELECIONADA;
	}
	
	public void menuFuncional() {
		Scanner sc = new Scanner(System.in);

		OpcoesMenuDoacoes opcao = OpcoesMenuDoacoes.OP_NAO_SELECIONADA;
		
		while (opcao != OpcoesMenuDoacoes.OP_SAIR) {
			opcao = menu();
			
			switch (opcao) {
			case OP_LISTAR_ITENS:
				doacoesController.opcaoListarItens();
				break;
			case OP_LISTAR_DOACOES:
				doacoesController.opcaoListar();
				break;
			case OP_DOAR_ITEM:
				doacoesController.opcaoInserir();
				break;
			case OP_ALTERAR_DOACAO:
				doacoesController.opcaoAlterar();
				break;
			case OP_DELETAR_DOACAO:
				doacoesController.opcaoDeletar();
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
