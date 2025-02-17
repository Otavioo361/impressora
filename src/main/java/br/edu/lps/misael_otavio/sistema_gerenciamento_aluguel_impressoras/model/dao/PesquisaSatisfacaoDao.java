package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Cliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.PesquisaSatisfacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;

import java.util.List;

public class PesquisaSatisfacaoDao implements DaoInterface<PesquisaSatisfacao> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();
    private final Logger logger =  LoggerSingleton.getLogger(this.getClass());


    @Override
    public void save(PesquisaSatisfacao obj) {
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
    public void update(PesquisaSatisfacao obj) {
        entityManager.merge(obj);;
    }

    @Override
    public boolean delete(PesquisaSatisfacao obj) {
        return false;
    }


    @Override
    public PesquisaSatisfacao findById(Long id) {
        return null;
    }

    @Override
    public List<PesquisaSatisfacao> findAll() {
        String jpql = "SELECT p FROM PesquisaSatisfacao p ";
        TypedQuery<PesquisaSatisfacao> query = entityManager.createQuery(jpql,PesquisaSatisfacao.class);
        return query.getResultList();
    }

    @Override
    public List<PesquisaSatisfacao> findActivesOnly() {
        return this.findAll();
    }
}
