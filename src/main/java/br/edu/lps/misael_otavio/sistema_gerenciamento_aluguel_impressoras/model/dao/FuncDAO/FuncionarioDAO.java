/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.FuncDAO;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.DatabaseConnection;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.DatabaseJPA;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.Funcionario;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.IDao;
import java.util.List;
import javax.management.Query;
import javax.persistence.EntityManager;
/**
 *
 * @author otavi
 */
public  class FuncionarioDAO implements IDao {
    private EntityManager entityManager;    
    private Query qry;
    private String jpql;
    public FuncionarioDAO(){
    
    }
    @Override
    public void save(Object obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        this.entityManager.getTransaction().begin();       
        this.entityManager.persist(obj);                    
        this.entityManager.getTransaction().commit();        
        
        this.entityManager.close();
    }
    
    @Override
    public void update(Object obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        this.entityManager.getTransaction().begin();       
        this.entityManager.merge(obj);                    
        this.entityManager.getTransaction().commit();     
        
        this.entityManager.close();
    }
     public boolean delete(Object obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        Funcionario funcionario = (Funcionario) obj;
        this.entityManager.getTransaction().begin();
        qry = (Query) this.entityManager.createQuery("DELETE FROM Funcionario WHERE id=:id ");
        qry.setParameter("id", funcionario.getId());
        qry.executeUpdate(); //Obrigatorio o executeUpdate!
        this.entityManager.getTransaction().commit();
        
        
        
        this.entityManager.close();
        return true;
    }
     //verificar erro
     public List<Object> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        jpql = " SELECT f "
             + " FROM Funcionario f ";

        qry = this.entityManager.createQuery(jpql);
        
        //List lst = qry.getResultList();
        
        this.entityManager.close();
        return (List<Object>) lst;
                
    }
      @Override
    public Object find(Object obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();        
        Funcionario funcionario = (Funcionario) obj;        
        Funcionario f = this.entityManager.find(Funcionario.class, funcionario.getId());
        
        this.entityManager.close();
        
        return f;
    }
    public Funcionario findByEmail(String email) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        jpql = " SELECT f "
             + " FROM Funcionario f "
             + " WHERE f.email like :email ";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("email", email);
        
        List lst = qry.getResultList();

        this.entityManager.close();
        
        if (lst.isEmpty()) {
            return null;
        } else {
            return (Funcionario) lst.get(0);
        }                
    }

}
