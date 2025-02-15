package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Fornecedor;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Taxa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MarcaDao implements DaoInterface<Taxa> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();

    @Override
    public void save(Fornecedor obj) {
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
    public void update(Fornecedor obj) {

    }

    @Override
    public boolean delete(Fornecedor obj) {
        return false;
    }

    @Override
    public void save(Taxa obj) {

    }

    @Override
    public void update(Taxa obj) {

    }

    @Override
    public boolean delete(Taxa obj) {
        return false;
    }

    @Override
    public Fornecedor findById(Long id) {
        String queryFind = "SELECT\n" +
                "  f\n" +
                "FROM Fornecedor f\n" +
                "JOIN FETCH f.tipoFornecedor mi\n" +
                "WHERE f.id = :id \n";
        TypedQuery<Fornecedor> query = entityManager.createQuery(queryFind, Fornecedor.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Fornecedor> findAll() {
        String jpql = "SELECT f FROM Fornecedor f WHERE f.inFornecedorDisponivel ORDER BY f.nmFornecedor ASC ";
        TypedQuery<Fornecedor> query = entityManager.createQuery(jpql,Fornecedor.class);
        return query.getResultList();
    }

    @Override
    public List<Taxa> findActivesOnly() {
        return List.of();
    }
}
