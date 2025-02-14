package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Fornecedor;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ModeloImpressora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class FornecedorDao implements DaoInterface<Fornecedor> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();

    @Override
    public Fornecedor save(Fornecedor obj) {
        return new Fornecedor();
    }

    @Override
    public void update(Fornecedor obj) {

    }

    @Override
    public boolean delete(Fornecedor obj) {
        return false;
    }

    @Override
    public Fornecedor findById(Long id) {
        return null;
    }

    @Override
    public List<Fornecedor> findAll() {
        String jpql = "SELECT f FROM Fornecedor f ORDER BY f.nmFornecedor ASC ";
        TypedQuery<Fornecedor> query = entityManager.createQuery(jpql,Fornecedor.class);
        return query.getResultList();
    }
}
