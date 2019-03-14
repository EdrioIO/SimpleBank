import java.util.Scanner;



import java.util.ArrayList;
public class Customer {
	public String name;
	public Integer savingBalance;
	public Integer currentBalance;
	public String password;
	public String email;
	int length = 0;
	
	public Customer() {
		
	}
	
	public Customer(Scanner input) {
		
		do {
			
				System.out.print("Input Your Name[3 - 20] : ");
				name = input.nextLine();
				length = name.length();
		}while(length < 3 || length > 20);
		
		length = 0; 
		
		do {
			
				System.out.print("Input Your Password[6] : ");
				password = input.nextLine();
				length = password.length();
			
		}while(password.length()!=6);
		
		do {
			try {
				System.out.print("Input Saving Balance[10000 - 100000] : ");
				savingBalance = input.nextInt();
			}catch(Exception e) {
				savingBalance = 0;
				System.out.println("Input Invalid.Please Try Again...");
			}
			input.nextLine();
		}while(savingBalance < 10000 || savingBalance > 100000);
		
		
		do {
			try {
				System.out.print("Input current Balance[10000 - 100000] : ");
				currentBalance = input.nextInt();
			}catch(Exception e) {
				currentBalance = 0;
				System.out.println("Input Invalid.Please Try Again...");
			}
			input.nextLine();
		}while(currentBalance < 10000 || currentBalance > 100000);
		
		length = 0;
		
		do {
			
				System.out.print("Input Recovery email [min 7 char]: ");
				email = input.nextLine();
				length = email.length();
		}while(length < 7);
		
	}
	
	
	public void lihat() {
		System.out.printf("%-20s | %-15s | %-20s | %-7s\n", name, savingBalance, currentBalance,email);
	}
	
	public static void lihat(ArrayList<Customer> customerList) {
		if(customerList.isEmpty()) {
			System.out.println("Tidak ada data.");
		}
		else {
			System.out.printf("%-20s | %-15s | %-20s | %-7s\n", "Nama", "Save", "Current","Email");
			for (Customer c : customerList) {
				c.lihat();
			}
		}
	}
	
	public static void regist(Scanner input,MainClass main) {
		main.customerList.add(new Customer(input));
		lihat(main.customerList);
	}
	

	
	public int checking(ArrayList<Customer> customerList,String namee,String passworde) {
			int flag = -1;
			if(customerList.isEmpty()) {
				flag = -1;
			}
			else {
				for (int i = 0 ; i < customerList.size();i++) {
					if(customerList.get(i).name.compareTo(namee)== 0 && customerList.get(i).password.compareTo(passworde) == 0) {
						flag = i;
						break;
					}
				}
			}
			return flag;
		}
	
	
	public int login(Scanner input,MainClass main) {
		
		do {
			
				System.out.print("Input Your Name[3 - 20] : ");
				name = input.nextLine();
				length = name.length();
			
		}while(length < 3 || length > 20);
		
		do {
		
				System.out.print("Input Your Password[6] : ");
				password = input.nextLine();
				length = password.length();
			
		}while(password.length()!=6);
		
		int status = checking(main.customerList,name,password);
		
		return status;
		
	}
	
	
}
