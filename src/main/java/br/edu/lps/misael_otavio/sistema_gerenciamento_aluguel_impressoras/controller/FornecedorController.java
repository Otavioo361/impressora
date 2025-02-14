package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.FornecedorDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Fornecedor;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ModeloImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;

import java.util.List;

public class FornecedorController {
    private static final String name = Fornecedor.class.getSimpleName();
    private final FornecedorDao fornecedorDao = new FornecedorDao();

    public DataResponseModel<List<Fornecedor>> findAll() {
        try {
            List<Fornecedor> dados = this.fornecedorDao.findAll();
            return new DataResponseModel<>(
                    true,
                    DefaultMessages.CONSULTA_SUCESSO.formatMessage(name),
                    dados,
                    null
            );
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new DataResponseModel<>(false, DefaultMessages.CONSULTA_ERROR.formatMessage(name), null, e);
        }
    }
}
