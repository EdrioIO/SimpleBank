import java.util.ArrayList;
import java.util.Scanner;

public class Info {
	public static void info(Scanner input,int idx,ArrayList<Customer> customerList){
		System.out.print("Account Information\nName : " + customerList.get(idx).name
				+ "\nSaving Balace : " + customerList.get(idx).savingBalance
				+ "\nCurrent Balance : " + customerList.get(idx).currentBalance +"\n");
	}
}
