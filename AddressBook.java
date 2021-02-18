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
	}
}

