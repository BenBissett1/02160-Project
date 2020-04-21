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
import main.Container;
import main.dataStructure;

import javax.swing.border.BevelBorder;

public class companyUpdateJourney extends JFrame {
	private JTextField journeyIDField;
	private JTextField originField;
	private JTextField destinationField;
	private JTextField statusField;
	private JTextField contentsField;
	private JTextField clientIDField;
	public companyUpdateJourney() {
		super("Update a Journey");
		setSize(new Dimension(313, 350));
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
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel header = new JLabel("Please fill in the form below");
		header.setBounds(0, 10, 310, 20);
		header.setHorizontalTextPosition(SwingConstants.CENTER);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 16));
		header.setBackground(Color.LIGHT_GRAY);
		panel.add(header);
		
		JLabel companyUpdateJourneyID = new JLabel("JourneyID:");
		companyUpdateJourneyID.setHorizontalTextPosition(SwingConstants.CENTER);
		companyUpdateJourneyID.setHorizontalAlignment(SwingConstants.CENTER);
		companyUpdateJourneyID.setFont(new Font("Tahoma", Font.BOLD, 16));
		companyUpdateJourneyID.setBounds(55, 40, 95, 20);
		panel.add(companyUpdateJourneyID);
		
		journeyIDField = new JTextField();
		journeyIDField.setHorizontalAlignment(SwingConstants.CENTER);
		journeyIDField.setFont(new Font("Tahoma", Font.BOLD, 13));
		journeyIDField.setColumns(10);
		journeyIDField.setBounds(160, 40, 95, 25);
		panel.add(journeyIDField);
		
		JLabel companyUpdateOrigin = new JLabel("Origin:");
		companyUpdateOrigin.setHorizontalTextPosition(SwingConstants.CENTER);
		companyUpdateOrigin.setHorizontalAlignment(SwingConstants.CENTER);
		companyUpdateOrigin.setFont(new Font("Tahoma", Font.BOLD, 16));
		companyUpdateOrigin.setBounds(55, 80, 100, 20);
		panel.add(companyUpdateOrigin);
		
		originField = new JTextField();
		originField.setHorizontalAlignment(SwingConstants.CENTER);
		originField.setFont(new Font("Tahoma", Font.BOLD, 13));
		originField.setColumns(10);
		originField.setBounds(160, 80, 95, 25);
		panel.add(originField);
		
		JLabel companyUpdateDestination = new JLabel("Destination:");
		companyUpdateDestination.setHorizontalTextPosition(SwingConstants.CENTER);
		companyUpdateDestination.setHorizontalAlignment(SwingConstants.CENTER);
		companyUpdateDestination.setFont(new Font("Tahoma", Font.BOLD, 16));
		companyUpdateDestination.setBounds(55, 120, 100, 20);
		panel.add(companyUpdateDestination);
		
		destinationField = new JTextField();
		destinationField.setHorizontalAlignment(SwingConstants.CENTER);
		destinationField.setFont(new Font("Tahoma", Font.BOLD, 13));
		destinationField.setColumns(10);
		destinationField.setBounds(160, 120, 95, 25);
		panel.add(destinationField);
		
		JLabel companyUpdateStatus = new JLabel("Status:");
		companyUpdateStatus.setHorizontalTextPosition(SwingConstants.CENTER);
		companyUpdateStatus.setHorizontalAlignment(SwingConstants.CENTER);
		companyUpdateStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		companyUpdateStatus.setBounds(55, 160, 95, 20);
		panel.add(companyUpdateStatus);
		
		statusField = new JTextField();
		statusField.setHorizontalAlignment(SwingConstants.CENTER);
		statusField.setFont(new Font("Tahoma", Font.BOLD, 13));
		statusField.setColumns(10);
		statusField.setBounds(160, 160, 95, 25);
		panel.add(statusField);
		
		JLabel companyUpdateContents = new JLabel("Contents:");
		companyUpdateContents.setHorizontalTextPosition(SwingConstants.CENTER);
		companyUpdateContents.setHorizontalAlignment(SwingConstants.CENTER);
		companyUpdateContents.setFont(new Font("Tahoma", Font.BOLD, 16));
		companyUpdateContents.setBounds(55, 200, 100, 20);
		panel.add(companyUpdateContents);
		
		contentsField = new JTextField();
		contentsField.setHorizontalAlignment(SwingConstants.CENTER);
		contentsField.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentsField.setColumns(10);
		contentsField.setBounds(160, 200, 95, 25);
		panel.add(contentsField);
		
		JLabel companyUpdateClientID = new JLabel("ClientID:");
		companyUpdateClientID.setHorizontalTextPosition(SwingConstants.CENTER);
		companyUpdateClientID.setHorizontalAlignment(SwingConstants.CENTER);
		companyUpdateClientID.setFont(new Font("Tahoma", Font.BOLD, 16));
		companyUpdateClientID.setBounds(55, 240, 95, 20);
		panel.add(companyUpdateClientID);
		
		clientIDField = new JTextField();
		clientIDField.setHorizontalAlignment(SwingConstants.CENTER);
		clientIDField.setFont(new Font("Tahoma", Font.BOLD, 13));
		clientIDField.setColumns(10);
		clientIDField.setBounds(160, 240, 95, 25);
		panel.add(clientIDField);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		backButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		backButton.setBounds(10, 287, 130, 25);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.saveC();
				dataStructure.saveJ();
				dispose();				
			}
		});
		panel.add(backButton);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		confirmButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		confirmButton.setBounds(160, 287, 130, 25);
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputJourneyID = journeyIDField.getText();
				String inputOrigin = originField.getText();
				String inputDestination = destinationField.getText();
				String inputStatus = statusField.getText();
				String inputContents = contentsField.getText();
				String inputClientID = clientIDField.getText();
				if (inputJourneyID.isEmpty() || inputOrigin.isEmpty() || inputDestination.isEmpty() || inputStatus.isEmpty() || inputContents.isEmpty() || inputClientID.isEmpty()) {
					JOptionPane.showMessageDialog(panel,
							"All fields must be completed",
							"Empty Field(s)",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int inputJourneyIDAsInt = 0;
					int inputClientIDAsInt = 0;
					try {
						inputJourneyIDAsInt = Integer.parseInt(inputJourneyID);
						inputClientIDAsInt = Integer.parseInt(inputClientID);
					} catch (NumberFormatException E) {
						JOptionPane.showMessageDialog(panel,
								"Please enter JourneyID and ClientID as a number",
								"Number Error",
						    	JOptionPane.ERROR_MESSAGE);
					}
					if(dataStructure.clientExists(inputClientIDAsInt) && dataStructure.journeyExists(inputJourneyIDAsInt)) {
						dataStructure.updateJourney(inputJourneyIDAsInt, inputOrigin, inputDestination, inputStatus, inputContents, inputClientID);
						JOptionPane.showMessageDialog(panel,
								"Journey Updated!",
								"Confirmation",
								JOptionPane.INFORMATION_MESSAGE);
						dataStructure.saveC();
						dataStructure.saveJ();
						dispose();
					} else {
						JOptionPane.showMessageDialog(panel,
								"Invalid ClientID or JourneyID!",
								"Error",
								JOptionPane.ERROR_MESSAGE);
						dataStructure.saveC();
						dataStructure.saveJ();
						dispose();
					}
				}
			}
		});
		panel.add(confirmButton);
	}
	public static void companyUpdateJourney() {
		companyUpdateJourney cmpUdtJrn = new companyUpdateJourney();
		cmpUdtJrn.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cmpUdtJrn.setLocationRelativeTo(null);
		cmpUdtJrn.setVisible(true);
	}
}
