//package UI;
//
//import java.awt.Color;
//import java.awt.Cursor;
//import java.awt.Dimension;
//import java.awt.Font;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.SwingConstants;
//import javax.swing.WindowConstants;
//import javax.swing.JTextField;
//import javax.swing.JPasswordField;
//import javax.swing.JButton;
//import javax.swing.border.SoftBevelBorder;
//import javax.swing.border.BevelBorder;
//
//public class companyLogin extends JFrame{
//	private JTextField textField;
//	private JPasswordField passwordField;
//	public companyLogin() {
//		super("Company Login");
//		getContentPane().setBackground(Color.LIGHT_GRAY);
//		setSize(new Dimension(315, 250));
//		setLocationByPlatform(true);
//		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
//		setAlwaysOnTop(true);
//		setFont(new Font("Times New Roman", Font.BOLD, 20));
//		setResizable(false);
//		setType(Type.POPUP);
//		setTitle("Company Login");
//		getContentPane().setForeground(Color.BLACK);
//		getContentPane().setLayout(null);
//		
//		JLabel header = new JLabel("Please Log In or Create User");
//		header.setHorizontalTextPosition(SwingConstants.CENTER);
//		header.setHorizontalAlignment(SwingConstants.CENTER);
//		header.setFont(new Font("Tahoma", Font.BOLD, 16));
//		header.setBackground(Color.LIGHT_GRAY);
//		header.setBounds(0, 20, 311, 20);
//		getContentPane().add(header);
//		
//		textField = new JTextField();
//		textField.setHorizontalAlignment(SwingConstants.CENTER);
//		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
//		textField.setColumns(10);
//		textField.setBounds(141, 70, 96, 25);
//		getContentPane().add(textField);
//		
//		passwordField = new JPasswordField();
//		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
//		passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
//		passwordField.setBounds(141, 115, 96, 25);
//		getContentPane().add(passwordField);
//		
//		JLabel usernameClient = new JLabel("Username:");
//		usernameClient.setHorizontalTextPosition(SwingConstants.CENTER);
//		usernameClient.setHorizontalAlignment(SwingConstants.CENTER);
//		usernameClient.setFont(new Font("Tahoma", Font.BOLD, 16));
//		usernameClient.setBounds(35, 73, 96, 17);
//		getContentPane().add(usernameClient);
//		
//		JLabel passwordClient = new JLabel("Password:");
//		passwordClient.setHorizontalTextPosition(SwingConstants.CENTER);
//		passwordClient.setHorizontalAlignment(SwingConstants.CENTER);
//		passwordClient.setFont(new Font("Tahoma", Font.BOLD, 16));
//		passwordClient.setBounds(35, 118, 96, 17);
//		getContentPane().add(passwordClient);
//		
//		JButton createUserButton = new JButton("Create User");
//		createUserButton.setFont(new Font("Tahoma", Font.BOLD, 16));
//		createUserButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
//		createUserButton.setBounds(10, 170, 130, 25);
//		getContentPane().add(createUserButton);
//		
//		JButton logInButton = new JButton("Log In");
//		logInButton.setFont(new Font("Tahoma", Font.BOLD, 16));
//		logInButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
//		logInButton.setBounds(160, 170, 130, 25);
//		getContentPane().add(logInButton);
//	}
//	
//	public static void companyLogin() {
//		companyLogin cmpLogin = new companyLogin();
//		cmpLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		cmpLogin.setLocationRelativeTo(null);
//		cmpLogin.setVisible(true);
//	}
//}
