package apresentacao;

import java.util.Scanner;

import Controller.AbrigoController;
import enums.OpcoesMenuAbrigo;

public class MenuAbrigo {
    AbrigoController abrigoController = new AbrigoController();

    public OpcoesMenuAbrigo menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("MENU DE ABRIGOS");
        System.out.println("1. Listar itens de estoque");
        System.out.println("2. Fazer pedido");
        System.out.println("3. Sair");

        int op = sc.nextInt();

        switch (op) {
            case 1:
                return OpcoesMenuAbrigo.OP_LISTAR_ESTOQUE;
            case 2:
                return OpcoesMenuAbrigo.OP_FAZER_PEDIDO;
            case 3:
                return OpcoesMenuAbrigo.OP_SAIR;
        }

        return OpcoesMenuAbrigo.OP_NAO_SELECIONADA;
    }

    public void menuFuncional() {
        Scanner sc = new Scanner(System.in);
        OpcoesMenuAbrigo opcao = OpcoesMenuAbrigo.OP_NAO_SELECIONADA;

        while (opcao != OpcoesMenuAbrigo.OP_SAIR) {
            opcao = menu();

            switch (opcao) {
                case OP_LISTAR_ESTOQUE:
                    abrigoController.opcaoListarEstoque();
                    break;
                case OP_FAZER_PEDIDO:
                    abrigoController.opcaoFazerPedido();
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
