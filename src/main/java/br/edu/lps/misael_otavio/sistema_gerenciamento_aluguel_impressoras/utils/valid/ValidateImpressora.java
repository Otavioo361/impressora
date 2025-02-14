package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Fornecedor;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Impressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ModeloImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ValidateImpressora {
    private List<String> erros;
    public Impressora validarCamposEntrada(HashMap<String, String> camposEntrada) {
        this.erros = new ArrayList<>();
        Impressora impressora = new Impressora();
        impressora.setCdBarrasImpressora(this.validarCampoString(camposEntrada.get("cdBarrasImpressora"),"Codigo de barras",9));
        impressora.setCdSerieImpressora(this.validarCampoString(camposEntrada.get("cdSerieImpressora"),"Codigo de serie",20));
        impressora.setInImpressoraDisponivel(this.validarCamposBoleanos(camposEntrada.get("inImpressoraDisponivel"),"Impressora disponivel"));

        ModeloImpressora modeloImpressora = new ModeloImpressora();
        modeloImpressora.setId(this.validarCamposNumericos(camposEntrada.get("idModeloImpressora"),"Modelo impressora"));
        impressora.setModeloImpressora(modeloImpressora);

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(this.validarCamposNumericos(camposEntrada.get("idFornecedorImpressora"),"Fornecedor"));
        impressora.setFornecedorImpressora(fornecedor);

        if(!this.erros.isEmpty()){
            this.throwException();
        }
        return impressora;
    }
    private String validarCampoString(String campo, String nome,int tamanhoMax){
        if(Objects.isNull(campo) || campo.isEmpty()){
            this.erros.add(nome+" nulo ou vazio!");
            return "";
        }
        if(!campo.matches("^[a-zA-Z0-9]+$")){
            this.erros.add(nome+" inválido");
            return "";
        }
        if(campo.length() > tamanhoMax){
            this.erros.add(nome+" tamanho invalido");
        }
        return campo;
    }

    private Long validarCamposNumericos(String campo,String nome){
        if(Objects.isNull(campo) || campo.isEmpty()){
            this.erros.add(nome+" nulo ou vazio!");
            return 0L;
        }
        if(!campo.matches("^[0-9]+$")){
            this.erros.add(nome +" invalido");
        }
        return Long.parseLong(campo);
    }

    private Boolean validarCamposBoleanos(String campo,String nome){
        if(Objects.isNull(campo) || campo.isEmpty()){
            this.erros.add(nome+" nulo ou vazio!");
            return false;
        }
        return Boolean.parseBoolean(campo);
    }
    private void throwException(){
        throw new AluguelImpressoraException(DefaultMessages.ERRO_FOMULARIO.formatMessage(this.erros));
    }
}
