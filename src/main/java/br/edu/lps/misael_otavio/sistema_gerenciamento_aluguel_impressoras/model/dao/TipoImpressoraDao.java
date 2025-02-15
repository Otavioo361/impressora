package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Marca;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.TipoImpressora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TipoImpressoraDao implements DaoInterface<TipoImpressora> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();

    @Override
    public void save(TipoImpressora obj) {
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
    public void update(TipoImpressora obj) {

    }

    @Override
    public boolean delete(TipoImpressora obj) {
        return false;
    }

    @Override
    public TipoImpressora findById(Long id) {
        String queryFind = "SELECT\n" +
                "  ti\n" +
                "FROM TipoImpressora ti\n" +
                "WHERE ti.id = :id \n";
        TypedQuery<TipoImpressora> query = entityManager.createQuery(queryFind, TipoImpressora.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<TipoImpressora> findAll() {
        String jpql = "SELECT ti FROM TipoImpressora ti  ORDER BY ti.nmTipoImpressora ASC ";
        TypedQuery<TipoImpressora> query = entityManager.createQuery(jpql,TipoImpressora.class);
        return query.getResultList();
    }

    @Override
    public List<TipoImpressora> findActivesOnly() {
        String jpql = "SELECT ti FROM TipoImpressora ti WHERE ti.inTipoImpressoraAtivo ORDER BY ti.nmTipoImpressora ASC ";
        TypedQuery<TipoImpressora> query = entityManager.createQuery(jpql,TipoImpressora.class);
        return query.getResultList();
    }
}
