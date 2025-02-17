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
public class ValidatePessoaFisica {
    private List<String> erros;

    public PessoaFisica validarCamposEntrada(HashMap<String,String> camposEntrada) {
        this.erros = new ArrayList<>();

        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setDtNascimento(this.validarDatas(camposEntrada.get("txDtNascimento")));
        pessoaFisica.setInPpe(Validators.validarCamposBoleanos(camposEntrada.get("jcbInPPE"),"Nome cliente",this.erros));
        pessoaFisica.setNmUsuario(Validators.validarCampoString(camposEntrada.get("nmUsuario"),"Usuario",60,this.erros));

        if(!this.erros.isEmpty()){
            this.throwException();
        }
        return pessoaFisica;
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
