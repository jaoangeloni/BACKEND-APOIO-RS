package dominio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "doacoes")
public class Doacao implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@ManyToOne
		@JoinColumn(name = "centroId")
		private Centro centro;
		
		@ManyToOne
		@JoinColumn(name = "itemId")
		private Item item;


		private Integer quantidade;
		
		public Doacao() {}

		public Doacao(Integer id, Centro centro, Item item, Integer quantidade) {
			this.id = id;
			this.centro = centro;
			this.item = item;
			this.quantidade = quantidade;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Item getItem() {
			return item;
		}

		public void setItem(Item item) {
			this.item = item;
		}

		public Centro getCentro() {
			return centro;
		}

		public void setCentro(Centro centro) {
			this.centro = centro;
		}

		public Integer getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(Integer quantidade) {
			this.quantidade = quantidade;
		}
		
		@Override
		public String toString() {
			return "[id: " + id + "] [centro: " + centro.getNome() + "] [item: " + item.getNome() + "] [quantidade: " + quantidade + "]";
		}
}
