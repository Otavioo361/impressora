package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Marca;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Uf;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UfDao implements DaoInterface<Uf> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();

    @Override
    public void save(Uf obj) {
    }


    @Override
    public void update(Uf obj) {
    }

    @Override
    public boolean delete(Uf obj) {
        return false;
    }

    @Override
    public Uf findById(Long id) {
        String queryFind = "SELECT\n" +
                "  u\n" +
                "FROM Uf u\n" +
                "WHERE u.id = :id \n";
        TypedQuery<Uf> query = entityManager.createQuery(queryFind, Uf.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Uf> findAll() {
        String jpql = "SELECT u FROM Uf u  ORDER BY u.nmEstado ASC ";
        TypedQuery<Uf> query = entityManager.createQuery(jpql,Uf.class);
        return query.getResultList();
    }

    @Override
    public List<Uf> findActivesOnly() {
        String jpql = "SELECT u FROM Uf u ORDER BY u.nmEstado ASC ";
        TypedQuery<Uf> query = entityManager.createQuery(jpql,Uf.class);
        return query.getResultList();
    }
}
