package com.sistgas.controles;

import java.sql.ResultSet;

public class ManterClientes {
    
    public static ResultSet listarClientes(){ 
        String sql= "select * from clientes;"; 
        ResultSet rs; 
        
        rs = AdaptadorBDSistGas.consultarBanco(sql) ;  
        return rs;   
    } 
    
    public static ResultSet getClientes(String id) { 
        String sql = "select * from clientes where cpf=" +id+ ";"; 
        ResultSet rs; 
        
        rs = AdaptadorBDSistGas.consultarBanco(sql) ;  
        return rs;  
    } 
    
    public static int adicionarClientes(String nome, String telefone, String endereco) { 
        
        int regInseridos = 0; 
        
        String insertSQL = "INSERT INTO clientes " + 
                "(nome, telefone, endereco) VALUES ("+ 
                "'" +nome+ "', " 
                +telefone+ ", " +
                "'" +endereco+ "'"+
                ");"; 
        
        regInseridos = AdaptadorBDSistGas.atualizarBanco(insertSQL) ;
        return regInseridos; 
    }  
    
     public static int atualizarClientes(String id, String nome, String telefone, String endereco) { 
        
        int regAtualizados = 0; 
        
        String updateSQL = "UPDATE clientes SET " + 
                
                "nome ='" +nome+ "', " +  
                "telefone ='"+telefone+"', " +
                "endereco ='"+endereco+"'" +
                " where id= "+id+";";
                
        
        regAtualizados = AdaptadorBDSistGas.atualizarBanco(updateSQL) ;
        
        return regAtualizados; 
    }  
     
          public static int excluirClientes(String id){ 
        
            int regExcluidos = 0; 

            String excluirSQL = "DELETE FROM clientes " + 
                 " where id= "+id+";";

            regExcluidos = AdaptadorBDSistGas.atualizarBanco(excluirSQL) ;

            return regExcluidos; 
        }
    
    
}
