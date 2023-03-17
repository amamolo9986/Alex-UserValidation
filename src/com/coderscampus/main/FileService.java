package com.coderscampus.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

	public User[] readMyFile() throws IOException {

		User[] users = new User[4];
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader("data.txt"));
			String line;

			int i = 0;
			while ((line = reader.readLine()) != null) {
				String[] userData = line.split(",");
				String username = userData[0];
				String password = userData[1];
				String name = userData[2];

				users[i] = new User(username, password, name);
				i++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return users;
	}

}
