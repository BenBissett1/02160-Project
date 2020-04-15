package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Dimension;
import javax.swing.WindowConstants;
import javax.swing.JLabel;

public class initInterface extends JFrame {
	private ButtonGroup group;
	private JPanel panel;
	
	public initInterface() {
		super("Initialization");
		getContentPane().setBackground(Color.WHITE);
		setSize(new Dimension(313, 250));
		setLocationByPlatform(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setAlwaysOnTop(true);
		setFont(new Font("Times New Roman", Font.BOLD, 20));
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Initialization...");
		getContentPane().setForeground(Color.WHITE);
		
		panel = new JPanel();
		panel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setBorder(null);
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JRadioButton clientButton = new JRadioButton("Client");
		clientButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		clientButton.setHorizontalAlignment(SwingConstants.LEFT);
		clientButton.setBorderPainted(true);
		clientButton.setBorder(null);
		clientButton.setBackground(Color.LIGHT_GRAY);
		clientButton.setForeground(Color.BLACK);
		clientButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientButton.setBounds(90, 75, 110, 25);
		panel.add(clientButton);
		
		JRadioButton companyButton = new JRadioButton("Company");
		companyButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		companyButton.setHorizontalAlignment(SwingConstants.LEFT);
		companyButton.setBorderPainted(true);
		companyButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		companyButton.setBorder(null);
		companyButton.setForeground(Color.BLACK);
		companyButton.setBackground(Color.LIGHT_GRAY);
		companyButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		companyButton.setBounds(90, 115, 110, 25);
		panel.add(companyButton);
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		group = new ButtonGroup();
		group.add(clientButton);
		group.add(companyButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		exitButton.setBounds(10, 170, 130, 25);
		exitButton.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
			    System.exit(0);
			  }
			});
		panel.add(exitButton);
		
		JButton nextButton = new JButton("Next");
		nextButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		nextButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		nextButton.setBounds(160, 170, 130, 25);
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if( companyButton.isSelected() == false && clientButton.isSelected() == false ) {
					JOptionPane.showMessageDialog(panel,
						    "Please select one or fuck off",
						    "Indecisive Error",
						    JOptionPane.ERROR_MESSAGE);
				} 
				else if (companyButton.isSelected() == true){
					companyLogin.companyLogin();
					dispose();
				}
				else if (clientButton.isSelected() == true) {
					clientLogin.clientLogin();
					dispose();
				}
			}
		});
		panel.add(nextButton);
		
		JLabel initHeader = new JLabel("Are you a Client or a Company?");
		initHeader.setForeground(Color.BLACK);
		initHeader.setFont(new Font("Tahoma", Font.BOLD, 16));
		initHeader.setHorizontalAlignment(SwingConstants.CENTER);
		initHeader.setBounds(10, 25, 280, 25);
		panel.add(initHeader);
		
	}

	public static void initInterface() {
		initInterface init = new initInterface();
		init.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		init.setLocationRelativeTo(null);
		init.setVisible(true);
	}
}