package dto;

import dominio.Item;

public class EstoqueCentroDTO {
	private Integer id;
	private Item item;
	private Integer quantidadeSomada;
	private Integer limite;

	public EstoqueCentroDTO(Integer id, Item item, Integer quantidadeSomada, Integer limite) {
		this.id = id;
		this.item = item;
		this.quantidadeSomada = quantidadeSomada;
		this.limite = limite;
	}

	@Override
	public String toString() {
		return "[id: " + id + "] [item: " + item.getNome() + "] [quantidadeSomada: " + quantidadeSomada
				+ "] [limite=" + limite + "]";
	}
}
