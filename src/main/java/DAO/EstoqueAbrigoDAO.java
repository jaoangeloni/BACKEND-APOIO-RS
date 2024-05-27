package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import dominio.EstoqueAbrigos;
import dominio.EstoqueCentros;

public class EstoqueAbrigoDAO {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sos-rs");

	// cadastro
	public void inserir(EstoqueAbrigos estoque) {
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
    public List<EstoqueAbrigos> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<EstoqueAbrigos> abrigos = null;
        try {
            Query query = em.createQuery("SELECT ea FROM EstoqueAbrigos ea");
            abrigos = query.getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return abrigos;
    }
    
	// excluir
	public void excluirPorId(Integer id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			EstoqueAbrigos abrigos = em.find(EstoqueAbrigos.class, id);
			em.remove(abrigos);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	// alterar por id
	public void alterarPorId(Integer id, EstoqueAbrigos estoque) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			EstoqueAbrigos estoqueBanco = em.find(EstoqueAbrigos.class, id);

			estoqueBanco.setAbrigo(estoque.getAbrigo());
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

	public EstoqueAbrigos listarPorId(Integer id) {
		EntityManager em = emf.createEntityManager();
		EstoqueAbrigos estoque = new EstoqueAbrigos();
		try {
			estoque = em.find(EstoqueAbrigos.class, id);
		} catch (HibernateException e) {
		} finally {
			em.close();
		}
		return estoque;
	}
}
