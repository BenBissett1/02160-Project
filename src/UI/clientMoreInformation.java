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
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.Journey;
import main.dataStructure;

public class clientMoreInformation extends JFrame{
	public clientMoreInformation(int genUser) {
		super("More Journey Information");
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

		JLabel clientTitleLabel = new JLabel("Please Choose a JourneyID");
		clientTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clientTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientTitleLabel.setBounds(5, 15, 300, 25);
		panel.add(clientTitleLabel);

		List<Integer> journeyID = Journey.searchJ(Integer.toString(genUser),4,genUser);
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
		containerHistoryJourneysComboBox.setBounds(160, 100, 95, 25);
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

		JButton clientConfirmButton = new JButton("Confirm");
		clientConfirmButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientConfirmButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		clientConfirmButton.setBounds(163, 205, 130, 25);
		clientConfirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputJourney = (String) containerHistoryJourneysComboBox.getSelectedItem();
				Journey J = dataStructure.journeys.get(Integer.parseInt(inputJourney));
				if (inputJourney.isEmpty()) {
					JOptionPane.showMessageDialog(panel,
							"Please choose a Journey",
							"Empty Field(s)",
							JOptionPane.ERROR_MESSAGE);
				} else {
					String info = "";
					info = "\n" + "Origin: " +  J.getOrigin() + "\n" + "Destination: " + J.getDestination() + "\n" + "Status: " + J.getStatus() 
						   + "\n" + "Contents: " + J.getContent() + "\n" + "Current Temperature: " + J.getLastTemp() + "\n" + "Current Humidity: "
						   + J.getLastHumidity() + "\n" + "Current Pressure: " + J.getLastAtmPressure();
					JOptionPane.showMessageDialog(panel,
							"All available information is as follows: " + info,
							"Confirmation",
							JOptionPane.INFORMATION_MESSAGE);
					dataStructure.save();
					dispose();
				}
			}
		});
		panel.add(clientConfirmButton);

		JLabel containerHistoryJourneyIDLabel = new JLabel("JourneyID:");
		containerHistoryJourneyIDLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		containerHistoryJourneyIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		containerHistoryJourneyIDLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		containerHistoryJourneyIDLabel.setBounds(55, 100, 95, 25);
		panel.add(containerHistoryJourneyIDLabel);

	}

	public static void clientMoreInformation(int genUser) {
		clientMoreInformation cltMreIfo = new clientMoreInformation(genUser);
		cltMreIfo.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cltMreIfo.setLocationRelativeTo(null);
		cltMreIfo.setVisible(true);
	}
}