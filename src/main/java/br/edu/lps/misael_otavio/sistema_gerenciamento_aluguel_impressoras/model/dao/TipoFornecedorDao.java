package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Fornecedor;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.TipoFornecedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TipoFornecedorDao implements DaoInterface<TipoFornecedor> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();
    @Override
    public void save(TipoFornecedor obj) {

    }

    @Override
    public void update(TipoFornecedor obj) {

    }

    @Override
    public boolean delete(TipoFornecedor obj) {
        return false;
    }

    @Override
    public TipoFornecedor findById(Long id) {
        return null;
    }

    @Override
    public List<TipoFornecedor> findAll() {
        String jpql = "SELECT tf FROM TipoFornecedor tf WHERE tf.inTipoFornecedorAtivo ORDER BY tf.nmTipoFornecedor ASC ";
        TypedQuery<TipoFornecedor> query = entityManager.createQuery(jpql,TipoFornecedor.class);
        return query.getResultList();
    }
}
