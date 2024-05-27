package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Item;

public class ItemDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicativoPU");

    public void createItem(Item item) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void inserir(Item item) {
        createItem(item);
    }

    public void apagarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM Item");
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Item> getAllItems() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT i FROM Item i", Item.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Item getItemById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Item.class, id);
        } finally {
            em.close();
        }
    }

    public void updateItem(Long id, Item itemDetails) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Item item = em.find(Item.class, id);
            if (item != null) {
                item.setNome(itemDetails.getNome());
                item.setQuantidade(itemDetails.getQuantidade());
                item.setTamanho(itemDetails.getTamanho());
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void deleteItem(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Item item = em.find(Item.class, id);
            if (item != null) {
                em.remove(item);
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

   
    public void transferirItens(Long itemId, int quantidade, String localOrigem, String localDestino) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Item itemOrigem = (Item) em.createQuery("SELECT i FROM Item i WHERE i.id = :id AND i.local = :local")
                .setParameter("id", itemId)
                .setParameter("local", localOrigem)
                .getSingleResult();

            Item itemDestino = (Item) em.createQuery("SELECT i FROM Item i WHERE i.id = :id AND i.local = :local")
                .setParameter("id", itemId)
                .setParameter("local", localDestino)
                .getSingleResult();

            if (itemOrigem != null && itemDestino != null) {
                itemOrigem.setQuantidade(itemOrigem.getQuantidade() - quantidade);
                itemDestino.setQuantidade(itemDestino.getQuantidade() + quantidade);

                em.merge(itemOrigem);
                em.merge(itemDestino);

                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    
    public void verificarAlertas() {
        EntityManager em = emf.createEntityManager();
        try {
            List<Item> excedenteItems = em.createQuery("SELECT i FROM Item i WHERE i.quantidade > 900", Item.class).getResultList();
            List<Item> escassezItems = em.createQuery("SELECT i FROM Item i WHERE i.quantidade < 100", Item.class).getResultList();

            System.out.println("Alertas de Excedente:");
            for (Item item : excedenteItems) {
                System.out.println("ID: " + item.getId() + " - Local: " + item.getLocal() + " - Quantidade: " + item.getQuantidade());
            }

            System.out.println("Alertas de Escassez:");
            for (Item item : escassezItems) {
                System.out.println("ID: " + item.getId() + " - Local: " + item.getLocal() + " - Quantidade: " + item.getQuantidade());
            }
        } finally {
            em.close();
        }
    }
}
