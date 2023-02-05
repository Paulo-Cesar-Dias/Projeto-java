
package com.sistgas.controles;

import java.sql.ResultSet;

public class ManterFuncionarios {
    
    public static ResultSet listarFuncionarios(){ 
        String sql= "select * from funcionarios;"; 
        ResultSet rs; 
        
        rs = AdaptadorBDSistGas.consultarBanco(sql) ;  
        return rs;   
    } 
    
    public static ResultSet getFuncionario(String cpf) { 
        String sql = "select * from funcionarios where cpf=" + cpf + ";"; 
        ResultSet rs; 
        
        rs = AdaptadorBDSistGas.consultarBanco(sql) ;  
        return rs;  
    } 
    
    public static int adicionarFuncionarios(String nome) { 
        
        int regInseridos = 0; 
        
        String insertSQL = "INSERT INTO funcionarios " + 
                "(nome) VALUES ("+ 
                "'" +nome+ "'" + 
                ");"; 
        
        regInseridos = AdaptadorBDSistGas.atualizarBanco(insertSQL) ;
        return regInseridos; 
    }
    
    public static int adicionarFuncionarios(String cpf, String nome, String contato, String email) { 
        
        int regInseridos = 0; 
        
        String insertSQL = "INSERT INTO funcionarios " + 
                "(cpf, nome, contato, email) VALUES ("+ cpf + "'"+ 
                "'" +nome+ "'" +contato+ "'" +email+ "'" +
                ");"; 
        
        regInseridos = AdaptadorBDSistGas.atualizarBanco(insertSQL) ;
        return regInseridos; 
    }
    
    public static int atualizarFuncionarios(String cpf, String nome, String contato, String email) { 
        
        int regAtualizados = 0; 
        
        String updateSQL = "UPDATE funcionarios SET " + 
                
                "nome ='" +nome+ "'" + "contato ='" +contato+ "email='" +email+
                " where cpf = "+cpf+";";
                
        
        regAtualizados = AdaptadorBDSistGas.atualizarBanco(updateSQL) ;
        
        return regAtualizados; 
    }
    
    public static int excluirFuncionarios(String id, String nome, String contato, String email) { 
        
            int regExcluidos = 0; 

            String excluirSQL = "DELETE FROM funcionarios " + 
                 " where id = "+id+";";

            regExcluidos = AdaptadorBDSistGas.atualizarBanco(excluirSQL) ;

            return regExcluidos; 
        }
    
}
