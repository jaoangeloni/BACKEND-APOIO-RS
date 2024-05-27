package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import dominio.Doacao;

public class DoacaoDAO {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sos-rs");

	//cadastro
    public void inserir(Doacao doacao) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(doacao);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            em.close();
            System.out.printf("Doação feita com sucesso!\n");
        }
    }
 
    //listar todos
    public List<Doacao> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Doacao> doacoes = null;
        try {
            Query query = em.createQuery("SELECT d FROM Doacao d");
            doacoes = query.getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return doacoes;
    }
    
    //excluir
    public void excluirPorId(Integer id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Doacao doacao = em.find(Doacao.class, id);
            em.remove(doacao);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
   
    //alterar por id
    public void alterarPorId(Integer id, Doacao doacao) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            transaction.begin();
            Doacao doacaoBanco = em.find(Doacao.class, id);
            
            doacaoBanco.setItem(doacao.getItem());
            doacaoBanco.setCentro(doacao.getCentro());
            doacaoBanco.setQuantidade(doacao.getQuantidade());
            
            em.merge(doacaoBanco);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    public Doacao listarPorId(Integer id) {
        EntityManager em = emf.createEntityManager();
        Doacao doacao = new Doacao();
        try {
            doacao = em.find(Doacao.class, id);
        } catch (HibernateException e) {
        } finally {
            em.close();
        }
        return doacao;
    }
}

