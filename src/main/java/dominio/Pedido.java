/* package dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	
	@ManyToOne
	@JoinColumn(name = "itemId")
	private Item item;
	
	private Integer quantidade;
	
	private Date data;
	
	private String status;
	
	private String motivo;
	
	public Pedido() {}

	public Pedido(String id, Item item, Integer quantidade, Date data, String status,String motivo) {
		this.id = id;
		this.item = item;
		this.quantidade = quantidade;
		this.data = data;
		this.status = status;
		this.motivo = motivo;
	}
}
*/