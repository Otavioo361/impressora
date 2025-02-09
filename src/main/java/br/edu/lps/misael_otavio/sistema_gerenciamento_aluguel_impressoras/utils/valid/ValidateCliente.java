package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.valid;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.ClienteException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Cliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Pessoa;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.PessoaFisica;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.PessoaJuridica;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.transaction.Validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


/**
 *
 * @author otavi
 */
public class ValidateCliente {


    public Cliente validaCamposEntrada(String nome, String email, String cpfCnpj, String telefone, String nascimento, String abertura) {
        Cliente cliente = new Cliente();
        Pessoa pessoa = new Pessoa();
        if (nome.isEmpty()) {
            throw new AluguelImpressoraException("Error - Campo vazio: 'nome'.");
        }
        pessoa.setNmPessoa(nome);
        if (email.isEmpty()) {
            throw new AluguelImpressoraException("Error - Campo vazio: 'email'.");
        }
        if (!Validators.validarEmail(email)) {
            throw new AluguelImpressoraException("Error - E-mail inválido.");
        }
        pessoa.setCdEmail(email);
        cpfCnpj = cpfCnpj.replaceAll("\\D", "");
        if(!Validators.validarCpfCnpj(cpfCnpj)){
            throw new ClienteException("Error - Cpf ou Cnpj inválido.");
        }
        pessoa.setCdCpfCnpj(cpfCnpj);


        if (!Validators.validarTelefone(telefone)) {
            throw new AluguelImpressoraException("Error - Telefone inválido.");
        }
        telefone = telefone.replaceAll("\\D", "");
        pessoa.setNrDdd(Integer.parseInt(telefone.substring(0, 2)));
        pessoa.setNrTelefone(Integer.parseInt(telefone.substring(2)));

        this.validaPessoaFisicaJuridica(pessoa,nascimento,abertura);

        cliente.setPessoa(pessoa);
        return cliente;
    }
    private void validaPessoaFisicaJuridica(Pessoa pessoa, String nascimento,String abertura){
        boolean ehPessoaFisica = pessoa.getCdCpfCnpj().length() == 11;
        if(ehPessoaFisica){
            if(nascimento==null || nascimento.isEmpty()){
                return;
            }
            if(nascimento.contains("/")){
                nascimento = LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            LocalDate dtNasc = LocalDate.parse(nascimento);
            PessoaFisica pessoaFisica = new PessoaFisica();
            pessoaFisica.setDtNascimento(dtNasc);
            pessoa.setPessoaFisica(pessoaFisica);
        }else{
            if(abertura==null || abertura.isEmpty()){
                return;
            }
            if(abertura.contains("/")){
                abertura = LocalDate.parse(abertura, DateTimeFormatter.ofPattern("dd/MM/yyyy")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            LocalDate dtAb = LocalDate.parse(abertura);
            PessoaJuridica juridica = new PessoaJuridica();
            juridica.setDtAbertura(dtAb);
            pessoa.setPessoaJuridica(juridica);
        }
    }

}
