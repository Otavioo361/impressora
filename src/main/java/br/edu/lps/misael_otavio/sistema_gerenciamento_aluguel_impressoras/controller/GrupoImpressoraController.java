package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.DataResponseFabric;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.EnderecoDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.GrupoImpressoraDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.ImpressoraGrupoImpressoraDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Endereco;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.GrupoImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ImpressoraGrupoImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ModeloImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.service.GrupoImpressoraService;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid.ValidateEndereco;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid.ValidateGrupoImpressora;
import lombok.extern.java.Log;
import org.slf4j.Logger;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GrupoImpressoraController {
    private static final String name = GrupoImpressora.class.getSimpleName();
    private final GrupoImpressoraDao grupoImpressoraDao = new GrupoImpressoraDao();
    private final ImpressoraGrupoImpressoraController impressoraGrupoImpressoraController = new ImpressoraGrupoImpressoraController();
    private final ValidateGrupoImpressora validateGrupoImpressora = new ValidateGrupoImpressora();
    private final Logger logger = LoggerSingleton.getLogger(GrupoImpressoraController.class);

    public DataResponseModel<GrupoImpressora> save(HashMap<String,String> dados) {
        try {
            GrupoImpressora grupoImpressora = validateGrupoImpressora.validarCamposEntrada(dados);
            this.grupoImpressoraDao.save(grupoImpressora);
            return DataResponseFabric.fabricSuccessResponse(DefaultMessages.CADASTRADO_SUCESSO.formatMessage(name), grupoImpressora);
        } catch (RuntimeException e) {
            this.logger.error(e.getMessage());
            e.printStackTrace();
            this.logger.error(Arrays.toString(e.getStackTrace()));
            return DataResponseFabric.fabricFailResponse(e.getMessage(),e );
        }
    }

    public DataResponseModel<GrupoImpressora> update(HashMap<String,String> dados) {
        try {
            GrupoImpressora grupoImpressora = validateGrupoImpressora.validarCamposEntrada(dados);
            this.grupoImpressoraDao.update(grupoImpressora);

            return DataResponseFabric.fabricSuccessResponse(DefaultMessages.CADASTRADO_SUCESSO.formatMessage(name), grupoImpressora);
        } catch (RuntimeException e) {
            this.logger.error(e.getMessage());
            e.printStackTrace();
            this.logger.error(Arrays.toString(e.getStackTrace()));
            return DataResponseFabric.fabricFailResponse(e.getMessage(),e );
        }
    }

    public DataResponseModel<List<GrupoImpressora>> findAll() {
        try {
            List<GrupoImpressora> dados = this.grupoImpressoraDao.findAll();
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

    public DataResponseModel<GrupoImpressora> adicionarImpressoras(Long idGrupoImpressora,HashMap<ModeloImpressora,Integer> dados) {
        try {
            GrupoImpressora grupoImpressora = validateGrupoImpressora.validarImpressoras(idGrupoImpressora);
            GrupoImpressoraService.preencherImpressoras(grupoImpressora,dados);
            this.impressoraGrupoImpressoraController.save(grupoImpressora);

            return DataResponseFabric.fabricSuccessResponse(DefaultMessages.CADASTRADO_SUCESSO.formatMessage(name), grupoImpressora);
        } catch (RuntimeException e) {
            this.logger.error(e.getMessage());
            this.logger.error(Arrays.toString(e.getStackTrace()));
            return DataResponseFabric.fabricFailResponse(DefaultMessages.CADASTRADO_ERROR.formatMessage(name),e);
        }
    }

    public DataResponseModel<List<GrupoImpressora>> findByContratoId(Long idContrato) {
        try {
            List<GrupoImpressora> dados = this.grupoImpressoraDao.findByContratoId(idContrato);
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


    public DataResponseModel<List<GrupoImpressora>> findActivesOnly() {
        try {
            List<GrupoImpressora> dados = this.grupoImpressoraDao.findActivesOnly();
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
