package com.sistgas.controles;

import java.sql.ResultSet;

public class ManterCaixas {  
    
    public static ResultSet listarCaixas(){ 
        String sql= "select * from caixa;"; 
        ResultSet rs; 
        
        rs = AdaptadorBDSistGas.consultarBanco(sql) ;  
        return rs;   
    } 
    
    public static ResultSet getCaixa(String id) { 
        String sql = "select * from caixa where id" + id + ";"; 
        ResultSet rs; 
        
        rs = AdaptadorBDSistGas.consultarBanco(sql) ;  
        return rs;  
    } 
    
    public static int adicionarCaixa(String descricao) { 
        
        int regInseridos = 0; 
        
        String insertSQL = "INSERT INTO caixa " + 
                "(descricao) VALUES ("+ 
                "'" +descricao+ "'" + 
                ");"; 
        
        regInseridos = AdaptadorBDSistGas.atualizarBanco(insertSQL) ;
        return regInseridos; 
    }  
    
     public static int atualizarCaixa(String id, String descricao) { 
        
        int regAtualizados = 0; 
        
        String updateSQL = "UPDATE caixa SET " + 
                
                "descricao ='" +descricao+ "'" +  
                " where id = "+id+";";
                
        
        regAtualizados = AdaptadorBDSistGas.atualizarBanco(updateSQL) ;
        
        return regAtualizados; 
    }  
     
          public static int excluirCaixa(String id, String descricao) { 
        
            int regExcluidos = 0; 

            String excluirSQL = "DELETE FROM caixa " + 
                 " where id = "+id+";";

            regExcluidos = AdaptadorBDSistGas.atualizarBanco(excluirSQL) ;

            return regExcluidos; 
        }        
}
