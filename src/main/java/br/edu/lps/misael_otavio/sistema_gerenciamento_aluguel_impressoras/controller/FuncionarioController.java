
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.valid.ValidateFuncionario;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.ImpreException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.FuncDAO.FuncionarioDAO;
import javax.swing.JTable;

/**
 *
 * @author otavi
 */
public class FuncionarioController {
     private FuncionarioDAO repositorio;

    public FuncionarioController() {
        repositorio = new FuncionarioDAO();        
    }

    public void cadastrarFuncionario(String nome, String email) {
        ValidateFuncionario valid = new ValidateFuncionario();
        Funcionario novoFuncionario = valid.validaCamposEntrada(nome, email);
                
        if (repositorio.findByEmail(novoFuncionario.getEmail()) != null) {
            throw new ImpreException("Error - Já existe um funcionario com este 'email'.");
        } else {
            repositorio.save(novoFuncionario);
        }
    }    
    
    public void atualizarFuncionario(int idFuncionario, String nome, String email) {
        ValidateFuncionario valid = new ValidateFuncionario();
        Funcionario novoFuncionario = valid.validaCamposEntrada(nome, email);
        novoFuncionario.setId(idFuncionario);
        repositorio.update(novoFuncionario);
    }
    

    public void atualizarTabela(JTable grd) {
       Util.jTableShow(grd, new TMCadFuncionario(repositorio.findAll()), null);
        
    }

    public void excluirFuncionario(Funcionario funcionario) {                    
        
        if (funcionario != null) {
            repositorio.delete(funcionario);
        } else {
            throw new ImpreException("Error - Funcionario inexistente.");
        }
    }    
}
