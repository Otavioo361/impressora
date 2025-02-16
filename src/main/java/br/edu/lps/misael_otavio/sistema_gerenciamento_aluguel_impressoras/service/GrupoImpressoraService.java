package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.service;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller.ImpressoraController;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.GrupoImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Impressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ModeloImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Taxa;

import java.math.BigDecimal;
import java.util.*;

public class GrupoImpressoraService {
    private static final ImpressoraController impressoraController = new ImpressoraController();

    public static void preencherImpressoras(GrupoImpressora grupoImpressora, HashMap<ModeloImpressora, Integer> campos) {
        List<Impressora> lsImpr = new ArrayList<Impressora>();
        campos.forEach((campo, valor) -> {
            List<Impressora> impressoras = buscarImpressoras(campo.getId(),valor);
            lsImpr.addAll(impressoras);
        });
        grupoImpressora.setImpressoras(lsImpr);
        grupoImpressora.setQtImpressora(lsImpr.size());

    }

    private static List<Impressora> buscarImpressoras(Long idModelo, Integer quantidade) {
        DataResponseModel<List<Impressora>> resp = impressoraController.findByIdModelo(idModelo, quantidade);
        if(!resp.isSuccess()){
            throw new AluguelImpressoraException("Erro ao buscar impressoras");
        }
        return resp.getData();
    }
    private static BigDecimal somarTaxas(List<Impressora> impressoras) {
        return impressoras.stream()
                .map(impressora -> Optional.ofNullable(impressora)
                        .map(Impressora::getModeloImpressora)
                        .map(ModeloImpressora::getTaxa)
                        .map(Taxa::getVlTaxa)
                        .orElse(BigDecimal.ZERO))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
