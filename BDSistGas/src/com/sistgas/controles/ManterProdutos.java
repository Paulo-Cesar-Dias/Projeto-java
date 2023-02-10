package com.sistgas.controles;

import java.sql.ResultSet;

public class ManterProdutos {
    
    public static ResultSet listarProdutos(){ 
        String sql= "select * from produtos;"; 
        ResultSet rs; 
        
        rs = AdaptadorBDSistGas.consultarBanco(sql) ;  
        return rs;   
    } 
    
    public static ResultSet getProdutos(String id) { 
        String sql = "select * from produtos where id=" +id+ ";"; 
        ResultSet rs; 
        
        rs = AdaptadorBDSistGas.consultarBanco(sql) ;  
        return rs;  
    } 
    
    public static int adicionarProdutos( String nome, String descricao, String preco_unitario) { 
        
        int regInseridos = 0; 
        
        String insertSQL = "INSERT INTO produtos " + 
                "( nome, descricao, preco_unitario) VALUES ("+ 
                "'"+nome+ "', "+ 
                "'"+descricao+ "', " +
                "'"+preco_unitario+"'"+ 
                ");"; 
        
        regInseridos = AdaptadorBDSistGas.atualizarBanco(insertSQL) ;
        return regInseridos; 
    }  
    
     public static int atualizarProdutos(String id, String nome, String descricao, String preco_unitario) { 
        
        int regAtualizados = 0; 
        
        String updateSQL = "UPDATE produtos SET " + 
                "nome ='" +nome+ "', " +  
                "descricao ='" +descricao+ "', " +
                "preco_unitario ='" +preco_unitario+ "'" +
                " where id= "+id+";";

        regAtualizados = AdaptadorBDSistGas.atualizarBanco(updateSQL) ;
        
        return regAtualizados; 
    }  
     
          public static int excluirProdutos(String id){ 
        
            int regExcluidos = 0; 

            String excluirSQL = "DELETE FROM produtos " + 
                 " where id= "+id+";";

            regExcluidos = AdaptadorBDSistGas.atualizarBanco(excluirSQL) ;

            return regExcluidos; 
        }
    
} 

