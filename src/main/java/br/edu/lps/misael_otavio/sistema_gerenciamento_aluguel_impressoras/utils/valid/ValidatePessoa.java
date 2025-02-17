package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Cliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Pessoa;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.PessoaFisica;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.PessoaJuridica;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author otavi
 */
public class ValidatePessoa {
    private List<String> erros;

    public Pessoa validarCamposEntrada(HashMap<String,String> camposEntrada) {
        this.erros = new ArrayList<>();

        Pessoa pessoa = new Pessoa();

        pessoa.setNmPessoa(Validators.validarCampoString(camposEntrada.get("txNmCliente"),"Nome cliente",60,this.erros));
        pessoa.setCdEmail(this.validarEmail(camposEntrada.get("txEmailCliente")));
        pessoa.setNmUsuario(Validators.validarCampoString(camposEntrada.get("nmUsuario"),"Usuario",60,this.erros));

        String telefone = this.validarTelefone(camposEntrada.get("txCdTelefone"));
        pessoa.setNrDdd(Integer.parseInt(telefone.substring(0, 2)));
        pessoa.setNrTelefone(Integer.parseInt(telefone.substring(2)));

        String cpfCnpj = this.validarCpfCpnj(camposEntrada.get("txCpfCnpjCliente"));
        pessoa.setCdCpfCnpj(cpfCnpj);
        if(cpfCnpj.length() == 11){
            this.validarPessoaFisica(camposEntrada,pessoa);
        }else {
            this.validarPessoaJuridica(camposEntrada,pessoa);
        }
        if(!this.erros.isEmpty()){
            this.throwException();
        }

        return pessoa;
    }

    private void validarPessoaFisica(HashMap<String,String> camposEntrada,Pessoa pessoa){
        pessoa.setPessoaFisica(new ValidatePessoaFisica().validarCamposEntrada(camposEntrada));
    }
    private void validarPessoaJuridica(HashMap<String,String> camposEntrada,Pessoa pessoa){
        pessoa.setPessoaJuridica(new ValidatePessoaJuridica().validarCamposEntrada(camposEntrada));
    }

    private String validarTelefone(String telefone) {
        if(Validators.validarTelefone(telefone)) {
            return Validators.apenasDigitos(telefone);
        }
        this.erros.add("Telefone inválido!");
        return "000000000000";
    }

    private String validarCpfCpnj(String cnpj) {
        cnpj = Validators.apenasDigitos(cnpj);
        if(Validators.validarCpfCnpj(cnpj)) {
            return cnpj;
        }
        this.erros.add("CPF ou CNPJ inválido");
        return "";
    }
    private String validarEmail(String email) {
        if(Validators.validarEmail(email) && email.length() >= 120) {
            return email;
        }
        this.erros.add("Email inválido");
        return "";
    }

    private LocalDate validarDatas(String data){
        if(Objects.isNull(data)) {
            return null;
        }
        return LocalDate.parse(data , DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private void throwException(){
        throw new AluguelImpressoraException(DefaultMessages.ERRO_FOMULARIO.formatMessage(this.erros));
    }
}
