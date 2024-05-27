package dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Estoque_dos_Abrigos")
public class EstoqueAbrigos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
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

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstoqueAbrigos that = (EstoqueAbrigos) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
