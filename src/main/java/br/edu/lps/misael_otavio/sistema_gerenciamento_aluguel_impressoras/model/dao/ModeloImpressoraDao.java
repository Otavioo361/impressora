package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ModeloImpressora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ModeloImpressoraDao implements DaoInterface<ModeloImpressora> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();


    @Override
    public void save(ModeloImpressora obj) {

    }

    @Override
    public void update(ModeloImpressora obj) {

    }

    @Override
    public boolean delete(ModeloImpressora obj) {
        return false;
    }

    @Override
    public ModeloImpressora findById(Long id) {
        return null;
    }

    @Override
    public List<ModeloImpressora> findAll() {
        String jpql = "SELECT m FROM ModeloImpressora m order by m.nmModeloImpressora ASC";
        TypedQuery<ModeloImpressora> query = entityManager.createQuery(jpql,ModeloImpressora.class);
        return query.getResultList();
    }
}
