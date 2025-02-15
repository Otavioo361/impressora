package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.*;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Validators;

import java.util.*;

public class ValidateModeloImpressora {
    private List<String> erros;

    public ModeloImpressora validarCamposEntrada(HashMap<String, String> camposEntrada) {
        this.erros = new ArrayList<>();

        ModeloImpressora mdImpressora = new ModeloImpressora();
        mdImpressora.setNmModeloImpressora(Validators.validarCampoString(camposEntrada.get("nmModeloImpressopra"),"Nome do modelo",64,this.erros));

        mdImpressora.setInModeloImpressoraAtivo(Validators.validarCamposBoleanos(camposEntrada.get("inImpressoraDisponivel"),"Disponivel",this.erros));

        Taxa taxa = new Taxa();
        taxa.setId(Validators.validarCamposLong(camposEntrada.get("idTaxa"),"Taxa",this.erros));
        mdImpressora.setTaxa(taxa);

        Marca marca = new Marca();
        marca.setId(Validators.validarCamposIntger(camposEntrada.get("idMarca"),"Marca",this.erros));
        mdImpressora.setMarcaImpressora(marca);

        TipoImpressora tpImp = new TipoImpressora();
        tpImp.setId(Validators.validarCamposIntger(camposEntrada.get("idTipoImpressora"),"Tipo impressora",this.erros));
        mdImpressora.setTipoImpressora(tpImp);

        System.out.println(erros);

        if(!this.erros.isEmpty()){
            this.throwException();
        }
        return mdImpressora;
    }

    private void throwException(){
        throw new AluguelImpressoraException(DefaultMessages.ERRO_FOMULARIO.formatMessage(this.erros));
    }
}
