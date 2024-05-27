package apresentacao;

import java.util.Scanner;

import Controller.AbrigoController;
import enums.OpcoesMenuAbrigo;

public class MenuAbrigo {
    AbrigoController abrigoController = new AbrigoController();

    public OpcoesMenuAbrigo menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("MENU ABRIGO");
        System.out.println("1. Listar itens em estoque");
        System.out.println("2. Realizar pedido");
        System.out.println("3. Transferir itens");
        System.out.println("4. Verificar alertas");
        System.out.println("5. Sair");

        int op = sc.nextInt();

        switch (op) {
            case 1:
                return OpcoesMenuAbrigo.OP_LISTAR_ITENS_ESTOQUE;
            case 2:
                return OpcoesMenuAbrigo.OP_REALIZAR_PEDIDO;
            case 3:
                return OpcoesMenuAbrigo.OP_TRANSFERIR_ITENS;
            case 4:
                return OpcoesMenuAbrigo.OP_VERIFICAR_ALERTAS;
            case 5:
                return OpcoesMenuAbrigo.OP_SAIR;
            default:
                return OpcoesMenuAbrigo.OP_NAO_SELECIONADA;
        }
    }

    public void menuFuncional() {
        Scanner sc = new Scanner(System.in);

        OpcoesMenuAbrigo opcao = OpcoesMenuAbrigo.OP_NAO_SELECIONADA;

        while (opcao != OpcoesMenuAbrigo.OP_SAIR) {
            opcao = menu();

            switch (opcao) {
                case OP_LISTAR_ITENS_ESTOQUE:
                    abrigoController.listarItensEstoque();
                    break;
                case OP_REALIZAR_PEDIDO:
                    abrigoController.fazerPedido();
                    break;
                case OP_TRANSFERIR_ITENS:
                    abrigoController.transferirItens();
                    break;
                case OP_VERIFICAR_ALERTAS:
                    abrigoController.verificarAlertas();
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