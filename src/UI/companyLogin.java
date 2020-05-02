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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

import main.dataStructure;

import javax.swing.border.BevelBorder;
import javax.swing.JPanel;

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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 313, 250);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel header = new JLabel("Please enter the company password");
		header.setBounds(0, 25, 300, 25);
		header.setHorizontalTextPosition(SwingConstants.CENTER);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 16));
		header.setBackground(Color.LIGHT_GRAY);
		panel.add(header);
				
		JLabel passwordClient = new JLabel("Password:");
		passwordClient.setBounds(50, 95, 100, 25);
		passwordClient.setHorizontalTextPosition(SwingConstants.CENTER);
		passwordClient.setHorizontalAlignment(SwingConstants.CENTER);
		passwordClient.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(passwordClient);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 95, 100, 25);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(passwordField);

		JButton logInButton = new JButton("Log In");
		logInButton.setBounds(160, 175, 130, 25);
		logInButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		logInButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		logInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String genPass = "";
				try {
					genPass = passwordField.getText();
				} catch (NumberFormatException | NullPointerException g) {}

				if (genPass == "" ) {
					JOptionPane.showMessageDialog(panel,
						    "Please enter a password",
						    "Empty password field",
						    JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						if (dataStructure.companyPasswordMatch(genPass)) {
							dataStructure.save();
							companyInterface.companyInterface();
							dispose();
						} else {
							JOptionPane.showMessageDialog(panel,
									"Incorrect password",
									"Wrong Password",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (NumberFormatException | NullPointerException h) {
							JOptionPane.showMessageDialog(panel,
									"Incorrect Information",
									"Wrong Password",
									JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		panel.add(logInButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(15, 175, 130, 25);
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		exitButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		exitButton.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
			    System.exit(0);
			  }
			});
		panel.add(exitButton);
	}
	
	public static void companyLogin() {
		companyLogin cmpLogin = new companyLogin();
		cmpLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cmpLogin.setLocationRelativeTo(null);
		cmpLogin.setVisible(true);
	}
}
