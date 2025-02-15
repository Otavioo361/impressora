package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.template;

import javax.swing.*;
import java.awt.*;

public class JpHeader extends javax.swing.JPanel {
    public JpHeader(JButton toggleButton, int screenWidth) {
        this.setBackground(Color.GRAY);
        this.setPreferredSize(new Dimension(screenWidth, 80));
        this.add(toggleButton);
    }
}
