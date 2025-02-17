package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Cliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.PesquisaSatisfacao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.TipoCliente;
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
public class ValidatePesquisaSatisfacao {
    private List<String> erros;

    public PesquisaSatisfacao validarCamposEntrada(HashMap<String,String> camposEntrada) {
        this.erros = new ArrayList<>();

        PesquisaSatisfacao pesquisaSatisfacao = new PesquisaSatisfacao();

        pesquisaSatisfacao.setTxDescricaoAvalicao(Validators.validarCampoString(camposEntrada.get("txDescricao"),"Descricao",400,this.erros));
        pesquisaSatisfacao.setQtPontosAvaliados(Validators.validarCamposShort(camposEntrada.get("qtAvaliacao"),"Avalicao",this.erros));
        Cliente cliente = new Cliente();
        cliente.setId(Validators.validarCamposLong(camposEntrada.get("idCliente"),"Cliente",this.erros));

        pesquisaSatisfacao.setCliente(cliente);
        pesquisaSatisfacao.setNmUsuario(Validators.validarCampoString(camposEntrada.get("nmUsuario"),"Usuario",60,this.erros));

        return pesquisaSatisfacao;
    }

    private void throwException(){
        throw new AluguelImpressoraException(DefaultMessages.ERRO_FOMULARIO.formatMessage(this.erros));
    }
}
