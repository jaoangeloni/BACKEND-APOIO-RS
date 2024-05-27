package config;

import DAO.CentroDAO;
import dominio.Centro;

public class CentrosInstantiation{
	CentroDAO centroDAO = new CentroDAO();
	
	public void instanciar() {
		centroDAO.apagarTodos();
		
        Centro c1 = new Centro(1, "Esperança", "Av. Boqueirão, 2450 - Igara, Canoas - RS, 92032420");
        Centro c2 = new Centro(2, "Prosperidade", "Av. Borges de Medeiros, 1501 - Porto Alegre - RS, 90119900");
        Centro c3 = new Centro(3, "Reconstrução", "R. Dr. Décio Martins Costa, 312 - Vila Eunice Nova, Cachoeirinha - RS, 94920170");
        
        centroDAO.inserir(c1);
        centroDAO.inserir(c2);
        centroDAO.inserir(c3);
        
	}
}