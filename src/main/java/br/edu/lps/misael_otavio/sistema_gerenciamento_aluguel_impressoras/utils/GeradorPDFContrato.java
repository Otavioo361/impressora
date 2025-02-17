package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils;


import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.*;
import com.itextpdf.html2pdf.HtmlConverter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GeradorPDFContrato {
    private Path arquivo;
    private Path output;
    private Contrato contrato;
    private Cliente cliente;
    private Pessoa pessoa;
    private List<GrupoImpressora> gruposImpressora;

    public GeradorPDFContrato(Contrato contrato, List<GrupoImpressora> gruposImpressora) {
        this.contrato = contrato;
        this.cliente = contrato.getCliente();
        this.pessoa = cliente.getPessoa();
        this.gruposImpressora = gruposImpressora;
        this.arquivo = Paths.get("src/main/resources/templates/cotacao.html");

        String userHome = System.getProperty("user.home");
        String documentsPath;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            documentsPath = Paths.get(userHome, "Documents").toString();
        } else {
            documentsPath = Paths.get(userHome, "Documents").toString();
        }
        this.output = Paths.get(documentsPath, this.contrato.getNrContrato()+"_contrato.pdf");
    }

    public void gerarPDF() throws IOException {

        String htmlTemplate = new String(Files.readAllBytes(this.arquivo));
        String dataAtual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        htmlTemplate = htmlTemplate.replace("{{data}}", dataAtual);
        htmlTemplate = htmlTemplate.replace("{{nr_contrato}}", String.valueOf(contrato.getNrContrato()));
        htmlTemplate = htmlTemplate.replace("{{nr_versao}}", String.valueOf(contrato.getNrVersaoContrato()));
        htmlTemplate = htmlTemplate.replace("{{cliente_nome}}", cliente.getPessoa().getNmPessoa());
        htmlTemplate = htmlTemplate.replace("{{cpf_cnpj}}", pessoa.getCdCpfCnpj());

        StringBuilder gruposHtml = this.gerarGrupos();

        htmlTemplate = htmlTemplate.replace("{{#grupos_impressora}}", gruposHtml.toString());
        HtmlConverter.convertToPdf(htmlTemplate, new FileOutputStream(this.output.toString()));
    }

    private StringBuilder gerarGrupos() {
        StringBuilder gruposHtml = new StringBuilder();
        if (this.gruposImpressora.isEmpty()) {
            return gruposHtml;
        }
        for (GrupoImpressora grupo : this.gruposImpressora) {
            StringBuilder impressorasHtml = new StringBuilder();
            BigDecimal totalValor = BigDecimal.ZERO;
            for (Impressora impressora : grupo.getImpressoras()) {
                impressorasHtml
                        .append("<tr>")
                        .append("<td>").append(impressora.getModeloImpressora().getMarcaImpressora().getNmMarca()).append("</td>")
                        .append("<td>").append(impressora.getModeloImpressora().getNmModeloImpressora()).append("</td>")
                        .append("<td>").append(impressora.getCdSerieImpressora()).append("</td>")
                        .append("<td>").append(Formatadores.formatMoney(impressora.getModeloImpressora().getTaxa().getVlTaxa())).append("</td>")
                        .append("</tr>");
                totalValor = totalValor.add(impressora.getModeloImpressora().getTaxa().getVlTaxa());
            }
            gruposHtml.append("<table class=\"table\"> <thead>\n" +
                            "        <tr>\n" +
                            "          <th colspan=\"4\">Grupo: "
            ).append(grupo.getNmGrupoImpressora())
                    .append("</th>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "        <th>Marca</th>\n" +
                            "          <th>Modelo</th>\n" +
                            "          <th>Número de série</th>\n" +
                            "          <th>Valor do Aluguel</th>\n" +
                            "        </tr>\n" +
                            "      </thead><tbody>")
                    .append(impressorasHtml)
                    .append("<tr class=\"total-row\"><td colspan=\"3\">Total</td><td>").append(totalValor).append("</td></tr></tbody></table>")
                    .append("<h4>Endereço: ").append(Formatadores.formatEndereco(grupo.getEndereco())).append("</h4>");
        }
        return gruposHtml;

    }
}
