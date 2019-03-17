package _02_Chat_Application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {
	
	private int port;
	
	private ServerSocket server;
	private Socket socket;
	
	private boolean running = false;
	
	private DataOutputStream os;
	private DataInputStream is;
	
	public Server(int port) {
		this.port = port;
	}
	
	public void run() {
		running = true;
		while(running) {
			try {
				server = new ServerSocket(port);
				
				socket = server.accept();
				
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
