package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.GrupoImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ImpressoraGrupoImpressora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;

import java.util.List;

public class ImpressoraGrupoImpressoraDao implements DaoInterface<ImpressoraGrupoImpressora> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();
    private final Logger logger =  LoggerSingleton.getLogger(this.getClass());


    @Override
    public void save(ImpressoraGrupoImpressora obj) {
        try {
            this.entityManager.getTransaction().begin();
            entityManager.persist(obj);
            this.entityManager.getTransaction().commit();
        }catch (RuntimeException e) {
            this.entityManager.getTransaction().rollback();
            throw new AluguelImpressoraException(e.getMessage());
        }
    }


    public void saveAll(List<ImpressoraGrupoImpressora> obj) {
        try {
            this.entityManager.getTransaction().begin();
            for(ImpressoraGrupoImpressora impressora : obj) {
                entityManager.persist(impressora);
            }
            this.entityManager.getTransaction().commit();
        }catch (RuntimeException e) {
            this.entityManager.getTransaction().rollback();
            throw new AluguelImpressoraException(e.getMessage());
        }
    }


    @Override
    public void update(ImpressoraGrupoImpressora obj) {
        try {
            this.entityManager.getTransaction().begin();
            entityManager.merge(obj);;
            this.entityManager.getTransaction().commit();
        }catch (RuntimeException e) {
            this.entityManager.getTransaction().rollback();
            throw new AluguelImpressoraException(e.getMessage());
        }
    }

    @Override
    public boolean delete(ImpressoraGrupoImpressora obj) {
        return false;
    }


    @Override
    public ImpressoraGrupoImpressora findById(Long id) {
        String jpql = "SELECT gimp FROM ImpressoraGrupoImpressora gimp WHERE gimp.id = :id";
        TypedQuery<ImpressoraGrupoImpressora> query = entityManager.createQuery(jpql,ImpressoraGrupoImpressora.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<ImpressoraGrupoImpressora> findAll() {
        String jpql = "SELECT gimp FROM ImpressoraGrupoImpressora gimp";
        TypedQuery<ImpressoraGrupoImpressora> query = entityManager.createQuery(jpql,ImpressoraGrupoImpressora.class);
        return query.getResultList();
    }

    @Override
    public List<ImpressoraGrupoImpressora> findActivesOnly() {
        String jpql = "SELECT gimp FROM GrupoImpressora gimp";
        TypedQuery<ImpressoraGrupoImpressora> query = entityManager.createQuery(jpql,ImpressoraGrupoImpressora.class);
        return query.getResultList();
    }
}
