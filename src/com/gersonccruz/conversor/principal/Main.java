package com.gersonccruz.conversor.principal;

import com.gersonccruz.conversor.modelos.ResultadoConversao;
import com.gersonccruz.conversor.servicos.ServicoDeConversao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicoDeConversao servico = new ServicoDeConversao();

        while (true) {
            System.out.println("\n*************************************************");
            System.out.println("Bem-vindo(a) ao Conversor de Moedas!");
            System.out.println("1) Dólar (USD) =>> Real Brasileiro (BRL)");
            System.out.println("2) Real Brasileiro (BRL) =>> Dólar (USD)");
            System.out.println("3) Euro (EUR) =>> Real Brasileiro (BRL)");
            System.out.println("4) Real Brasileiro (BRL) =>> Euro (EUR)");
            System.out.println("5) Franco Suiço (CHF) =>> Dólar (USD)");
            System.out.println("6) Dólar (USD) =>> Franco Suiço (JPY)");
            System.out.println("7) Sair");
            System.out.println("*************************************************");
            System.out.print("Escolha uma opção válida: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 7) {
                    System.out.println("Obrigado por utilizar meu programa!" +
                            "Programa Finalizado!");
                    break;
                }

                String moedaOrigem;
                String moedaDestino;

                switch (opcao) {
                    case 1 -> { moedaOrigem = "USD"; moedaDestino = "BRL"; }
                    case 2 -> { moedaOrigem = "BRL"; moedaDestino = "USD"; }
                    case 3 -> { moedaOrigem = "EUR"; moedaDestino = "BRL"; }
                    case 4 -> { moedaOrigem = "BRL"; moedaDestino = "EUR"; }
                    case 5 -> { moedaOrigem = "CHF"; moedaDestino = "USD"; }
                    case 6 -> { moedaOrigem = "USD"; moedaDestino = "CHF"; }
                    default -> {
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                        continue;
                    }
                }

                System.out.print("Digite o valor que deseja converter: ");
                double valor = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Buscando conversão...");
                ResultadoConversao resultado = servico.converter(moedaOrigem, moedaDestino, valor);
                System.out.println(resultado);

            } catch (InputMismatchException e) {
                System.out.println("\nEntrada inválida. Por favor, digite apenas números para a opção e o valor.");
                scanner.nextLine(); // Limpa a entrada em caso de erro
            } catch (Exception e) {
                System.out.println("\nOcorreu um problema: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
