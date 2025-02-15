/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Impressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ModeloImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Taxa;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Formatadores;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.modify.ModifyImpressoraScreen;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.template.FrMain;
import lombok.Getter;
import lombok.Setter;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author misael
 */
@Getter
@Setter
public class ImpressoraCard extends JPanel {
    private Impressora impressora;
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
        this.impressora = impressora;
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
        Color cor = new Color(0, 162, 46);
        String text = "Disponivel";
        if (Objects.nonNull(inAlugada) && inAlugada) {
            text = "Alugado";
            cor = new Color(176, 6, 6);
        }
        SimpleBadge statusBadge = SimpleBadge.create(text,cor,Color.WHITE,new Font("Arial", Font.BOLD, 14));
        statusLabel.setBackground(this.getBackground());
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
        JLabel dataLabel = new JLabel(String.format(text + " : " + Formatadores.formatDateTimeDate(this.dataImpressora)));
        if (Objects.nonNull(this.inAlugada)) {
            text = "Data aluguel";
            dataLabel = new JLabel(String.format(text + " : " + Formatadores.formatDateTimeDate(this.dataAluguelImpressora)));
        }
        dataLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        this.add(dataLabel,this.gbc);
    }

    private void render(){
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(230, 230, 230)); // Cor de fundo cinza claro
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ModifyImpressoraScreen impressoraScreen = new ModifyImpressoraScreen(FrMain.getFrame(),false,impressora);
                impressoraScreen.setLocationRelativeTo(FrMain.getFrame());
                impressoraScreen.setSize(FrMain.getFrame().getSize());
                impressoraScreen.setVisible(true);
            }

            void onClick(MouseEvent mouseEvent) {}
        });
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
