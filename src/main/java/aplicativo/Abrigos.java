/*package aplicativo;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
public class Abrigos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String endereco;
	private String email;
	private int capacidade;
	private String ocupacao;
	private String responsavel;
	private String telefone;
	
	
	
	
	public Abrigos() {
	}


	
	public Abrigos(Integer id, String nome, String endereco, String email, int capacidade, String ocupacao, String responsavel,
			String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.capacidade = capacidade;
		this.ocupacao = ocupacao;
		this.responsavel = responsavel;
		this.telefone = telefone;
	}

		

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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
	
	public void inserirTeste() {
		Abrigos ab1 = new Abrigos(1, "abrigo1", "rua do bairro", "abrigo@abrigo.com", 300, "75%", "Joao Augusto", "139989898");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sos_rs");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            transaction.begin();
            em.persist(ab1);
            transaction.commit();
        } catch (Exception e) {
        	
        } finally {
            em.close();
        
        }
		
	}
	

	
	
}*/
