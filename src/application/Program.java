package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contracts;
import entities.Installments;
import services.ContractsServices;
import services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract Value: ");
		Double value = sc.nextDouble();
		
		Contracts contract = new Contracts(number,date,value);
		
		System.out.print("Enter number of installments: ");
		int n = sc.nextInt();
		
		ContractsServices cs = new ContractsServices(new PaypalService());
		
		cs.processContracts(contract, n);
		
		System.out.println("Installments:");
		for(Installments it: contract.getInstallments()) {
			
		}
		
		sc.close();
		
	}

}
