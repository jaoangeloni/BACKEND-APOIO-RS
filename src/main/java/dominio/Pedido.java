/*package dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "centroId")
	private Centro centro;
	
	@OneToOne
	@JoinColumn(name = "abrigoId")
	private Abrigo abrigo;
	
	@ManyToOne
	@JoinColumn(name = "itemId")
	private Item item;
	
	private Integer quantidade;
	
	private Date data;
	
	private String status;
	
	private String motivo;
	
	public Pedido() {}

	public Pedido(Integer id, Centro centro, Abrigo abrigo, Item item, Integer quantidade, Date data, String status,String motivo) {
		this.id = id;
		this.centro = centro;
		this.abrigo = abrigo;
		this.item = item;
		this.quantidade = quantidade;
		this.data = data;
		this.status = status;
		this.motivo = motivo;
	}
}
*/