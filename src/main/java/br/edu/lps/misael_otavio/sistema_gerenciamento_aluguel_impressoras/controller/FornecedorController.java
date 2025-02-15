package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.DataResponseFabric;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.FornecedorDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Fornecedor;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Impressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ModeloImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid.ValidateFornecedor;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FornecedorController {
    private static final String name = Fornecedor.class.getSimpleName();
    private final FornecedorDao fornecedorDao = new FornecedorDao();
    private final ValidateFornecedor validateFornecedor = new ValidateFornecedor();
    private final Logger logger = LoggerSingleton.getLogger(FornecedorController.class);

    public DataResponseModel<Fornecedor> save(HashMap<String,String> dados) {
        try {
            Fornecedor fornecedor = validateFornecedor.validarCamposEntrada(dados);
            this.fornecedorDao.save(fornecedor);
            return DataResponseFabric.fabricSuccessResponse(DefaultMessages.CADASTRADO_SUCESSO.formatMessage(name), fornecedor);
        } catch (RuntimeException e) {
            this.logger.error(e.getMessage());
            e.printStackTrace();
            this.logger.error(Arrays.toString(e.getStackTrace()));
            return DataResponseFabric.fabricFailResponse(e.getMessage(),e );
        }
    }

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
            this.logger.error(e.getMessage());
            this.logger.error(Arrays.toString(e.getStackTrace()));
            return DataResponseFabric.fabricFailResponse(DefaultMessages.CONSULTA_ERROR.formatMessage(name),e);
        }
    }
}
