package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.DataResponseFabric;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.ClienteDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.EnderecoDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Cliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Endereco;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid.ValidateCliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid.ValidateEndereco;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EnderecoController {
    private static final String name = Endereco.class.getSimpleName();
    private final EnderecoDao enderecoDao = new EnderecoDao();
    private final ValidateEndereco validateEndereco = new ValidateEndereco();
    private final Logger logger = LoggerSingleton.getLogger(EnderecoController.class);

    public DataResponseModel<Endereco> save(HashMap<String,String> dados) {
        try {
            Endereco endereco = validateEndereco.validarCamposEntrada(dados);
            this.enderecoDao.save(endereco);
            return DataResponseFabric.fabricSuccessResponse(DefaultMessages.CADASTRADO_SUCESSO.formatMessage(name), endereco);
        } catch (RuntimeException e) {
            this.logger.error(e.getMessage());
            e.printStackTrace();
            this.logger.error(Arrays.toString(e.getStackTrace()));
            return DataResponseFabric.fabricFailResponse(e.getMessage(),e );
        }
    }

    public DataResponseModel<List<Endereco>> findAll() {
        try {
            List<Endereco> dados = this.enderecoDao.findAll();
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


    public DataResponseModel<List<Endereco>> findActivesOnly() {
        try {
            List<Endereco> dados = this.enderecoDao.findActivesOnly();
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
