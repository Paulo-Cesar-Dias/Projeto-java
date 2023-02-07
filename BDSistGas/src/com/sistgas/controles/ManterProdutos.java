
package com.sistgas.controles;

import java.sql.ResultSet;

public class ManterProdutos {
    
} 

    public static ResultSet listarProdutos(){ 
        String sql= "select * from produtos;"; 
        ResultSet rs; 
        
        rs = AdaptadorBDSistGas.consultarBanco(sql) ;  
        return rs;   
    } 
    
    public static ResultSet getProdutos(String cpf) { 
        String sql = "select * from produtos where cpf=" +cpf+ ";"; 
        ResultSet rs; 
        
        rs = AdaptadorBDSistGas.consultarBanco(sql) ;  
        return rs;  
    } 
    
    public static int adicionarProdutos(String nome, String contato, String email, String endereco) { 
        
        int regInseridos = 0; 
        
        String insertSQL = "INSERT INTO produtos " + 
                "(nome, contato, email, endereco) VALUES ("+ 
                "'" +nome+ "', " 
                +contato+ ", " +
                "'" +email+ "', "+
                "'" +endereco+ "'"+
                ");"; 
        
        regInseridos = AdaptadorBDSistGas.atualizarBanco(insertSQL) ;
        return regInseridos; 
    }  
    
     public static int atualizarProdutos(String cpf, String nome, String contato, String email, String endereco) { 
        
        int regAtualizados = 0; 
        
        String updateSQL = "UPDATE funcionarios SET " + 
                
                "nome ='" +nome+ "', " +  
                "contato =" +contato+ ", " +
                "email ='" +email+ "', " +
                "endereco ='" +endereco+ "'" +
                " where cpf= "+cpf+";";
                
        
        regAtualizados = AdaptadorBDSistGas.atualizarBanco(updateSQL) ;
        
        return regAtualizados; 
    }  
     
          public static int excluirProdutos(String cpf){ 
        
            int regExcluidos = 0; 

            String excluirSQL = "DELETE FROM produtos " + 
                 " where cpf= "+cpf+";";

            regExcluidos = AdaptadorBDSistGas.atualizarBanco(excluirSQL) ;

            return regExcluidos; 
        }
    
}

