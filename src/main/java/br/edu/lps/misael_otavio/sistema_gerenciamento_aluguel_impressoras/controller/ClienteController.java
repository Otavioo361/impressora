package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.Valid.ValidateCliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.ImpreException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.ClienteDAO;

import javax.swing.JTable;

public class ClienteController {
    private ClienteDAO repositorio;

 

    // Construtor do Controller
    public ClienteController() {
        repositorio = new ClienteDAO();        
    }

    // Método para cadastrar um cliente
    public void cadastrarCliente(String nome, String email, String cpfCnpj, String telefone) {
        ValidateCliente valid = new ValidateCliente();
        
        // Valida os campos de entrada
        Cliente novoCliente = valid.validaCamposEntrada(nome, email, cpfCnpj, telefone);
        
        // Verifica se já existe um cliente com o mesmo e-mail
        if (repositorio.findByEmail(novoCliente.getEmail()) != null) {
            throw new ImpreException("Error - Já existe um cliente com este 'email'.");
        }
        
        // Verifica se já existe um cliente com o mesmo CPF/CNPJ
        if (repositorio.findByCpfCnpj(novoCliente.getCpf_cnpj()) != null) {
            throw new ImpreException("Error - Já existe um cliente com este 'CPF/CNPJ'.");
        }
        
        // Salva o novo cliente no repositório
        repositorio.save(novoCliente);
    }

    // Método para atualizar as informações de um cliente
    public void atualizarCliente(int idCliente, String nome, String email, String cpfCnpj, String telefone) {
        ValidateCliente valid = new ValidateCliente();
        
        // Valida os campos de entrada
        Cliente novoCliente = valid.validaCamposEntrada(nome, email, cpfCnpj, telefone);
        novoCliente.setId(idCliente);

        // Verifica se já existe um cliente com o mesmo e-mail
        if (repositorio.findByEmail(novoCliente.getEmail()) != null && !repositorio.findByEmail(novoCliente.getEmail()).getId().equals(idCliente)) {
            throw new ImpreException("Error - Já existe um cliente com este 'email'.");
        }
        
        // Verifica se já existe um cliente com o mesmo CPF/CNPJ
        if (repositorio.findByCpfCnpj(novoCliente.getCpf_cnpj()) != null && !repositorio.findByCpfCnpj(novoCliente.getCpf_cnpj()).getId().equals(idCliente)) {
            throw new ImpreException("Error - Já existe um cliente com este 'CPF/CNPJ'.");
        }

        // Atualiza as informações do cliente no repositório
        repositorio.update(novoCliente);
    }
    

    // Método para atualizar a tabela de clientes
    public void atualizarTabela(JTable grd) {
        Util.jTableShow(grd, new TMCadCliente(repositorio.findAll()), null);
    }
    public Cliente buscarClientePorCpf(String cpfCnpj) {
           Cliente cliente = repositorio.findByCpfCnpj(cpfCnpj);

           if (cliente == null) {
               throw new ImpreException("Erro - Cliente não encontrado com o CPF/CNPJ informado.");
           }
            return cliente;
       }

    // Método para excluir um cliente
    public void excluirCliente(Cliente cliente) {
        if (cliente != null) {
            repositorio.delete(cliente);
        } else {
            throw new ImpreException("Error - Cliente inexistente.");
        }
    }    
}
