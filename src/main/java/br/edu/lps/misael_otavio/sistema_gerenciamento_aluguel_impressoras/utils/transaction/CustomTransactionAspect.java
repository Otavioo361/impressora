package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.transaction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.aspectj.lang.annotation.*;

@Aspect
public class CustomTransactionAspect {

    private EntityManager entityManager;

    public CustomTransactionAspect(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Pointcut("@annotation(br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.transaction.Transactional)")
    public void transactionalMethod() {}

    @Before("transactionalMethod()")
    public void beginTransaction() {
        EntityTransaction transaction = entityManager.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
    }

    @After("transactionalMethod()")
    public void commitTransaction() {
        EntityTransaction transaction = entityManager.getTransaction();
        if (transaction.isActive()) {
            transaction.commit();
        }
    }

    @AfterThrowing("transactionalMethod()")
    public void rollbackTransaction() {
        EntityTransaction transaction = entityManager.getTransaction();
        if (transaction.isActive()) {
            transaction.rollback();
        }
    }
}
