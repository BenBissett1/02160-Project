package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.dataStructure;

public class companyChangePassword extends JFrame{
	private JTextField currentPasswordField;
	private JTextField repeatPasswordField;
	private JTextField newPasswordField;
	public companyChangePassword() {
		super("Company Password Change");
		setSize(new Dimension(313, 280));
		setLocationByPlatform(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setAlwaysOnTop(true);
		setFont(new Font("Times New Roman", Font.BOLD, 20));
		setResizable(false);
		setType(Type.POPUP);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setBorder(null);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel header = new JLabel("Please fill in the boxes below");
		header.setBounds(0, 25, 300, 20);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setHorizontalTextPosition(SwingConstants.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 16));
		header.setBackground(Color.LIGHT_GRAY);
		panel.add(header);
		
		JLabel currentPasswordLabel = new JLabel("Current Password:");
		currentPasswordLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		currentPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		currentPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		currentPasswordLabel.setBounds(20, 75, 150, 25);
		panel.add(currentPasswordLabel);
		
		JLabel confirmCurrentPasswordLabel = new JLabel("Repeat Password:");
		confirmCurrentPasswordLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		confirmCurrentPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		confirmCurrentPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		confirmCurrentPasswordLabel.setBounds(20, 110, 150, 25);
		panel.add(confirmCurrentPasswordLabel);
		
		JLabel newPasswordLabel = new JLabel("New Password:");
		newPasswordLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		newPasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		newPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		newPasswordLabel.setBounds(20, 145, 150, 25);
		panel.add(newPasswordLabel);
		
		repeatPasswordField = new JTextField();
		repeatPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		repeatPasswordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		repeatPasswordField.setEditable(true);
		repeatPasswordField.setColumns(10);
		repeatPasswordField.setBounds(180, 110, 96, 25);
		panel.add(repeatPasswordField);
		
		newPasswordField = new JTextField();
		newPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		newPasswordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		newPasswordField.setEditable(true);
		newPasswordField.setColumns(10);
		newPasswordField.setBounds(180, 145, 96, 25);
		panel.add(newPasswordField);
		
		currentPasswordField = new JTextField();
		currentPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		currentPasswordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		currentPasswordField.setColumns(10);
		currentPasswordField.setEditable(true);
		currentPasswordField.setBounds(180, 75, 96, 25);
		panel.add(currentPasswordField);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		backButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		backButton.setBounds(10, 210, 130, 25);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				dispose();				
			}
		});
		panel.add(backButton);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		confirmButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		confirmButton.setBounds(160, 210, 130, 25);
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputCurrentPassword = currentPasswordField.getText();
				String inputPasswordRepeat = repeatPasswordField.getText();
				String inputNewPassword = newPasswordField.getText();
				if (inputCurrentPassword.isEmpty() || inputPasswordRepeat.isEmpty() || inputNewPassword.isEmpty()) {
					JOptionPane.showMessageDialog(panel,
							"Please fill in all fields",
							"Empty field(s)",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if(dataStructure.companyPasswordMatch(inputCurrentPassword) && inputCurrentPassword.equals(inputPasswordRepeat)) {
						dataStructure.changeCompanyPassword(inputCurrentPassword, inputNewPassword);
						JOptionPane.showMessageDialog(panel,
								"Password Updated!",
								"Confirmation",
								JOptionPane.INFORMATION_MESSAGE);
						dataStructure.save();
						dataStructure.load();
						dispose();
					} else {
						JOptionPane.showMessageDialog(panel,
								"Invalid password",
								"Password error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		panel.add(confirmButton);
	}
	
	public static void companyChangePassword() {
		companyChangePassword cmpCngPas= new companyChangePassword();
		cmpCngPas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cmpCngPas.setLocationRelativeTo(null);
		cmpCngPas.setVisible(true);
	}
}
