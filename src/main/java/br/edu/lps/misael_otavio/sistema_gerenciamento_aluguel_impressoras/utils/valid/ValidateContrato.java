package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Cliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Contrato;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Validators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidateContrato {
    private List<String> erros;
    public Contrato validarCamposEntrada(HashMap<String, String> camposEntrada) {
        this.erros = new ArrayList<>();
        Contrato contrato = new Contrato();
        contrato.setNmUsuario(Validators.validarCampoString(camposEntrada.get("nmUsuario"),"Usuario",60,this.erros));

        Cliente cliente = new Cliente();
        cliente.setId(Validators.validarCamposLong(camposEntrada.get("idCliente"),"Cliente",this.erros));
        contrato.setCliente(cliente);

        if(!this.erros.isEmpty()){
            this.throwException();
        }
        return contrato;
    }

    private void throwException(){
        throw new AluguelImpressoraException(DefaultMessages.ERRO_FOMULARIO.formatMessage(this.erros));
    }

}
