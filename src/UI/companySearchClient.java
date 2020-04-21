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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class companySearchClient extends JFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField keywordField;
	public companySearchClient() {
		super("Search For A Client");
		setTitle("Search for a Client");
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
		header.setBounds(0, 10, 300, 20);
		header.setHorizontalTextPosition(SwingConstants.CENTER);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 16));
		header.setBackground(Color.LIGHT_GRAY);
		panel.add(header);
		
		JRadioButton nameRadioButton = new JRadioButton("Name");
		nameRadioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		nameRadioButton.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(nameRadioButton);
		nameRadioButton.setBounds(100, 40, 100, 25);
		panel.add(nameRadioButton);
		
		JRadioButton addressRadioButton = new JRadioButton("Address");
		buttonGroup.add(addressRadioButton);
		addressRadioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		addressRadioButton.setBackground(Color.LIGHT_GRAY);
		addressRadioButton.setBounds(100, 70, 100, 25);
		panel.add(addressRadioButton);
		
		JRadioButton emailRadioButton = new JRadioButton("Email");
		buttonGroup.add(emailRadioButton);
		emailRadioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		emailRadioButton.setBackground(Color.LIGHT_GRAY);
		emailRadioButton.setBounds(100, 130, 100, 25);
		panel.add(emailRadioButton);
		
		JRadioButton telephoneRadioButton = new JRadioButton("Telephone");
		buttonGroup.add(telephoneRadioButton);
		telephoneRadioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		telephoneRadioButton.setBackground(Color.LIGHT_GRAY);
		telephoneRadioButton.setBounds(100, 100, 100, 25);
		panel.add(telephoneRadioButton);
		
		keywordField = new JTextField();
		keywordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		keywordField.setBounds(150, 162, 75, 25);
		panel.add(keywordField);
		keywordField.setColumns(10);
		
		JLabel keywordLabel = new JLabel("Keyword:");
		keywordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		keywordLabel.setBounds(75, 160, 75, 25);
		panel.add(keywordLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		backButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		backButton.setBounds(10, 205, 130, 25);
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
		confirmButton.setBounds(150, 205, 130, 25);
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputKeyword = keywordField.getText();
				int type = -1;
				if (inputKeyword.isEmpty() ) {
					JOptionPane.showMessageDialog(panel,
							"All fields must be completed",
							"Empty Field(s)",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if( nameRadioButton.isSelected() == false && addressRadioButton.isSelected() == false && emailRadioButton.isSelected() == false && telephoneRadioButton.isSelected() == false ) {
						JOptionPane.showMessageDialog(panel,
							    "Please select one from the list",
							    "Indecisive Error",
							    JOptionPane.ERROR_MESSAGE);
					} else {
						if(nameRadioButton.isSelected() == true) {
							type = 0;
						} else if (addressRadioButton.isSelected() == true) {
							type = 2;
						} else if (emailRadioButton.isSelected() == true) {
							type = 3;
						} else if (telephoneRadioButton.isSelected() == true) {
							type = 4;
						}
						
						int cID = dataStructure.searchC(inputKeyword,type);
						if (cID == -1) {
							JOptionPane.showMessageDialog(panel,
									"The ClientID cannot be found with the provided information",
									"Error",
									JOptionPane.ERROR_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(panel,
									"The ClientID is: " + Integer.toString(cID),
									"Confirmation",
									JOptionPane.INFORMATION_MESSAGE);
							dataStructure.saveC();
							dataStructure.saveJ();
							dispose();
						}
					}
				}
			}
		});
		panel.add(confirmButton);
	}
	
	public static void companySearchClient() {
		companySearchClient cmpSrcClt= new companySearchClient();
		cmpSrcClt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cmpSrcClt.setLocationRelativeTo(null);
		cmpSrcClt.setVisible(true);
	}
}
