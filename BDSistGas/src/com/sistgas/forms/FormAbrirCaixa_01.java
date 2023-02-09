package com.sistgas.forms;

import com.sistgas.controles.FuncoesUteis;
import com.sistgas.controles.ManterAbrirFecharCaixa;
import com.sistgas.controles.ManterFuncionarios;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class FormAbrirCaixa_01 extends javax.swing.JInternalFrame {
    
    private ResultSet rs = null;
    
    public FormAbrirCaixa_01() {
        super("Formulário Abrir Caixa", true, true, true, true);
        initComponents();
        listarAbrirCaixa();
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
    
    public void exibirAbrirCaixa(ResultSet rs) {
        ResultSet rs1 = null;

        try {
            tfCpf.setEditable(false);
            tfValorAbertura.setEditable(false);

            tfIdCaixa.setText(new Integer(rs.getInt("id")).toString());
            tfCpf.setText(rs.getString("fkFuncionario_cpf"));

            rs1 = ManterFuncionarios.getFuncionarios(rs.getString("fkFuncionario_cpf"));
            if (rs1 != null && rs1.next()) {
                tfNomeFuncionario.setText(rs1.getString("nome"));
            }
            rs1 = null;

            tfDataAbertura.setText(FuncoesUteis.converteDataparaAplicacao(rs.getString("data_abertura")));
            tfValorAbertura.setText(new Double(rs.getString("valor_abertura")).toString());
            tfSituacao.setText(rs.getString("situacao"));

            if (rs.getString("data_fechamento") != null) {
                tfDataFechamento.setText(FuncoesUteis.converteDataparaAplicacao(rs.getString("data_fechamento")));
                tfValorFechamento.setText(new Double(rs.getDouble("valor_fechamento")).toString());
            } else {
                tfDataFechamento.setText("");
                tfValorFechamento.setText("");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void adicionarAbrirCaixa() {
        int regInseridos = 0;

        Date data = new Date(System.currentTimeMillis());
        String fData = new SimpleDateFormat("yyyy-MM-dd").format(data);

        regInseridos = ManterAbrirFecharCaixa.adicionarAbrirCaixa(tfCpf.getText(),fData,
                new Double(tfValorAbertura.getText()).toString(), "Aberto");

        System.out.println("Número de registros inseridos: " + regInseridos);
        if (regInseridos == 1) {
            JOptionPane.showMessageDialog(this, "Informações do Abrir Caixa adicionadas com sucesso.", "Mensagem de confirmação", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void limparFormulario() {
        tfCpf.setEditable(true);
        tfValorAbertura.setEditable(true);

        tfIdCaixa.setText("");
        tfCpf.setText("");
        tfNomeFuncionario.setText("");
        tfDataAbertura.setText("");
        tfDataFechamento.setText("");
        tfValorAbertura.setText("");
        tfValorFechamento.setText("");
        tfSituacao.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfIdCaixa = new javax.swing.JTextField();
        tfCpf = new javax.swing.JTextField();
        tfNomeFuncionario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfDataAbertura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfDataFechamento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfValorAbertura = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfValorFechamento = new javax.swing.JTextField();
        tfSituacao = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btAnterior = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btAdicionar = new javax.swing.JButton();
        btProximo = new javax.swing.JButton();
        btProcurar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Cód Caixa:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("CPF Funcionário:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Situação:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Data abertura:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Data fechamento:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Valor abertura:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Valor fechamento:");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(btAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btProcurar.setText("...");
        btProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfNomeFuncionario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btProcurar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)
                                .addComponent(tfIdCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(29, 29, 29)
                                        .addComponent(tfDataAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(29, 29, 29)
                                        .addComponent(tfDataFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(29, 29, 29)
                                        .addComponent(tfValorFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(tfSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(29, 29, 29)
                                            .addComponent(tfValorAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 24, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(tfIdCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btProcurar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfValorAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfValorFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfDataAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfDataFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnteriorActionPerformed
        // TODO add your handling code here:
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
        // TODO add your handling code here:
        limparFormulario();
        btAdicionar.setEnabled(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        // TODO add your handling code here:
        adicionarAbrirCaixa();
        listarAbrirCaixa();
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProximoActionPerformed
        // TODO add your handling code here:
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
        // TODO add your handling code here:
        ResultSet rs;

        if (!tfCpf.getText().isEmpty()) {
            rs = ManterFuncionarios.getFuncionarios(tfCpf.getText());
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfCpf;
    private javax.swing.JTextField tfDataAbertura;
    private javax.swing.JTextField tfDataFechamento;
    private javax.swing.JTextField tfIdCaixa;
    private javax.swing.JTextField tfNomeFuncionario;
    private javax.swing.JTextField tfSituacao;
    private javax.swing.JTextField tfValorAbertura;
    private javax.swing.JTextField tfValorFechamento;
    // End of variables declaration//GEN-END:variables
}
