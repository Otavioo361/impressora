package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.ClienteException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.*;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Validators;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author otavi
 */
public class ValidateCliente {
    private List<String> erros;

    public Cliente validarCamposEntrada(HashMap<String,String> camposEntrada) {
        this.erros = new ArrayList<>();

        Cliente cliente = new Cliente();
        TipoCliente tipoCliente = new TipoCliente();
        tipoCliente.setId(1);
        cliente.setTipoCliente(tipoCliente);

        cliente.setNmUsuario(Validators.validarCampoString(camposEntrada.get("nmUsuario"),"Usuario",60,this.erros));

        cliente.setPessoa(new ValidatePessoa().validarCamposEntrada(camposEntrada));
        if(!this.erros.isEmpty()){
            this.throwException();
        }
        return cliente;
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
