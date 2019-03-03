package _01_Intro_To_Sockets.client;

import java.awt.HeadlessException;
import java.awt.image.DataBufferByte;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ClientGreeter {

   public static void main(String [] args) {
	  //1. Create a String for the ip address of the server. 
	  // If you don't know how to find a computer's ip address, ask about ifconfig on linux/mac and ipconfig on windows.
      
	  InetAddress ip = null;
	try {
		ip = InetAddress.getLocalHost().getByName(JOptionPane.showInputDialog("Put the damn ip:"));
	} catch (HeadlessException e1) {
		e1.printStackTrace();
	} catch (UnknownHostException e1) {
		e1.printStackTrace();
	}
	   
      //2. Create an integer for the server's port number

	  int port = 6699;
	  
      //3. Surround steps 4-9 in a try-catch block that catches any IOExceptions.
    
	  try {
		  
		  Socket socket = new Socket(ip, port);
		  
		  DataOutputStream os = new DataOutputStream(socket.getOutputStream());
		  
		  os.writeUTF("You are unloved you stupid Klein Bottle.");
		  
		  DataInputStream is = new DataInputStream(socket.getInputStream());
		  
		  System.out.println(is.readUTF());
		  
		  socket.close();
		  
	  } catch (IOException e) {
		  
	  }
	  
    	 //4. Create an object of the Socket class. When initializing the object, pass in the ip address and the port number
 
         //5. Create a DataOutputStream object. When initializing it, use the Socket object you created in step 4 to call the getOutputStream() method.
         
         //6. Use the DataOutputStream object to send a message to the server using the writeUTF(String message) method
         
         //7. Create a DataInputStream object. When initializing it, use the Server object you created in step 4 to call the getInputStream() method.
         
         //8. Use the DataInputStream object to print a message from the server using the readUTF() method.
         
         //9. Close the client's server object

   }
}
