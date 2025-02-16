package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Pessoa;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.PessoaFisica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PessoaFisicaDao implements DaoInterface<PessoaFisica> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();

    @Override
    public void save(PessoaFisica obj) {
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
    public void update(PessoaFisica obj) {

    }

    @Override
    public boolean delete(PessoaFisica obj) {
        return false;
    }

    @Override
    public PessoaFisica findById(Long id) {
        String queryFind = "SELECT pf FROM PessoaFisica pf WHERE pf.id = :id \n";
        TypedQuery<PessoaFisica> query = entityManager.createQuery(queryFind, PessoaFisica.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<PessoaFisica> findAll() {
        String jpql = "SELECT pf FROM PessoaFisica pf ORDER BY pf.dtInclusao  ASC ";
        TypedQuery<PessoaFisica> query = entityManager.createQuery(jpql,PessoaFisica.class);
        return query.getResultList();
    }

    @Override
    public List<PessoaFisica> findActivesOnly() {
        String jpql = "SELECT pf FROM PessoaFisica pf ORDER BY pf.dtInclusao  ASC";
        TypedQuery<PessoaFisica> query = entityManager.createQuery(jpql,PessoaFisica.class);
        return query.getResultList();
    }
}
