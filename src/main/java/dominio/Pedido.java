package dominio;

import enums.StatusPedido;

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
	
	@ManyToOne
	@JoinColumn(name = "abrigoId")
	private Abrigo abrigo;
	
	@ManyToOne
	@JoinColumn(name = "itemId")
	private Item item;

	@Enumerated(EnumType.STRING)
	private StatusPedido status = StatusPedido.PENDENTE;
	
	private Integer quantidade;
	
	private Date data;
	
	private String motivo;
	
	public Pedido() {}

	public Pedido(Integer id, Centro centro, Abrigo abrigo, Item item, Integer quantidade, Date data,String motivo) {
		this.id = id;
		this.item = (item);
		this.quantidade = quantidade;
		this.data = data;
		this.motivo = motivo;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
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

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}