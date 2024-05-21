package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

import dominio.Centro;

public class CentroDAO {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sos-rs");

    public void inserirCentros() {
        Centro c1 = new Centro(null, "Esperança", "Av. Boqueirão, 2450 - Igara, Canoas - RS, 92032-420");
        Centro c2 = new Centro(null, "Prosperidade.", "Av. Borges de Medeiros 1501 Porto Alegre CEP: 90119900");
        Centro c3 = new Centro(null, "Reconstrução.", "R. Dr. Décio Martins Costa, 312 - Vila Eunice Nova, Cachoeirinha - RS, 94920-170");

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
