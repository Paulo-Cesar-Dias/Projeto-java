package com.sistgas.forms;

import com.sistgas.controles.ManterProdutos; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import javax.swing.JOptionPane;

public class FormProdutos extends javax.swing.JInternalFrame {
    
    private ResultSet rs = null;

    public FormProdutos() {
        super("Formulário Produtos", true,true,true,true);
        initComponents();
        listarProdutos();
    }
    
    public void listarProdutos() { 
        rs = ManterProdutos.listarProdutos();
        try { 
            if (rs != null && rs.next()) {
            exibirProdutos(rs);    
            
            
            btAdicionar.setEnabled(false); 
            btSalvar.setEnabled(true); 
            btAnterior.setEnabled(true); 
            btProximo.setEnabled(true); 
            btExcluir.setEnabled(true);
                   
        }else{ 
            limparFormulario(); 
            rs = null;
            
        }
    }catch (SQLException e) { 
        e.printStackTrace();
    }
    }
    
    public void exibirProdutos(ResultSet rs) { 
        try { 
        
        tfIdProduto.setText(new Integer(rs.getInt("id")).toString()); 
        tfNome.setText(rs.getString("nome"));
        taDescricao.setText(rs.getString("descricao"));
        tfPreco_unitario.setText(rs.getString("preco_unitario"));

        }catch (SQLException e) { 
        e.printStackTrace();
    } 
    }
    
    public void limparFormulario() { 
        
        tfIdProduto.setText(""); 
        tfNome.setText("");  
        taDescricao.setText("");
        tfPreco_unitario.setText("");
            
        btSalvar.setEnabled(false); 
        btAdicionar.setEnabled(true); 
        btAnterior.setEnabled(true); 
        btProximo.setEnabled(true); 
        btExcluir.setEnabled(false); 
            
    }
    
    public void adicionarProdutos(){  
        int regInseridos = 0; 
        
        regInseridos = ManterProdutos.adicionarProdutos( tfNome.getText(), taDescricao.getText(), tfPreco_unitario.getText()); 
        
        System.out.println ("Número de registros inseridos: " +regInseridos); 
        if(regInseridos == 1){ 
            JOptionPane.showMessageDialog(this, "Informações do Caixa adicionada com sucesso",
                    "Mensagem de confirmação", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void atualizarProdutos() {
        int regAtualizados = 0;

        regAtualizados = ManterProdutos.atualizarProdutos(tfIdProduto.getText(),
                tfNome.getText(), taDescricao.getText(),tfPreco_unitario.getText());

        System.out.println("Número de registros atualizados: "+regAtualizados);
        if(regAtualizados == 1){
            JOptionPane.showMessageDialog(this, "Informações do Funcionario salvas com sucesso.", "Mensagem de confirmação", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void excluirProdutos(){
        int regExcluidos = 0;
        
        regExcluidos = ManterProdutos.excluirProdutos(tfIdProduto.getText());
        
        System.out.println("Número de registros deletados: "+regExcluidos);
        if(regExcluidos == 1){
            JOptionPane.showMessageDialog(this, "Informações do Caixa excluídas com sucesso.", "Mensagem de confirmação", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        taDescricao = new javax.swing.JTextField();
        tfPreco_unitario = new javax.swing.JTextField();
        tfIdProduto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btAnterior = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btAdicionar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btProximo = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Código ID:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Descrição:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Preço unitário:");

        tfIdProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdProdutoActionPerformed(evt);
            }
        });

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

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sistgas/icones/salvar.gif"))); // NOI18N
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sistgas/icones/excluir.gif"))); // NOI18N
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btSalvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAdicionar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAnterior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btProximo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(taDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfPreco_unitario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(taDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfPreco_unitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdProdutoActionPerformed

    private void btAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnteriorActionPerformed
        try {
            if (rs != null) {
                if (!rs.isFirst()) {
                    rs.previous();
                }
                exibirProdutos(rs);

                btAdicionar.setEnabled(false);
                btSalvar.setEnabled(true);
                btAnterior.setEnabled(true);
                btProximo.setEnabled(true);
                btExcluir.setEnabled(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btAnteriorActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limparFormulario();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        adicionarProdutos();
        listarProdutos();
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {
            int codigo = rs.getRow();
            atualizarProdutos();
            listarProdutos();
            rs.absolute(codigo);
            exibirProdutos(rs);

            btAdicionar.setEnabled(false);
            btSalvar.setEnabled(true);
            btAnterior.setEnabled(true);
            btProximo.setEnabled(true);
            btExcluir.setEnabled(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        excluirProdutos();
        listarProdutos();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProximoActionPerformed
        try {
            if (rs != null) {
                if (!rs.isLast()) {
                    rs.next();
                }
                exibirProdutos(rs);

                btAdicionar.setEnabled(false);
                btSalvar.setEnabled(true);
                btAnterior.setEnabled(true);
                btProximo.setEnabled(true);
                btExcluir.setEnabled(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btProximoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btAnterior;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btProximo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField taDescricao;
    private javax.swing.JTextField tfIdProduto;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPreco_unitario;
    // End of variables declaration//GEN-END:variables
}
