package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.*;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Validators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidateGrupoImpressora {
    private List<String> erros;
    public GrupoImpressora validarCamposEntrada(HashMap<String, String> camposEntrada) {
        this.erros = new ArrayList<>();

        GrupoImpressora gpImp = new GrupoImpressora();

        gpImp.setNmGrupoImpressora(Validators.validarCampoString(camposEntrada.get("nmGrupoImpressora"),"Nome do grupo",64,this.erros));
        gpImp.setNmUsuario(Validators.validarCampoString(camposEntrada.get("nmUsuario"),"Usuario",60,this.erros));

        Endereco endereco = new Endereco();
        endereco.setId(Validators.validarCamposLong(camposEntrada.get("idEndereco"),"Endereco",this.erros));
        gpImp.setEndereco(endereco);

        Contrato contrato = new Contrato();
        contrato.setId(Validators.validarCamposLong(camposEntrada.get("idContrato"),"Contrato",this.erros));
        gpImp.setContrato(contrato);

        if(!this.erros.isEmpty()){
            this.throwException();
        }
        return gpImp;
    }

    public GrupoImpressora validarImpressoras(Long idGrupoImpressora) {
        this.erros = new ArrayList<>();
        GrupoImpressora gpImp = new GrupoImpressora();
        gpImp.setId(idGrupoImpressora);
        gpImp.setInGrupoFinalizado(true);
        return gpImp;

    }

    private void throwException(){
        throw new AluguelImpressoraException(DefaultMessages.ERRO_FOMULARIO.formatMessage(this.erros));
    }

}
