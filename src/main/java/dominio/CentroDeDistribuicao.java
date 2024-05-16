package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;

@Entity
@Table(name = "centro_distribuicao")
public class CentroDeDistribuicao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String endereco;
	
	public CentroDeDistribuicao() {}

	public CentroDeDistribuicao(Integer id, String nome, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
	}

	public void inserirCentros() {
	        CentroDeDistribuicao c1 = new CentroDeDistribuicao(null, "Esperança", "Av. Boqueirão, 2450 - Igara, Canoas - RS, 92032-420");
	        CentroDeDistribuicao c2 = new CentroDeDistribuicao(null, "Prosperidade.", "Av. Borges de Medeiros 1501 Porto Alegre CEP: 90119900");
	        CentroDeDistribuicao c3 = new CentroDeDistribuicao(null, "Reconstrução.", "R. Dr. Décio Martins Costa, 312 - Vila Eunice Nova, Cachoeirinha - RS, 94920-170");

	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sos-rs");
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction transaction = em.getTransaction();

	        try {
	            transaction.begin();
	            em.persist(c1);
	            em.persist(c2);
	            em.persist(c3);
	            transaction.commit();
	        } catch (Exception e) {
	        	
	        } finally {
	            em.close();
	        
	        }
	}
	
}
