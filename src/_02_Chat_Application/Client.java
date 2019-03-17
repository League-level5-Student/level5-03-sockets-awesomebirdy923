package _02_Chat_Application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {

	private String ipAddress;
	private int port;
	
	private Socket socket;
	
	private boolean running = false;
	
	private DataOutputStream os;
	private DataInputStream is;
	
	public Client(String ipAddress, int port) {
		this.ipAddress = ipAddress;
		this.port = port;
	}
	
	public void run() {
		running = true;
		while(running) {
			try {
				socket = new Socket(ipAddress, port);
				
				is = new DataInputStream(socket.getInputStream());
				os = new DataOutputStream(socket.getOutputStream());
				
				os.flush();
				
				while(socket.isConnected()) {
					JOptionPane.showMessageDialog(null, is.readUTF());
				}
				
			} catch (IOException e) {
				running = false;
			} 
		}
	}
	
	public void sendMessage(String message) {
		try {
			os.writeUTF(message);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
