package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.*;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Validators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidateImpressoraGrupoImpressora {
    private List<String> erros;
    public ImpressoraGrupoImpressora validarCamposEntrada(HashMap<String, String> camposEntrada) {
        this.erros = new ArrayList<>();
        ImpressoraGrupoImpressora impGpImp = new ImpressoraGrupoImpressora();

        GrupoImpressora gpImp = new GrupoImpressora();

        gpImp.setId(Validators.validarCamposLong(camposEntrada.get("idGrupoImpressora"),"Grupo",this.erros));

        impGpImp.setGrupoImpressora(gpImp);

        Impressora imp = new Impressora();
        imp.setId(Validators.validarCamposLong(camposEntrada.get("idImpressora"),"Impressora",this.erros));

        impGpImp.setImpressora(imp);

        if(!this.erros.isEmpty()){
            this.throwException();
        }
        return impGpImp;
    }


    private void throwException(){
        throw new AluguelImpressoraException(DefaultMessages.ERRO_FOMULARIO.formatMessage(this.erros));
    }

}
