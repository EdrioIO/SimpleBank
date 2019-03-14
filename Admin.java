import java.util.Scanner;
import java.util.ArrayList;

public class Admin {
	
	
	
	Scanner input = new Scanner(System.in);
	public String name;
	public String email;
	public Integer length;
	int flag = -1;
	
	
	public Admin() {
		
	}
	
	public int recovery(ArrayList<Customer> customerList) {
		do {
			
				System.out.print("Input Your Name[3 - 20] : ");
				name = input.nextLine();
				length = name.length();
			
		}while(length < 3 || length > 20);
		
		do {
				length = 0;
				System.out.print("Input Your Recovery Email[>=7] : ");
				email = input.nextLine();
				length = email.length();
			
		}while(length < 7);
		
		for(int i = 0 ; i < customerList.size() ; i++) {
			if(customerList.get(i).name.compareTo(name) == 0 && customerList.get(i).email.compareTo(email) == 0) {
				flag = i;
				break;
			}
		}
		return flag;
	}
	
	public static int checking(ArrayList<Customer> customerList,String namee,String passworde,String email) {
		int flag = -1;
		if(customerList.isEmpty()) {
			flag = -1;
		}
		else {
			for (int i = 0 ; i < customerList.size();i++) {
				if(customerList.get(i).name.compareTo(namee)== 0 && customerList.get(i).password.compareTo(passworde) == 0 && customerList.get(i).email.compareTo(email) ==0) {
					flag = i;
					break;
				}
			}
		}
		return flag;
	}
	
	
	public static int emergencyWithdraw(int check,ArrayList<Customer> customerList) {
		int total = 0;
		if(check!= -1) {
			total +=customerList.get(check).savingBalance;
			customerList.get(check).savingBalance = 0;
			total+=customerList.get(check).currentBalance;
			customerList.get(check).currentBalance = 0;
		}
		return total;
	}
	
	public static void menu(Scanner input,ArrayList<Customer> customerList) {
		int choose;
		int length = 0;
		String name;
		String password;
		String email;
		int status = -1;
		int check = -1;
		int retrive = 0;
		do {
			try {
			System.out.println("\n1. Emergency Withdraw");
			System.out.println("2. Recover Password");
			System.out.println("3. Back");
			System.out.print(">> ");
			choose = input.nextInt();
			}catch(Exception e) {
				choose = 0;
			}
			input.nextLine();
			switch(choose) {
			case 1 :
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
				
				do {
					
					System.out.print("Input Recovery email [min 7 char]: ");
					email = input.nextLine();
					length = email.length();
				}while(length < 7);
				check = checking(customerList,name,password,email);
				retrive = emergencyWithdraw(check,customerList);
				if(retrive != 0) {					
					System.out.printf("Retrive Amount = %d \n",retrive);
				}
				else {
					System.out.print("Wrong Data / Invalid Balance");
				}
				break;
				
			case 2 :
				Admin a = new Admin();
				status = a.recovery(customerList);
				if(status != -1) {
					System.out.printf("Your Password is %s\n",customerList.get(status).password);
				}
				else {
					System.out.print("Data Not exist / wrong recovery data");
				}
				break;
				
			default :
				break;
			}
			
		}while(choose != 3);
	}
}
