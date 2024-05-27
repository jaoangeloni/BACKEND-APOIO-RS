package dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Estoque_dos_Centros")
public class EstoqueCentros implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "centro_id")
    private Centro centro;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private Integer quantidade;
    private Integer limite = 1000;

    public EstoqueCentros() {}

    public EstoqueCentros(Integer id, Centro centro, Item item, Integer quantidade) {
        this.id = id;
        this.centro = centro;
        this.item = item;
    }

    public Integer getId() {
        return id;
    }
    
    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
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
	public String toString() {
		return "[id: " + id + "] [centro=" + centro.getNome() + "] [item: " + item.getNome() + "] [quantidade: " + quantidade
				+ "] [limite=" + limite + "]";
	}
}
