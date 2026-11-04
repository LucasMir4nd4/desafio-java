package org.example;

import java.nio.file.Path;

public record Ocorrencia(Path arquivo,int numeroLinha, String linha){

    public Ocorrencia(Path arquivo, int numeroLinha, String linha) {
        this.arquivo = arquivo;
        this.numeroLinha = numeroLinha;
        this.linha = linha;
    }

    @Override
    public String toString() {
        return String.format("Arquivo: [%s]\nLinha %d: %s%n", arquivo, numeroLinha, linha);
    }
}
