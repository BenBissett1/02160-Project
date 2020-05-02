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
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

import main.dataStructure;

public class clientLogin extends JFrame{
	private JTextField textFieldUsername;
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
		header.setBounds(0, 20, 300, 20);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setHorizontalTextPosition(SwingConstants.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 16));
		header.setBackground(Color.LIGHT_GRAY);
		panel.add(header);
		
		JLabel usernameClient = new JLabel("ClientID:");
		usernameClient.setHorizontalTextPosition(SwingConstants.CENTER);
		usernameClient.setHorizontalAlignment(SwingConstants.CENTER);
		usernameClient.setFont(new Font("Tahoma", Font.BOLD, 16));
		usernameClient.setBounds(45, 70, 100, 25);
		panel.add(usernameClient);
		
		JLabel passwordClient = new JLabel("Password:");
		passwordClient.setHorizontalTextPosition(SwingConstants.CENTER);
		passwordClient.setHorizontalAlignment(SwingConstants.CENTER);
		passwordClient.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordClient.setBounds(45, 115, 100, 25);
		panel.add(passwordClient);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldUsername.setBounds(155, 70, 100, 25);
		panel.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordField.setBounds(155, 115, 100, 25);
		panel.add(passwordField);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		exitButton.setBounds(15, 170, 130, 25);
		exitButton.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
			    System.exit(0);
			  }
			});
		panel.add(exitButton);
		
		JButton logInButton = new JButton("Log In");
		logInButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		logInButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		logInButton.setBounds(160, 170, 130, 25);
		logInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int genUser = -1;
				String genPass = "";
				try {
					genUser = Integer.parseInt(textFieldUsername.getText());
					genPass = passwordField.getText();
				} catch (NumberFormatException | NullPointerException g) {}

				if( genUser == -1 || genPass == "" ) {
					JOptionPane.showMessageDialog(panel,
						    "Please fill in both fields",
						    "Empty field(s)",
						    JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						if (genPass.equals(dataStructure.clients.get(genUser).getPassword())) {
							dataStructure.save();
							clientInterface.clientInterface(genUser);
							dispose();
						} else {
							JOptionPane.showMessageDialog(panel,
									"Incorrect Information",
									"Wrong ClientID or Password",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (NumberFormatException | NullPointerException h) {
							JOptionPane.showMessageDialog(panel,
									"Incorrect Information",
									"Wrong ClientID or Password",
									JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		panel.add(logInButton);
	}
	
	public static void clientLogin() {
		clientLogin cltLogin = new clientLogin();
		cltLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cltLogin.setLocationRelativeTo(null);
		cltLogin.setVisible(true);
	}
}
