package package_webserver;
import package_shopping.*;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

	public static void main(String[] args) throws Exception 
	{
		System.out.println("Hello World Server!");
		
		
		int port = 4123;
	    ServerSocket server = new ServerSocket(port);
	    while(true) {
	        try {
	          new Server(server.accept()).handle();
	        } catch(IOException e) {
	          System.out.println(e.getMessage());
	          e.printStackTrace();
	        }
	      }    
	    
	}

}

