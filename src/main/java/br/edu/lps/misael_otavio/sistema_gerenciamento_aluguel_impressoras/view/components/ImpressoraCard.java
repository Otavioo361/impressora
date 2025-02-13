/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Taxa;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Impressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ModeloImpressora;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Formatadores;
import lombok.Getter;
import lombok.Setter;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author misael
 */
@Getter
@Setter
public class ImpressoraCard extends JPanel {
    private String nmImpressora;
    private String cdSerieImpressora;
    private BigDecimal vlTaxaImpressora;
    private Boolean inAlugada;
    private LocalDateTime dataAluguelImpressora;    
    private LocalDateTime dataImpressora;

    private GridBagConstraints gbc;

    public ImpressoraCard(Impressora impressora){
        ModeloImpressora mdImp = impressora.getModeloImpressora();
        Taxa txImp = mdImp.getTaxa();

        this.nmImpressora = mdImp.getNmModeloImpressora();
        this.cdSerieImpressora = impressora.getCdSerieImpressora();
        this.vlTaxaImpressora =  txImp.getVlTaxa();
        this.inAlugada = impressora.getInImpressoraAlugada();
        this.dataImpressora = impressora.getDtInclusao();
        this.dataAluguelImpressora = impressora.getDtUltimaLocacao();
        this.render();
    }

    public ImpressoraCard(String nmImpressora, String cdSerieImpressora, BigDecimal vlTaxaImpressora, Boolean inAlugada, LocalDateTime dataAluguelImpressora, LocalDateTime dataImpressora) {
        this.nmImpressora = nmImpressora;
        this.cdSerieImpressora = cdSerieImpressora;
        this.vlTaxaImpressora = vlTaxaImpressora;
        this.inAlugada = inAlugada;
        this.dataImpressora = dataImpressora;       
        this.dataAluguelImpressora = dataAluguelImpressora;

        this.render();

    }

    private void renderStatus() {
        JLabel statusLabel = new JLabel("Status: ");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        String text = "Disponivel";
        if (inAlugada) {
            text = "Alugado";
        }
        SimpleBadge statusBadge = new SimpleBadge(text,Color.RED,Color.WHITE,new Font("Arial", Font.BOLD, 14));

        JPanel status = new JPanel();
        status.setLayout(new GridBagLayout());
        status.add(statusLabel);
        status.add(statusBadge);
        this.add(status,this.gbc);
    }

    private void renderNmImpressora() {
        JLabel nomeLabel = new JLabel(this.nmImpressora);
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(nomeLabel,this.gbc);
    }
    private void renderCdSerieImpressora() {
        JLabel serieLabel = new JLabel("N° Serie: " + this.cdSerieImpressora);
        serieLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        this.add(serieLabel,this.gbc);
    }

    private void renderVlTaxaImpressora() {

        JLabel taxaLabel = new JLabel(String.format("Taxa: %s /mês", Formatadores.formatMoney(this.vlTaxaImpressora)));
        taxaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(taxaLabel,this.gbc);
    }

    private void renderDataImpressora() {
        String text = "Data aquisição";
        if (this.inAlugada) {
            text = "Data aluguel";
        }
        JLabel dataLabel = new JLabel(String.format(text + " : " + Formatadores.formatDateTimeDate(this.dataImpressora)));
        dataLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        this.add(dataLabel,this.gbc);
    }

    private void render(){
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(230, 230, 230)); // Cor de fundo cinza claro
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.gbc = new GridBagConstraints();
        this.gbc.gridx = 0;
        this.gbc.gridy = GridBagConstraints.RELATIVE;
        this.gbc.anchor = GridBagConstraints.WEST;
        this.gbc.insets = new Insets(5, 5, 5, 5);

        this.renderNmImpressora();
        this.renderCdSerieImpressora();
        this.renderVlTaxaImpressora();
        this.renderStatus();
        this.renderDataImpressora();
        this.setVisible(true);
    }


    
}
