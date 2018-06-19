package com.bridgelabz.hibernate;

import java.util.Scanner;

import com.bridgelabz.controller.Manager;
import com.bridgelabz.model.User;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Manager manager=new Manager();
		User user;
		char input = ' ';
		do {

			System.out.print("\n\t\t\t\t    A D D_I N F O-S Y S T E M ");
			System.out.print("\n\t\t\t\t--------------------------------");

			System.out.print("\n\t\t\t\t  Registration : Enter 1");
			System.out.print("\n\t\t\t\t  login        : Enter 2");
			System.out.print("\n\t\t\t\t  display      : Enter 3");

			System.out.print("\n\t\t\t\t--------------------------------\n");

			System.out.print("\n\t\t\t\tEnter Choice : ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				 user= new User();

				System.out.println("\n\t\t\t\tP E R S O N-D E T A I L S");
				System.out.println("\t\t\t\t----------------------------");

				System.out.print("\t\t\t\tEnter the First Name : ");
				user.setFirstName(scanner.next());

				System.out.print("\t\t\t\tEnter the Last Name  : ");
				user.setLastName(scanner.next());

				System.out.print("\t\t\t\tEnter the Email Id   : ");
				user.setEmail(scanner.next());

				System.out.print("\t\t\t\tEnter the Password   : ");
				user.setPassword(scanner.next());

                manager.register(user);
                
				break;

			case 2:
				user = new User();

				System.out.print("\t\t\t\tEnter the Email Id   : ");
				user.setEmail(scanner.next());

				System.out.print("\t\t\t\tEnter the Password   : ");
				user.setPassword(scanner.next());
           
				manager.login(user);

				break;
				
			case 3: manager.display();
			       break;

			default:
				System.out.println("\n\t\t\t\tInvalid Choice...!");
			}
			System.out.print("\n\t\t\t\tDo you Want to continue (Y/N) : ");
			input = scanner.next().charAt(0);
		} while (input == 'Y' || input == 'y');

	}
}
