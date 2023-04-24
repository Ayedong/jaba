
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OOP {
	public static void main(String[] args) {
		new choices();
	
	}//main
	
}	
	class choices{
		private double balance = 100;
		static Scanner scan = new Scanner(System.in);
		private int counter = 0;
		private String username;
		private int acc;
		private boolean check;
	
		
		choices(){
			System.out.println("WELCOME TO AYIL's ATM");
			getUser();
		}
		
		
		public void getUser(){
			
			while(true) {
			System.out.println("[1] Log in | [2] Create User | [3] Exit");
			while(true) {
				System.out.print("Enter Choice: ");
				acc = scan.nextInt();
				if(acc == 3)
					break;
				
				if(acc == 1 || acc == 2)
						break;
				

				}
				if(acc == 3) {
					System.out.println("Thank you for using our system!");
				break;
				}
				if(getInfo(acc) == true)
					break;
			}

		
		
		do {
		System.out.println("[1] Withdraw [2] Display Balance [3] Deposit [4] Exit");
		System.out.println("============================================");
		System.out.print("Enter choice: ");
		int ch = scan.nextInt();
		
		switch(ch) {
		
		case 1 :
			withdraw();
			break;
		
		case 2:
			disBalance();
			break;
			
		case 3:
			deposit();
			break;
		
		case 4:
			System.out.print("Are you sure you want to exit? Y[yes] | N[no]: ");
			char ex = scan.next().charAt(0);
			if(ex == 'N' || ex == 'n') {
				continue;
			}
			else {
				System.out.println("THANK YOU FOR USING OUR SYSTEM \nCOME AGAIN!");
				return;
			}
		}
		
		}while(counter != 1);
	
	
		}
		public boolean getInfo(int acc) {
			
			if(acc == 1) {
				
				while(!check) {
				System.out.print("Enter username: ");
				String getInfo = scan.next();
				
				if(!getInfo.equals(username)) {
					System.out.println("User not found");
					System.out.println("Do you want to enter again? [yes] | [no]");
					char get = scan.next().charAt(0);
					
					if(get == 'N' || get == 'n' )
						break;
					
					
				}
				else {
					check = true;
				}
					
				}
				
			}
			else {
				System.out.println("Create Username: ");
				String created = scan.next();
				
				Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]{3,16}$");
		        Matcher matcher = pattern.matcher(created);

		        if (matcher.matches()) {
		            System.out.println("Valid username");		            
		            System.out.println("Username created");
		            setUser(created);
		        } else {
		            System.out.println("Invalid username");
		        }
			}
			return check;
		}
		public void setUser(String user) {
			this.username = user;
		}
		
	public void withdraw(){
		System.out.print("Enter the amount you want to withdraw: ");
		double with = scan.nextDouble();
		if(with > balance)
			System.out.println("!!The amount you have entered exceed to your current balance!!");
			
		else {
			System.out.println("You have successfully withdraw!");
			balance -= with;
			System.out.println();
		}
		
		
	}
	public void disBalance(){
		System.out.println("Your current balance is: " + this.balance);
		System.out.println();
	}
	public void deposit(){
		System.out.println("Enter amount you want to deposit: ");
		balance += scan.nextDouble();
		System.out.println("You have succesfully deposit");
		System.out.println();
	}
	
}//class


