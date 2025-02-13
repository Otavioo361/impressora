package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.ImpressoraDao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;

import java.util.List;


public class ImpressoraController {
    private static final String name = "Impressora";
    private ImpressoraDao impressoraDao = new ImpressoraDao();
    public DataResponseModel<List<Impressora>> buscarImpressorasRecentes() {
        try {
            return new DataResponseModel<>(true, DefaultMessages.CONSULTA_SUCESSO.formatMessage(name), this.impressoraDao.listarTop20(),null);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new DataResponseModel<>(false, DefaultMessages.CONSULTA_ERROR.formatMessage(name),null,e);
        }
}
}
