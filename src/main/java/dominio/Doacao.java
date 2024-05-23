/*package dominio;

import java.io.Serializable;

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
		@JoinColumn(name = "itemId")
		private Item item;
		
		@ManyToOne
		@JoinColumn(name = "centroId")
		private Centro centro;
		
		private Integer quantidade;
		
		public Doacao() {}

		public Doacao(Integer id, Item item, Centro centro, Integer quantidade) {
			this.id = id;
			this.item = item;
			this.centro = centro;
			this.quantidade = quantidade;
		}
		
}*/
