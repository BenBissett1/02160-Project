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

public class clientRegContainer extends JFrame {
	private JTextField regContainerOriginField;
	private JTextField regContainerDestinationField;
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
		
		JButton clientCreateBack = new JButton("Back");
		clientCreateBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientCreateBack.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		clientCreateBack.setBounds(10, 205, 130, 25);
		clientCreateBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.saveC();
				dataStructure.saveJ();
				dispose();				
			}
		});
		panel.add(clientCreateBack);
		
		JButton clientRegContainerButton = new JButton("Confirm");
		clientRegContainerButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientRegContainerButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		clientRegContainerButton.setBounds(160, 205, 130, 25);
		clientRegContainerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputOrigin = regContainerOriginField.getText();
				String inputDestination = regContainerDestinationField.getText();
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
					dataStructure.saveC();
					dataStructure.saveJ();
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
		
		regContainerOriginField = new JTextField();
		regContainerOriginField.setHorizontalAlignment(SwingConstants.CENTER);
		regContainerOriginField.setFont(new Font("Tahoma", Font.BOLD, 13));
		regContainerOriginField.setColumns(10);
		regContainerOriginField.setBounds(160, 65, 95, 25);
		panel.add(regContainerOriginField);
		
		JLabel regContainerDestination = new JLabel("Destination:");
		regContainerDestination.setHorizontalTextPosition(SwingConstants.CENTER);
		regContainerDestination.setHorizontalAlignment(SwingConstants.CENTER);
		regContainerDestination.setFont(new Font("Tahoma", Font.BOLD, 16));
		regContainerDestination.setBounds(55, 105, 100, 20);
		panel.add(regContainerDestination);
		
		regContainerDestinationField = new JTextField();
		regContainerDestinationField.setHorizontalAlignment(SwingConstants.CENTER);
		regContainerDestinationField.setFont(new Font("Tahoma", Font.BOLD, 13));
		regContainerDestinationField.setColumns(10);
		regContainerDestinationField.setBounds(160, 105, 95, 25);
		panel.add(regContainerDestinationField);
		
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