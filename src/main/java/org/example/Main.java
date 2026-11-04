package org.example;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Path PASTA = Path.of("src/main/resources/arquivos");
    private static final List<String> ARQUIVOS = List.of(
            "signatarios-out-2002",
            "signatarios-out-2003",
            "signatarios-out-2004"
    );

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome a pesquisar: ");
        String nome = "Dave";

        if (nome.isBlank()) {
            System.out.println("Nome inválido.");
            return;
        }

        List<Path> caminhos = ARQUIVOS.stream().map(PASTA::resolve).toList();

        ConstrutorResumo relatorio = new ConstrutorResumo();
        relatorio.imprimirCabecalho(nome);

        long inicio = System.nanoTime();
        List<ResultadoBusca> resultados = new BuscaService().buscarTodos(caminhos, nome);
        long tempoTotalMs = (System.nanoTime() - inicio) / 1_000_000;

        relatorio.imprimirResultados(resultados, tempoTotalMs);
        

    }
}