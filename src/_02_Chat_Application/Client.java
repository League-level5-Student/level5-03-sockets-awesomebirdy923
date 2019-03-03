package _02_Chat_Application;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

	DatagramSocket socket;
	int port;
	InetAddress ip;
	
	public Client(String ip) {
		try {
			this.ip = InetAddress.getByName(ip);
			socket = new DatagramSocket(6699, InetAddress.getByName(ip));
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			byte[] data = new byte[1024];
			
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			try {
				socket.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println(new String(packet.getData()));
		}
	}
	
	public void sendData(byte[] bytes) {
		DatagramPacket packet = new DatagramPacket(bytes, bytes.length, ip, port);
		try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
