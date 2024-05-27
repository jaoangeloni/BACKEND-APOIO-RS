package apresentacao;

import java.util.Scanner;

import Controller.MainController;
import enums.OpcoesMenuPrincipal;

public class MenuPrincipal {
    MainController mainController = new MainController();
   
	public OpcoesMenuPrincipal menu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("MENU PRINCIPAL - SISTEMA SOS RIO GRANDE DO SUL");
    	System.out.println("1. Centros de Distribuição");
    	System.out.println("2. Abrigos");
    	System.out.println("3. Doações");
    	System.out.println("4. Sair");
    	
    	int op = sc.nextInt();
    	
    	switch (op) {
	        case 1:
	            return OpcoesMenuPrincipal.OP_CENTRO;
	        case 2:
	        	return OpcoesMenuPrincipal.OP_ABRIGO;
	        case 3:
	        	return OpcoesMenuPrincipal.OP_DOACAO;
	        case 4:
	        	return OpcoesMenuPrincipal.OP_SAIR;

    	}
    	return OpcoesMenuPrincipal.OP_NAO_SELECIONADA;
	}
	
	
	
	public void menuFuncional() {
		MenuCentros menuCentros = new MenuCentros();
		MenuDoacoes menuDoacoes = new MenuDoacoes();
		
		OpcoesMenuPrincipal opcao = OpcoesMenuPrincipal.OP_NAO_SELECIONADA;

		while (opcao != OpcoesMenuPrincipal.OP_SAIR) {
			opcao = menu();
			
			switch (opcao) {
			case OP_CENTRO:
				menuCentros.menuFuncional();
				break;
			case OP_ABRIGO:

				break;
			case OP_DOACAO:
				menuDoacoes.menuFuncional();
				break;
			case OP_SAIR:
				System.out.println("Saindo do programa...");
				break;
			default:
				System.out.println("Opção inválida");
			}

		}

	}
}
