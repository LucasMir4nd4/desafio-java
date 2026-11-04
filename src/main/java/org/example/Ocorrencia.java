package org.example;

public class Ocorrencia {

    private String arquivo;
    private int numeroLinha;
    private String linha;

    public Ocorrencia(String arquivo, int numeroLinha, String linha) {
        this.arquivo = arquivo;
        this.numeroLinha = numeroLinha;
        this.linha = linha;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public int getNumeroLinha() {
        return numeroLinha;
    }

    public void setNumeroLinha(int numeroLinha) {
        this.numeroLinha = numeroLinha;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    @Override
    public String toString() {
        return String.format("Arquivo: [%s]\nLinha %d: %s%n", arquivo, numeroLinha, linha, "\n");
    }
}
