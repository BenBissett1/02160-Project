package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import io.cucumber.core.internal.gherkin.StringUtils;
import main.Journey;
import main.dataStructure;
import main.request;

public class clientContainerHistory extends JFrame{
	public clientContainerHistory(int genUser) {
		super("Client Container History");
		setSize(new Dimension(320,280));
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
		clientRegContainerLabel.setBounds(5, 15, 300, 25);
		panel.add(clientRegContainerLabel);
		
		String[] statusList = {"Temperature", "Humidity", "Pressure"};
		
		JComboBox containerHistoryStatusComboBox = new JComboBox(statusList);
		containerHistoryStatusComboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		containerHistoryStatusComboBox.setBounds(160, 125, 95, 25);
		panel.add(containerHistoryStatusComboBox);
		
		List<Integer> journeyID = dataStructure.searchJ(Integer.toString(genUser),4,genUser);
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
		
		JComboBox containerHistoryJourneysComboBox = new JComboBox(jIDs);
		containerHistoryJourneysComboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		containerHistoryJourneysComboBox.setBounds(160, 80, 95, 25);
		panel.add(containerHistoryJourneysComboBox);
		
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
		
		request R = new request();
		Journey J = new Journey();
		
		JButton clientConfirmButton = new JButton("Confirm");
		clientConfirmButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientConfirmButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		clientConfirmButton.setBounds(163, 205, 130, 25);
		clientConfirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputJourney = (String) containerHistoryJourneysComboBox.getSelectedItem();
				String inputStatus = (String) containerHistoryStatusComboBox.getSelectedItem();
				if (inputJourney.isEmpty() || inputStatus.isEmpty()) {
					JOptionPane.showMessageDialog(panel,
							"Please choose one of each",
							"Empty Field(s)",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if(inputStatus.equals("Temperature")) {
						List<Float> jTemp = J.getTemp();
						String listString = jTemp.stream().map(Object::toString)
								.collect(Collectors.joining(", "));
						JOptionPane.showMessageDialog(panel,
								"The history of the temperature is: " + listString,
								"Confirmation",
								JOptionPane.INFORMATION_MESSAGE);
						dataStructure.save();
						dispose();
					} else if (inputStatus.equals("Humidity")){
						List<Float> jHum = J.getHum();
						String listString = jHum.stream().map(Object::toString)
								.collect(Collectors.joining(", "));
						JOptionPane.showMessageDialog(panel,
								"The history of the humidity is: " + listString,
								"Confirmation",
								JOptionPane.INFORMATION_MESSAGE);
						dataStructure.save();
						dispose();
					} else if (inputStatus.equals("Pressure")) {
						List<Float> jPres = J.getPres();
						String listString = jPres.stream().map(Object::toString)
								.collect(Collectors.joining(", "));
						JOptionPane.showMessageDialog(panel,
								"The history of the pressure is: " + listString,
								"Confirmation",
								JOptionPane.INFORMATION_MESSAGE);
						dataStructure.save();
						dispose();
					}
				}
			}
		});
		panel.add(clientConfirmButton);
		
		JLabel containerHistoryJourneyIDLabel = new JLabel("JourneyID:");
		containerHistoryJourneyIDLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		containerHistoryJourneyIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		containerHistoryJourneyIDLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		containerHistoryJourneyIDLabel.setBounds(55, 80, 95, 25);
		panel.add(containerHistoryJourneyIDLabel);
		
		JLabel containerHistoryStatusLabel = new JLabel("Status:");
		containerHistoryStatusLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		containerHistoryStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		containerHistoryStatusLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		containerHistoryStatusLabel.setBounds(55, 125, 95, 25);
		panel.add(containerHistoryStatusLabel);
		
	}

	public static void clientContainerHistory(int genUser) {
		clientContainerHistory cltCntHst= new clientContainerHistory(genUser);
		cltCntHst.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cltCntHst.setLocationRelativeTo(null);
		cltCntHst.setVisible(true);
	}
}
