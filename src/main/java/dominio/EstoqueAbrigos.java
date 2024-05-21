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

    @OneToMany
    @JoinColumn(name = "abrigo_id")
    private Integer abrigosFK;

    //@OneToMany
    //@JoinColumn(name = "item_id")
    private Integer itemFK;

    private Integer quantidade;
    private Integer limite = 1000;

    public EstoqueAbrigos() {}

    public EstoqueAbrigos(Integer id, Integer abrigosFK, Integer itemFK, Integer quantidade, Integer limite) {
        this.id = id;
        this.abrigosFK = abrigosFK;
        this.itemFK = itemFK;
        this.quantidade = quantidade;
        this.limite = limite;
    }
}
