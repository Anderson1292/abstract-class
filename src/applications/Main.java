package applications;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalPerson;
import entities.People;
import entities.PhysicalPerson;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<People> list = new ArrayList<>();
		
		System.out.print("Enter the number of max payers: ");
		int payers = sc.nextInt();
		
		for(int i = 1;i <= payers;i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char option = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Annual Income: ");
			double income = sc.nextDouble();
			
			if(option == 'i') {
				System.out.print("Healt expenditures: ");
				double spending = sc.nextDouble();
				list.add(new PhysicalPerson(name, income, spending));
			}
			else {
				System.out.print("Number of employees: ");
				int employees = sc.nextInt();
				list.add(new LegalPerson(name, income, employees));
			}
			
		}
		double sum = 0.0;
		System.out.println();
		System.out.println("TAXES PAID:");
		for(People people:list) {
			double tax = people.taxCalculation();
			System.out.println(people.getName()+": $ " + String.format("%.2f", tax));
			sum += tax;
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		sc.close();
	}

}
