package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

import main.dataStructure;

import javax.swing.border.BevelBorder;

public class companyLogin extends JFrame{
	private JPasswordField passwordField;
	public companyLogin() {
		super("Company Login");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setSize(new Dimension(315, 250));
		setLocationByPlatform(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setAlwaysOnTop(true);
		setFont(new Font("Times New Roman", Font.BOLD, 20));
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Company Login");
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JLabel header = new JLabel("Please enter the company password");
		header.setHorizontalTextPosition(SwingConstants.CENTER);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 16));
		header.setBackground(Color.LIGHT_GRAY);
		header.setBounds(0, 20, 311, 20);
		getContentPane().add(header);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordField.setBounds(145, 90, 100, 25);
		getContentPane().add(passwordField);
		
		JLabel passwordClient = new JLabel("Password:");
		passwordClient.setHorizontalTextPosition(SwingConstants.CENTER);
		passwordClient.setHorizontalAlignment(SwingConstants.CENTER);
		passwordClient.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordClient.setBounds(40, 90, 100, 25);
		getContentPane().add(passwordClient);
		
		JButton logInButton = new JButton("Log In");
		logInButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		logInButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		logInButton.setBounds(160, 175, 130, 25);
		logInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String genPass = "";
				try {
					genPass = passwordField.getText();
				} catch (NumberFormatException | NullPointerException g) {}

				if(genPass == "" ) {
					JOptionPane.showMessageDialog(panel,
						    "Please fill in both fields",
						    "Empty field(s)",
						    JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						if (genPass.equals(0)) {
							dataStructure.saveC();
							dataStructure.saveJ();
							companyInterface.companyInterface();
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
		getContentPane().add(logInButton);
		
		JButton backButton = new JButton("Exit");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		backButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		backButton.setBounds(20, 175, 130, 25);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.saveC();
				dataStructure.saveJ();
				System.exit(0);				
			}
		});
		getContentPane().add(backButton);
	}
	
	public static void companyLogin() {
		companyLogin cmpLogin = new companyLogin();
		cmpLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cmpLogin.setLocationRelativeTo(null);
		cmpLogin.setVisible(true);
	}
}
