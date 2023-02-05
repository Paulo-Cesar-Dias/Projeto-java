package com.sistgas.controles;

import java.sql.*;

public class AdaptadorBDSistGas {

    private static String serverName = "localhost"; //caminho do servidor do BD
    private static String mydatabase = "bdsistemagerenciamentogas"; //nome do seu banco de dados
    // endereço onde está o banco de dados. Lembrem-se que BDClientes é o nome
    // que vocês colocaram no Administrador ODBC
    private static String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
    // usuário do banco de dados
    private static String username = "root";
    // senha para acesso ao banco de dados
    private static String password = "123456";
    // Conexão ao banco de dados
    private static Connection cnn = null;
    // Driver para conexão ao banco de dados
    private static String driverName = "com.mysql.cj.jdbc.Driver";

    public static Connection abrirConexao() {

        try {
            if (AdaptadorBDSistGas.cnn == null) {
                // Este é um dos meios para registrar um driver
                Class.forName(driverName);
                // Configurando a nossa conexão com um banco de dados//
                AdaptadorBDSistGas.cnn = DriverManager.getConnection(url, username, password);
                // Se a conexão foi executada com sucesso, a mensagem abaixo é exibida na Saída Padrão Java
                System.out.println("Você se conectou ao banco de dados!! :D :D");
                System.out.println("#####################################");
                return AdaptadorBDSistGas.cnn;
            }

        } catch (SQLException e) {
            // se houve algum erro, uma exceção é gerada para informar o erro
            e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
        }

        return AdaptadorBDSistGas.cnn;
    }

    public static int atualizarBanco(String sql){
        Statement stmt = null;
        int regAlterados = 0;

        try {
            Connection cnn = abrirConexao();
            stmt = cnn.createStatement();
            regAlterados = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // se houve algum erro, uma exceção é gerada para informar o erro
            e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
        }

        return regAlterados;
    }

    public static ResultSet consultarBanco(String sql) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection cnn = abrirConexao();
            stmt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            // se houve algum erro, uma exceção é gerada para informar o erro
            e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
        }

        return rs;
    }
    

}
