package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.Client;
import main.Journey;
import main.dataStructure;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

class clientInterface extends JFrame {
	private ButtonGroup group;
	private JPanel panel;
	private JTextField txtinit;
	
	public clientInterface(int genUser) {
		super("Client Interface");
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setAlwaysOnTop(true);
		setFont(new Font("Times New Roman", Font.BOLD, 20));
		setResizable(false);
		setType(Type.NORMAL);
		setTitle("Client Interface");
		getContentPane().setForeground(Color.BLACK);
		
		panel = new JPanel();
		panel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(Color.BLACK);
		headerPanel.setBounds(0, 0, 600, 50);
		panel.add(headerPanel);
				
		JPanel clientManagePanel = new JPanel();
		clientManagePanel.setBackground(Color.BLACK);
		clientManagePanel.setBounds(0, 50, 600, 620);
		panel.add(clientManagePanel);
		clientManagePanel.setLayout(null);
				
		JPanel clientContainersInfoPanel = new JPanel();
		clientContainersInfoPanel.setBackground(Color.BLACK);
		clientContainersInfoPanel.setBounds(0, 185, 595, 335);
		clientManagePanel.add(clientContainersInfoPanel);
		clientContainersInfoPanel.setLayout(null);
		
		JLabel containerStatusLabel = new JLabel("Container Status");
		containerStatusLabel.setBounds(428, 25, 134, 20);
		containerStatusLabel.setForeground(SystemColor.controlShadow);
		containerStatusLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientManagePanel.add(containerStatusLabel);
		
		JLabel journeyIDLabel = new JLabel("Journey ID");
		journeyIDLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		journeyIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		journeyIDLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		journeyIDLabel.setForeground(SystemColor.controlShadow);
		journeyIDLabel.setBounds(0, 0, 95, 50);
		clientContainersInfoPanel.add(journeyIDLabel);
		
		JLabel destinationLabel = new JLabel("Destination");
		destinationLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		destinationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		destinationLabel.setForeground(SystemColor.controlShadow);
		destinationLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		destinationLabel.setBounds(95, 0, 110, 50);
		clientContainersInfoPanel.add(destinationLabel);
		
		JLabel statusLabel = new JLabel("Status");
		statusLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statusLabel.setForeground(SystemColor.controlShadow);
		statusLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		statusLabel.setBounds(205, 0, 120, 50);
		clientContainersInfoPanel.add(statusLabel);
		
		JLabel temperatureLabel = new JLabel("Temp. (\u00B0C)");
		temperatureLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		temperatureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		temperatureLabel.setForeground(SystemColor.controlShadow);
		temperatureLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		temperatureLabel.setBounds(320, 0, 90, 50);
		clientContainersInfoPanel.add(temperatureLabel);
		
		JLabel pressureLabel = new JLabel("Pressure (Pa)");
		pressureLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		pressureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pressureLabel.setForeground(SystemColor.controlShadow);
		pressureLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		pressureLabel.setBounds(505, 0, 90, 50);
		clientContainersInfoPanel.add(pressureLabel);
		
		JLabel humidityLabel = new JLabel("Humidity (g/m3)");
		humidityLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		humidityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		humidityLabel.setForeground(SystemColor.controlShadow);
		humidityLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		humidityLabel.setBounds(407, 0, 101, 50);
		clientContainersInfoPanel.add(humidityLabel);
		
		JLabel clientHeaderLabel = new JLabel("Client Interface: " + Integer.toString(genUser));
		clientHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		clientHeaderLabel.setForeground(SystemColor.controlShadow);
		headerPanel.add(clientHeaderLabel);

		JLabel clientManageLabel = new JLabel("Client Management");
		clientManageLabel.setBounds(21, 25, 157, 20);
		clientManageLabel.setForeground(SystemColor.controlShadow);
		clientManageLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientManagePanel.add(clientManageLabel);
		
		JLabel journeyManageLabel = new JLabel("Journey Management");
		journeyManageLabel.setBounds(211, 25, 175, 20);
		journeyManageLabel.setForeground(SystemColor.controlShadow);
		journeyManageLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientManagePanel.add(journeyManageLabel);
		
		List<Integer> jID = Journey.searchJ(Integer.toString(genUser),4,genUser);
		String jIDs = "";
		if(jID.size() == 0) {
			jIDs = "None";
		} else {
			for(int i = 0; i<jID.size(); i++) {
				jIDs = jIDs +  Integer.toString(jID.get(i)) + " ";
			}
		}
		
		JTextArea journeyIDTextArea = new JTextArea(jIDs);
		journeyIDTextArea.setEditable(false);
		journeyIDTextArea.setWrapStyleWord(true);
		journeyIDTextArea.setBorder(new LineBorder(SystemColor.controlDkShadow));
		journeyIDTextArea.setForeground(SystemColor.controlDkShadow);
		journeyIDTextArea.setBackground(Color.BLACK);
		journeyIDTextArea.setFont(new Font("Monospaced", Font.BOLD, 14));
		journeyIDTextArea.setLineWrap(true);
		journeyIDTextArea.setBounds(0, 50, 95, 285);
		clientContainersInfoPanel.add(journeyIDTextArea);
		
		String jDests = "";
		if(jID.size() == 0) {
			jDests = "None";
		} else {
			for(int i = 0; i<jID.size(); i++) {
				jDests = jDests +  dataStructure.journeys.get(jID.get(i)).getDestination() + "\n";
			}
		}
		
		JTextArea journeyDestArea = new JTextArea(jDests);
		journeyDestArea.setEditable(false);
		journeyDestArea.setWrapStyleWord(true);
		journeyDestArea.setBorder(new LineBorder(SystemColor.controlDkShadow));
		journeyDestArea.setBackground(Color.BLACK);
		journeyDestArea.setForeground(SystemColor.controlDkShadow);
		journeyDestArea.setFont(new Font("Monospaced", Font.BOLD, 14));
		journeyDestArea.setBounds(95, 50, 110, 285);
		clientContainersInfoPanel.add(journeyDestArea);
		
		String jTemp = "";
		if(jID.size() == 0) {
			jTemp = "None";
		} else {
			for(int i = 0; i<jID.size(); i++) {
				jTemp = jTemp +  dataStructure.journeys.get(jID.get(i)).getLastTemp() + "\n";
			}
		}

		JTextArea temperatureArea = new JTextArea(jTemp);
		temperatureArea.setEditable(false);
		temperatureArea.setWrapStyleWord(true);
		temperatureArea.setBorder(new LineBorder(SystemColor.controlDkShadow));
		temperatureArea.setBackground(Color.BLACK);
		temperatureArea.setForeground(SystemColor.controlDkShadow);
		temperatureArea.setLineWrap(true);
		temperatureArea.setFont(new Font("Monospaced", Font.BOLD, 14));
		temperatureArea.setBounds(325, 50, 90, 285);
		clientContainersInfoPanel.add(temperatureArea);
		
		String jStats = "";
		if(jID.size() == 0) {
			jStats = "None";
		} else {
			for(int i = 0; i<jID.size(); i++) {
				jStats = jStats +  dataStructure.journeys.get(jID.get(i)).getStatus() + "\n";
			}
		}
		
		JTextArea statusArea = new JTextArea(jStats);
		statusArea.setEditable(false);
		statusArea.setWrapStyleWord(true);
		statusArea.setBorder(new LineBorder(SystemColor.controlDkShadow));
		statusArea.setForeground(SystemColor.controlDkShadow);
		statusArea.setBackground(Color.BLACK);
		statusArea.setLineWrap(true);
		statusArea.setFont(new Font("Monospaced", Font.BOLD, 14));
		statusArea.setBounds(205, 50, 120, 285);
		clientContainersInfoPanel.add(statusArea);
		
		String jHum = "";
		if(jID.size() == 0) {
			jHum = "None";
		} else {
			for(int i = 0; i<jID.size(); i++) {
				jHum = jHum +  dataStructure.journeys.get(jID.get(i)).getLastHumidity() + "\n";
			}
		}
		
		JTextArea humidityArea = new JTextArea(jHum);
		humidityArea.setEditable(false);
		humidityArea.setWrapStyleWord(true);
		humidityArea.setBorder(new LineBorder(SystemColor.controlDkShadow));
		humidityArea.setForeground(SystemColor.controlDkShadow);
		humidityArea.setBackground(Color.BLACK);
		humidityArea.setLineWrap(true);
		humidityArea.setFont(new Font("Monospaced", Font.BOLD, 14));
		humidityArea.setBounds(415, 50, 90, 285);
		clientContainersInfoPanel.add(humidityArea);
		
		String jPres = "";
		if(jID.size() == 0) {
			jPres = "None";
		} else {
			for(int i = 0; i<jID.size(); i++) {
				jPres = jPres +  dataStructure.journeys.get(jID.get(i)).getLastAtmPressure() + "\n";
			}
		}
		
		JTextArea pressureArea = new JTextArea(jPres);
		pressureArea.setEditable(false);
		pressureArea.setWrapStyleWord(true);
		pressureArea.setBorder(new LineBorder(SystemColor.controlDkShadow));
		pressureArea.setBackground(Color.BLACK);
		pressureArea.setForeground(SystemColor.controlDkShadow);
		pressureArea.setLineWrap(true);
		pressureArea.setFont(new Font("Monospaced", Font.BOLD, 14));
		pressureArea.setBounds(505, 50, 90, 285);
		clientContainersInfoPanel.add(pressureArea);
		
		JButton updateClientInfoButton = new JButton("Update Client Info");
		updateClientInfoButton.setBounds(25, 70, 150, 25);
		updateClientInfoButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		updateClientInfoButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		updateClientInfoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				clientUpdateInfo.clientUpdateInfo(genUser);
			}
		});
		clientManagePanel.add(updateClientInfoButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(226, 540, 150, 25);
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		exitButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		exitButton.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
			    System.exit(0);
			  }
			});
		clientManagePanel.add(exitButton);
		
		JButton regContainerJourneyButton = new JButton("Register a Container");
		regContainerJourneyButton.setBounds(226, 70, 150, 25);
		regContainerJourneyButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		regContainerJourneyButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		regContainerJourneyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				clientRegContainer.clientRegContainer(genUser);
			}
		});
		clientManagePanel.add(regContainerJourneyButton);
		
		JButton refreshTableButton = new JButton("Refresh");
		refreshTableButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		refreshTableButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		refreshTableButton.setBounds(226, 150, 150, 25);
		refreshTableButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				dataStructure.load();
				clientInterface.clientInterface(genUser);
				dispose();
			}
		});
		clientManagePanel.add(refreshTableButton);
		
		JButton containerHistoryButton = new JButton("Container History");
		containerHistoryButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		containerHistoryButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		containerHistoryButton.setBounds(426, 70, 150, 25);
		containerHistoryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jID.size() == 0) {
					JOptionPane.showMessageDialog(panel,
							"There are no JourneyIDs",
							"Journey Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					dataStructure.save();
					clientContainerHistory.clientContainerHistory(genUser);
				}
			}
		});
		clientManagePanel.add(containerHistoryButton);
		
		JButton moreJourneyInformationButton = new JButton("More Journey Info");
		moreJourneyInformationButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		moreJourneyInformationButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		moreJourneyInformationButton.setBounds(226, 110, 150, 25);
		moreJourneyInformationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jID.size() == 0) {
					JOptionPane.showMessageDialog(panel,
							"There are no JourneyIDs",
							"Journey Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					dataStructure.save();
					clientMoreInformation.clientMoreInformation(genUser);
				}
			}
		});
		clientManagePanel.add(moreJourneyInformationButton);
		
		Client C = dataStructure.clients.get(genUser);
		
		JButton seeClientInfoButton = new JButton("See Client Info");
		seeClientInfoButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		seeClientInfoButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		seeClientInfoButton.setBounds(25, 110, 150, 25);
		seeClientInfoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String clientInfo = "ClientID: " + Integer.toString(genUser) + "\n" + "Name: " + C.getName() + "\n" + "Password: " + C.getPassword() 
									+ "\n" + "Address: " + C.getAddress() + "\n" + "Email: " + C.getEmail() + "\n" + "Phone: " + C.getPhone();
				JOptionPane.showMessageDialog(panel,
						"\n" + clientInfo,
						"All of your information",
						JOptionPane.INFORMATION_MESSAGE);
				}
		});
		clientManagePanel.add(seeClientInfoButton);
		
		JButton seeContainerMapButton = new JButton("See Container Map");
		seeContainerMapButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		seeContainerMapButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		seeContainerMapButton.setBounds(426, 110, 150, 25);
		seeContainerMapButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				clientContainerMap.clientContainerMap(genUser);
			}
		});
		clientManagePanel.add(seeContainerMapButton);
		
		JButton returnLoginButton = new JButton("Return to Login");
		returnLoginButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		returnLoginButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		returnLoginButton.setBounds(25, 540, 150, 25);
		returnLoginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				initInterface.initInterface();
				dispose();
			}
		});
		clientManagePanel.add(returnLoginButton);		
	}

	public static void clientInterface(int genUser) {
		clientInterface cltInterface = new clientInterface(genUser);
		cltInterface.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cltInterface.setSize(610, 670);
		cltInterface.setLocationRelativeTo(null);
		cltInterface.setVisible(true);
	}
}