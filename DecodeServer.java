package lab2;

import java.net.*;
import java.io.*;

public class DecodeServer {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		
		// Input line received from client (i.e. 01001101)
		String inputLine = null;
		// Output line decoded using HDB3 (i.e. ???)
        String outputLine = null;
        
        // Agent to write decoded bit string to output line

        
        // Agent to read encoded bit string from input line (received from client)

        
        
        int nPort = 4445;
        String nHost = "127.0.0.1";
        boolean server_listen = true;

        
        // Create server socket
        try {
            serverSocket = new ServerSocket(nPort);
            
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + args[0]);
            System.exit(-1);
        }
        
        // Set timeout value
        //serverSocket.setSoTimeout(1000);
        
        while (server_listen) {
        	try {
        		System.out.println("Listening for client connection...");
        		clientSocket = serverSocket.accept();
        		
        		/*
        		 * Connection successful
        		 */
        		if (clientSocket != null) {
        			System.out.println("Connection from " +
  					      clientSocket.getInetAddress() + " accepted.");
        			//clientSocket.setSoTimeout(1000);
        			System.out.println("Accepted client.");
        			
        			// Establish PrintWriter and BufferedReader objects
        			PrintWriter out =
        			        new PrintWriter(clientSocket.getOutputStream(), true);
        			BufferedReader in = new BufferedReader(
        			        new InputStreamReader(clientSocket.getInputStream()));
        			
        			String clientStr = in.readLine();
        			System.out.println("Client string BEFORE decode: "+clientStr);
        			clientStr = decode(clientStr);
        			System.out.println("Client string AFTER decode: "+clientStr);
        			
        		}
        	} catch (InterruptedIOException e) {
        		System.out.println(e);
        	}	
        }
        
	}
	
	public static String decode(String input) {
		String output = input.toUpperCase();
		
		return output;
	}
}
