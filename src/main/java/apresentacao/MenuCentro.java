package apresentacao;

import java.util.Scanner;

import Controller.CentroController;
import DAO.CentroDAO;
import enums.OpcoesMenuCentro;

public class MenuCentro {
	CentroController centroController = new CentroController();
	
	public OpcoesMenuCentro menu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Listar estoque");
    	System.out.println("2. Listar pedidos");
    	System.out.println("3. Aprovar/Rescusar pedido");
    	System.out.println("4. Sair");
    	
    	int op = sc.nextInt();
    	
    	switch (op) {
        case 1:
        	return OpcoesMenuCentro.OP_LISTAR_ESTOQUE;
        case 2:
        	return OpcoesMenuCentro.OP_LISTAR_PEDIDOS;
        case 3:
        	return OpcoesMenuCentro.OP_ATENDER_PEDIDO;
        case 4:
        	return OpcoesMenuCentro.OP_SAIR;
    	}
    	return OpcoesMenuCentro.OP_NAO_SELECIONADA;
	}
	
	public void menuFuncional() {

		CentroDAO centroDAO = new CentroDAO();		
		Scanner sc = new Scanner(System.in);

		OpcoesMenuCentro opcao = OpcoesMenuCentro.OP_NAO_SELECIONADA;
		
		while (opcao != OpcoesMenuCentro.OP_SAIR) {
			opcao = menu();
			
			switch (opcao) {
			case OP_LISTAR_ESTOQUE:
				centroController.opcaoListarEstoque();
				break;
			case OP_LISTAR_PEDIDOS:
				
				break;
			case OP_ATENDER_PEDIDO:
				
				break;
			case OP_SAIR:
				System.out.println("Voltando para o menu de centros...");
				break;
			default:
				System.out.println("Opção não selecionada");
			}

		}
	}
}
