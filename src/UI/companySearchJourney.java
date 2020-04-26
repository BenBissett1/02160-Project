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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.dataStructure;

public class companySearchJourney extends JFrame{
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField keywordField;
	private JTextField clientIDField;
	public companySearchJourney() {
		super("Search For A Journey");
		setTitle("Search for a Journey");
		setSize(new Dimension(300, 280));
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
		header.setBounds(0, 5, 300, 20);
		header.setHorizontalTextPosition(SwingConstants.CENTER);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 16));
		header.setBackground(Color.LIGHT_GRAY);
		panel.add(header);
		
		JRadioButton originRadioButton = new JRadioButton("Origin");
		originRadioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		originRadioButton.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(originRadioButton);
		originRadioButton.setBounds(100, 30, 100, 25);
		panel.add(originRadioButton);
		
		JRadioButton destinationRadioButton = new JRadioButton("Destination");
		buttonGroup.add(destinationRadioButton);
		destinationRadioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		destinationRadioButton.setBackground(Color.LIGHT_GRAY);
		destinationRadioButton.setBounds(100, 60, 100, 25);
		panel.add(destinationRadioButton);
		
		JRadioButton contentsRadioButton = new JRadioButton("Contents");
		buttonGroup.add(contentsRadioButton);
		contentsRadioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentsRadioButton.setBackground(Color.LIGHT_GRAY);
		contentsRadioButton.setBounds(100, 120, 100, 25);
		panel.add(contentsRadioButton);
		
		JRadioButton statusRadioButton = new JRadioButton("Status");
		buttonGroup.add(statusRadioButton);
		statusRadioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		statusRadioButton.setBackground(Color.LIGHT_GRAY);
		statusRadioButton.setBounds(100, 90, 100, 25);
		panel.add(statusRadioButton);
		
		keywordField = new JTextField();
		keywordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		keywordField.setBounds(150, 150, 75, 25);
		panel.add(keywordField);
		keywordField.setColumns(10);
		
		JLabel keywordLabel = new JLabel("Keyword:");
		keywordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		keywordLabel.setBounds(75, 150, 75, 25);
		panel.add(keywordLabel);
		
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
		confirmButton.setBounds(150, 210, 130, 25);
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputKeyword = keywordField.getText();
				String inputClientID = clientIDField.getText();
				int type = -1;
				if (inputKeyword.isEmpty() || inputClientID.isEmpty() ) {
					JOptionPane.showMessageDialog(panel,
							"All fields must be completed",
							"Empty Field(s)",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int inputClientIDAsInt = 0;
					try {
						inputClientIDAsInt = Integer.parseInt(inputClientID);
					} catch (NumberFormatException E) {
						JOptionPane.showMessageDialog(panel,
								"Please enter a number for the ClientID",
								"Number Error",
						    	JOptionPane.ERROR_MESSAGE);
					}
					if( originRadioButton.isSelected() == false && destinationRadioButton.isSelected() == false && contentsRadioButton.isSelected() == false && statusRadioButton.isSelected() == false ) {
						JOptionPane.showMessageDialog(panel,
							    "Please select one from the list",
							    "Indecisive Error",
							    JOptionPane.ERROR_MESSAGE);
					} else {
						if(originRadioButton.isSelected() == true) {
							type = 0;
						} else if (destinationRadioButton.isSelected() == true) {
							type = 1;
						} else if (contentsRadioButton.isSelected() == true) {
							type = 2;
						} else if (statusRadioButton.isSelected() == true) {
							type = 3;
						}
						
						List<Integer> jID = dataStructure.searchJ(inputKeyword,type,inputClientIDAsInt);
						if(jID.size() == 0) {
							JOptionPane.showMessageDialog(panel,
									"No JourneyID(s) can be found with the provided information",
									"Error",
									JOptionPane.ERROR_MESSAGE);
						} else {
							String jIDs = "";
							for(int i = 0; i<jID.size(); i++) {
								jIDs = jIDs +  Integer.toString(jID.get(i)) + " ";
							}
							JOptionPane.showMessageDialog(panel,
									"The JourneyID(s) are: " + jIDs,
									"Confirmation",
									JOptionPane.INFORMATION_MESSAGE);
							dataStructure.save();
							dispose();
						}
					}
				}
			}
		});
		panel.add(confirmButton);
		
		JLabel clientIDLabel = new JLabel("ClientID:");
		clientIDLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		clientIDLabel.setBounds(75, 180, 75, 25);
		panel.add(clientIDLabel);
		
		clientIDField = new JTextField();
		clientIDField.setFont(new Font("Tahoma", Font.BOLD, 13));
		clientIDField.setColumns(10);
		clientIDField.setBounds(150, 180, 75, 25);
		panel.add(clientIDField);
	}
	
	public static void companySearchJourney() {
		companySearchJourney cmpSrcJrn= new companySearchJourney();
		cmpSrcJrn.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cmpSrcJrn.setLocationRelativeTo(null);
		cmpSrcJrn.setVisible(true);
	}
}
