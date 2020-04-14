package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

public class clientLogin extends JFrame{
	private JTextField textField;
	private JPasswordField passwordField;
	public clientLogin() {
		super("Client Login");
		setSize(new Dimension(313, 250));
		setLocationByPlatform(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setAlwaysOnTop(true);
		setFont(new Font("Times New Roman", Font.BOLD, 20));
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Client Login");
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setBorder(null);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel header = new JLabel("Please Log In or Create User");
		header.setBounds(0, 20, 311, 20);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setHorizontalTextPosition(SwingConstants.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 16));
		header.setBackground(Color.LIGHT_GRAY);
		panel.add(header);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setBounds(141, 70, 96, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordField.setBounds(141, 115, 96, 25);
		panel.add(passwordField);
		
		JLabel usernameClient = new JLabel("Username:");
		usernameClient.setHorizontalTextPosition(SwingConstants.CENTER);
		usernameClient.setHorizontalAlignment(SwingConstants.CENTER);
		usernameClient.setFont(new Font("Tahoma", Font.BOLD, 16));
		usernameClient.setBounds(35, 73, 96, 17);
		panel.add(usernameClient);
		
		JLabel passwordClient = new JLabel("Password:");
		passwordClient.setHorizontalTextPosition(SwingConstants.CENTER);
		passwordClient.setHorizontalAlignment(SwingConstants.CENTER);
		passwordClient.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordClient.setBounds(35, 118, 96, 17);
		panel.add(passwordClient);
		
		JButton createUserButton = new JButton("Create User");
		createUserButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		createUserButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		createUserButton.setBounds(10, 170, 130, 25);
		panel.add(createUserButton);
		createUserButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				clientCreateUser.clientCreateUser();
				dispose();
			}
		});
		
		JButton logInButton = new JButton("Log In");
		logInButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		logInButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		logInButton.setBounds(160, 170, 130, 25);
		panel.add(logInButton);
	}
	
	public static void clientLogin() {
		clientLogin cltLogin = new clientLogin();
		cltLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cltLogin.setLocationRelativeTo(null);
		cltLogin.setVisible(true);
	}
}
