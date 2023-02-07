package com.sistgas.controles;

import java.sql.ResultSet;

public class ManterFuncionarios{
    
    public static ResultSet listarFuncionarios(){ 
        String sql= "select * from funcionarios;"; 
        ResultSet rs; 
        
        rs = AdaptadorBDSistGas.consultarBanco(sql) ;  
        return rs;   
    } 
    
    public static ResultSet getFuncionarios(String cpf) { 
        String sql = "select * from funcionarios where cpf=" +cpf+ ";"; 
        ResultSet rs; 
        
        rs = AdaptadorBDSistGas.consultarBanco(sql) ;  
        return rs;  
    } 
    
    public static int adicionarFuncionarios(String nome, String contato, String email, String endereco) { 
        
        int regInseridos = 0; 
        
        String insertSQL = "INSERT INTO funcionarios " + 
                "(nome, contato, email, endereco) VALUES ("+ 
                "'" +nome+ "'" + 
                "'" +contato+ "'"+
                "'" +email+ "'"+
                "'" +endereco+ "'"+
                ");"; 
        
        regInseridos = AdaptadorBDSistGas.atualizarBanco(insertSQL) ;
        return regInseridos; 
    }  
    
     public static int atualizarFuncionarios(String cpf, String nome, String contato, String email, String endereco) { 
        
        int regAtualizados = 0; 
        
        String updateSQL = "UPDATE caixa SET " + 
                
                "nome ='" +nome+ "'" +  
                "contato ='" +contato+ "'" +
                "email ='" +email+ "'" +
                "endereco ='" +endereco+ "'" +
                " where cpf= "+cpf+";";
                
        
        regAtualizados = AdaptadorBDSistGas.atualizarBanco(updateSQL) ;
        
        return regAtualizados; 
    }  
     
          public static int excluirFuncionarios(String cpf, String nome, String contato, String email, String endereco){ 
        
            int regExcluidos = 0; 

            String excluirSQL = "DELETE FROM caixa " + 
                 " where cpf= "+cpf+";";

            regExcluidos = AdaptadorBDSistGas.atualizarBanco(excluirSQL) ;

            return regExcluidos; 
        }
    
}
