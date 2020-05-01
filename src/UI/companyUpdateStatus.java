package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.dataStructure;
import main.request;

public class companyUpdateStatus extends JFrame{
	private JTextField temperatureTextField;
	private JTextField humidityTextField;
	private JTextField atmPressureTextField;
	private JTextField journeyIDField;
	public companyUpdateStatus() {
		super("Company Update Container Status");
		setTitle("Update Container Status");
		setSize(new Dimension(320, 280));
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
		panel.setForeground(Color.BLACK);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel companyUpdateStatusLabel = new JLabel("Please enter new information below");
		companyUpdateStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		companyUpdateStatusLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		companyUpdateStatusLabel.setBounds(5, 15, 300, 25);
		panel.add(companyUpdateStatusLabel);
		
		JLabel updateTemperature = new JLabel("Temperature:");
		updateTemperature.setHorizontalTextPosition(SwingConstants.CENTER);
		updateTemperature.setHorizontalAlignment(SwingConstants.RIGHT);
		updateTemperature.setFont(new Font("Tahoma", Font.BOLD, 16));
		updateTemperature.setBounds(10, 90, 150, 25);
		panel.add(updateTemperature);
		
		JLabel updateAtmPressure = new JLabel("Atm. Pressure:");
		updateAtmPressure.setHorizontalTextPosition(SwingConstants.CENTER);
		updateAtmPressure.setHorizontalAlignment(SwingConstants.RIGHT);
		updateAtmPressure.setFont(new Font("Tahoma", Font.BOLD, 16));
		updateAtmPressure.setBounds(10, 150, 150, 25);
		panel.add(updateAtmPressure);
		
		JLabel updateHumidity = new JLabel("Humidity:");
		updateHumidity.setHorizontalTextPosition(SwingConstants.CENTER);
		updateHumidity.setHorizontalAlignment(SwingConstants.RIGHT);
		updateHumidity.setFont(new Font("Tahoma", Font.BOLD, 16));
		updateHumidity.setBounds(10, 120, 150, 25);
		panel.add(updateHumidity);
		
		JButton clientCreateBack = new JButton("Back");
		clientCreateBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientCreateBack.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		clientCreateBack.setBounds(15, 205, 130, 25);
		clientCreateBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				dispose();				
			}
		});
		panel.add(clientCreateBack);
		
		JButton companyUpdateStatusButton = new JButton("Confirm");
		companyUpdateStatusButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		companyUpdateStatusButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		companyUpdateStatusButton.setBounds(165, 205, 130, 25);
		companyUpdateStatusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputJourneyID = journeyIDField.getText();
				String inputTemp = temperatureTextField.getText();
				String inputHumidity = humidityTextField.getText();
				String inputPressure = atmPressureTextField.getText();
				if (inputTemp.isEmpty() || inputHumidity.isEmpty() || inputPressure.isEmpty() || inputJourneyID.isEmpty()) {
					JOptionPane.showMessageDialog(panel,
							"All fields must be completed",
							"Empty Field(s)",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int inputJourneyIDAsInt = 0;
					float inputTempAsFloat = 0.f;
					float inputHumidityAsFloat = 0.f;
					float inputPressureAsFloat = 0.f;
					try {
						inputJourneyIDAsInt = Integer.parseInt(inputJourneyID);
						inputTempAsFloat = Float.parseFloat(inputTemp);
						inputHumidityAsFloat = Float.parseFloat(inputHumidity);
						inputPressureAsFloat = Float.parseFloat(inputPressure);
					} catch (NumberFormatException E) {
						JOptionPane.showMessageDialog(panel,
								"Please enter numbers in the correct format",
								"Number Error",
						    	JOptionPane.ERROR_MESSAGE);
					}
					request myObject = new request();
					myObject.updateContainerStatus(inputJourneyIDAsInt,inputTempAsFloat, inputHumidityAsFloat, inputPressureAsFloat);
					JOptionPane.showMessageDialog(panel,
							"Information Updated!",
							"Confirmation",
							JOptionPane.INFORMATION_MESSAGE);
					dataStructure.save();
					dispose();
				}
			}
		});
		panel.add(companyUpdateStatusButton);
		
		temperatureTextField = new JTextField();
		temperatureTextField.setHorizontalAlignment(SwingConstants.CENTER);
		temperatureTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		temperatureTextField.setColumns(10);
		temperatureTextField.setBounds(165, 90, 96, 25);
		panel.add(temperatureTextField);
		
		humidityTextField = new JTextField();
		humidityTextField.setHorizontalAlignment(SwingConstants.CENTER);
		humidityTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		humidityTextField.setColumns(10);
		humidityTextField.setBounds(165, 120, 96, 25);
		panel.add(humidityTextField);
		
		atmPressureTextField = new JTextField();
		atmPressureTextField.setHorizontalAlignment(SwingConstants.CENTER);
		atmPressureTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		atmPressureTextField.setColumns(10);
		atmPressureTextField.setBounds(165, 150, 96, 25);
		panel.add(atmPressureTextField);
		
		JLabel journeyID = new JLabel("JourneyID:");
		journeyID.setHorizontalTextPosition(SwingConstants.CENTER);
		journeyID.setHorizontalAlignment(SwingConstants.RIGHT);
		journeyID.setFont(new Font("Tahoma", Font.BOLD, 16));
		journeyID.setBounds(10, 60, 150, 25);
		panel.add(journeyID);
		
		journeyIDField = new JTextField();
		journeyIDField.setHorizontalAlignment(SwingConstants.CENTER);
		journeyIDField.setFont(new Font("Tahoma", Font.BOLD, 13));
		journeyIDField.setColumns(10);
		journeyIDField.setBounds(165, 60, 96, 25);
		panel.add(journeyIDField);
	}
	
	public static void companyUpdateStatus() {
		companyUpdateStatus cmpUptStt= new companyUpdateStatus();
		cmpUptStt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cmpUptStt.setLocationRelativeTo(null);
		cmpUptStt.setVisible(true);
	}
}
