package aplicativo;

import dominio.Abrigo;
import dominio.CentroDeDistribuicao;

import java.util.List;

import DAO.AbrigoDAO;

public class Programa {
	public static void main(String[] args) {
		
		CentroDeDistribuicao centros = new CentroDeDistribuicao();
		centros.inserirCentros();
		
		
		Abrigo abrigo1 = new Abrigo(null, "Abrigo1", "Rua das ruas", "abrigo@gmail.com", 300, "75%", "Seu Joao","13997973955");
		
		AbrigoDAO crud = new AbrigoDAO();
		
		crud.inserirAbrigo(abrigo1);;
		
	}
}
		
