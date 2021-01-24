package entidades;

public class PessoaFisica extends Contribuinte {

	private Double gastosSaude;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public Double impostoPago() {
		double imposto = 0;
		if (getRendaAnual() < 20000.00) {
			imposto *= 0.15;
		} else {
			if (getGastosSaude() > 0) {
				imposto = (getRendaAnual() * 0.25) - (getGastosSaude() * 0.50);
			}
		}
		return imposto;
	}

	@Override
	public Double impostoArrecadado() {

		return null;
	}

}
