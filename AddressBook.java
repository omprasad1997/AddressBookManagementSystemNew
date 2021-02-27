package com.blbz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
	public static final int 	 addNewAddressBook  	      =   1;
	public static final int 	 showNamesOfAddressBook 	  =   2;
	public static final int		 enterContactInAddressBook    =   3;
	public static final int		 exitFromAddressBook          =   4;
	

	public static void welcomeToAddressBook() {
		Map<String, ArrayList<Contact>> hm = new HashMap<String, ArrayList<Contact>>();
		Contact dMart = new Contact("Pushpak","Ghatode","Kailash Nagar","Pune","Maharashtra","400001","384792876","abc@gmail.com");
		ArrayList<Contact> contact = new ArrayList<Contact>();
		Scanner sc  = new Scanner(System.in);

		boolean check = true;
		while(check)
		{		

			System.out.println("1 : Add new address book");
			System.out.println("2 : Show names of address book");
			System.out.println("3 : Enter Contact in address book");
			System.out.println("4 : Exit from address book");
			System.out.println("Enter choice :");
			int choiceForAddressBook = sc.nextInt();

			switch(choiceForAddressBook)
			{		
			case addNewAddressBook:{
				System.out.println("Enter number of Address Book:");
				int numberOfAddressBook = sc.nextInt();
				ArrayList<String> names = new ArrayList<String>();
				
				System.out.println("Enter names of Address Book:");
				for(int i=0;i<numberOfAddressBook;i++) {		
					while(true){	
						String namesOfAddressBook= sc.next();
						if(!names.contains(namesOfAddressBook)){
							names.add(namesOfAddressBook);
							hm.put(namesOfAddressBook, contact);
							break;
						}
						else {
							System.out.println("This name of address book already exist.Please enter new name");
						}
					}	
				}
				System.out.println("You have Successfully added " + numberOfAddressBook + " address book");
				break;
			}
			case showNamesOfAddressBook:{
				System.out.println("Total address books are:");
				for(Map.Entry<String,ArrayList<Contact>> eachAddressbook:hm.entrySet()) {
					System.out.println(eachAddressbook.getKey() + " : " + eachAddressbook.getValue());
				}
			}

			case exitFromAddressBook:{
				check = false;
				break;
			}
			}
		}
	}

	public static void main(String[] args) {

		System.out.println("-----------------------------------------------------------Welcome to Address Book Manangement System--------------------------------------------------------\n");
		welcomeToAddressBook();
		System.out.println();
		System.out.println("-------------------------------------------Thank you for using address book management system.--------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
}

