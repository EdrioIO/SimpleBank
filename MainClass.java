import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
// buat simpen data UNTUK BANK
	
	 ArrayList<Customer> customerList = new ArrayList<Customer>();
//	 ArrayList<Transaction> TransactionList = new ArrayList<Transaction>();
	  
	 public void menu() {
		 Scanner input = new Scanner(System.in);
			int choose = 0;
			do {
				
				try {
					System.out.println("ABC Bank");
					System.out.println("1. Register");
					System.out.println("2. Login");
					System.out.println("3. Contact Support");
					System.out.println("4. Exit");
					System.out.print(">> ");
					choose = input.nextInt();
					
				}catch(Exception e) {
					choose = 0;
				}
				input.nextLine();
				switch(choose) {
				case 1 :
					Customer.regist(input, this);
					// Goto customer Class regist void
					break;
					
				case 2 :
					//Goto account -> pilih account curr /save -> reduce / deposit(update the arraylist obj
					Customer c = new Customer();
					int idx = c.login(input,this);
					if(idx == -1) {
						System.out.println("Username / Password Error");
					}
					else {
						Account.menu(input, idx,customerList);
					}
					break;
					
				case 3 :
					Admin.menu(input, customerList);
					break;
				
				case 4 :
					System.exit(0);
					break;
					
				default :

					
					
					
					
					break;
				}
				
				
			}while(choose != 0);
			input.close();
	 }
	 
	

	public MainClass() {
		 menu();
	 }
	 
	 
	
	public static void main(String[] args) {
		new MainClass();
	}

}
