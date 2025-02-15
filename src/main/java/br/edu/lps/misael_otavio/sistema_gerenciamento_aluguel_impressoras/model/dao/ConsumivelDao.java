package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Consumivel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Impressora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ConsumivelDao implements DaoInterface<Consumivel> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();


    public List<Consumivel> findByImpressoraId(Long idImpressora) {
        String queryBuscaListaPorImpressora = "SELECT c FROM Consumivel c\n" +
                "JOIN FETCH c.impressora im\n" +
                "JOIN FETCH c.modeloConsumivel mc\n" +
                "JOIN FETCH mc.taxa t\n" +
                "WHERE c.impressora.id = :idImpressora";
        TypedQuery<Consumivel> query = entityManager.createQuery(queryBuscaListaPorImpressora, Consumivel.class);
        query.setParameter("idImpressora", idImpressora);
        return query.getResultList();
    }

    @Override
    public void save(Consumivel obj) {

    }

    @Override
    public void update(Consumivel obj) {

    }

    @Override
    public boolean delete(Consumivel obj) {
        return false;
    }

    @Override
    public Consumivel findById(Long id) {
        return null;
    }

    @Override
    public List<Consumivel> findAll() {
        return List.of();
    }
}
