package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Impressora;
import jakarta.persistence.EntityManager;
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
    public List<Impressora> listarTop20() {
        return this.listar(20);
    }
    @Override
    public List<Impressora> findAll() {
        return this.listar(100);
    }

    @Override
    public List<Impressora> findActivesOnly() {
        return List.of();
    }

    private List<Impressora> listar(int quantidade) {
        String queryFind = "SELECT\n" +
                "  im\n" +
                "FROM Impressora im\n" +
                "JOIN FETCH im.modeloImpressora mi\n" +
                "JOIN FETCH mi.taxa t\n" +
                "ORDER BY im.dtInclusao DESC";
        TypedQuery<Impressora> query = entityManager.createQuery(queryFind, Impressora.class);
        return query.setMaxResults(quantidade).getResultList();
    }
}
