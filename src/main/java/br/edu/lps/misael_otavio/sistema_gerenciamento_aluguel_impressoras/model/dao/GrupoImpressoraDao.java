package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Endereco;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.GrupoImpressora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;

import java.util.List;

public class GrupoImpressoraDao implements DaoInterface<GrupoImpressora> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();
    private final Logger logger =  LoggerSingleton.getLogger(this.getClass());


    @Override
    public void save(GrupoImpressora obj) {
        try {
            this.entityManager.getTransaction().begin();
            System.out.println(obj);
            GrupoImpressora gpImp = this.findByNameAndContrato(obj.getContrato().getId(),obj.getNmGrupoImpressora());
            if (gpImp != null) {
                throw new AluguelImpressoraException("Grupo impressora já existente na base de dados");
            }
            entityManager.persist(obj);
            this.entityManager.getTransaction().commit();
        }catch (RuntimeException e) {
            this.entityManager.getTransaction().rollback();
            throw new AluguelImpressoraException(e.getMessage());
        }
    }

    @Override
    public void update(GrupoImpressora obj) {
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
    public boolean delete(GrupoImpressora obj) {
        return false;
    }


    @Override
    public GrupoImpressora findById(Long id) {
        String jpql = "SELECT gimp FROM GrupoImpressora gimp WHERE gimp.id = :id";
        TypedQuery<GrupoImpressora> query = entityManager.createQuery(jpql,GrupoImpressora.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public GrupoImpressora findByNameAndContrato(Long contratoId,String nmGrupoImpressora) {
        String jpql = "SELECT gimp FROM GrupoImpressora gimp WHERE gimp.contrato.id = :idContrato AND gimp.nmGrupoImpressora = :nmGrupoImpressora";
        TypedQuery<GrupoImpressora> query = entityManager.createQuery(jpql,GrupoImpressora.class);
        query.setParameter("idContrato", contratoId);
        query.setParameter("nmGrupoImpressora", nmGrupoImpressora);
        if (query.getResultList().isEmpty()) {
            return null;
        }
        return query.setMaxResults(1).getResultList().get(0);
    }

    public List<GrupoImpressora> findByContratoId(Long contratoId) {
        String jpql = "SELECT gimp \n" +
                "FROM GrupoImpressora gimp \n" +
                "  LEFT JOIN gimp.impressoras imp \n" +
                "  LEFT JOIN imp.modeloImpressora mimp \n" +
                "  LEFT JOIN mimp.taxa \n" +
                "  LEFT JOIN mimp.marcaImpressora \n" +
                "  JOIN FETCH gimp.endereco  \n" +
                "\n" +
                "WHERE gimp.contrato.id = :idContrato";
        TypedQuery<GrupoImpressora> query = entityManager.createQuery(jpql,GrupoImpressora.class);
        query.setParameter("idContrato", contratoId);
        return query.getResultList();
    }

    @Override
    public List<GrupoImpressora> findAll() {
        String jpql = "SELECT gimp FROM GrupoImpressora gimp JOIN FETCH gimp.contrato";
        TypedQuery<GrupoImpressora> query = entityManager.createQuery(jpql,GrupoImpressora.class);
        return query.getResultList();
    }

    @Override
    public List<GrupoImpressora> findActivesOnly() {
        String jpql = "SELECT gimp FROM GrupoImpressora gimp JOIN FETCH gimp.contrato";
        TypedQuery<GrupoImpressora> query = entityManager.createQuery(jpql,GrupoImpressora.class);
        return query.getResultList();
    }
}
