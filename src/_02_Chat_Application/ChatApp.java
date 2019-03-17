package _02_Chat_Application;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp {

	static JButton button = new JButton("Send");
	static JFrame frame = new JFrame("fortnite");
	static JPanel panel = new JPanel();
	static JTextField text = new JTextField();
	
	static Client client;
	static Server server;
	
	public static void main(String[] args) {
		if(JOptionPane.showConfirmDialog(null, "Want to host a server?", "fortnite", JOptionPane.YES_NO_OPTION) == 0) {
			text.setPreferredSize(new Dimension(100,30));
			server = new Server(6699);
			button.addActionListener((e)->{
				server.sendMessage(text.getText());
			});
			panel.add(button);
			panel.add(text);
		    frame.add(panel);
		    frame.pack();
		    frame.setTitle("Server");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setResizable(false);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
		    server.run();
		}else {
			text.setPreferredSize(new Dimension(100,30));
			client = new Client("192.168.1.174", 6699);
			button.addActionListener((e)->{
				client.sendMessage(text.getText());
			});
			panel.add(button);
			panel.add(text);
		    frame.add(panel);
		    frame.pack();
		    frame.setTitle("Client");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setResizable(false);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
		    client.run();
		}
	}
	
}
