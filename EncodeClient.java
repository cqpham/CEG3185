package lab2;

import java.awt.*;
import java.applet.*;
import java.net.*;

import javax.swing.*;

import java.io.*;

public class EncodeClient {
	
	public static void main(String[] args) throws IOException {
		Socket MyClient;
		
		// CLIENT CONNECTION
		try {
			// Create client socket
			MyClient = new Socket("127.0.0.1", 4445);
			System.out.println("Client started...");
			
			// Establish PrintWrite and BufferedReader objects
			PrintWriter out = new PrintWriter(MyClient.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(MyClient.getInputStream()));
			
			BufferedReader stdIn = new BufferedReader(
		            new InputStreamReader(System.in));
			
			System.out.println("Read line:");
			// Get user input string
			String userInput;
			while ((userInput = stdIn.readLine()) != null) {
				System.out.println("Client string BEFORE encode: " + userInput);
				userInput = encode(userInput);
			    System.out.println("Client string AFTER encode: " + userInput);
			    
			    //Send to server
			    out.println(userInput);
			}
			System.out.println("Done reading line.");
			
		}
		catch (IOException e) {
				System.out.println(e);
		}
		
		
	}
	
	public static String encode(String input) {
		String output = input.toLowerCase();
		
		
		
		return output;
	}
}
