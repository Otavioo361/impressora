package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Cliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Endereco;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;

import java.util.List;

public class EnderecoDao implements DaoInterface<Endereco> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();
    private final Logger logger =  LoggerSingleton.getLogger(this.getClass());


    @Override
    public void save(Endereco obj) {
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
    public void update(Endereco obj) {
        entityManager.merge(obj);;
    }

    @Override
    public boolean delete(Endereco obj) {
        return false;
    }


    @Override
    public Endereco findById(Long id) {
        return null;
    }

    @Override
    public List<Endereco> findAll() {
        String jpql = "SELECT e FROM Endereco e JOIN FETCH e.uf";
        TypedQuery<Endereco> query = entityManager.createQuery(jpql,Endereco.class);
        return query.getResultList();
    }

    @Override
    public List<Endereco> findActivesOnly() {
        String jpql = "SELECT e FROM Endereco e JOIN FETCH e.uf ";
        TypedQuery<Endereco> query = entityManager.createQuery(jpql,Endereco.class);
        return query.getResultList();
    }
}
