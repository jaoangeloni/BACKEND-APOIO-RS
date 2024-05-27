package config;

import DAO.ItemDAO;
import dominio.Item;
import enums.Categoria;

public class ItemInstantiation{
	ItemDAO itemDao = new ItemDAO();
	
	public void instanciar() {
		itemDao.apagarTodos();
        Item i1 = new Item(1, "Item teste", Categoria.ALIMENTO, "Item teste");
        itemDao.inserir(i1);
  
	}
}
