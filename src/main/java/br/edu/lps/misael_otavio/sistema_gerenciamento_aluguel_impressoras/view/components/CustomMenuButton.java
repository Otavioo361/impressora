package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.ScreensName;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Cursor;

public class CustomMenuButton extends JButton {

    public CustomMenuButton(ScreensName screensName) {
        super(screensName.getLabel());
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.setForeground(Color.WHITE);
        this.setBackground(new Color(65, 105, 225)); // Azul Royal
        this.setOpaque(true);
        this.setBorderPainted(false);
        this.setPreferredSize(new Dimension(0, 50)); // Altura fixa
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
