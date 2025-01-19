/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.Valid;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.ImpreException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.Funcionario;

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
