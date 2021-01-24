package entidades;

public class PessoaJuridica extends Contribuinte {

	private Integer funcionarios;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer funcionarios) {
		super(nome, rendaAnual);
		this.funcionarios = funcionarios;
	}

	public Integer getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Integer funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public Double impostoPago() {
		double imposto = 0;
		if (getFuncionarios() < 10) {
			imposto = getRendaAnual() * 0.16;
		} else {
			imposto = getRendaAnual() * 0.14;
		}
		return imposto;
	}
}