package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SimpleBadge extends JPanel{

    SimpleBadge(String text){
        this.render(text,null,null,null);
    }
    SimpleBadge(String text,Color bgColor){
        this.render(text,bgColor,null,null);
    }
    SimpleBadge(String text,Color bgColor, Color fgColor){
        this.render(text,bgColor,fgColor,null);
    }

    SimpleBadge(String text, Color bgColor, Color fgColor, Font font) {
        this.render(text, bgColor, fgColor, font);
    }

    public static SimpleBadge create(String text, Color bgColor, Color fgColor, Font font){
        return new SimpleBadge(text, bgColor, fgColor, font);
    }

    private void render(String text, Color bgColor, Color fgColor, Font font) {
        JLabel label = new JLabel(text);
        this.setOpaque(false);
        if(bgColor != null){
            this.setBackground(bgColor);
        }
        if(fgColor != null){
            label.setForeground(fgColor);
        }

        if(font != null){
            label.setFont(font);
        }

        this.setMinimumSize(new Dimension(label.getPreferredSize().width +2, label.getPreferredSize().height+2));
        this.add(label);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
    }
}
