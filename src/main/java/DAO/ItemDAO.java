package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import dominio.Centro;
import dominio.Doacao;
import dominio.Item;

public class ItemDAO {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sos-rs");

    public void inserir(Item item) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(item);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Item> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Item> centros = null;
        try {
            Query query = em.createQuery("SELECT i FROM Item i");
            centros = query.getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return centros;
    }
   
    // Método para buscar um item pelo seu ID
    public Item listarPorId(Integer id) {
        EntityManager em = emf.createEntityManager();
        Item item = new Item();
        try {
        	item = em.find(Item.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return item;
    }

    public void alterarPorId(Integer id, Item item) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            transaction.begin();
            Item itemBanco = em.find(Item.class, id);
            itemBanco.setNome(item.getNome());
            itemBanco.setCategoria(item.getCategoria());
            itemBanco.setDescricao(item.getDescricao());

            em.merge(itemBanco);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    // Método para deletar um item
    public void deleteItem(Long id) {
        EntityManager em = emf.createEntityManager(); // Cria uma nova instância de EntityManager
        em.getTransaction().begin(); // Inicia uma transação
        Item item = em.find(Item.class, id); // Busca o item pelo ID
        if (item != null) {
            em.remove(item); // Remove o item
            em.getTransaction().commit(); // Confirma a transação
        } else {
            em.getTransaction().rollback(); // Desfaz a transação se o item não for encontrado
        }
        em.close(); // Fecha o EntityManager
    }
    
    public void apagarTodos() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.createQuery("DELETE FROM Item").executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
}