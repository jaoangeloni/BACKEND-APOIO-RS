package dominio;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "abrigo")
public class Abrigo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String endereco;
	private String email;
	private Integer capacidade;
	private String ocupacao;
	private String responsavel;
	private String telefone;
	
	@OneToMany(mappedBy = "abrigo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EstoqueAbrigos> estoqueAbrigos;
	
	public Abrigo() {
	}
	

		
	public Abrigo(Integer id, String nome, String endereco, String email, Integer capacidade, String ocupacao,
			String responsavel, String telefone
			/*List<EstoqueAbrigos> estoqueAbrigos*/
		) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.capacidade = capacidade;
		this.ocupacao = ocupacao;
		this.responsavel = responsavel;
		this.telefone = telefone;
		//this.estoqueAbrigos = estoqueAbrigos;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	public Set<EstoqueAbrigos> getEstoqueAbrigos() {
        return estoqueAbrigos;
    }

    public void setEstoqueAbrigos(Set<EstoqueAbrigos> estoqueAbrigos) {
        this.estoqueAbrigos = estoqueAbrigos;
    }


	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getCapacidade() {
		return capacidade;
	}



	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}



	public String getOcupacao() {
		return ocupacao;
	}



	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}



	public String getResponsavel() {
		return responsavel;
	}



	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
