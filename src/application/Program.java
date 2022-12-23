package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		int i;
		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		
		for(i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Digite os dados do " + (i + 1) + "o contribuinte:");
			System.out.print("Renda anual com salário: ");
			Double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			Double servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			Double capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			Double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			Double educationSpending = sc.nextDouble();
			
			TaxPayer contributor = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
			list.add(contributor);
		}
		
		System.out.println();
		i = 1;
		for(TaxPayer contributor :  list) {
				System.out.println("Resumo do " +  (i++) + "o contribuinte:");
				System.out.println(contributor);
		}
		
		sc.close();

	}

}
