package fag.objetos;

public class Vaga {

	public Integer numeroVaga;
	public String tamanhoVaga;
	public boolean disponibilidade;

	
	public Vaga(Integer numeroVaga, String tamanhoVaga, boolean disponibilidade) {
		super();
		this.numeroVaga = numeroVaga;
		this.tamanhoVaga = tamanhoVaga;
		this.disponibilidade = disponibilidade;
	}

	public String toString() {
		return "CadastroVaga [numeroVaga=" + numeroVaga + ", tamanhoVaga=" + tamanhoVaga + ", disponibilidade="
				+ disponibilidade + "]";
	}
	
	
	
}
