package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
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
		
		JLabel header = new JLabel("Please Log In");
		header.setBounds(0, 20, 311, 20);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setHorizontalTextPosition(SwingConstants.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 16));
		header.setBackground(Color.LIGHT_GRAY);
		panel.add(header);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setBounds(155, 70, 96, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordField.setBounds(155, 115, 96, 25);
		panel.add(passwordField);
		
		JLabel usernameClient = new JLabel("Username:");
		usernameClient.setHorizontalTextPosition(SwingConstants.CENTER);
		usernameClient.setHorizontalAlignment(SwingConstants.CENTER);
		usernameClient.setFont(new Font("Tahoma", Font.BOLD, 16));
		usernameClient.setBounds(45, 73, 96, 17);
		panel.add(usernameClient);
		
		JLabel passwordClient = new JLabel("Password:");
		passwordClient.setHorizontalTextPosition(SwingConstants.CENTER);
		passwordClient.setHorizontalAlignment(SwingConstants.CENTER);
		passwordClient.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordClient.setBounds(45, 118, 96, 17);
		panel.add(passwordClient);
		
// Obsolete
//		JButton createUserButton = new JButton("Create User");
//		createUserButton.setFont(new Font("Tahoma", Font.BOLD, 16));
//		createUserButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
//		createUserButton.setBounds(10, 170, 130, 25);
//		panel.add(createUserButton);
//		createUserButton.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				clientCreateUser.clientCreateUser();
//				dispose();
//			}
//		});
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		exitButton.setBounds(15, 170, 130, 25);
		exitButton.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
			    System.exit(0);
			  }
			});
		panel.add(exitButton);
		
		JButton logInButton = new JButton("Log In");
		logInButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		logInButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		logInButton.setBounds(160, 170, 130, 25);
		panel.add(logInButton);
	}
	
	public static void clientLogin() {
		clientLogin cltLogin = new clientLogin();
		cltLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cltLogin.setLocationRelativeTo(null);
		cltLogin.setVisible(true);
	}
}
