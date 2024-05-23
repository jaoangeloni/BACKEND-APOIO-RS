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

    @OneToMany
    @JoinColumn(name = "centro_id")
    private Integer centroFK;

    //@OneToMany
    //@JoinColumn(name = "item_id")
    private Integer itemFK;

    private Integer quantidade;
    private Integer limite = 1000;

    public EstoqueCentros() {}

    public EstoqueCentros(Integer id, Integer centroFK, Integer itemFK, Integer quantidade, Integer limite) {
        this.id = id;
        this.centroFK = centroFK;
        this.itemFK = itemFK;
        this.quantidade = quantidade;
    }
}
*/