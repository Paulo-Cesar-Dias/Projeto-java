package com.sistgas.controles;

import java.sql.ResultSet;

public class ManterCaixas {  
    
    public static ResultSet listarCaixas(){ 
        String sql= "select * from caixa;"; 
        ResultSet rs; 
        
        rs = AdaptadorBDSistGas.consultarBanco(sql) ;  
        return rs;   
    } 
    
    public static ResultSet getCaixa(String idcaixa) { 
        String sql = "select * from caixa where idcaixa=" + idcaixa + ";"; 
        ResultSet rs; 
        
        rs = AdaptadorBDSistGas.consultarBanco(sql) ;  
        return rs;  
    } 
    
    public static int adcionarCaixa(String descricao) { 
        
        int regInseridos = 0; 
        
        String insertSQL = "INSERT INTO caixa " + 
                "(descricao) VALUES ("+ 
                "'" +descricao+ "'" + 
                ");"; 
        
        regInseridos = AdaptadorBDSistGas.atualizarBanco(insertSQL) ;
        return regInseridos; 
    }  
    
     public static int atualizarCaixa(String idCaixa, String descricao) { 
        
        int regAtualizados = 0; 
        
        String updateSQL = "UPDATE caixa SET " + 
                
                "descricao ='" +descricao+ "'" +  
                " where idcaixa = "+idCaixa+";";
                
        
        regAtualizados = AdaptadorBDSistGas.atualizarBanco(updateSQL) ;
        
        return regAtualizados; 
    }  
     
          public static int excluirCaixa(String idCaixa, String descricao) { 
        
            int regExcluidos = 0; 

            String excluirSQL = "DELETE FROM caixa " + 
                 " where idcaixa = "+idCaixa+";";

            regExcluidos = AdaptadorBDSistGas.atualizarBanco(excluirSQL) ;

            return regExcluidos; 
        } 
             
}
