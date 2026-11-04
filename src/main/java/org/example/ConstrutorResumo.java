package org.example;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ConstrutorResumo {



    private static String LINHA_DUPLA = "=".repeat(40);
    private static String LINHA_SIMPLES = "-".repeat(40);
    public void imprimirCabecalho(String nome) {
        System.out.println(LINHA_DUPLA);
        System.out.println("       SISTEMA DE BUSCA DE NOMES");
        System.out.println(LINHA_DUPLA);
        System.out.println();
        System.out.println("Nome pesquisado: " + nome);
        System.out.println();
        System.out.println("Iniciando pesquisa nos arquivos...");
        System.out.println();
    }

    public void imprimirResultados(List<ResultadoBusca> resultados, long tempoExecucao) {
        imprimirOcorrencias(resultados);
        imprimirResumo(resultados);
        imprimirRodape(resultados, tempoExecucao);
    }



    public void imprimirResumo(List<ResultadoBusca> resultados) {
        System.out.println(LINHA_DUPLA);
        System.out.println("       RESUMO DA PESQUISA");
        System.out.println(LINHA_DUPLA);

        
        
        for (ResultadoBusca r : resultados) {
            System.out.println("Arquivo: " + r.arquivo());
            System.out.println(r.temErro() ? "Ocorrências: - (erro na leitura)" : "Ocorrências: " + r.total());
            System.out.println(LINHA_SIMPLES);
        }
        

    }


    public void imprimirOcorrencias(List<ResultadoBusca>resultadoBuscas){

        for(ResultadoBusca r : resultadoBuscas){

            if (r.temErro()) {
                System.out.println("Erro ao processar arquivo");
                System.out.println(r.arquivo());
                System.out.println("Motivo: ");
                System.out.println(r.erro());
                System.out.println();

            }
            else if(r.total() > 0){
                System.out.println("Arquivo: " + r.arquivo());
                r.ocorrencias().forEach(o -> {
                    System.out.println("Linha " + o.numeroLinha() + " " + o.linha());
                    System.out.println();
                });
                
            }
        }

    }

    public void imprimirRodape(List<ResultadoBusca> resultados, long tempoExecucao){
        System.out.println(LINHA_DUPLA);
        System.out.println("NOTAS FINAIS");
        System.out.println(LINHA_DUPLA);

        System.out.println("Tempo de execução: " + tempoExecucao + " ms");
    }

}
