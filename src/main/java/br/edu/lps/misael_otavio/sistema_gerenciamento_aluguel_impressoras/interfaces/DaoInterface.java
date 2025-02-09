package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public interface DaoInterface<T> {
    void save(T obj);
    void update(T obj);
    boolean delete(T obj);
    T findById(Long id);
    List<T> findAll();
}
