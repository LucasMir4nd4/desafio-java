package org.example;

import java.io.BufferedReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BuscaService {

    private static final BuscadorArquivo buscador = new BuscadorArquivo();


    public static List<ResultadoBusca> buscarTodos(List<Path> arquivosList, String nome) {
        ResultadoBusca[] resultados = new ResultadoBusca[arquivosList.size()];
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < arquivosList.size(); i++) {
            int index = i;
            Path arquivo = arquivosList.get(i);

            Thread thread = new Thread(() -> {
                resultados[index] = buscador.buscar(arquivo, nome);
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return List.of(resultados);
    }
}
