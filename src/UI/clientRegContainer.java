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
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

import main.dataStructure;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class clientRegContainer extends JFrame {
	private JTextField regContainerContentsField;
	public clientRegContainer(int genUser) {
		super("Client Container Registry");
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
		panel.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel clientRegContainerLabel = new JLabel("Fill in the below fields:");
		clientRegContainerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clientRegContainerLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientRegContainerLabel.setBounds(5, 10, 300, 25);
		panel.add(clientRegContainerLabel);
		
		String[] mapLocations = { "Copenhagen", "New York", "Toronto", "Edinburgh", "Busan", "Shenzhen", "Shanghai", "Tanjung", "Dubai", "Los Angeles", "Valencia",
                "Santos", "Tanger Med", "Salalah", "Cape Town", "Colombo", "Comodoro", "Christchurch", "Perth", "Mogadishu"};

		JComboBox regContainerOriginComboBox = new JComboBox(mapLocations);
		regContainerOriginComboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		regContainerOriginComboBox.setBounds(160, 65, 95, 25);
		panel.add(regContainerOriginComboBox);

		JComboBox regContainerDestinationComboBox = new JComboBox(mapLocations);
		regContainerDestinationComboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		regContainerDestinationComboBox.setBounds(160, 105, 95, 25);
		panel.add(regContainerDestinationComboBox);
		
		JButton clientCreateBack = new JButton("Back");
		clientCreateBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientCreateBack.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		clientCreateBack.setBounds(13, 205, 130, 25);
		clientCreateBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				dispose();				
			}
		});
		panel.add(clientCreateBack);
		
		JButton clientRegContainerButton = new JButton("Confirm");
		clientRegContainerButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientRegContainerButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		clientRegContainerButton.setBounds(163, 205, 130, 25);
		clientRegContainerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputOrigin = (String) regContainerOriginComboBox.getSelectedItem();
				String inputDestination = (String) regContainerDestinationComboBox.getSelectedItem();
				String inputContents = regContainerContentsField.getText();
				if (inputOrigin.isEmpty() || inputDestination.isEmpty() || inputContents.isEmpty()) {
					JOptionPane.showMessageDialog(panel,
							"All fields must be completed",
							"Empty Field(s)",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int jID = dataStructure.regNewJourney(inputOrigin,inputDestination,inputContents,genUser);
					JOptionPane.showMessageDialog(panel,
							"Your Journey ID is: " + Integer.toString(jID),
							"Confirmation",
							JOptionPane.INFORMATION_MESSAGE);
					dataStructure.save();
					dispose();
				}
			}
		});
		panel.add(clientRegContainerButton);
		
		JLabel regContainerOrigin = new JLabel("Origin:");
		regContainerOrigin.setHorizontalTextPosition(SwingConstants.CENTER);
		regContainerOrigin.setHorizontalAlignment(SwingConstants.CENTER);
		regContainerOrigin.setFont(new Font("Tahoma", Font.BOLD, 16));
		regContainerOrigin.setBounds(55, 65, 95, 20);
		panel.add(regContainerOrigin);
		
		JLabel regContainerDestination = new JLabel("Destination:");
		regContainerDestination.setHorizontalTextPosition(SwingConstants.CENTER);
		regContainerDestination.setHorizontalAlignment(SwingConstants.CENTER);
		regContainerDestination.setFont(new Font("Tahoma", Font.BOLD, 16));
		regContainerDestination.setBounds(55, 105, 100, 20);
		panel.add(regContainerDestination);
		
		JLabel regContainerContents = new JLabel("Contents:");
		regContainerContents.setHorizontalTextPosition(SwingConstants.CENTER);
		regContainerContents.setHorizontalAlignment(SwingConstants.CENTER);
		regContainerContents.setFont(new Font("Tahoma", Font.BOLD, 16));
		regContainerContents.setBounds(55, 145, 95, 20);
		panel.add(regContainerContents);
		
		regContainerContentsField = new JTextField();
		regContainerContentsField.setHorizontalAlignment(SwingConstants.CENTER);
		regContainerContentsField.setFont(new Font("Tahoma", Font.BOLD, 13));
		regContainerContentsField.setColumns(10);
		regContainerContentsField.setBounds(160, 145, 95, 25);
		panel.add(regContainerContentsField);	
		
	}

	public static void clientRegContainer(int genUser) {
		clientRegContainer cltRegCnt= new clientRegContainer(genUser);
		cltRegCnt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cltRegCnt.setLocationRelativeTo(null);
		cltRegCnt.setVisible(true);
	}
}
