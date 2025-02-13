/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.template;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller.LoginController;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.SessionModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Validators;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components.PopUpDefault;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author misael
 */
public class FrLogin extends javax.swing.JFrame {
    private LoginController loginController ;
    private PopUpDefault popUpDefault;
    /**
     * Creates new form NewJFrame
     */
    public FrLogin() {
        this.setLocationRelativeTo(null);
        initComponents();
        this.loginController =  new LoginController();
        this.popUpDefault = new PopUpDefault(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodyPanel = new javax.swing.JPanel();
        credentialInputPanel = new javax.swing.JPanel();
        passwordInputContainer = new javax.swing.JPanel();
        passwordLabel = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        userNameInputContainer = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        loginButtonPanel = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bodyPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        passwordLabel.setText("Senha");

        passwordInput.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        passwordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout passwordInputContainerLayout = new javax.swing.GroupLayout(passwordInputContainer);
        passwordInputContainer.setLayout(passwordInputContainerLayout);
        passwordInputContainerLayout.setHorizontalGroup(
            passwordInputContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordInputContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(passwordInputContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordInput)
                    .addGroup(passwordInputContainerLayout.createSequentialGroup()
                        .addComponent(passwordLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        passwordInputContainerLayout.setVerticalGroup(
            passwordInputContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordInputContainerLayout.createSequentialGroup()
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        usernameLabel.setText("Email:");

        emailInput.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        emailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userNameInputContainerLayout = new javax.swing.GroupLayout(userNameInputContainer);
        userNameInputContainer.setLayout(userNameInputContainerLayout);
        userNameInputContainerLayout.setHorizontalGroup(
            userNameInputContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emailInput)
            .addGroup(userNameInputContainerLayout.createSequentialGroup()
                .addComponent(usernameLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        userNameInputContainerLayout.setVerticalGroup(
            userNameInputContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userNameInputContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout credentialInputPanelLayout = new javax.swing.GroupLayout(credentialInputPanel);
        credentialInputPanel.setLayout(credentialInputPanelLayout);
        credentialInputPanelLayout.setHorizontalGroup(
            credentialInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(passwordInputContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(credentialInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userNameInputContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        credentialInputPanelLayout.setVerticalGroup(
            credentialInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(credentialInputPanelLayout.createSequentialGroup()
                .addComponent(userNameInputContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordInputContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnLogin.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginButtonPanelLayout = new javax.swing.GroupLayout(loginButtonPanel);
        loginButtonPanel.setLayout(loginButtonPanelLayout);
        loginButtonPanelLayout.setHorizontalGroup(
            loginButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginButtonPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );
        loginButtonPanelLayout.setVerticalGroup(
            loginButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginButtonPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titleLabel.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        titleLabel.setText("LOGIN");

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(credentialInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addGap(123, 123, 123))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(credentialInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(112, 112, 112))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String email = "misaelg.freitas2000@gmail.com";//emailInput.getText();
        String password = "123456789";//String.valueOf(passwordInput.getPassword());
        if(!Validators.validarEmail(email)){
            this.exibirPopUP(DefaultMessages.EMAIL_INVALIDO.getMessage());
            return;
        }
         DataResponseModel<SessionModel> resp = this.loginController.validarLogin(email, password);
        if(!resp.isSuccess()){
            this.exibirPopUP(resp.getMessage());
            return;
        }
        this.setVisible(false);
        FrMain.criarInterface();
       
    }//GEN-LAST:event_btnLoginActionPerformed

    private void emailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailInputActionPerformed

    }//GEN-LAST:event_emailInputActionPerformed

    private void passwordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordInputActionPerformed

    void exibirPopUP(String message){
        this.popUpDefault.showPopUp(message);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel credentialInputPanel;
    private javax.swing.JTextField emailInput;
    private javax.swing.JPanel loginButtonPanel;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JPanel passwordInputContainer;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel userNameInputContainer;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
