/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Contrato;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.GrupoImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Formatadores;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.create.CreateCotacaoScreen;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.modify.ModifyGrupoImpressoraScreen;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.template.FrMain;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author misael
 */
@Getter
@Setter
public class ContratoCard extends JPanel {

    private Contrato contrato;

    private GridBagConstraints gbc;

    public ContratoCard(Contrato contrato){
        this.contrato = contrato;

        this.render();
    }


    private void renderNome() {
        JLabel nomeLabel = new JLabel(String.valueOf(this.contrato.getNrContrato()));
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(nomeLabel,this.gbc);
    }


    private void render(){
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(230, 230, 230)); // Cor de fundo cinza claro
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CreateCotacaoScreen screen = new CreateCotacaoScreen(FrMain.getFrame(),false,contrato);
                screen.setLocationRelativeTo(FrMain.getFrame());
                screen.setSize(FrMain.getFrame().getSize());
                screen.setVisible(true);
            }

        });
        this.gbc = new GridBagConstraints();
        this.gbc.gridx = 0;
        this.gbc.gridy = GridBagConstraints.RELATIVE;
        this.gbc.anchor = GridBagConstraints.WEST;
        this.gbc.insets = new Insets(5, 5, 5, 5);

        this.renderNome();
        this.setVisible(true);
    }


    
}
