package Controller;

import java.util.Scanner;

import DAO.ItemDAO;
import dominio.Item;

public class AbrigoController {

    public void opcaoListarEstoque() {
        
        System.out.println("Listando itens de estoque...");
       //
    }

    public void opcaoFazerPedido() {
       
        System.out.println("Fazendo pedido...");
        //
    }



public void transferirItens() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o ID do item a ser transferido: ");
    int itemId = sc.nextInt();
    System.out.println("Digite a quantidade a ser transferida: ");
    int quantidade = sc.nextInt();
    System.out.println("Digite o local de origem (centro/abrigo): ");
    String origem = sc.next();
    System.out.println("Digite o local de destino (centro/abrigo): ");
    String destino = sc.next();

    ItemDAO.transferirItens(itemId, quantidade, origem, destino);
}

private void gerarAlerta(Item item, int quantidade) {
    if (quantidade > 900) {
        System.out.println("Alerta: Excedente de " + item.getNome() + ". Quantidade: " + quantidade);
    } else if (quantidade < 100) {
        System.out.println("Alerta: Escassez de " + item.getNome() + ". Quantidade: " + quantidade);
    }
}
}