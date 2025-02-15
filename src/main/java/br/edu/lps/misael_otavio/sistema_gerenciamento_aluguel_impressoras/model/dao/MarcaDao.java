package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Marca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MarcaDao implements DaoInterface<Marca> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();

    @Override
    public void save(Marca obj) {
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
    public void update(Marca obj) {

    }

    @Override
    public boolean delete(Marca obj) {
        return false;
    }

    @Override
    public Marca findById(Long id) {
        String queryFind = "SELECT\n" +
                "  f\n" +
                "FROM Marca f\n" +
                "WHERE f.id = :id \n";
        TypedQuery<Marca> query = entityManager.createQuery(queryFind, Marca.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Marca> findAll() {
        String jpql = "SELECT m FROM Marca m  ORDER BY m.nmMarca ASC ";
        TypedQuery<Marca> query = entityManager.createQuery(jpql,Marca.class);
        return query.getResultList();
    }

    @Override
    public List<Marca> findActivesOnly() {
        String jpql = "SELECT m FROM Marca m WHERE m.inMarcaAtivo ORDER BY m.nmMarca ASC ";
        TypedQuery<Marca> query = entityManager.createQuery(jpql,Marca.class);
        return query.getResultList();
    }
}
