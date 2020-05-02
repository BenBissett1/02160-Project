package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.SoftBevelBorder;

import main.Client;
import main.Journey;
import main.dataStructure;

import javax.swing.border.BevelBorder;

public class companyUpdateJourney extends JFrame {
	private JTextField journeyIDField;
	private JTextField destinationField;
	private JTextField statusField;
	public companyUpdateJourney() {
		super("Update a Journey");
		setSize(new Dimension(313, 300));
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
		header.setBounds(0, 15, 310, 20);
		header.setHorizontalTextPosition(SwingConstants.CENTER);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 16));
		header.setBackground(Color.LIGHT_GRAY);
		panel.add(header);
		
		JLabel companyUpdateJourneyID = new JLabel("JourneyID:");
		companyUpdateJourneyID.setHorizontalTextPosition(SwingConstants.CENTER);
		companyUpdateJourneyID.setHorizontalAlignment(SwingConstants.CENTER);
		companyUpdateJourneyID.setFont(new Font("Tahoma", Font.BOLD, 16));
		companyUpdateJourneyID.setBounds(55, 75, 95, 20);
		panel.add(companyUpdateJourneyID);
		
		List<Integer> journeyID = dataStructure.allJourneys();
		String[] jIDs = new String[journeyID.size()];
		if(journeyID.size() == 0) {
			JOptionPane.showMessageDialog(panel,
					"There are no JourneyIDs",
					"Journey Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			for(int i = 0; i<journeyID.size(); i++) {
				jIDs[i] =  Integer.toString(journeyID.get(i));
			}
		}
		
		JComboBox journeysComboBox = new JComboBox(jIDs);
		journeysComboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		journeysComboBox.setBounds(160, 75, 95, 25);
		panel.add(journeysComboBox);
		
		String[] mapLocations = { "Copenhagen", "New York", "Toronto", "Edinburgh", "Busan", "Shenzhen", "Shanghai", "Tanjung", "Dubai", "Los Angeles", "Valencia",
                "Santos", "Tanger Med", "Salalah", "Cape Town", "Colombo", "Comodoro", "Christchurch", "Perth", "Mogadishu"};
		
		JLabel companyUpdateDestination = new JLabel("Destination:");
		companyUpdateDestination.setHorizontalTextPosition(SwingConstants.CENTER);
		companyUpdateDestination.setHorizontalAlignment(SwingConstants.CENTER);
		companyUpdateDestination.setFont(new Font("Tahoma", Font.BOLD, 16));
		companyUpdateDestination.setBounds(55, 115, 100, 20);
		panel.add(companyUpdateDestination);
		
		JComboBox regContainerDestinationComboBox = new JComboBox(mapLocations);
		regContainerDestinationComboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		regContainerDestinationComboBox.setBounds(160, 115, 95, 25);
		panel.add(regContainerDestinationComboBox);
		
		String[] statuses = { "Origin", "Embarked", "Destination"};
		
		JLabel companyUpdateStatus = new JLabel("Status:");
		companyUpdateStatus.setHorizontalTextPosition(SwingConstants.CENTER);
		companyUpdateStatus.setHorizontalAlignment(SwingConstants.CENTER);
		companyUpdateStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		companyUpdateStatus.setBounds(55, 155, 95, 20);
		panel.add(companyUpdateStatus);
		
		JComboBox statusComboBox = new JComboBox(statuses);
		statusComboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		statusComboBox.setBounds(160,155,95,25);;
		panel.add(statusComboBox);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		backButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		backButton.setBounds(10, 220, 130, 25);
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
		confirmButton.setBounds(160, 220, 130, 25);
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputJourneyID = (String) journeysComboBox.getSelectedItem();
				Journey J = dataStructure.journeys.get(Integer.parseInt(inputJourneyID));
				String inputDestination = (String) regContainerDestinationComboBox.getSelectedItem();
				String inputStatus = (String) statusComboBox.getSelectedItem();
				if (inputJourneyID.isEmpty() || inputDestination.isEmpty() || inputStatus.isEmpty() || inputDestination.equals(J.getOrigin())) {
					JOptionPane.showMessageDialog(panel,
							"Destination cannot be the same as the origin",
							"Destination Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int inputJourneyIDAsInt = 0;
					try {
						inputJourneyIDAsInt = Integer.parseInt(inputJourneyID);
					} catch (NumberFormatException E) {
						JOptionPane.showMessageDialog(panel,
								"Please enter JourneyID as a number",
								"Number Error",
						    	JOptionPane.ERROR_MESSAGE);
					}
					if(Journey.journeyExists(inputJourneyIDAsInt)) {
						Journey.updateJourney(inputJourneyIDAsInt, inputDestination, inputStatus);
						JOptionPane.showMessageDialog(panel,
								"Journey Updated!",
								"Confirmation",
								JOptionPane.INFORMATION_MESSAGE);
						dataStructure.save();
						dispose();
					} else if (Journey.journeyExists(inputJourneyIDAsInt) == false) {
						JOptionPane.showMessageDialog(panel,
								"Invalid JourneyID!",
								"Error",
								JOptionPane.ERROR_MESSAGE);
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