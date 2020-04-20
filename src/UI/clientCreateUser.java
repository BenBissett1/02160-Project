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
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

import main.Database;

public class clientCreateUser extends JFrame{
	private JTextField textFieldAddress;
	private JTextField textFieldEmail;
	private JTextField textFieldTelephone;
	private JTextField textFieldName;
	private JTextField textFieldPassword;
	public clientCreateUser() {
		super("Create Client User");
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
		
		JLabel header = new JLabel("Please fill in the form below");
		header.setBounds(0, 10, 310, 20);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setHorizontalTextPosition(SwingConstants.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 16));
		header.setBackground(Color.LIGHT_GRAY);
		panel.add(header);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldAddress.setBounds(141, 70, 96, 25);
		panel.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		JLabel createClientAddress = new JLabel("Address:");
		createClientAddress.setHorizontalTextPosition(SwingConstants.CENTER);
		createClientAddress.setHorizontalAlignment(SwingConstants.CENTER);
		createClientAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		createClientAddress.setBounds(35, 73, 96, 17);
		panel.add(createClientAddress);
		
		JButton clientCreateBack = new JButton("Back");
		clientCreateBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientCreateBack.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		clientCreateBack.setBounds(10, 205, 130, 25);
		panel.add(clientCreateBack);
		clientCreateBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Database.saveC();
				Database.saveJ();
				clientLogin.clientLogin();
				dispose();				
			}
		});
		
		JButton clientCreateSave = new JButton("Create User");
		clientCreateSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientCreateSave.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		clientCreateSave.setBounds(160, 205, 130, 25);
		panel.add(clientCreateSave);
		clientCreateSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputName = textFieldName.getText();
				String inputAddress = textFieldAddress.getText();
				String inputEmail = textFieldEmail.getText();
				String inputTelephone = textFieldTelephone.getText();
				String inputPassword = textFieldPassword.getText();
				if (inputName.isEmpty() || inputAddress.isEmpty() || inputEmail.isEmpty() || inputTelephone.isEmpty() || inputPassword.isEmpty() ) {
					JOptionPane.showMessageDialog(panel,
							"All fields must be completed",
							"Empty Field(s)",
							JOptionPane.ERROR_MESSAGE);
				}
				else {
					int inputTelephoneAsInt = 0;
					try {
						inputTelephoneAsInt = Integer.parseInt(inputTelephone);
					} catch (NumberFormatException E) {
						JOptionPane.showMessageDialog(panel,
								"Please enter a telephone NUMBER",
								"Number Error",
						    	JOptionPane.ERROR_MESSAGE);
					}
					int cID = Database.regNewClient(inputName, inputPassword, inputAddress, inputEmail, inputTelephone, 0);
					Database.saveC();
					Database.saveJ();
					clientUserGen.clientUserGen(cID,inputPassword);
					dispose();
				}
			}
		});
		
		JLabel createClientEmail = new JLabel("Email:");
		createClientEmail.setHorizontalTextPosition(SwingConstants.CENTER);
		createClientEmail.setHorizontalAlignment(SwingConstants.CENTER);
		createClientEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		createClientEmail.setBounds(35, 103, 96, 17);
		panel.add(createClientEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(141, 100, 96, 25);
		panel.add(textFieldEmail);
		
		JLabel createClientTelephone = new JLabel("Telephone:");
		createClientTelephone.setHorizontalTextPosition(SwingConstants.CENTER);
		createClientTelephone.setHorizontalAlignment(SwingConstants.CENTER);
		createClientTelephone.setFont(new Font("Tahoma", Font.BOLD, 16));
		createClientTelephone.setBounds(35, 133, 96, 17);
		panel.add(createClientTelephone);
		
		textFieldTelephone = new JTextField();
		textFieldTelephone.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTelephone.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldTelephone.setColumns(10);
		textFieldTelephone.setBounds(141, 130, 96, 25);
		panel.add(textFieldTelephone);
		
		JLabel createClientName = new JLabel("Name:");
		createClientName.setHorizontalTextPosition(SwingConstants.CENTER);
		createClientName.setHorizontalAlignment(SwingConstants.CENTER);
		createClientName.setFont(new Font("Tahoma", Font.BOLD, 16));
		createClientName.setBounds(35, 43, 96, 17);
		panel.add(createClientName);
		
		textFieldName = new JTextField();
		textFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldName.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldName.setColumns(10);
		textFieldName.setBounds(141, 40, 96, 25);
		panel.add(textFieldName);
		
		JLabel createClientPassword = new JLabel("Password:");
		createClientPassword.setHorizontalTextPosition(SwingConstants.CENTER);
		createClientPassword.setHorizontalAlignment(SwingConstants.CENTER);
		createClientPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		createClientPassword.setBounds(35, 163, 96, 17);
		panel.add(createClientPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(141, 160, 96, 25);
		panel.add(textFieldPassword);
	}
	
	public static void clientCreateUser() {
		clientCreateUser cltCrtUsr= new clientCreateUser();
		cltCrtUsr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cltCrtUsr.setLocationRelativeTo(null);
		cltCrtUsr.setVisible(true);
	}
}