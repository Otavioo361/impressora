package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Cliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Pessoa;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.PessoaFisica;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.PessoaJuridica;
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
public class ValidatePessoaJuridica {
    private List<String> erros;

    public PessoaJuridica validarCamposEntrada(HashMap<String,String> camposEntrada) {
        this.erros = new ArrayList<>();
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setDtAbertura(this.validarDatas(camposEntrada.get("txDtAbertura")));
        pessoaJuridica.setNmNaturezaJurica(Validators.validarCampoString(camposEntrada.get("txNmNaturezaJuridica"),"Natureza juridica",120,this.erros));
        pessoaJuridica.setNmRazaoSocial(Validators.validarCampoString(camposEntrada.get("txNmRazaoSocial"),"Razão social",60,this.erros));

        pessoaJuridica.setNmUsuario(Validators.validarCampoString(camposEntrada.get("nmUsuario"),"Usuario",60,this.erros));

        return pessoaJuridica;

    }

    private LocalDate validarDatas(String data){
        if(Objects.isNull(data)) {
            return null;
        }
        return LocalDate.parse(data , DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
