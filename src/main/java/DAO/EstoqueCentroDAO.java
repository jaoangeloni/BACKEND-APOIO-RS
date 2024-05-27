package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;

import dominio.EstoqueCentros;
import dto.EstoqueCentroDTO;

public class EstoqueCentroDAO {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sos-rs");

	// cadastro
	public void inserir(EstoqueCentros estoque) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(estoque);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			em.close();
			System.out.printf("Item cadastrado no estoque!\n");
		}
	}

	//listar todos
	public List<EstoqueCentroDTO> listarTodos() {
	    EntityManager em = emf.createEntityManager();
	    List<EstoqueCentroDTO> estoque = null;
	    try {
	        String jpql = "SELECT new dto.EstoqueCentroDTO(ec.id, ec.item, SUM(ec.quantidade), ec.limite) "
	                    + "FROM EstoqueCentros ec "
	                    + "GROUP BY ec.id, ec.item, ec.limite";
	        TypedQuery<EstoqueCentroDTO> query = em.createQuery(jpql, EstoqueCentroDTO.class);
	        estoque = query.getResultList();
	    } catch (HibernateException e) {
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	    return estoque;
	}
	
	// excluir
	public void excluirPorId(Integer id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			EstoqueCentros estoque = em.find(EstoqueCentros.class, id);
			em.remove(estoque);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	// alterar por id
	public void alterarPorId(Integer id, EstoqueCentros estoque) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			EstoqueCentros estoqueBanco = em.find(EstoqueCentros.class, id);

			estoqueBanco.setCentro(estoque.getCentro());
			estoqueBanco.setItem(estoque.getItem());
			estoqueBanco.setQuantidade(estoque.getQuantidade());

			em.merge(estoqueBanco);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public EstoqueCentros listarPorId(Integer id) {
		EntityManager em = emf.createEntityManager();
		EstoqueCentros estoque = new EstoqueCentros();
		try {
			estoque = em.find(EstoqueCentros.class, id);
		} catch (HibernateException e) {
		} finally {
			em.close();
		}
		return estoque;
	}
}
