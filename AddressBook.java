package com.blbz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Contact dMart = new Contact("Pushpak","Ghatode","Kailash Nagar","Pune","Maharashtra","400001","384792876","abc@gmail.com");
		ArrayList<Contact> contact = new ArrayList<Contact>();
		contact.add(dMart);

		System.out.println("-----------------------------------------------------------Welcome to Address Book Manangement System--------------------------------------------------------\n");

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
	}
}

