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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "abrigo_id")
    private Abrigo abrigo;

    @ManyToOne(cascade = CascadeType.ALL)
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
}