package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.dataStructure;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

class companyInterface extends JFrame {
	private ButtonGroup group;
	private JPanel panel;
	private JTextField txtinit;
	
	public companyInterface() {
		super("Company Interface");
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setAlwaysOnTop(true);
		setFont(new Font("Times New Roman", Font.BOLD, 20));
		setResizable(false);
		setType(Type.NORMAL);
		setTitle("Company Interface");
		getContentPane().setForeground(Color.BLACK);
		
		panel = new JPanel();
		panel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.desktop, SystemColor.desktop, SystemColor.desktop, SystemColor.desktop));
		panel.setForeground(SystemColor.desktop);
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel clientManagePanel = new JPanel();
		clientManagePanel.setBorder(null);
		clientManagePanel.setBackground(Color.BLACK);
		clientManagePanel.setBounds(0, 50, 200, 620);
		panel.add(clientManagePanel);
		clientManagePanel.setLayout(null);
		
		JLabel clientManageLabel = new JLabel("Client Management");
		clientManageLabel.setBounds(21, 25, 157, 20);
		clientManageLabel.setForeground(SystemColor.controlShadow);
		clientManageLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientManagePanel.add(clientManageLabel);
		
		JButton regNewClientButton = new JButton("Register a New Client");
		regNewClientButton.setBounds(25, 70, 150, 25);
		regNewClientButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		regNewClientButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		regNewClientButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.saveC();
				dataStructure.saveJ();
				companyCreateClient.companyCreateClient();		
			}
		});
		clientManagePanel.add(regNewClientButton);
		
		JButton searchClientButton = new JButton("Search for a Client");
		searchClientButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		searchClientButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		searchClientButton.setBounds(25, 120, 150, 25);
		searchClientButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.saveC();
				dataStructure.saveJ();
				companySearchClient.companySearchClient();		
			}
		});
		clientManagePanel.add(searchClientButton);
		
		JPanel journeyManagePanel = new JPanel();
		journeyManagePanel.setBorder(null);
		journeyManagePanel.setBackground(Color.BLACK);
		journeyManagePanel.setBounds(200, 50, 200, 620);
		panel.add(journeyManagePanel);
		journeyManagePanel.setLayout(null);
		
		JLabel journeyManageLabel = new JLabel("Journey Management");
		journeyManageLabel.setBounds(10, 25, 175, 20);
		journeyManageLabel.setForeground(SystemColor.controlShadow);
		journeyManageLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		journeyManagePanel.add(journeyManageLabel);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(60, 530, 80, 25);
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		exitButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
		exitButton.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.saveC();
				dataStructure.saveJ();
			    System.exit(0);
			  }
			});
		journeyManagePanel.add(exitButton);
		
		JButton updateJourneyButton = new JButton("Update a Journey");
		updateJourneyButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		updateJourneyButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		updateJourneyButton.setBounds(25, 70, 150, 25);
		updateJourneyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.saveC();
				dataStructure.saveJ();
				companyUpdateJourney.companyUpdateJourney();		
			}
		});
		journeyManagePanel.add(updateJourneyButton);
		
		JButton searchJourneyButton = new JButton("Search for a Journey");
		searchJourneyButton.setBounds(25, 120, 150, 25);
		searchJourneyButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		searchJourneyButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		searchJourneyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.saveC();
				dataStructure.saveJ();
				companySearchJourney.companySearchJourney();		
			}
		});
		journeyManagePanel.add(searchJourneyButton);
		
		JPanel containerStatusPanel = new JPanel();
		containerStatusPanel.setBorder(null);
		containerStatusPanel.setBackground(Color.BLACK);
		containerStatusPanel.setBounds(400, 50, 200, 620);
		panel.add(containerStatusPanel);
		containerStatusPanel.setLayout(null);
		
		JLabel containerStatusLabel = new JLabel("Container Status");
		containerStatusLabel.setBounds(30, 25, 134, 20);
		containerStatusLabel.setForeground(SystemColor.controlShadow);
		containerStatusLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		containerStatusPanel.add(containerStatusLabel);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setForeground(SystemColor.desktop);
		headerPanel.setBackground(SystemColor.desktop);
		headerPanel.setBounds(0, 0, 600, 50);
		panel.add(headerPanel);
		
		JLabel companyHeaderLabel = new JLabel("Company Interface");
		companyHeaderLabel.setForeground(SystemColor.controlShadow);
		companyHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		headerPanel.add(companyHeaderLabel);
		
	}

	public static void companyInterface() {
		companyInterface cmpInterface = new companyInterface();
		cmpInterface.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cmpInterface.setSize(600, 670);
		cmpInterface.setLocationRelativeTo(null);
		cmpInterface.setVisible(true);
	}
}