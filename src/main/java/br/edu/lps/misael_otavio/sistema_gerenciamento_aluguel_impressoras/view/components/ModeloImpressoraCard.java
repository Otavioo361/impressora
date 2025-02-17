/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ModeloImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Taxa;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Formatadores;

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
public class ModeloImpressoraCard extends JPanel {
    private ModeloImpressora mdImpressora;
    private String nmImpressora;
    private BigDecimal vlTaxaImpressora;
    private LocalDateTime dtCadastroModelo;
    private boolean inDisponivel;
    private String recorrencia;
    private int quantidadeImpressoras;

    private GridBagConstraints gbc;

    public ModeloImpressoraCard(ModeloImpressora mdImp){
        Taxa txImp = mdImp.getTaxa();

        this.nmImpressora = mdImp.getNmModeloImpressora();
        this.vlTaxaImpressora =  txImp.getVlTaxa();
        this.dtCadastroModelo = mdImp.getDtInclusao();
        this.inDisponivel = mdImp.getInModeloImpressoraAtivo();
        this.mdImpressora = mdImp;
        this.recorrencia = txImp.getTipoRecorrencia().getDsTipoRecorrencia();
        this.quantidadeImpressoras = 0;
        this.render();
    }

    public ModeloImpressoraCard(ModeloImpressora mdImp,int quantidadeImpressoras){
        Taxa txImp = mdImp.getTaxa();

        this.nmImpressora = mdImp.getNmModeloImpressora();
        this.vlTaxaImpressora =  txImp.getVlTaxa();
        this.dtCadastroModelo = mdImp.getDtInclusao();
        this.inDisponivel = mdImp.getInModeloImpressoraAtivo();
        this.mdImpressora = mdImp;
        this.recorrencia = txImp.getTipoRecorrencia().getDsTipoRecorrencia();
        this.quantidadeImpressoras = quantidadeImpressoras;
        this.render();
    }


    private void renderStatus() {
        JLabel statusLabel = new JLabel("Status: ");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));

        SimpleBadge statusBadge = SimpleBadge.createSuccess("Disponivel");

        if (!inDisponivel) {
            statusBadge = SimpleBadge.createError("Indisponivel");
        }

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

    private void renderQuantidade() {
        if(this.quantidadeImpressoras == 0){
            return;
        }
        JLabel nomeLabel = new JLabel(String.valueOf(this.quantidadeImpressoras));
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(nomeLabel,this.gbc);
    }


    private void renderVlTaxaImpressora() {

        JLabel taxaLabel = new JLabel(String.format("Taxa: %s /%s", Formatadores.formatMoney(this.vlTaxaImpressora),this.recorrencia));
        taxaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(taxaLabel,this.gbc);
    }

    private void renderDataImpressora() {
        String text = "Data aquisição";
        JLabel dataLabel = new JLabel(String.format(text + " : " + Formatadores.formatDateTimeDate(this.dtCadastroModelo)));

        dataLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        this.add(dataLabel,this.gbc);
    }

    private void render(){
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(230, 230, 230)); // Cor de fundo cinza claro
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.gbc = new GridBagConstraints();
        this.gbc.gridx = 0;
        this.gbc.gridy = GridBagConstraints.RELATIVE;
        this.gbc.anchor = GridBagConstraints.WEST;
        this.gbc.insets = new Insets(5, 5, 5, 5);

        this.renderNmImpressora();
        this.renderVlTaxaImpressora();
        this.renderStatus();
        this.renderDataImpressora();
        this.renderQuantidade();
        this.setVisible(true);
    }


    
}
