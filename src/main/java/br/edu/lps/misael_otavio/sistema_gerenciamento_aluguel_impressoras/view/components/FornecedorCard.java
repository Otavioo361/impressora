/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Fornecedor;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Formatadores;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.modify.ModifyImpressoraScreen;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.template.FrMain;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

/**
 *
 * @author misael
 */
@Getter
@Setter
public class FornecedorCard extends JPanel {

    private Fornecedor fornecedor;

    private GridBagConstraints gbc;

    public FornecedorCard(Fornecedor fornecedor){
        this.fornecedor = fornecedor;
        this.render();
    }


    private void renderStatus() {
        JLabel statusLabel = new JLabel("Status: ");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        Color cor = new Color(0, 162, 46);
        String text = "Disponivel";
        Boolean disponivel = this.fornecedor.getInFornecedorDisponivel();
        if (Objects.isNull(disponivel) || !disponivel) {
            text = "Indisponivel";
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

    private void renderNmFornecedor() {
        JLabel nomeLabel = new JLabel(this.fornecedor.getNmFornecedor());
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(nomeLabel,this.gbc);
    }



    private void renderDataContrato() {
        String text = "Data cotrato";
        JLabel dataLabel = new JLabel(String.format(text + " : " + Formatadores.formatDateTimeDate(this.fornecedor.getDtInicioContrato())));
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
                ModifyImpressoraScreen impressoraScreen = new ModifyImpressoraScreen(FrMain.getFrame(),false,null);
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

        this.renderNmFornecedor();
        this.renderDataContrato();
        this.renderStatus();
        this.setVisible(true);
    }


    
}
