package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.*;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Validators;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ValidateEndereco {
    private List<String> erros;
    public Endereco validarCamposEntrada(HashMap<String, String> camposEntrada) {
        this.erros = new ArrayList<>();
        Endereco endereco = new Endereco();


        endereco.setNmEndereco(Validators.validarCampoString(camposEntrada.get("txNmEndereco"),"Nome endereco",60,this.erros));
        endereco.setNmBairro(Validators.validarCampoString(camposEntrada.get("txBairro"),"Bairro",30,this.erros));
        endereco.setNmCep(this.validarCep(camposEntrada.get("txCdCep")));
        endereco.setNmComplemento(Validators.validarCampoString(camposEntrada.get("txComplemento"),"Complemento",32,this.erros));
        endereco.setNmLogradouro(Validators.validarCampoString(camposEntrada.get("txLogradouro"),"Logradouro",120,this.erros));
        endereco.setNrLogradouro(Validators.validarCamposIntger(camposEntrada.get("txNrLogradouro"),"Numero logradouro",this.erros));
        endereco.setNmCidade(Validators.validarCampoString(camposEntrada.get("txNmCidade"),"Cidade",60,this.erros));
        endereco.setNmReferencia(Validators.validarCampoString(camposEntrada.get("txReferencia"),"referencia",32,this.erros));

        Uf uf = new Uf();
        uf.setId(Validators.validarCamposIntger(camposEntrada.get("idUf"),"UF",this.erros));
        endereco.setUf(uf);

        Cliente cliente = new Cliente();
        cliente.setId(Validators.validarCamposLong(camposEntrada.get("idCliente"),"Cliente",this.erros));
        endereco.setCliente(cliente);

        if(!this.erros.isEmpty()){
            this.throwException();
        }
        return endereco;
    }

    private String validarCep(String valor){
        String cep = Validators.apenasDigitos(Validators.validarCampoString(valor,"Cep",11,this.erros));
        if(cep.length() == 8){
            return cep;
        }
        this.erros.add("Cep com tamanho invalido");
        return "";
    }

    private void throwException(){
        throw new AluguelImpressoraException(DefaultMessages.ERRO_FOMULARIO.formatMessage(this.erros));
    }

}
