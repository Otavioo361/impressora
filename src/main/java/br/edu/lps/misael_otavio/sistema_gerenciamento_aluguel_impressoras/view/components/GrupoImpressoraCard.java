/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.*;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Formatadores;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.modify.ModifyClienteScreen;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.modify.ModifyGrupoImpressoraScreen;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.template.FrMain;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author misael
 */
@Getter
@Setter
public class GrupoImpressoraCard extends JPanel {

    private GrupoImpressora gpImp;

    private HashMap<String,Boolean> checkList;

    private GridBagConstraints gbc;

    public GrupoImpressoraCard(GrupoImpressora gpImp,HashMap<String,Boolean> checkList){
        this.gpImp = gpImp;
        this.checkList = checkList;
        this.render();
    }


    private void renderNome() {
        JLabel nomeLabel = new JLabel(this.gpImp.getNmGrupoImpressora());
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(nomeLabel,this.gbc);
    }

    private void renderVlTaxa() {
        BigDecimal valor = this.gpImp.getVlAluguelGrupoImpressora();
        if (Objects.isNull(valor)) {
            return;
        }
        JLabel taxaLabel = new JLabel(String.format("Custo mensal: %s", Formatadores.formatMoney(valor)));
        taxaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(taxaLabel,this.gbc);
    }

    private void renderStatus() {
        JLabel statusLabel = new JLabel("Status: ");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));

        Color cor = new Color(0, 162, 46);
        String text = "Finalizado";
        Boolean disponivel = this.gpImp.getInGrupoFinalizado();

        if (Objects.isNull(disponivel) || !disponivel) {
            text = "Não finalizado";
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

    private void render(){
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(230, 230, 230)); // Cor de fundo cinza claro
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ModifyGrupoImpressoraScreen screen = new ModifyGrupoImpressoraScreen(FrMain.getFrame(),false,gpImp, checkList);
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
        this.renderStatus();
        this.renderVlTaxa();
        this.setVisible(true);
    }


    
}
