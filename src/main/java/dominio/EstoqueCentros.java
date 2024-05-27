/*package dominio;

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

    public EstoqueCentros(Integer id, Centro centro, Item item, Integer quantidade, Integer limite) {
        this.id = id;
        this.centro = centro;
        this.item = item;
        this.quantidade = quantidade;
    }

}
*/