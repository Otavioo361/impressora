/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.View;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.Valid.ValidateCliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller.ClienteController;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller.FuncionarioController;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.ImpreException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.Cliente;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author otavi
 */
public class FrCliente extends javax.swing.JFrame {
    ClienteController ClienteController;
    int idClienteEditando;
    /**
     * Creates new form FrCliente
     */
    public FrCliente() {
       
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonNovo = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonDesativar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanCliente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextCPF_cpnj = new javax.swing.JTextField();
        jTextEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("BUSCAR CLIENTE");

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Editar");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonDesativar.setText("Desativar");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setText("Nome:");

        jTextNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeActionPerformed(evt);
            }
        });

        jLabel4.setText("cpf/cnpj:");

        jTextCPF_cpnj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCPF_cpnjActionPerformed(evt);
            }
        });

        jTextEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextEmailActionPerformed(evt);
            }
        });

        jLabel3.setText("e-mail:");

        javax.swing.GroupLayout jPanClienteLayout = new javax.swing.GroupLayout(jPanCliente);
        jPanCliente.setLayout(jPanClienteLayout);
        jPanClienteLayout.setHorizontalGroup(
            jPanClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanClienteLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanClienteLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanClienteLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextCPF_cpnj, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanClienteLayout.setVerticalGroup(
            jPanClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextCPF_cpnj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButtonNovo)
                        .addGap(70, 70, 70)
                        .addComponent(jButtonEdit)
                        .addGap(74, 74, 74)
                        .addComponent(jButtonDesativar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonDesativar))
                .addGap(18, 18, 18)
                .addComponent(jPanCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
 
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jTextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeActionPerformed
    String nome = jTextNome.getText();
    ValidateCliente validateCliente = new ValidateCliente();
    try {        
        Cliente cliente = validateCliente.validaCamposEntrada(nome, "", "");      
        JOptionPane.showMessageDialog(this, "Nome válido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    } catch (ImpreException e) {        
        JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }   
  
    }//GEN-LAST:event_jTextNomeActionPerformed

    private void jTextCPF_cpnjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCPF_cpnjActionPerformed
    String cpfCnpj = jTextCPF_cpnj.getText();   
    
    ValidateCliente validateCliente = new ValidateCliente();
    
    try {
        if (!validateCliente.validarCpfCnpj(cpfCnpj)) {
            jTextCPF_cpnj.setBackground(Color.WHITE);  
        } else {
            jTextCPF_cpnj.setBackground(Color.RED);  
            JOptionPane.showMessageDialog(this, "CPF ou CNPJ inválido! Por favor, insira um CPF ou CNPJ válido.");
        }
    } catch (Exception e) {
        jTextCPF_cpnj.setBackground(Color.RED);  
        JOptionPane.showMessageDialog(this, "Erro ao validar CPF ou CNPJ: " + e.getMessage());
    }
    }//GEN-LAST:event_jTextCPF_cpnjActionPerformed

    private void jTextEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextEmailActionPerformed
      String email = jTextEmail.getText();
    ValidateCliente validateCliente = new ValidateCliente();

    try {
        if (!validateCliente.validarEmail(email)) {
            jTextEmail.setBackground(Color.RED);  
            JOptionPane.showMessageDialog(this, "E-mail inválido! Por favor, insira um e-mail válido.");
        } else {
            jTextEmail.setBackground(Color.WHITE);  
        }
    } catch (Exception e) {
        jTextEmail.setBackground(Color.RED);  
        JOptionPane.showMessageDialog(this, "Erro ao validar o e-mail: " + e.getMessage());
    }
      
    }//GEN-LAST:event_jTextEmailActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDesativar;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextCPF_cpnj;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextNome;
    // End of variables declaration//GEN-END:variables
}