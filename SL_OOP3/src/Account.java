import java.util.*;

public class Account {
	// deposit
	// withdraw
	// acc info
	int balance;

	public Account() {

	}

	

	

	public static void menu(Scanner input, int idx,ArrayList<Customer> customerList) {
		int choose = 0;
		do {
			try {
				System.out.println("1. Account Current");
				System.out.println("2. Account Saving");
				System.out.println("3. Accounts Balance");
				System.out.println("4. Back");
				System.out.print(">> ");
				choose = input.nextInt();
			} catch (Exception e) {
				choose = 0;
			}
			input.nextLine();

			switch (choose) {
			case 1:
				Current.Current(input,idx,customerList);
				break;
			case 2:
//				Saving(input, idx);
				break;
			
			case 3:
				Info.info(input, idx, customerList);
				break;
			
			default :
				
				break;
			}
		} while (choose != 4);
	}
}