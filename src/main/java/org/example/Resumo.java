package org.example;

import java.util.List;

public class Resumo {

    List<Ocorrencia> ocorrencias;

    public void printarResumo() {
    String titulo = """
                ========================================
                       RESUMO DA PESQUISA
                ========================================
                """;
        System.out.println(titulo);



        //System.out.println("Busca finalizada: " + arquivo + " | Ocorrências: " + numeroOcorrencias);

        System.out.println("RESUMO AQUI");

    }

}
