package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

import dominio.Abrigo;


public class AbrigoDAO {


	
	

	
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sos_rs");

	
	public void inserirAbrigo(Abrigo obj) {
		
		EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(obj);
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
	        em.createQuery("DELETE FROM Abrigo").executeUpdate(); // Correção na consulta JPQL
	        transaction.commit();
	    } catch (HibernateException e) {
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	}
	
	public void apagarPorId(Integer id) {
		EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        Abrigo abrigo = em.find(Abrigo.class, id);
            transaction.begin();
            em.remove(abrigo);
            transaction.commit();
        
            em.close();
        
		
	}
	
	

/*	public void atualizar(Abrigo obj, Integer id) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction transaction = em.getTransaction();

	    try {
	        transaction.begin();
	        
	        Abrigo existingEntity = em.find(Abrigo.class, id);
	        
	        if (existingEntity != null) {
	        	
	        	existingEntity.setNome(obj.getNome());
	        	existingEntity.setCapacidade(obj.getCapacidade());
	        	existingEntity.setEmail(obj.getEmail());
	        	existingEntity.setOcupacao(obj.getOcupacao());
	        	existingEntity.setResponsavel(obj.getResponsavel());
	            existingEntity.setEndereco(obj.getEndereco());
	            existingEntity.setTelefone(obj.getTelefone());
	           
	            em.merge(existingEntity);
	        } else {
	            System.out.println("Nenhuma entidade encontrada com o id " + obj.getId());
	        }
	        
	        transaction.commit();
	    } catch (HibernateException e) {
	        if (transaction.isActive()) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	}

	
	*/
	

	
	public Abrigo encontrarPorId(Integer id) {
		
		 EntityManager em = emf.createEntityManager();

		    try {
		         Abrigo entity = em.find(Abrigo.class, id);
		         System.out.println("Dados do abrigo de ID: " + entity.getId());
		            System.out.println("Nome: " + entity.getNome());
		            System.out.println("Endereço: " + entity.getEndereco());
		            System.out.println("Capacidade: " + entity.getCapacidade());
		            System.out.println("Ocupação: " + entity.getOcupacao());
		            System.out.println("Responsável: " + entity.getResponsavel());
		            System.out.println("Telefone: " + entity.getTelefone());
		        
		        
		            return entity;
		            
		        
		    } catch (HibernateException e) {
		        e.printStackTrace();
		        return null;
		    } finally {
		        em.close();
		    }
	}
	
	public List<Abrigo> retornaTodos() {
	    EntityManager em = emf.createEntityManager();
	    List<Abrigo> abrigosList = em.createQuery("SELECT a FROM Abrigo a", Abrigo.class).getResultList(); // Executa a consulta e retorna a lista de itens
	    em.close();

	    for (Abrigo abrigo : abrigosList) {
	        System.out.println("ID: " + abrigo.getId());
	        System.out.println("Nome: " + abrigo.getNome());
            System.out.println("Endereço: " + abrigo.getEndereco());
            System.out.println("Capacidade: " + abrigo.getCapacidade());
            System.out.println("Ocupação: " + abrigo.getOcupacao());
            System.out.println("Responsável: " + abrigo.getResponsavel());
            System.out.println("Telefone: " + abrigo.getTelefone());
         }

	    return abrigosList;
	}

	

	

	
	

	
	

	

	


	

}
