package aplicação;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contribuinte;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public class Programa {

	public static void main(String[] args) {

		List<Contribuinte> contribuinte = new ArrayList<>();

		Locale.setDefault(Locale.US);

		Scanner leitor = new Scanner(System.in);

		System.out.print("Informe a quantidade de contribuintes que irá declarar IR: ");
		int qtdContri = leitor.nextInt();

		for (int i = 1; i <= qtdContri; i++) {
			System.out.println("Contribuinte #" + i);
			System.out.print("Tipo de contribuinte: (F/J): ");
			char escolha = leitor.next().charAt(0);
			System.out.print("Nome: ");
			leitor.nextLine();
			String nome = leitor.nextLine();
			System.out.print("Renda anual: ");
			Double rendaAnual = leitor.nextDouble();
			if (escolha == 'f' || escolha == 'F') {
				System.out.print("Gastos com saúde: ");
				Double gastosSaude = leitor.nextDouble();
				contribuinte.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
			} else {
				System.out.print("Quantidade de funcionários: ");
				Integer qtdFunc = leitor.nextInt();
				contribuinte.add(new PessoaJuridica(nome, rendaAnual, qtdFunc));
			}
		}
		System.out.println();
		System.out.println("Imposto pago:");
		for (Contribuinte c : contribuinte) {
			System.out.println(c.getNome() + ": " + String.format("%.2f", c.impostoPago()));
		}

		System.out.println();
		double soma = 0;
		for (Contribuinte c : contribuinte) {
			soma += c.impostoPago();
		}
		System.out.printf("Imposto arrecadado: " + String.format("%.2f", soma));

		leitor.close();
	}
}