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
            		new Item(Categoria.ROUPA, "Agasalho", "M", "Infantil", 0),
                    new Item(Categoria.ROUPA, "Agasalho", "F", "PP", 0),
                    new Item(Categoria.ROUPA, "Agasalho", "M", "P", 0),
                    new Item(Categoria.ROUPA, "Agasalho", "F", "M", 0),
                    new Item(Categoria.ROUPA, "Agasalho", "M", "G", 0),
                    new Item(Categoria.ROUPA, "Agasalho", "F", "GG", 0),
                    new Item(Categoria.ROUPA, "Camisa", "M", "Infantil", 0),
                    new Item(Categoria.ROUPA, "Camisa", "F", "PP", 0),
                    new Item(Categoria.ROUPA, "Camisa", "M", "P", 0),
                    new Item(Categoria.ROUPA, "Camisa", "F", "M", 0),
                    new Item(Categoria.ROUPA, "Camisa", "M", "G", 0),
                    new Item(Categoria.ROUPA, "Camisa", "F", "GG", 0),
                    new Item(Categoria.ROUPA, "Calça", "M", "Infantil", 0),
                    new Item(Categoria.ROUPA, "Calça", "F", "PP", 0),
                    new Item(Categoria.ROUPA, "Calça", "M", "P", 0),
                    new Item(Categoria.ROUPA, "Calça", "F", "M", 0),
                    new Item(Categoria.ROUPA, "Calça", "M", "G", 0),
                    new Item(Categoria.ROUPA, "Calça", "F", "GG", 0),
                    new Item(Categoria.ROUPA, "Calçado", "", "34", 0),
                    new Item(Categoria.ROUPA, "Calçado", "", "35", 0),
                    new Item(Categoria.ROUPA, "Calçado", "", "36", 0),
                    new Item(Categoria.ROUPA, "Calçado", "", "37", 0),
                    new Item(Categoria.ROUPA, "Calçado", "", "38", 0),
                    new Item(Categoria.ROUPA, "Calçado", "", "39", 0),
                    new Item(Categoria.ROUPA, "Calçado", "", "40", 0),
                    new Item(Categoria.ROUPA, "Calçado", "", "41", 0),
                    new Item(Categoria.ROUPA, "Calçado", "", "42", 0),
                    new Item(Categoria.HIGIENE, "Sabonete", "", "", 0),
                    new Item(Categoria.HIGIENE, "Escova de Dentes", "", "", 0),
                    new Item(Categoria.HIGIENE, "Pasta de Dentes", "", "", 0),
                    new Item(Categoria.HIGIENE, "Absorventes", "", "", 0),
                    new Item(Categoria.HIGIENE, "Papel Higiênico", "", "", 0),
                    new Item(Categoria.ALIMENTO, "Arroz", "", "", 0),
                    new Item(Categoria.ALIMENTO, "Feijão", "", "", 0),
                    new Item(Categoria.ALIMENTO, "Leite", "", "", 0),
                    new Item(Categoria.ALIMENTO, "Água", "", "", 0),
                    new Item(Categoria.ALIMENTO, "Óleo", "", "", 0),
                    new Item(Categoria.ALIMENTO, "Macarrão", "", "", 0)
                };

            
        
            for (Item item : items) {
                itemDAO.inserir(item); 
            }
            System.out.println("Itens inseridos com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir itens: " + e.getMessage());
        }
    }
}
