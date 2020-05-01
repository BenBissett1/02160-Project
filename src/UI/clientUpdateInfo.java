package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

import main.Client;
import main.dataStructure;

import javax.swing.border.BevelBorder;

public class clientUpdateInfo extends JFrame {
	private JTextField updateNameField;
	private JTextField updateAddressField;
	private JTextField updateEmailField;
	private JTextField updateTelephoneField;
	private JTextField updatePasswordField;
	public clientUpdateInfo(int genUser) {
		super("Client Information Update");
		setSize(new Dimension(313, 280));
		setLocationByPlatform(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setAlwaysOnTop(true);
		setFont(new Font("Times New Roman", Font.BOLD, 20));
		setResizable(false);
		setType(Type.POPUP);
		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.BLACK);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel clientUpdateInfoLabel = new JLabel("Please complete at least one:");
		clientUpdateInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clientUpdateInfoLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientUpdateInfoLabel.setBounds(5, 10, 300, 25);
		panel.add(clientUpdateInfoLabel);
		
		JLabel updateClientName = new JLabel("Name:");
		updateClientName.setHorizontalTextPosition(SwingConstants.CENTER);
		updateClientName.setHorizontalAlignment(SwingConstants.CENTER);
		updateClientName.setFont(new Font("Tahoma", Font.BOLD, 16));
		updateClientName.setBounds(45, 48, 96, 17);
		panel.add(updateClientName);
		
		JLabel updateClientPassword = new JLabel("Password:");
		updateClientPassword.setHorizontalTextPosition(SwingConstants.CENTER);
		updateClientPassword.setHorizontalAlignment(SwingConstants.CENTER);
		updateClientPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		updateClientPassword.setBounds(45, 168, 96, 17);
		panel.add(updateClientPassword);
		
		JLabel updateClientTelephone = new JLabel("Telephone:");
		updateClientTelephone.setHorizontalTextPosition(SwingConstants.CENTER);
		updateClientTelephone.setHorizontalAlignment(SwingConstants.CENTER);
		updateClientTelephone.setFont(new Font("Tahoma", Font.BOLD, 16));
		updateClientTelephone.setBounds(45, 138, 96, 17);
		panel.add(updateClientTelephone);
		
		JLabel updateClientEmail = new JLabel("Email:");
		updateClientEmail.setHorizontalTextPosition(SwingConstants.CENTER);
		updateClientEmail.setHorizontalAlignment(SwingConstants.CENTER);
		updateClientEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		updateClientEmail.setBounds(45, 108, 96, 17);
		panel.add(updateClientEmail);
		
		JLabel updateClientAddress = new JLabel("Address:");
		updateClientAddress.setHorizontalTextPosition(SwingConstants.CENTER);
		updateClientAddress.setHorizontalAlignment(SwingConstants.CENTER);
		updateClientAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		updateClientAddress.setBounds(45, 78, 96, 17);
		panel.add(updateClientAddress);
		
		updateNameField = new JTextField();
		updateNameField.setHorizontalAlignment(SwingConstants.CENTER);
		updateNameField.setFont(new Font("Tahoma", Font.BOLD, 13));
		updateNameField.setColumns(10);
		updateNameField.setBounds(151, 45, 96, 25);
		panel.add(updateNameField);
		
		updateAddressField = new JTextField();
		updateAddressField.setHorizontalAlignment(SwingConstants.CENTER);
		updateAddressField.setFont(new Font("Tahoma", Font.BOLD, 13));
		updateAddressField.setColumns(10);
		updateAddressField.setBounds(151, 75, 96, 25);
		panel.add(updateAddressField);
		
		updateEmailField = new JTextField();
		updateEmailField.setHorizontalAlignment(SwingConstants.CENTER);
		updateEmailField.setFont(new Font("Tahoma", Font.BOLD, 13));
		updateEmailField.setColumns(10);
		updateEmailField.setBounds(151, 105, 96, 25);
		panel.add(updateEmailField);
		
		updateTelephoneField = new JTextField();
		updateTelephoneField.setHorizontalAlignment(SwingConstants.CENTER);
		updateTelephoneField.setFont(new Font("Tahoma", Font.BOLD, 13));
		updateTelephoneField.setColumns(10);
		updateTelephoneField.setBounds(151, 135, 96, 25);
		panel.add(updateTelephoneField);
		
		updatePasswordField = new JTextField();
		updatePasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		updatePasswordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		updatePasswordField.setColumns(10);
		updatePasswordField.setBounds(151, 165, 96, 25);
		panel.add(updatePasswordField);
		
		JButton clientCreateBack = new JButton("Back");
		clientCreateBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientCreateBack.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		clientCreateBack.setBounds(10, 205, 130, 25);
		clientCreateBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				dispose();				
			}
		});
		panel.add(clientCreateBack);
		
		Client C = dataStructure.clients.get(genUser);
		
		JButton clientUpdateInfoButton = new JButton("Confirm");
		clientUpdateInfoButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientUpdateInfoButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		clientUpdateInfoButton.setBounds(160, 205, 130, 25);
		clientUpdateInfoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputName = updateNameField.getText();
				String inputAddress = updateAddressField.getText();
				String inputEmail = updateEmailField.getText();
				String inputTelephone = updateTelephoneField.getText();
				String inputPassword = updatePasswordField.getText();
				if (inputName.isEmpty() && inputAddress.isEmpty() && inputEmail.isEmpty() && inputTelephone.isEmpty() && inputPassword.isEmpty() ) {
					JOptionPane.showMessageDialog(panel,
							"At least one field must be completed",
							"Empty Field",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (inputName.isEmpty()) {
						inputName = C.getName();
					} if (inputAddress.isEmpty()) {
						inputAddress = C.getAddress();
					} if (inputEmail.isEmpty()) {
						inputEmail = C.getEmail();
					} if (inputTelephone.isEmpty()) {
						inputTelephone = C.getPhone();
					} if (inputPassword.isEmpty()) {
						inputPassword = C.getPassword();
					}
					int inputTelephoneAsInt = 0;
					try {
						inputTelephoneAsInt = Integer.parseInt(inputTelephone);
						dataStructure.updateClient(genUser,inputName, inputPassword, inputAddress, inputEmail, inputTelephone);
						JOptionPane.showMessageDialog(panel,
								"Information Updated!",
								"Confirmation",
								JOptionPane.INFORMATION_MESSAGE);
						dataStructure.save();
						dispose();
					} catch (NumberFormatException E) {
						JOptionPane.showMessageDialog(panel,
								"Please enter a telephone NUMBER",
								"Number Error",
						    	JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		panel.add(clientUpdateInfoButton);
	}
	
	public static void clientUpdateInfo(int genUser) {
		clientUpdateInfo cltUptInf= new clientUpdateInfo(genUser);
		cltUptInf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cltUptInf.setLocationRelativeTo(null);
		cltUptInf.setVisible(true);
	}
}
