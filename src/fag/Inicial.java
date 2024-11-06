package fag;

import java.util.Scanner;
import fag.objetos.Estacionamento;
import fag.objetos.Vaga;

public class Inicial {

    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        Scanner scanner = new Scanner(System.in);
        
        estacionamento.adicionarVaga(1, "pequeno", true);
        estacionamento.adicionarVaga(2, "médio", true);
        estacionamento.adicionarVaga(3, "grande", true);
        
        int opcao = 0;
        
        do {
            System.out.println("1. Registrar Veículo");
            System.out.println("2. Remover Veículo");
            System.out.println("3. Veículos Estacionados");
            System.out.println("4. Relatório de Saída");
            System.out.println("5. Relatório Geral");
            System.out.println("6. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.print("Placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Modelo do veículo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Tamanho do veículo (pequeno, médio, grande): ");
                    String tamanho = scanner.nextLine();
                    System.out.print("Hora de entrada: ");
                    int horaEntrada = scanner.nextInt();
                    estacionamento.registrarEntrada(placa, modelo, tamanho, horaEntrada);
                    break;

                case 2:
                    System.out.print("Placa do veículo: ");
                    String placaSaida = scanner.nextLine();
                    System.out.print("Hora de saída: ");
                    int horaSaida = scanner.nextInt();
                    estacionamento.registrarSaida(placaSaida, horaSaida);
                    break;

                case 3:
                    estacionamento.relatorioVeiculosEstacionados();
                    break;

                case 4:
                    estacionamento.relatorioSaida();
                    break;

                case 5:
                    estacionamento.relatorioGeral();
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 6);
    }
}
