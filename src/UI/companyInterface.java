package UI;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.Client;
import main.Painter;
import main.dataStructure;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.ComponentOrientation;

class companyInterface extends JFrame {
	private ButtonGroup group;
	private JPanel panel;
	private JTextField txtinit;
    private BufferedImage Worldmap;
	
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
		
		JPanel headerPanel = new JPanel();
		headerPanel.setForeground(SystemColor.desktop);
		headerPanel.setBackground(SystemColor.desktop);
		headerPanel.setBounds(0, 0, 605, 50);
		panel.add(headerPanel);
		
		JLabel companyHeaderLabel = new JLabel("Company Interface");
		companyHeaderLabel.setForeground(SystemColor.controlShadow);
		companyHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		headerPanel.add(companyHeaderLabel);
		
		JPanel clientManagePanel = new JPanel();
		clientManagePanel.setBorder(null);
		clientManagePanel.setBackground(Color.BLACK);
		clientManagePanel.setBounds(0, 50, 605, 620);
		panel.add(clientManagePanel);
		clientManagePanel.setLayout(null);
		
		JLabel containerStatusLabel = new JLabel("Container Status");
		containerStatusLabel.setForeground(SystemColor.controlShadow);
		containerStatusLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		containerStatusLabel.setBounds(435, 25, 134, 20);
		clientManagePanel.add(containerStatusLabel);
		
		JLabel clientManageLabel = new JLabel("Client Management");
		clientManageLabel.setBounds(21, 25, 157, 20);
		clientManageLabel.setForeground(SystemColor.controlShadow);
		clientManageLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientManagePanel.add(clientManageLabel);
		
		JLabel journeyManageLabel = new JLabel("Journey Management");
		journeyManageLabel.setForeground(SystemColor.controlShadow);
		journeyManageLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		journeyManageLabel.setBounds(212, 25, 175, 20);
		clientManagePanel.add(journeyManageLabel);
		
		JButton regNewClientButton = new JButton("Register a New Client");
		regNewClientButton.setBounds(25, 70, 150, 25);
		regNewClientButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		regNewClientButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		regNewClientButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				companyCreateClient.companyCreateClient();		
			}
		});
		clientManagePanel.add(regNewClientButton);
		
		JButton searchClientButton = new JButton("Search for a Client");
		searchClientButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		searchClientButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		searchClientButton.setBounds(25, 110, 150, 25);
		searchClientButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				companySearchClient.companySearchClient();		
			}
		});
		clientManagePanel.add(searchClientButton);
		
		JButton seeAllCurrentButton = new JButton("View All Ongoing");
		seeAllCurrentButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		seeAllCurrentButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		seeAllCurrentButton.setBounds(425, 110, 150, 25);
		seeAllCurrentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String clients = (dataStructure.allClients()).stream().map(Object::toString)
						.collect(Collectors.joining(", "));
				String journeys = (dataStructure.allJourneys()).stream().map(Object::toString)
						.collect(Collectors.joining(", "));
				JOptionPane.showMessageDialog(panel,
						"\n" + "Clients: " + clients + "\n" + "Journeys: " + journeys,
						"All Ongoing Clients and Journeys",
						JOptionPane.INFORMATION_MESSAGE);
				}
		});
		clientManagePanel.add(seeAllCurrentButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		exitButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
		exitButton.setBounds(226, 540, 150, 25);
		exitButton.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
			    System.exit(0);
			  }
			});
		clientManagePanel.add(exitButton);
		
		JButton updateJourneyButton = new JButton("Update a Journey");
		updateJourneyButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		updateJourneyButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		updateJourneyButton.setBounds(226, 70, 150, 25);
		updateJourneyButton.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
				 if(dataStructure.allJourneys().size() == 0) {
					JOptionPane.showMessageDialog(panel,
							"There are no JourneyIDs",
							"Journey Error",
							JOptionPane.ERROR_MESSAGE);
				 } else {
					dataStructure.save();
					companyUpdateJourney.companyUpdateJourney();
				 }
			  }
			});
		clientManagePanel.add(updateJourneyButton);
		
		JButton searchJourneyButton = new JButton("Search for a Journey");
		searchJourneyButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		searchJourneyButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		searchJourneyButton.setBounds(226, 110, 150, 25);
		searchJourneyButton.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
			    companySearchJourney.companySearchJourney();
			  }
			});
		clientManagePanel.add(searchJourneyButton);
		
		JButton updateContainerStatusButton = new JButton("Update Status");
		updateContainerStatusButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		updateContainerStatusButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		updateContainerStatusButton.setBounds(426, 70, 150, 25);
		updateContainerStatusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				companyUpdateStatus.companyUpdateStatus();		
			}
		});
		clientManagePanel.add(updateContainerStatusButton);
		
		JButton refreshTableButton = new JButton("Refresh");
		refreshTableButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		refreshTableButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		refreshTableButton.setBounds(226, 150, 150, 25);
		refreshTableButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				dataStructure.load();
				companyInterface.companyInterface();
				dispose();
			}
		});
		clientManagePanel.add(refreshTableButton);
		
		Painter paintedPanel = new Painter(0);
		paintedPanel.setOpaque(true);
		paintedPanel.setBounds(0, 185, 595, 335);
		clientManagePanel.add(paintedPanel);
		

	}

	public static void companyInterface() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
			companyInterface cmpInterface = new companyInterface();
			cmpInterface.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			cmpInterface.setSize(605, 670);
			cmpInterface.setLocationRelativeTo(null);
			cmpInterface.setVisible(true);
			}
		});
	}
}