package fag.objetos;

import java.util.ArrayList;

public class Estacionamento {

    public ArrayList<Vaga> vagas = new ArrayList<>();
    public ArrayList<Carro> carros = new ArrayList<>();

    public void adicionarVaga(Integer numeroVaga, String tamanhoVaga, boolean disponibilidade) {
        Vaga vaga = new Vaga(numeroVaga, tamanhoVaga, disponibilidade);
        vagas.add(vaga);
    }

    public void registrarEntrada(String placa, String modelo, String tamanhoCarro, Integer horaEntrada) {
        for (Vaga vaga : vagas) {
            
            if (vaga.disponibilidade && vaga.tamanhoVaga.equalsIgnoreCase(tamanhoCarro)) {
                
                Carro carro = new Carro(placa, modelo, tamanhoCarro, horaEntrada, -1);
                carros.add(carro);
                
                vaga.disponibilidade = false;
                System.out.println("Carro registrado na vaga " + vaga.numeroVaga);
                return;
            }
        }
        System.out.println("Não há vaga disponível para o carro de tamanho " + tamanhoCarro);
    }
    
    public void registrarSaida(String placa, Integer horaSaida) {
        for (Carro carro : carros) {
            if (carro.placa.equalsIgnoreCase(placa) && carro.horaSaida == -1) { // -1 é que o carro ainda tá no estacionamento
                carro.horaSaida = horaSaida;
                
                Integer tempoPermanencia = carro.horaSaida - carro.horaEntrada;
                
                double valorPago = calcularValor(tempoPermanencia);
                
                System.out.println("Carro " + carro.placa + " permaneceu por " + tempoPermanencia + " horas.");
                System.out.println("Valor a ser pago: R$ " + valorPago);
                
                for (Vaga vaga : vagas) {
                    if (!vaga.disponibilidade) {
                        vaga.disponibilidade = true;
                        System.out.println("Vaga " + vaga.numeroVaga + " liberada.");
                        break;
                    }
                }
                return;
            }
        }
        System.out.println("Veículo não encontrado ou já registrou saída.");
    }

    private double calcularValor(Integer tempoPermanencia) {
        if (tempoPermanencia <= 1) {
            return 5.00;
        } else if (tempoPermanencia <= 3) {
            return 10.00;
        } else {
            return 15.00;
        }
    }

    public void relatorioVeiculosEstacionados() {
        System.out.println("Relatório de veículos estacionados:");
        for (Vaga vaga : vagas) {
            if (!vaga.disponibilidade) {
                for (Carro carro : carros) {
                    if (carro.horaSaida == -1 && carro.tamanho.equalsIgnoreCase(vaga.tamanhoVaga)) {
                        System.out.println("Vaga " + vaga.numeroVaga + " | " + carro.placa + " | " + carro.modelo);
                        break;
                    }
                }
            }
        }
    }

    public void relatorioSaida() {
        System.out.println("Relatório de Saída de Veículos:");
        for (Carro carro : carros) {
            if (carro.horaSaida != -1) {
                int tempoPermanencia = carro.horaSaida - carro.horaEntrada;
                
                double valorPago = calcularValor(tempoPermanencia);

                System.out.println("Placa: " + carro.placa + " | Tempo de permanência: " + tempoPermanencia + " horas | Valor Pago: R$ " + valorPago);
            }
        }
    }

    public void relatorioGeral() {
        System.out.println("Relatório Geral de Vagas e Veículos:");
        
        for (Vaga vaga : vagas) {
            if (!vaga.disponibilidade) {
                for (Carro carro : carros) {
                    if (carro.horaSaida == -1 && carro.tamanho.equalsIgnoreCase(vaga.tamanhoVaga)) { 
                        System.out.println("Vaga " + vaga.numeroVaga + " (Tamanho: " + vaga.tamanhoVaga + ") | Veículo: " + carro.placa + " (" + carro.modelo + ")");
                        break;
                    }
                }
            } else {
                System.out.println("Vaga " + vaga.numeroVaga + " (Tamanho: " + vaga.tamanhoVaga + ") | Status: Livre");
            }
        }
    }

}
