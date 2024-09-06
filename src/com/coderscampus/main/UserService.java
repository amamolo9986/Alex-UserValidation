package com.coderscampus.main;

import java.io.IOException;
import java.util.Scanner;

public class UserService {

	public void readUsers() throws IOException {
		Scanner scan = new Scanner(System.in);
		FileService fileService = new FileService();
		User[] users = fileService.readMyFile();

	
			for (int i = 0; i < 5; i++) {
				
			System.out.println("Enter your username: ");
			String username = scan.next();
			System.out.println("Enter your password: ");
			String password = scan.next();

			User[] successfulLogin = validateUser(users, username, password);

			if (successfulLogin != null) {
				break;
			} else if (i < 5) {
				System.out.println("Invalid login, please try again");
			} else {
				System.out.println("Too many failed login attempts, your account is locked.");

			}

		}
		scan.close();

	}

	public User[] validateUser(User[] users, String username, String password) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				System.out.println("Welcome " + user.getName());
				return users;
			}
		}
		return null;

	}

}
