package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.DataResponseFabric;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.ModeloImpressoraDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ModeloImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid.ValidateModeloImpressora;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ModeloImpressoraController {
    private static final String name = ModeloImpressora.class.getSimpleName();
    private final ModeloImpressoraDao modeloImpressoraDao = new ModeloImpressoraDao();
    private final Logger logger =  LoggerSingleton.getLogger(this.getClass());
    private final ValidateModeloImpressora validateModeloImpressora = new ValidateModeloImpressora();

    public DataResponseModel<ModeloImpressora> save(HashMap<String,String> dados) {
        try {
            ModeloImpressora mdImp = this.validateModeloImpressora.validarCamposEntrada(dados);

            return DataResponseFabric.fabricSuccessResponse(DefaultMessages.CADASTRADO_SUCESSO.formatMessage(name), mdImp);
        } catch (RuntimeException e) {
            this.logger.error(e.getMessage());
            e.printStackTrace();
            this.logger.error(Arrays.toString(e.getStackTrace()));
            return DataResponseFabric.fabricFailResponse(e.getMessage(),e );
        }
    }
    public DataResponseModel<List<ModeloImpressora>> findAll() {
        try {
            List<ModeloImpressora> dados = this.modeloImpressoraDao.findAll();
            return new DataResponseModel<>(
                    true,
                    DefaultMessages.CONSULTA_SUCESSO.formatMessage(name),
                    dados,
                    null
            );
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new DataResponseModel<>(false, DefaultMessages.CONSULTA_ERROR.formatMessage(name),null,e);
        }
    }
    public DataResponseModel<List<ModeloImpressora>> findActivesOnly() {
        try {
            List<ModeloImpressora> dados = this.modeloImpressoraDao.findActivesOnly();
            return new DataResponseModel<>(
                    true,
                    DefaultMessages.CONSULTA_SUCESSO.formatMessage(name),
                    dados,
                    null
            );
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new DataResponseModel<>(false, DefaultMessages.CONSULTA_ERROR.formatMessage(name),null,e);
        }
    }
}
