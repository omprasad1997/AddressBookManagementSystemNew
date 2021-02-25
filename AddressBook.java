package com.blbz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
	public static final int  showContact 	     = 1;
	public static final int  addNewContact       = 2;
	public static final int  editExistingContact = 3;
	public static final int  deletePersonContact = 4;
	public static final int  exit  				 = 5;
	
	public static void welcomeToAddressBook() {
		HashMap<String, ArrayList<Contact>> hm = new HashMap<String, ArrayList<Contact>>();
		
		System.out.println("Enter number of Address Book:");
		Scanner sc = new Scanner(System.in);
		int numberOfAddressBook = sc.nextInt();
		ArrayList<String> names = new ArrayList<String>();
		System.out.println("Enter names of Address Book:");
		String namesOfAddressBook= sc.nextLine();
		
		for(int i = 0;i<numberOfAddressBook;i++)
			names.add(sc.nextLine());
			
		for(int i = 0;i<numberOfAddressBook;i++)
		{
			System.out.println("Enter Contact in " + names.get(i));
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");					
			hm.put(names.get(i),AddressBook.goToAddressBook());
		}
			
		boolean newFlag = true;
		
		while(newFlag) {
			System.out.println("Enter AddressBook names : ");
			System.out.println("First  book is ");
			String firstBook = sc.nextLine();
			System.out.println( firstBook + " "+ hm.get(firstBook));
			System.out.println("Second  book is ");
			String secondBook = sc.nextLine();
			System.out.println(secondBook + " "+ hm.get(secondBook));
			newFlag = false;
		}	
		System.out.println("Total address books are " + hm);	
	}
	
	public static ArrayList<Contact> goToAddressBook() {
		Scanner sc = new Scanner(System.in);
		Contact dMart = new Contact("Pushpak","Ghatode","Kailash Nagar","Pune","Maharashtra","400001","384792876","abc@gmail.com");
		ArrayList<Contact> contact = new ArrayList<Contact>();
	
		boolean flag = true;
		
		while(flag) 
		{
			System.out.println("1 : Showing Contact");
			System.out.println("2 : Adding New Contact");
			System.out.println("3 : Edit Existing Contact");
			System.out.println("4 : Delete Person Contact");
			System.out.println("5 : Exit");

			System.out.print("Enter a choice : ");
			int choice = sc.nextInt();
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");					

			switch(choice)
			{
			case showContact:
			{
				System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n","First Name","Last Name","Address","City","State","Zip","Phone Number","E-mail");
				for(int i=0;i<contact.size();i++){
					contact.get(i).showDetails();
				}
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");					
				break;
			}
			case addNewContact :{
				ArrayList<String> details = new ArrayList<String>();
				System.out.println("First Name : ");
				details.add(sc.next());
				System.out.println("Last Name : ");
				details.add(sc.next());
				System.out.println("Address : ");
				details.add(sc.next());
				System.out.println("City Name : ");
				details.add(sc.next());
				System.out.println("State Name : ");
				details.add(sc.next());
				System.out.println("Zip code : ");
				details.add(sc.next());
				System.out.println("Phone Number: ");
				details.add(sc.next());
				System.out.println("E-mail id : ");
				details.add(sc.next());
				Contact input=new Contact(details.get(0),details.get(1),details.get(2),details.get(3),details.get(4),details.get(5),details.get(6),details.get(7));
				contact.add(input);
				System.out.println("You have successfully added new contact.");
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");					
				break;
			}
			case editExistingContact:{
				int index=0;
				boolean isPresent=false;
				System.out.print("Enter person name do you want to edit : ");
				String tempFirstName=sc.next();
				for(int i = 0; i < contact.size(); i++) {
					if(contact.get(i).getFirstName().equals(tempFirstName)) {
						isPresent=true;
						index=i;
						break;		
					}
				}
				if(isPresent) {
					System.out.println("First Name : ");
					contact.get(index).setFirstName(sc.next());
					System.out.println("Last Name : ");
					contact.get(index).setLastName(sc.next());
					System.out.println("Address : ");
					contact.get(index).setAddress(sc.next());
					System.out.println("City Name : ");
					contact.get(index).setCity(sc.next());
					System.out.println("State Name : ");
					contact.get(index).setState(sc.next());
					System.out.println("Zip code : ");
					contact.get(index).setZip(sc.next());
					System.out.println("Phone Number: ");
					contact.get(index).setPhoneNumber(sc.next());
					System.out.println("E-mail id : ");
					contact.get(index).setEmail(sc.next());
					System.out.println("You have successfully edited contact.");
				}
				else {
					System.out.println("Invalid Name");
				}	
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");					
				break;
			}
			case deletePersonContact:{
				int index=0;
				boolean isPresent=false;
				System.out.print("Enter person name do you want to delete : ");
				String tempFirstName=sc.next();
				for(int i = 0; i < contact.size(); i++) {
					if(contact.get(i).getFirstName().equals(tempFirstName)) {
						isPresent=true;
						index=i;
						break;		
					}
				}
				if(isPresent) {
					contact.remove(contact.get(index));
					System.out.println("You have successfully deleted contact.");
				}
				else {
					System.out.println("Invalid Name");
				}	
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");					
				break;
			}
			case exit:{				
				flag = false;
				break;
			}
			}
		}
		return contact;
	}

	public static void main(String[] args) {
		
		System.out.println("-----------------------------------------------------------Welcome to Address Book Manangement System--------------------------------------------------------\n");
		welcomeToAddressBook();
		System.out.println();
		System.out.println("-------------------------------------------Thank you for using address book management system.--------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
}

