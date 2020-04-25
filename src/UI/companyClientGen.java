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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.dataStructure;

import javax.swing.JTextField;

public class companyClientGen extends JFrame {
	private JTextField clientIDField;
	private JTextField clientPasswordField;
	public companyClientGen(int cID, String pass) {
		super("Client User Created");
		setSize(new Dimension(313, 280));
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
		panel.setForeground(Color.WHITE);
		panel.setBorder(null);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel header = new JLabel("Your ClientID and Password are:");
		header.setBounds(0, 25, 300, 20);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setHorizontalTextPosition(SwingConstants.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 16));
		header.setBackground(Color.LIGHT_GRAY);
		panel.add(header);
		
		JLabel clientIDLabel = new JLabel("ClientID:");
		clientIDLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		clientIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clientIDLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientIDLabel.setBounds(44, 90, 96, 17);
		panel.add(clientIDLabel);
		
		clientIDField = new JTextField(Integer.toString(cID));
		clientIDField.setHorizontalAlignment(SwingConstants.CENTER);
		clientIDField.setFont(new Font("Tahoma", Font.BOLD, 13));
		clientIDField.setColumns(10);
		clientIDField.setEditable(false);
		clientIDField.setBounds(150, 90, 96, 25);
		panel.add(clientIDField);
		
		JLabel clientPasswordLabel = new JLabel("Password:");
		clientPasswordLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		clientPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clientPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientPasswordLabel.setBounds(44, 130, 96, 17);
		panel.add(clientPasswordLabel);
		
		clientPasswordField = new JTextField(pass);
		clientPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		clientPasswordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		clientPasswordField.setColumns(10);
		clientPasswordField.setEditable(false);
		clientPasswordField.setBounds(150, 130, 96, 25);
		panel.add(clientPasswordField);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		exitButton.setBounds(10, 200, 130, 25);
		exitButton.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
			    System.exit(0);
			  }
			});
		panel.add(exitButton);
		
		JButton loginPageButton = new JButton("Next");
		loginPageButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		loginPageButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		loginPageButton.setBounds(160, 200, 130, 25);
		loginPageButton.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
			    dispose();
			  }
			});
		panel.add(loginPageButton);
	}
	public static void companyClientGen(int cID, String pass) {
		companyClientGen cmpCltGen= new companyClientGen(cID, pass);
		cmpCltGen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cmpCltGen.setLocationRelativeTo(null);
		cmpCltGen.setVisible(true);
	}
}
