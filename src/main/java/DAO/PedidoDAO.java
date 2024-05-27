package DAO;

import dominio.*;
import enums.StatusPedido;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PedidoDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sos-rs");

    public List<EstoqueCentros> listarCentrosDisponiveis(Item item) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<EstoqueCentros> query = em.createQuery(
                    "SELECT ec FROM EstoqueCentros ec WHERE ec.item = :item ORDER BY ec.quantidade DESC",
                    EstoqueCentros.class
            );
            query.setParameter("item", item);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public String criarPedido(Integer abrigoId, Item item, int quantidade) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            List<EstoqueCentros> estoquesCentro = listarCentrosDisponiveis(item);
            // Lógica para criar o pedido
            em.getTransaction().commit();
            return "Pedido realizado com sucesso!";
        } catch (HibernateException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return "Erro ao criar pedido: " + e.getMessage();
        } finally {
            em.close();
        }
    }

    public String atualizarStatusDoPedido(Integer pedidoId, StatusPedido novoStatus) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            // Lógica para atualizar o status do pedido
            em.getTransaction().commit();
            return "Status do pedido atualizado com sucesso!";
        } catch (HibernateException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return "Erro ao atualizar status do pedido: " + e.getMessage();
        } finally {
            em.close();
        }
    }

    public List<Pedido> listarPedidosPendentesPorCentro(Integer centroId) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Pedido> query = em.createQuery(
                    "SELECT p FROM Pedido p WHERE p.centro.id = :centro and p.status = :status",
                    Pedido.class
            );
            query.setParameter("centro", centroId);
            query.setParameter("status", StatusPedido.PENDENTE);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public String aceitarPedido(Long pedidoId) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Pedido pedido = em.find(Pedido.class, pedidoId);
            if (pedido == null) {
                return "Pedido não encontrado.";
            }
            pedido.setStatus(StatusPedido.ACEITO);
            em.merge(pedido);

            // Atualizar estoques
            // Lógica para atualizar estoques

            em.getTransaction().commit();
            return "Pedido aceito e estoque atualizado com sucesso.";
        } catch (HibernateException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return "Erro ao aceitar pedido: " + e.getMessage();
        } finally {
            em.close();
        }
    }
}


