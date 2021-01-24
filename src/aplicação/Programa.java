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

		Contribuinte cont;

		Locale.setDefault(Locale.US);
		Scanner leitorInteiro = new Scanner(System.in);
		Scanner leitor = new Scanner(System.in);

		System.out.print("Informe a quantidade de contribuintes que irá declarar IR: ");
		int qtdContri = leitorInteiro.nextInt();

		for (int i = 1; i <= qtdContri; i++) {
			System.out.println("Contribuinte #" + i);
			System.out.print("Tipo de contribuinte: (F/J): ");
			char escolha = leitor.next().charAt(0);
			System.out.print("Nome: ");
			String nome = leitor.nextLine();
			Double rendaAnual = leitor.nextDouble();
			if (escolha == 'f' || escolha == 'F') {
				System.out.print("Gastos com saúde: ");
				Double gastosSaude = leitor.nextDouble();
				contribuinte.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
			} else {
				System.out.print("Quantidade de funcionários: ");
				Integer qtdFunc = leitorInteiro.nextInt();
				contribuinte.add(new PessoaJuridica(nome, rendaAnual, qtdFunc));
			}

		}

		leitor.close();
		leitorInteiro.close();
	}
}