package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String alternateEmail;
	private String email;
	private String companySuffix = "aeycompany.com";
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;

	//constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email Created: " + this.firstName + " " + this.lastName);
		
		//Call a method asking for the department - return the department
		this.department = setDepartment();
		System.out.println("Department:" + this.department);
		
		//call a method that return a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("your passwrod is:" + this.password);
		
		//Combine elements to generate email
		email = firstName.toLowerCase() + "." +lastName.toLowerCase() + "@" + department + "." + companySuffix;
		System.out.println("your email is: " + email);
				
	}
	//ask for the department
	private String setDepartment() {
	System.out.println("Department Codes\n1 for sales\n2 for development\n3 for accounting\n0 for none\nEnter department code: ");
	Scanner in = new Scanner(System.in);
	int depChoice = in.nextInt();
	if (depChoice == 1) {return "sales"; }
	else if (depChoice == 2) {return "dev"; }
	else if (depChoice == 3) {return "acct"; }
	else { return ""; }
	}
	
	//generate a password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
			//System.out.println(rand);
			//System.out.println(passwordSet.charAt(rand));
		}

		return new String(password); 	
	}
	//Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//change the password
	public void changePassword(String password) {
		this.password = password;
	}	
	public int getMailboxCapacity() { return mailboxCapacity;}
	public String getAlternateEmail() { return alternateEmail;}	
	public String getPassword() { return password;}
	
	public String showInfo() {
		return "Display Name: "+firstName + " " +lastName+ "\nCompany Email: " +email+ "\nMailbox Capacity: " +mailboxCapacity+ "mb";
	}
}
