package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Leitura {

    private Time tempodeExecucao;

    private final Path pastaArquivos = Path.of("C:\\Users\\LUMI\\IdeaProjects\\desafio-java\\src\\main\\resources\\arquivos");

    private final List<String> arquivos = List.of(
            "signatarios-out-2002",
            "signatarios-out-2003",
            "signatarios-out-2004"
    );

    public List<Ocorrencia> ocorrencias = new ArrayList<>();


    public void buscar(String nome) throws FileNotFoundException {

        System.out.println("Buscando pelo nome: " + nome);

        arquivos.forEach( arquivo -> {

            Path caminho = Path.of(String.valueOf(pastaArquivos), arquivo);
            int numeroLinha = 0;
            int numeroOcorrencias = 0;


            try(BufferedReader br = new BufferedReader(new FileReader(caminho.toFile()))) {
                String linha = br.readLine();

                while (linha != null) {
                    numeroLinha++;
                    if (linha.contains(nome)) {
                        numeroOcorrencias++;

                        Ocorrencia ocorrencia = new Ocorrencia(arquivo, numeroLinha, linha);
                        ocorrencias.add(ocorrencia);


                    }
                    linha = br.readLine();
                }


            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        );
    }

    public void Busca(String nome) throws FileNotFoundException {
        buscar(nome);
    }

}