package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Contrato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ContratoDao implements DaoInterface<Contrato> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();
    private final Logger logger =  LoggerSingleton.getLogger(this.getClass());
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void save(Contrato obj) {
        try {
            lock.lock();
            this.entityManager.getTransaction().begin();
            Long nrContrato= this.findNexNrContrato();
            obj.setNrContrato(nrContrato);
            obj.setNrVersaoContrato(0);
            entityManager.persist(obj);
            this.entityManager.getTransaction().commit();

        }catch (RuntimeException e) {
            this.entityManager.getTransaction().rollback();
            throw new AluguelImpressoraException(e.getMessage());
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public void update(Contrato obj) {
        entityManager.merge(obj);;
    }

    @Override
    public boolean delete(Contrato obj) {
        return false;
    }


    @Override
    public Contrato findById(Long id) {
        return null;
    }

    private Long findNexNrContrato() {
        LocalDate agora = LocalDate.now();
        String month = String.valueOf(agora.getMonthValue());
        if(month.length() ==1 ){
            month = "0"+month;
        }
        long nrContratoHoje = Long.parseLong(String.format("%s%s%s000001", agora.getYear(), month, agora.getDayOfMonth()));

        String queryStr = "SELECT TOP 1 c.nr_contrato FROM contrato c WHERE CONVERT(date, c.dt_inclusao) = CONVERT(date, GETDATE()) ORDER BY c.dt_inclusao DESC";

        Query query = entityManager.createNativeQuery(queryStr, Long.class); // Aqui usamos o tipo String, já que nr_contrato é do tipo String

        List resultado = query.getResultList();
        return resultado.isEmpty() ? nrContratoHoje : (Long) resultado.get(0)+1;
    }

    public List<Contrato> findByClienteId(Long clienteId) {
        String jpql = "SELECT e FROM Contrato e WHERE e.cliente.id = :idCliente";
        TypedQuery<Contrato> query = entityManager.createQuery(jpql,Contrato.class);
        query.setParameter("idCliente", clienteId);
        return query.getResultList();
    }

    @Override
    public List<Contrato> findAll() {
        String jpql = "SELECT e FROM Contrato e JOIN FETCH e.cliente";
        TypedQuery<Contrato> query = entityManager.createQuery(jpql,Contrato.class);
        return query.getResultList();
    }

    @Override
    public List<Contrato> findActivesOnly() {
        String jpql = "SELECT e FROM Contrato e JOIN FETCH e.cliente ";
        TypedQuery<Contrato> query = entityManager.createQuery(jpql,Contrato.class);
        return query.getResultList();
    }
}
