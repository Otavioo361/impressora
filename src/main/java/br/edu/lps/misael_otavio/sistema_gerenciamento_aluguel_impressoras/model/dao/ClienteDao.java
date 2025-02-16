package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.interfaces.DaoInterface;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Cliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Fornecedor;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.GrupoImpressora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.slf4j.Logger;

import java.util.List;

public class ClienteDao implements DaoInterface<Cliente> {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();
    private final Logger logger =  LoggerSingleton.getLogger(this.getClass());

    private final String queryBuscaCpfCnpjOUEmail = "SELECT \n" +
            "\t*\n" +
            "FROM aluguel_impressora.dbo.cliente c\n" +
            "INNER JOIN aluguel_impressora.dbo.pessoa p \n" +
            "\tON p.id_pessoa = c.id_pessoa \n" +
            "LEFT JOIN aluguel_impressora.dbo.pessoa_fisica pf\n" +
            "\tON p.id_pessoa_fisica = pf.id_pessoa_fisica\n" +
            "LEFT JOIN aluguel_impressora.dbo.pessoa_juridica pj \n" +
            "\tON p.id_pessoa_juridica  = pj.id_pessoa_juridica \n" +
            "WHERE \n" +
            "\t(:cpfCnpj IS NOT NULL AND p.cd_cpf_cnpj = :cpfCnpj) \n" +
            "\tOR (:email IS NOT NULL AND p.cd_email = :email)";

    @Override
    public void save(Cliente obj) {
        try {
            Cliente cliente = this.validaClienteExistente(obj);
            if (cliente != null) {
                throw new AluguelImpressoraException("Cpf ou email já existente");
            }
            this.entityManager.getTransaction().begin();
            entityManager.persist(obj);
            this.entityManager.getTransaction().commit();
        }catch (RuntimeException e) {
            this.entityManager.getTransaction().rollback();
            throw new AluguelImpressoraException(e.getMessage());
        }
    }

    @Override
    public void update(Cliente obj) {
        entityManager.merge(obj);;
    }

    @Override
    public boolean delete(Cliente obj) {
        return false;
    }

    public Cliente findByCpfCnpj(String cpfCnpj) {
        return this.findByCpnfCpnpjOrEmail(cpfCnpj,null);
    }
    public Cliente findByEmail(String email) {
        return this.findByCpnfCpnpjOrEmail(null, email);
    }
    private Cliente findByCpnfCpnpjOrEmail(String cpfCnpj, String email) {
        TypedQuery<Cliente> qry = this.entityManager.createQuery(this.queryBuscaCpfCnpjOUEmail, Cliente.class);
        qry.setParameter("cpf", cpfCnpj);
        qry.setParameter("email", email);
        return qry.getSingleResult();
    }



    public Cliente validaClienteExistente(Cliente cliente){
        return this.findByCpnfCpnpjOrEmail(cliente.getPessoa().getCdCpfCnpj(),cliente.getPessoa().getCdEmail());
    }

    @Override
    public Cliente findById(Long id) {
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        String jpql = "SELECT f FROM Cliente f JOIN FETCH f.pessoa p LEFT JOIN p.pessoaFisica LEFT JOIN p.pessoaJuridica ORDER BY p.nmPessoa  ASC ";
        TypedQuery<Cliente> query = entityManager.createQuery(jpql,Cliente.class);
        return query.getResultList();
    }

    @Override
    public List<Cliente> findActivesOnly() {
        String jpql = "SELECT f FROM Cliente f JOIN FETCH f.pessoa p JOIN FETCH p.pessoaFisica JOIN FETCH p.pessoaJuridica ORDER BY p.nmPessoa  ASC ";
        TypedQuery<Cliente> query = entityManager.createQuery(jpql,Cliente.class);
        return query.getResultList();
    }
}
