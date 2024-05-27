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

            int quantidadeRestante = quantidade;
            for (EstoqueCentros estoqueCentros : estoquesCentro) {
                if (quantidadeRestante <= 0) break;

                int quantidadePedida = Math.min(quantidadeRestante, estoqueCentros.getQuantidade());
                Pedido pedido = new Pedido();
                pedido.setAbrigo(em.find(Abrigo.class, abrigoId));
                pedido.setItem(item);
                pedido.setQuantidade(quantidadePedida);
                pedido.setCentro(estoqueCentros.getCentro());

                estoqueCentros.setQuantidade(estoqueCentros.getQuantidade() - quantidadePedida);
                em.persist(pedido);
                em.merge(estoqueCentros);

                quantidadeRestante -= quantidadePedida;
            }

            if (quantidadeRestante > 0) {
                em.getTransaction().rollback();
                em.close();
                return "Não há quantidade suficiente do item nos centros de distribuição.";
            } else {
                em.getTransaction().commit();
            }
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

            Pedido pedido = em.find(Pedido.class, pedidoId);
            if (pedido == null) {
                em.getTransaction().rollback();
                em.close();
                return "Pedido não encontrado.";
            }

            pedido.setStatus(novoStatus);
            if (novoStatus == StatusPedido.ACEITO) {
                EstoqueCentros estoqueCentros = em.createQuery(
                                "SELECT ec FROM EstoqueCentros ec WHERE ec.centro = :centro AND ec.item = :item",
                                EstoqueCentros.class
                        )
                        .setParameter("centro", pedido.getCentro())
                        .setParameter("item", pedido.getItem())
                        .getSingleResult();
                estoqueCentros.setQuantidade((estoqueCentros.getQuantidade()) - pedido.getQuantidade());
                em.merge(estoqueCentros);
                EstoqueAbrigos estoqueAbrigos = em.createQuery(
                                "SELECT ec FROM EstoqueAbrigos ec WHERE ec.abrigo = :abrigo AND ec.item = :item",
                                EstoqueAbrigos.class
                        )
                        .setParameter("abrigo", pedido.getAbrigo())
                        .setParameter("item", pedido.getItem())
                        .getSingleResult();
                estoqueAbrigos.setQuantidade((estoqueAbrigos.getQuantidade()) + pedido.getQuantidade());
                em.merge(estoqueAbrigos);
                return "Pedido aceito com sucesso e quantidades atualizadas!";
            } else if (novoStatus == StatusPedido.REJEITADO) {
                return "Pedido rejeitado pelo centro";
            }
            em.merge(pedido);
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
}