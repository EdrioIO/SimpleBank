import java.util.ArrayList;
import java.util.Scanner;

public class Saving {
	
	public static void Deposit(Scanner input, int idx,ArrayList<Customer> customerList) {
		int money = 0;
		do {
			try {
			System.out.print("Input Money Nominal[1-100000]: ");
			money = input.nextInt();
			
			}catch(Exception e) {
				money = 0;
			}
			input.nextLine();
		} while (money < 1 || money > 100000);
		customerList.get(idx).currentBalance += money;
		int limit = 0;
		if(customerList.get(idx).savingBalance > 2000000) {
			limit = customerList.get(idx).savingBalance - 2000000;
			customerList.get(idx).savingBalance = 2000000;
			System.out.printf("%d Is returned (Max Balance Reached)\n",limit);
		}
	}
	
	static void Saving(Scanner input,int idx,ArrayList<Customer> customerList) {
		int choice = 0;
		do {
			try {
				System.out.println("Account Current");
				System.out.println("===============");
				System.out.println("1. Deposit");
				System.out.println("2. Back");
				System.out.print(">> ");
				choice = input.nextInt();
			} catch (Exception e) {
				choice = 0;
			}
			input.nextLine();

			switch (choice) {
			case 1:
				Saving.Deposit(input, idx, customerList);
				break;
			default:
				
				break;
			}
		} while (choice != 2);
	}
}
