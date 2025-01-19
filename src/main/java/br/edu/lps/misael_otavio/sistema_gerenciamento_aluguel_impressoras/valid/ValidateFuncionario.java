
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.valid;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.ImpreException;

/**
 *
 * @author otavi
 */
public class ValidateFuncionario {
    public Funcionario validaCamposEntrada(String nome, String email){
        Funcionario funcionario = new Funcionario();
        if (nome.isEmpty())
            throw new ImpreException("Error - Campo vazio: 'nome'.");
        funcionario.setNome(nome);
        
        if (email.isEmpty()) 
            throw new ImpreException("Error - Campo vazio: 'email'.");                
        funcionario.setEmail(email);

        return funcionario;
    }
}
