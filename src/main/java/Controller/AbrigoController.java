package Controller;

import java.util.Scanner;

import DAO.ItemDAO;

public class AbrigoController {
    ItemDAO itemDAO = new ItemDAO();

    public void listarItensEstoque() {
        itemDAO.listarItensEstoque();
    }

    public void fazerPedido() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID do item que deseja pedir: ");
        int itemId = sc.nextInt();
        System.out.println("Digite a quantidade desejada: ");
        int quantidade = sc.nextInt();

        itemDAO.registrarPedido(itemId, quantidade);
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
}
