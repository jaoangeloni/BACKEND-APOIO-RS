package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enums.Categoria;

@Entity
@Table(name = "item")
class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private Categoria categoria;
    private Integer quantidade;
    private String descricao;

    public Item() {}

    public Item(String nome, Categoria categoria, Integer quantidade, String descricao) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    
}
