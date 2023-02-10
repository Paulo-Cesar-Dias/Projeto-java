package com.sistgas.controles;

import java.sql.ResultSet;

public class ManterFecharCaixa {  
    
    public static ResultSet listarFecharCaixa(){
        String sql = "select * from caixa;";
        ResultSet rs;

        rs = AdaptadorBDSistGas.consultarBanco(sql);

        return rs;
    }
    
    public static ResultSet getFuncionarioCaixa(String id){
        String sql = "select * from caixa as c, funcionarios as f "
                + "where f.cpf = c.fkFuncionarios_cpf and "
                + "c.id="+id+";";
        ResultSet rs;

        rs = AdaptadorBDSistGas.consultarBanco(sql);

        return rs;
    }
    
    public static int atualizarFecharCaixa(String id,
            String data_fechamento, String valor_fechamento,
             String situacao){
        
        int regAtualizados = 0;
        // Consulta a ser executada no banco de dados através de um método da classe Statement
        String updateSQL = "UPDATE caixa SET " +
                "data_fechamento = '"+data_fechamento+"'"+ ","+
                "valor_fechamento = "+valor_fechamento+ ","+
                "situacao = '"+situacao+"'"+ 
                " where id= "+id+";";

        regAtualizados = AdaptadorBDSistGas.atualizarBanco(updateSQL);

        return regAtualizados;
    }
}
