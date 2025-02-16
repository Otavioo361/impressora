package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Impressora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ImpressoraDao implements DaoInterface<Impressora> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();


    @Override
    public void save(Impressora obj) {
        try {
            this.entityManager.getTransaction().begin();
            entityManager.persist(obj);
            this.entityManager.getTransaction().commit();

        }catch (RuntimeException e) {
            this.entityManager.getTransaction().rollback();
            throw new AluguelImpressoraException(e.getMessage());
        }
    }

    @Override
    public void update(Impressora obj) {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(obj);
            this.entityManager.getTransaction().commit();
        }catch (RuntimeException e) {
            this.entityManager.getTransaction().rollback();
            throw new AluguelImpressoraException(e.getMessage());
        }
    }

    @Override
    public boolean delete(Impressora obj) {
        return false;
    }

    @Override
    public Impressora findById(Long id) {
        String queryFind = "SELECT\n" +
                "  im\n" +
                "FROM Impressora im\n" +
                "JOIN FETCH im.modeloImpressora mi\n" +
                "JOIN FETCH mi.taxa t\n" +
                "WHERE im.id = :id \n";
        TypedQuery<Impressora> query = entityManager.createQuery(queryFind, Impressora.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Impressora> findAll() {
        return this.listar(100);
    }

    @Override
    public List<Impressora> findActivesOnly() {
        String queryFind = "SELECT\n" +
                "  im\n" +
                "FROM Impressora im\n" +
                "JOIN FETCH im.modeloImpressora mi\n" +
                "JOIN FETCH mi.taxa t\n" +
                "JOIN FETCH t.tipoRecorrencia\n" +
                " WHERE im.inImpressoraDisponivel AND NOT im.inImpressoraAlugada \n" +
                "ORDER BY im.dtInclusao DESC";
        TypedQuery<Impressora> query = entityManager.createQuery(queryFind, Impressora.class);
        return query.getResultList();
    }

    public List<Impressora> findByIdModelo(Long idModelo,Integer quantidate) {
        String queryFind = "SELECT\n" +
                "  im\n" +
                "FROM Impressora im\n" +
                "JOIN FETCH im.modeloImpressora mi\n" +
                "JOIN FETCH mi.taxa t\n" +
                "WHERE im.modeloImpressora.id = :idModelo AND im.inImpressoraDisponivel AND NOT im.inImpressoraAlugada \n" +
                "ORDER BY im.dtInclusao ASC";
        TypedQuery<Impressora> query = entityManager.createQuery(queryFind, Impressora.class);
        query.setParameter("idModelo", idModelo);
        return query.setMaxResults(quantidate).getResultList();
    }
    private List<Impressora> listar(int quantidade) {
        String queryFind = "SELECT\n" +
                "  im\n" +
                "FROM Impressora im\n" +
                "JOIN FETCH im.modeloImpressora mi\n" +
                "JOIN FETCH mi.taxa t\n" +
                "JOIN FETCH t.tipoRecorrencia\n" +
                "ORDER BY im.dtInclusao DESC";
        TypedQuery<Impressora> query = entityManager.createQuery(queryFind, Impressora.class);
        return query.setMaxResults(quantidade).getResultList();
    }
}
