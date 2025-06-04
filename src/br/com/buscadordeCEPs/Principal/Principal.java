package br.com.buscadordeCEPs.Principal;

import br.com.buscadordeCEPs.Modelos.ConsutaCep;
import br.com.buscadordeCEPs.Modelos.Endereco;
import br.com.buscadordeCEPs.Modelos.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        String cep = "";

        while(!cep.equalsIgnoreCase("sair")) {

            System.out.println("Digite o CEP de busca ou sair para sair do programa:");
            cep = leitura.nextLine();

            if (cep.equalsIgnoreCase("sair")){
                break;
            }

            ConsutaCep consutaCep = new ConsutaCep();

            try {
                Endereco novoEndereco = consutaCep.buscaCep(cep);
                System.out.println(novoEndereco);
                GeradorDeArquivo gerador = new GeradorDeArquivo();
                gerador.geraJson(novoEndereco);
            } catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Tente digitar outro CEP");
            }
        }
    }
}