package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import enums.Categoria;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Categoria categoria;
	private String nome;
	private String genero;
	private String tamanho;
	private int quantidade;


	public Item(int id, Categoria categoria, String nome, String genero, String tamanho, int quantidade) {
		this.id = id;
		this.categoria = categoria;
		this.nome = nome;
		this.genero = genero;
		this.tamanho = tamanho;
		this.quantidade = quantidade;
	}


	public Item(Categoria categoria, String nome, String genero, String tamanho, int quantidade) {
		this.categoria = categoria;
		this.nome = nome;
		this.genero = genero;
		this.tamanho = tamanho;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
