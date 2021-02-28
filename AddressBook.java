package com.blbz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class AddressBook {
	public static final int 	 addNewAddressBook  	   =   1;
	public static final int 	 showNamesOfAddressBook    =   2;
	public static final int		 enterContactInAddressBook =   3;
	public static final int		 searchPersonByCityOrState =   4;
	public static final int		 exitFromAddressBook       =   5;
	public static final String   showContact 	           = "a";
	public static final String   addNewContact             = "b";
	public static final String   editExistingContact       = "c";
	public static final String   deletePersonContact       = "d";
	public static final String   exit 					   = "e";

	public static void welcomeToAddressBook() {
		Map<String, ArrayList<Contact>> hm = new HashMap<String, ArrayList<Contact>>();
		Contact dMart = new Contact("Pushpak","Ghatode","Kailash Nagar","Pune","Maharashtra","400001","384792876","abc@gmail.com");
		Scanner sc  = new Scanner(System.in);

		boolean check = true;
		while(check)
		{		
			System.out.println("1 : Add new address book");
			System.out.println("2 : Show names of address book");
			System.out.println("3 : Enter contact in address book");		
			System.out.println("4 : Search person by city or state");
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
						String nameOfAddressBook= sc.next();
						if(!names.contains(nameOfAddressBook)){
							names.add(nameOfAddressBook);
							hm.put(names.get(i), new ArrayList<Contact>());
							break;
						}
						else {
							System.out.println("This name of address book is already exist.Please enter new name");
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
				break;
			}
			case enterContactInAddressBook:{
				for(Map.Entry<String,ArrayList<Contact>> givenAddressbook:hm.entrySet()) {
					System.out.println("Enter contact in : " + givenAddressbook.getKey());
					boolean temp = true;
					while(temp) {
						boolean flag = true;
						while(flag) 
						{
							System.out.println("a : Showing Contact");
							System.out.println("b : Adding New Contact");
							System.out.println("c : Edit Existing Contact");
							System.out.println("d : Delete Person Contact");
							System.out.println("e : Exit");

							System.out.print("Enter a choice : ");
							String choice = sc.next();
							System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");

							switch(choice)
							{
							case showContact:
							{
								System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n","First Name","Last Name","Address","City","State","Zip","Phone Number","E-mail");
								for(int i=0;i<hm.get(givenAddressbook.getKey()).size();i++){
									hm.get(givenAddressbook.getKey()).get(i).showDetails();					
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

								boolean isMatch=false;
								for(Map.Entry<String,ArrayList<Contact>> eachAddressBook:hm.entrySet()) {
									for(int index=0;index<eachAddressBook.getValue().size();index++) {
										if(eachAddressBook.getValue().get(index).getFirstName().equals(input.getFirstName())) {
											isMatch=true;
											break;
										}
									}
									if(isMatch) {
										break;
									}									
								}
								if(!isMatch) {
									hm.get(givenAddressbook.getKey()).add(input);
									System.out.println("You have successfully added new contact.");
									System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");					
								}
								else {
									System.out.println("This person is already exist.Please enter contact of new person");
								}
								break;
							}
							case exit:{
								flag = false;
								break;
							}
							}	
						}						 
						hm.put(givenAddressbook.getKey(), hm.get(givenAddressbook.getKey()));
						temp = false;	
					}
				}
				break;
			}
			case searchPersonByCityOrState:{
				System.out.println("1 : Search person by city name");
				System.out.println("2 : Search person by state name");
				System.out.println("Enter choice : ");
				int choice = sc.nextInt();
				switch(choice)
				{
				case 1:{
					System.out.println("Enter city name : ");
					String cityName = sc.next();

					for(Map.Entry<String,ArrayList<Contact>> eachAddressBook:hm.entrySet()) {
						for(int index=0;index<eachAddressBook.getValue().size();index++) {
							if(eachAddressBook.getValue().get(index).getCity().equals(cityName)) {
								System.out.println(eachAddressBook.getKey() + " : " + eachAddressBook.getValue().get(index).getFirstName());							
							}
						}				
					}
					break;
				}
				case 2:{
					System.out.println("Enter state name : ");
					String stateName = sc.next();

					for(Map.Entry<String,ArrayList<Contact>> eachAddressBook:hm.entrySet()) {
						for(int index=0;index<eachAddressBook.getValue().size();index++) {
							if(eachAddressBook.getValue().get(index).getState().equals(stateName)) {
								System.out.println(eachAddressBook.getKey() + " : " + eachAddressBook.getValue().get(index).getFirstName());							
							}
						}				
					}
					break;
				}
				}
				break;
			}
			case exitFromAddressBook:{
				check = false;
				break;
			}
			default:{
				System.out.println("Invalid choice");
			}
			}
		}
	}


	public static void main(String[] args) {

		System.out.println("-----------------------------------------------------------Welcome to Address Book Manangement System--------------------------------------------------------\n");
		welcomeToAddressBook();
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------Thank you for using address book management system.--------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
}

