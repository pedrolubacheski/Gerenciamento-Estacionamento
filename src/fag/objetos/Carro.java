package fag.objetos;

public class Carro {

	public String placa;
	public String modelo;
	public String tamanho;
	public Integer horaEntrada;
	public Integer horaSaida;
	
	public Carro(String placa, String modelo, String tamanho, Integer horaEntrada, Integer horaSaida) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.tamanho = tamanho;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
	}

	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", modelo=" + modelo + ", tamanho=" + tamanho + ", horaEntrada=" + horaEntrada
				+ ", horaSaida=" + horaSaida + "]";
	}
	
	
	
}
