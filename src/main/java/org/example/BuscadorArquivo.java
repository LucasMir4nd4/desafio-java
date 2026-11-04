package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BuscadorArquivo {

    private final Path pastaArquivos = Path.of("src/main/resources/arquivos");


    // private final List<String> arquivos = List.of(
    //         "signatarios-out-2002",
    //         "signatarios-out-2003",
    //         "signatarios-out-2004"
    // );

    public ResultadoBusca buscar(Path arquivo, String nome){

        long tempoInicio = System.nanoTime();

        List<Ocorrencia> ocorrencias = new ArrayList<>();
        String erro = null;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo.toFile()))) {
            String linha = br.readLine();
            int numeroLinha = 0;

            while (linha != null) {
                numeroLinha++;
                if (linha.contains(nome)) {
                    Ocorrencia ocorrencia = new Ocorrencia(arquivo, numeroLinha, linha);
                    ocorrencias.add(ocorrencia);

                }
                linha = br.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long tempoFim = System.nanoTime();
        return new ResultadoBusca(arquivo.toString(), ocorrencias, erro, (tempoFim - tempoInicio) / 1_000_000);

    }

}