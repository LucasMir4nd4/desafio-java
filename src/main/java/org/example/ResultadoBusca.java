package org.example;

import java.util.List;

public record ResultadoBusca(String arquivo, List<Ocorrencia> ocorrencias, String erro, long tempoMs) {

    public int total() {
        return ocorrencias.size();
    }

    public boolean temErro() {
        return erro != null;
    }
}