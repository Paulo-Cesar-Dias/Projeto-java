package com.sistgas.forms;

import com.sistgas.controles.FuncoesUteis;
import com.sistgas.controles.ManterFuncionarios;
import com.sistgas.controles.ManterAbrirFecharCaixa;
import java.sql.Date;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class FormAbrirCaixa extends javax.swing.JInternalFrame {
    
    private ResultSet rs = null;

    public FormAbrirCaixa() {
        super("Formulário Abrir Caixas", true,true,true,true);
        listarAbrirCaixa();
        initComponents();
        
    }
    
    public void listarAbrirCaixa() {

        rs = ManterAbrirFecharCaixa.listarAbrirFecharCaixa();
        try {
            // exibe o resultado (ResultSet) da consulta na saida padrão Java (Console, prompt de comando)
            if (rs != null && rs.next()) {
                exibirAbrirCaixa(rs);

                btAdicionar.setEnabled(false);
                btAnterior.setEnabled(true);
                btProximo.setEnabled(true);
            } else {
                limparFormulario();
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void limparFormulario() { 
        
        tfCpf_Funcionario.setEditable(true);
        tfValor_Fechamento.setEditable(true);
        
        tfIdCaixa.setText(""); 
        tfCpf_Funcionario.setText("");  
        tfNomeFuncionario.setText("");
        tfData_Abertura.setText("");
        tfValor_Abertura.setText("");
        tfData_Fechamento.setText("");
        tfValor_Fechamento.setText("");
        tfSituacao.setText("");
        tfDiferenca.setText("");
        
        btAdicionar.setEnabled(true); 
        btAnterior.setEnabled(true); 
        btProximo.setEnabled(true);              
    }
    
    public void exibirAbrirCaixa(ResultSet rs) {
        ResultSet rs1 = null;

        try {

            tfCpf_Funcionario.setEditable(false);
            tfValor_Abertura.setEditable(false);

            tfIdCaixa.setText(new Integer(rs.getInt("id")).toString());
            tfCpf_Funcionario.setText(rs.getString("fkFuncionario_cpf"));

            rs1 = ManterFuncionarios.getFuncionarios(rs.getString("fkFuncionario_cpf"));
            if (rs1 != null && rs1.next()) {
                tfNomeFuncionario.setText(rs1.getString("nome"));
            }
            rs1 = null;

            tfData_Abertura.setText(FuncoesUteis.converteDataparaAplicacao(rs.getString("data_abertura")));
            tfValor_Abertura.setText(new Double(rs.getDouble("valor_abertura")).toString());
            tfSituacao.setText(rs.getString("situacao"));

            if (rs.getString("data_fechamento") != null) {
                tfData_Fechamento.setText(FuncoesUteis.converteDataparaAplicacao(rs.getString("data_fechamento")));
                tfValor_Fechamento.setText(new Double(rs.getDouble("valor_fechamento")).toString());
                tfDiferenca.setText(new Double(rs.getDouble("diferenca")).toString());
            } else {
                tfData_Fechamento.setText("");
                tfValor_Fechamento.setText("");
                tfDiferenca.setText("0.0");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void adicionarAbrirCaixa() {
        int regInseridos = 0;

        Date data = new Date(System.currentTimeMillis());
        String fData = new SimpleDateFormat("yyyy-MM-dd").format(data);
        String fHora = new SimpleDateFormat("HH:mm").format(data);

        regInseridos = ManterAbrirFecharCaixa.adicionarAbrirCaixa(tfCpf_Funcionario.getText(),tfData_Abertura.getText(),
                new Double(tfValor_Abertura.getText()).toString(), "Aberto");

        System.out.println("Número de registros inseridos: " + regInseridos);
        if (regInseridos == 1) {
            JOptionPane.showMessageDialog(this, "Informações do Abrir Caixa adicionadas com sucesso.", "Mensagem de confirmação", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void tfCpf_FuncionarioFocusLost(java.awt.event.FocusEvent evt) {                                 
        ResultSet rs;

        if (!tfCpf_Funcionario.getText().isEmpty()) {
            rs = ManterFuncionarios.getFuncionarios(tfCpf_Funcionario.getText());
            try {
                // exibe o resultado (ResultSet) da consulta na saida padrão Java (Console, prompt de comando)
                if (rs != null && rs.next()) {
                    tfCpf_Funcionario.setText(rs.getString("nome"));
                } else {
                    tfCpf_Funcionario.setText("");
                    rs = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfIdCaixa = new javax.swing.JTextField();
        tfCpf_Funcionario = new javax.swing.JTextField();
        btProcurar = new javax.swing.JButton();
        tfNomeFuncionario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfData_Abertura = new javax.swing.JTextField();
        tfValor_Abertura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfData_Fechamento = new javax.swing.JTextField();
        tfValor_Fechamento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfSituacao = new javax.swing.JTextField();
        tfDiferenca = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btAnterior = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btAdicionar = new javax.swing.JButton();
        btProximo = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Cód Caixa:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("CPF Funcionario:");

        btProcurar.setText("...");
        btProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcurarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Data abertura:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Valor abertura:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Data fechamento:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Valor fechamento:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Situação:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Diferença:");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sistgas/icones/anterior.gif"))); // NOI18N
        btAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnteriorActionPerformed(evt);
            }
        });

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sistgas/icones/novo.gif"))); // NOI18N
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sistgas/icones/adicionar.gif"))); // NOI18N
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sistgas/icones/proximo.gif"))); // NOI18N
        btProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProximoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btAdicionar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAnterior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btProximo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNomeFuncionario)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCpf_Funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(41, 41, 41)
                                .addComponent(tfIdCaixa)))
                        .addGap(18, 18, 18)
                        .addComponent(btProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfValor_Abertura, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(tfData_Abertura, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfDiferenca, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(tfSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfValor_Fechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(tfData_Fechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfIdCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfCpf_Funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btProcurar))
                .addGap(18, 18, 18)
                .addComponent(tfNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfData_Abertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfValor_Abertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfData_Fechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfValor_Fechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfDiferenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnteriorActionPerformed
        try {
            if (rs != null) {
                if (!rs.isFirst()) {
                    rs.previous();
                }
                exibirAbrirCaixa(rs);

                btAdicionar.setEnabled(false);
                btAnterior.setEnabled(true);
                btProximo.setEnabled(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btAnteriorActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limparFormulario();
        btAdicionar.setEnabled(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        adicionarAbrirCaixa();
        listarAbrirCaixa();
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProximoActionPerformed
        try {
            if (rs != null) {
                if (!rs.isLast()) {
                    rs.next();
                }
                exibirAbrirCaixa(rs);

                btAdicionar.setEnabled(false);
                btAnterior.setEnabled(true);
                btProximo.setEnabled(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btProximoActionPerformed

    private void btProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcurarActionPerformed
        ResultSet rs;

        if (!tfCpf_Funcionario.getText().isEmpty()) {
            rs = ManterFuncionarios.getFuncionarios(tfCpf_Funcionario.getText());
            try {
                // exibe o resultado (ResultSet) da consulta na saida padrão Java (Console, prompt de comando)
                if (rs != null && rs.next()) {
                    tfNomeFuncionario.setText(rs.getString("nome"));
                } else {
                    tfNomeFuncionario.setText("");
                    rs = null;
                    JOptionPane.showMessageDialog(null, "Funcionário inexistente.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btProcurarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btAnterior;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btProcurar;
    private javax.swing.JButton btProximo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField tfCpf_Funcionario;
    private javax.swing.JTextField tfData_Abertura;
    private javax.swing.JTextField tfData_Fechamento;
    private javax.swing.JTextField tfDiferenca;
    private javax.swing.JTextField tfIdCaixa;
    private javax.swing.JTextField tfNomeFuncionario;
    private javax.swing.JTextField tfSituacao;
    private javax.swing.JTextField tfValor_Abertura;
    private javax.swing.JTextField tfValor_Fechamento;
    // End of variables declaration//GEN-END:variables

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
