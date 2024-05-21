package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
}

