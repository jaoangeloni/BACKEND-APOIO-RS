package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enums.Categoria;

@Entity
@Table(name = "item")
public class Item implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    private Integer id;

    private String nome;
    private Categoria categoria;
    private String descricao;


    public Item() {}

	public Item(Integer id, String nome, Categoria categoria, String descricao) {
    	this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "[id: " + id + "] [nome: " + nome + "] [categoria: " + categoria + "] [descricao:" + descricao + "]";
	}
    
}