package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

public class DatabaseCleaner {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sos-rs");

	public static void clearDatabase() {
		EntityManager em = emf.createEntityManager();
	       EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			em.createQuery("DELETE FROM Abrigo").executeUpdate();
			em.createQuery("DELETE FROM Doacao").executeUpdate();
			em.createQuery("DELETE FROM EstoqueAbrigos").executeUpdate();
			em.createQuery("DELETE FROM EstoqueCentros").executeUpdate();
			em.createQuery("DELETE FROM Item").executeUpdate();
			em.createQuery("DELETE FROM Pedido").executeUpdate();
			em.createQuery("DELETE FROM Centro").executeUpdate();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
