package org.example;

import java.io.FileNotFoundException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {


    Scanner input = new Scanner(System.in);

    Leitura leitura = new Leitura();


        String saudacao = """
                ========================================
                       SISTEMA DE BUSCA DE NOMES
                ========================================
                """;

        System.out.println(saudacao);

        System.out.print("Nome pesquisado: ");
        String nome = input.nextLine();

        System.out.println("iniciando pesquisa nos arquivos para o nome: " + nome);

        leitura.Busca(nome);

        input.close();

    }
}