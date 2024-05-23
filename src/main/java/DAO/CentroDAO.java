package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import dominio.Centro;

public class CentroDAO {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sos-rs");

    public void inserir(Centro centro) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
        	
            transaction.begin();
            em.persist(centro);
            transaction.commit();
            
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    public void apagarTodos() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.createQuery("DELETE FROM Centro").executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    public List<Centro> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Centro> centros = null;
        try {
            Query query = em.createQuery("SELECT c FROM Centro c");
            centros = query.getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return centros;
    }
    
    public Centro listarPorId(Integer id) {
        EntityManager em = emf.createEntityManager();
        Centro centro = new Centro();
        try {
        	centro = em.find(Centro.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return centro;
    }
}

