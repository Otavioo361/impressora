package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Fornecedor;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Taxa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TaxaDao implements DaoInterface<Taxa> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();

    @Override
    public void save(Taxa obj) {
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
    public void update(Taxa obj) {

    }

    @Override
    public boolean delete(Taxa obj) {
        return false;
    }

    @Override
    public Taxa findById(Long id) {
        String queryFind = "SELECT\n" +
                "  t\n" +
                "FROM Taxa t\n" +
                "JOIN FETCH t.tipoTaxa \n" +
                "JOIN FETCH t.tipoRecorrencia \n" +
                "WHERE t.id = :id \n";
        TypedQuery<Taxa> query = entityManager.createQuery(queryFind, Taxa.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Taxa> findAll() {
        String jpql = "SELECT t FROM Taxa t JOIN FETCH t.tipoTaxa tt JOIN FETCH t.tipoRecorrencia ORDER BY tt.nmTipoTaxa ASC ";
        TypedQuery<Taxa> query = entityManager.createQuery(jpql,Taxa.class);
        return query.getResultList();
    }

    @Override
    public List<Taxa> findActivesOnly() {
        String jpql = "SELECT t FROM Taxa t JOIN FETCH t.tipoTaxa tt JOIN FETCH t.tipoRecorrencia WHERE t.inTaxaAtivo ORDER BY tt.nmTipoTaxa ASC ";
        TypedQuery<Taxa> query = entityManager.createQuery(jpql,Taxa.class);
        return query.getResultList();
    }
}
