package config;

import DAO.ItemDAO;
import dominio.Item;
import enums.Categoria;

public class ItemInstantiation {
    private ItemDAO itemDAO = new ItemDAO(); 
    public void instanciar() {
        try {
            itemDAO.apagarTodos(); 
            Item[] items = {
            		new Item(1,Categoria.ROUPA, "Agasalho", "M", "Infantil"),
                    new Item(2,Categoria.ROUPA, "Agasalho", "F", "PP"),
                    new Item(3, Categoria.ROUPA, "Agasalho", "M", "P"),
                    new Item(4,Categoria.ROUPA, "Agasalho", "F", "M"),
                    new Item(5,Categoria.ROUPA, "Agasalho", "M", "G"),
                    new Item(6,Categoria.ROUPA, "Agasalho", "F", "GG"),
                    new Item(7,Categoria.ROUPA, "Camisa", "M", "Infantil"),
                    new Item(8,Categoria.ROUPA, "Camisa", "F", "PP"),
                    new Item(9,Categoria.ROUPA, "Camisa", "M", "P"),
                    new Item(10,Categoria.ROUPA, "Camisa", "F", "M"),
                    new Item(11,Categoria.ROUPA, "Camisa", "M", "G"),
                    new Item(12,Categoria.ROUPA, "Camisa", "F", "GG"),
                    new Item(13,Categoria.ROUPA, "Calça", "M", "Infantil"),
                    new Item(14,Categoria.ROUPA, "Calça", "F", "PP"),
                    new Item(15,Categoria.ROUPA, "Calça", "M", "P"),
                    new Item(16,Categoria.ROUPA, "Calça", "F", "M"),
                    new Item(17,Categoria.ROUPA, "Calça", "M", "G"),
                    new Item(18,Categoria.ROUPA, "Calça", "F", "GG"),
                    new Item(19,Categoria.ROUPA, "Calçado", "", "34"),
                    new Item(20,Categoria.ROUPA, "Calçado", "", "35"),
                    new Item(21,Categoria.ROUPA, "Calçado", "", "36"),
                    new Item(22,Categoria.ROUPA, "Calçado", "", "37"),
                    new Item(23,Categoria.ROUPA, "Calçado", "", "38"),
                    new Item(24,Categoria.ROUPA, "Calçado", "", "39"),
                    new Item(25,Categoria.ROUPA, "Calçado", "", "40"),
                    new Item(26,Categoria.ROUPA, "Calçado", "", "41"),
                    new Item(27,Categoria.ROUPA, "Calçado", "", "42"),
                    new Item(28,Categoria.HIGIENE, "Sabonete", "", ""),
                    new Item(29,Categoria.HIGIENE, "Escova de Dentes", "", ""),
                    new Item(30,Categoria.HIGIENE, "Pasta de Dentes", "", ""),
                    new Item(31,Categoria.HIGIENE, "Absorventes", "", ""),
                    new Item(32,Categoria.HIGIENE, "Papel Higiênico", "", ""),
                    new Item(33,Categoria.ALIMENTO, "Arroz", "", ""),
                    new Item(34,Categoria.ALIMENTO, "Feijão", "", ""),
                    new Item(35,Categoria.ALIMENTO, "Leite", "", ""),
                    new Item(36,Categoria.ALIMENTO, "Água", "", ""),
                    new Item(37,Categoria.ALIMENTO, "Óleo", "", ""),
                    new Item(38,Categoria.ALIMENTO, "Macarrão", "", "")
                };
            for (Item item : items) {
                itemDAO.inserir(item); 
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir itens: " + e.getMessage());
        }
    }
}
