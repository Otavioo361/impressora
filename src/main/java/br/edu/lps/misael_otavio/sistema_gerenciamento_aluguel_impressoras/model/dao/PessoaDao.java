package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Fornecedor;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Pessoa;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Taxa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PessoaDao implements DaoInterface<Pessoa> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();

    @Override
    public void save(Pessoa obj) {
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
    public void update(Pessoa obj) {

    }

    @Override
    public boolean delete(Pessoa obj) {
        return false;
    }

    @Override
    public Pessoa findById(Long id) {
        String queryFind = "SELECT p FROM Pessoa p LEFT JOIN p.pessoaFisica LEFT JOIN p.pessoaJuridica WHERE p.id = :id ORDER BY p.nmPessoa  ASC  \n";
        TypedQuery<Pessoa> query = entityManager.createQuery(queryFind, Pessoa.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Pessoa> findAll() {
        String jpql = "SELECT p FROM Pessoa p LEFT JOIN p.pessoaFisica LEFT JOIN p.pessoaJuridica ORDER BY p.nmPessoa  ASC ";
        TypedQuery<Pessoa> query = entityManager.createQuery(jpql,Pessoa.class);
        return query.getResultList();
    }

    @Override
    public List<Pessoa> findActivesOnly() {
        String jpql = "SELECT p FROM Pessoa p LEFT JOIN p.pessoaFisica LEFT JOIN p.pessoaJuridica ORDER BY p.nmPessoa  ASC ";
        TypedQuery<Pessoa> query = entityManager.createQuery(jpql,Pessoa.class);
        return query.getResultList();
    }
}
