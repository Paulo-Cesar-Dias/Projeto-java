package com.sistgas.controles;

import java.sql.ResultSet;

public class ManterAbrirFecharCaixa {  
    
    public static ResultSet listarAbrirFecharCaixa(){
        String sql = "select * from caixa;";
        ResultSet rs;

        rs = AdaptadorBDSistGas.consultarBanco(sql);

        return rs;
    }
    
    public static ResultSet getFuncionarioCaixa(String id){
        String sql = "select * from caixa as c, funcionario as f "
                + "where f.cpf = c.fkFuncionario_cpf and "
                + "c.id="+id+";";
        ResultSet rs;

        rs = AdaptadorBDSistGas.consultarBanco(sql);

        return rs;
    }
    
    public static int adicionarAbrirCaixa(String cpf, String data_abertura, String valor_abertura, String situacao){

        int regInseridos = 0;

        // Consulta a ser executada no banco de dados através de um método da classe Statement
        String insertSQL = "INSERT INTO caixa " +
                "(fkFuncionario_cpf, data_abertura, valor_abertura, situacao) VALUES ("+
                cpf+", "+ 
                "'"+data_abertura+"'"+ ","+
                valor_abertura+","+
                "'"+situacao+"'"+ 
                ");";

        regInseridos = AdaptadorBDSistGas.atualizarBanco(insertSQL);

        return regInseridos;
    }
    
    public static int atualizarFecharCaixa(String id, 
            String data_fechamento, String valor_fechamento,
            String diferenca, String situacao){
        
        int regAtualizados = 0;
        // Consulta a ser executada no banco de dados através de um método da classe Statement
        String updateSQL = "UPDATE caixa SET " +
                "data_fechamento = '"+data_fechamento+"'"+ ","+
                "valor_fechamento = "+valor_fechamento+ ","+
                "diferenca = "+diferenca+ ","+
                "situacao = '"+situacao+"'"+ 
                " where idfuncionario_caixa = "+id+";";

        regAtualizados = AdaptadorBDSistGas.atualizarBanco(updateSQL);

        return regAtualizados;
    }
}
