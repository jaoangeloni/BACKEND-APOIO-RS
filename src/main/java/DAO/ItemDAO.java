package aplicativo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ItemDAO {
    // Cria uma instância do EntityManagerFactory usando a unidade de persistência "aplicativoPU"
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicativoPU");

    // Método para criar um item no banco de dados
    public void createItem(Item item) {
        EntityManager em = emf.createEntityManager(); // Cria uma nova instância de EntityManager
        em.getTransaction().begin(); // Inicia uma transação
        em.persist(item); // Persiste o item (insere no banco de dados)
        em.getTransaction().commit(); // Confirma a transação
        em.close(); // Fecha o EntityManager
    }

    // Método para buscar todos os itens no banco de dados
    public List<Item> getAllItems() {
        EntityManager em = emf.createEntityManager(); // Cria uma nova instância de EntityManager
        List<Item> items = em.createQuery("SELECT i FROM Item i", Item.class).getResultList(); // Executa a consulta e retorna a lista de itens
        em.close(); // Fecha o EntityManager
        return items;
    }

    // Método para buscar um item pelo seu ID
    public Item getItemById(Long id) {
        EntityManager em = emf.createEntityManager(); // Cria uma nova instância de EntityManager
        Item item = em.find(Item.class, id); // Busca o item pelo ID
        em.close(); // Fecha o EntityManager
        return item;
    }

    // Método para atualizar um item
    public void updateItem(Long id, Item itemDetails) {
        EntityManager em = emf.createEntityManager(); // Cria uma nova instância de EntityManager
        em.getTransaction().begin(); // Inicia uma transação
        Item item = em.find(Item.class, id); // Busca o item pelo ID
        if (item != null) {
            item.setNome(itemDetails.getNome());
            item.setCategoria(itemDetails.getCategoria());
            item.setQuantidade(itemDetails.getQuantidade());
            item.setTamanho(itemDetails.getTamanho());
            item.setNumeroCalcado(itemDetails.getNumeroCalcado());
            em.getTransaction().commit(); // Confirma a transação
        } else {
            em.getTransaction().rollback(); // Desfaz a transação se o item não for encontrado
        }
        em.close(); // Fecha o EntityManager
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
}
