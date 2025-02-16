package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Fornecedor;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.TipoFornecedor;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Validators;
import org.hibernate.grammars.hql.HqlParser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ValidateFornecedor {
    private List<String> erros;
    public Fornecedor validarCamposEntrada(HashMap<String, String> camposEntrada) {
        this.erros = new ArrayList<>();
        Fornecedor fornecedor = new Fornecedor();
        String cnpj = camposEntrada.get("cdCpfCnpjFornecedor");

        fornecedor.setCdCnpjFornecedor(this.validarCpnj(cnpj));
        fornecedor.setCdEmailContatoFornecedor(this.validarEmail(camposEntrada.get("cdEmailFornecedor")));
        fornecedor.setNmFornecedor(Validators.validarCampoString(camposEntrada.get("nmFornecedor"),"nome do fornecedor",120,this.erros));
        fornecedor.setNmContatoFornecedor(Validators.validarCampoString(camposEntrada.get("nmContatoFornecedor"),"Contato fornecedor",60,this.erros));
        fornecedor.setCdTelefoneContatoFornecedor(this.validarTelefone(camposEntrada.get("cdTelefone")));
        fornecedor.setCdUrlSiteFornecedor(this.validarSiteURL(camposEntrada.get("cdUrlFornecedor")));
        fornecedor.setInFornecedorDisponivel(Validators.validarCamposBoleanos(camposEntrada.get("inFornecedorDisponivel"),"Fornecedor disponivel",this.erros));
        fornecedor.setDtInicioContrato(this.validarDataContrataca(camposEntrada.get("dtInicioContratacao")));
        fornecedor.setNmUsuario(Validators.validarCampoString(camposEntrada.get("nmUsuario"),"Usuario",60,this.erros));

        TipoFornecedor tipoFornecedor = new TipoFornecedor();
        tipoFornecedor.setId(Integer.parseInt(camposEntrada.get("idTipoFornecedor")));

        fornecedor.setTipoFornecedor(tipoFornecedor);
        if(!this.erros.isEmpty()){
            this.throwException();
        }
        return fornecedor;
    }

    private String validarCpnj(String cnpj) {
        cnpj = Validators.apenasDigitos(cnpj);
        if(Validators.validarCpfCnpj(cnpj)) {
            return cnpj;
        }
        this.erros.add("CNPJ inválido");
        return "";
    }

    private String validarEmail(String email) {
        if(Validators.validarEmail(email)) {
            return email;
        }
        this.erros.add("Email inválido");
        return "";
    }

    private String validarTelefone(String telefone) {
        if(Validators.validarTelefone(telefone)) {
            return Validators.apenasDigitos(telefone);
        }
        this.erros.add("Telefone inválido!");
        return "";
    }

    private String validarSiteURL(String siteURL) {
        if(Objects.isNull(siteURL)) {
            return null;
        }
        if(siteURL.length()>260){
            this.erros.add("URL maior que max(260) permitidos");
            return null;
        }
        return siteURL;
    }

    private LocalDateTime validarDataContrataca(String data){
        if(Objects.isNull(data)) {
            return LocalDateTime.now();
        }
        return LocalDateTime.parse(data + " 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    private void throwException(){
        throw new AluguelImpressoraException(DefaultMessages.ERRO_FOMULARIO.formatMessage(this.erros));
    }

}
