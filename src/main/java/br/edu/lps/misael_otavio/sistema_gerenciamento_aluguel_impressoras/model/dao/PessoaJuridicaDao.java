package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.PessoaFisica;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.PessoaJuridica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PessoaJuridicaDao implements DaoInterface<PessoaJuridica> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();

    @Override
    public void save(PessoaJuridica obj) {
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
    public void update(PessoaJuridica obj) {

    }

    @Override
    public boolean delete(PessoaJuridica obj) {
        return false;
    }

    @Override
    public PessoaJuridica findById(Long id) {
        String queryFind = "SELECT pj FROM PessoaJuridica pj WHERE pj.id = :id \n";
        TypedQuery<PessoaJuridica> query = entityManager.createQuery(queryFind, PessoaJuridica.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<PessoaJuridica> findAll() {
        String jpql = "SELECT pj FROM PessoaJuridica pj ORDER BY pj.dtInclusao  ASC ";
        TypedQuery<PessoaJuridica> query = entityManager.createQuery(jpql,PessoaJuridica.class);
        return query.getResultList();
    }

    @Override
    public List<PessoaJuridica> findActivesOnly() {
        String jpql = "SELECT pj FROM PessoaJuridica pj ORDER BY pj.dtInclusao  ASC ";
        TypedQuery<PessoaJuridica> query = entityManager.createQuery(jpql,PessoaJuridica.class);
        return query.getResultList();
    }
}
