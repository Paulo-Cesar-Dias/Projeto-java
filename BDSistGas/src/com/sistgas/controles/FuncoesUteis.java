package com.sistgas.controles;

public class FuncoesUteis {
    
    public static String converteDataparaMySql(String data){
        String[] nasc1 = data.replace("/", "-").split("-");
        String nasc = nasc1[2] + "-" + nasc1[1] + "-" + nasc1[0];

        return nasc;
    }

    public static String converteDataparaAplicacao(String data){
        String[] nasc1 = data.replace("-", "/").split("/");
        String nasc = nasc1[2] + "/" + nasc1[1] + "/" + nasc1[0];

        return nasc;
    } 
    
}
