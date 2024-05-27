package dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Estoque_dos_Abrigos")
public class EstoqueAbrigos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "abrigo_id")
    private Abrigo abrigo;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private Integer quantidade;
    private Integer limite = 1000;

    public EstoqueAbrigos() {}

    public EstoqueAbrigos(Integer id, Abrigo abrigo, Item item, Integer quantidade, Integer limite) {
        this.id = id;
        this.abrigo = abrigo;
        this.item = item;
        this.quantidade = quantidade;
        this.limite = limite;
    }


public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public Abrigo getAbrigo() {
    return abrigo;
}

public void setAbrigo(Abrigo abrigo) {
    this.abrigo = abrigo;
}

public Item getItem() {
    return item;
}

public void setItem(Item item) {
    this.item = item;
}

public Integer getQuantidade() {
    return quantidade;
}

public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
}
}
