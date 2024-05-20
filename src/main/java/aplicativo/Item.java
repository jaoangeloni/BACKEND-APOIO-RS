package aplicativo;

import java.util.Objects;

enum Categoria {
    ROUPA, HIGIENE, ALIMENTO
}

class Item {
    private String nome;
    private Categoria categoria;
    private int quantidade;
    private String tamanho; // Usado apenas para roupas
    private int numeroCalcado; // Usado apenas para calçados

    public Item(String nome, Categoria categoria, int quantidade, String tamanho, int numeroCalcado) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
        this.numeroCalcado = numeroCalcado;
    }

    @Override
	public int hashCode() {
		return Objects.hash(categoria, nome, numeroCalcado, quantidade, tamanho);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return categoria == other.categoria && Objects.equals(nome, other.nome) && numeroCalcado == other.numeroCalcado
				&& quantidade == other.quantidade && Objects.equals(tamanho, other.tamanho);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public int getNumeroCalcado() {
		return numeroCalcado;
	}

	public void setNumeroCalcado(int numeroCalcado) {
		this.numeroCalcado = numeroCalcado;
	}

}

