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

		System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n","First Name","Last Name","Address","City","State","Zip","Phone Number","E-mail");
		for(int i=0;i<contact.size();i++){
			contact.get(i).showDetails();
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");	
	
		
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
	}
}

