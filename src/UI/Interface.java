package UI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import java.awt.Window.Type;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

class clientInterface extends JFrame {
	private ButtonGroup group;
	private JPanel panel;
	private JTextField txtinit;
	
	public clientInterface() {
		super("Client Interface");
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setAlwaysOnTop(true);
		setFont(new Font("Times New Roman", Font.BOLD, 20));
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Client Interface");
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
	}

	public static void clientInterface() {
		clientInterface cltInterface = new clientInterface();
		cltInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cltInterface.setSize(800, 700);
		cltInterface.setLocationRelativeTo(null);
		cltInterface.setVisible(true);
	}
}

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
		setType(Type.POPUP);
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
	}

	public static void companyInterface() {
		companyInterface cmpInterface = new companyInterface();
		cmpInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cmpInterface.setSize(800, 700);
		cmpInterface.setLocationRelativeTo(null);
		cmpInterface.setVisible(true);
	}
}

public class Interface extends JFrame {
	private ButtonGroup group;
	private JPanel panel;
	private JTextField txtinit;
	
	public Interface() {
		super("Initialization");
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setAlwaysOnTop(true);
		setFont(new Font("Times New Roman", Font.BOLD, 20));
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Initialization...");
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
		
		txtinit = new JTextField();
		txtinit.setBorder(null);
		txtinit.setCaretColor(Color.BLACK);
		txtinit.setSelectedTextColor(Color.GRAY);
		txtinit.setSelectionColor(SystemColor.desktop);
		txtinit.setBounds(10, 10, 280, 35);
		txtinit.setBackground(SystemColor.desktop);
		txtinit.setForeground(SystemColor.text);
		txtinit.setText(" Are you a client or a company? ");
		txtinit.setFont(new Font("Thames", Font.BOLD, 20));
		panel.add(txtinit);
		
		JRadioButton clientButton = new JRadioButton("Client");
		clientButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		clientButton.setHorizontalAlignment(SwingConstants.LEFT);
		clientButton.setBorderPainted(true);
		clientButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		clientButton.setBackground(SystemColor.desktop);
		clientButton.setForeground(SystemColor.text);
		clientButton.setFont(new Font("Thames", Font.BOLD, 18));
		clientButton.setBounds(90, 75, 110, 25);
		panel.add(clientButton);
		
		JRadioButton companyButton = new JRadioButton("Company");
		companyButton.setBorderPainted(true);
		companyButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		companyButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		companyButton.setForeground(SystemColor.text);
		companyButton.setBackground(SystemColor.desktop);
		companyButton.setFont(new Font("Thames", Font.BOLD, 18));
		companyButton.setBounds(90, 115, 110, 25);
		panel.add(companyButton);
		setForeground(Color.BLACK);
		setBackground(Color.BLACK);
		group = new ButtonGroup();
		group.add(clientButton);
		group.add(companyButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		exitButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		exitButton.setBounds(10, 170, 120, 20);
		exitButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			    System.exit(0);
			  }
			});
		panel.add(exitButton);
		
		JButton nextButton = new JButton("Next");
		nextButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		nextButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		nextButton.setBounds(180, 170, 110, 20);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( companyButton.isSelected() == false && clientButton.isSelected() == false ) {
					JOptionPane.showMessageDialog(panel,
						    "Please select one or fuck off",
						    "Indecisive Error",
						    JOptionPane.ERROR_MESSAGE);
				} 
				else if (companyButton.isSelected() == true){
					companyInterface.companyInterface();
					dispose();
				}
				else if (clientButton.isSelected() == true) {
					clientInterface.clientInterface();
					dispose();
				}
			}
		});
		panel.add(nextButton);
		
	}
	
	public static void main(String[] args) {
		Interface mainInterface = new Interface();
		mainInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainInterface.setSize(315, 250);
		mainInterface.setLocationRelativeTo(null);
		mainInterface.setVisible(true);
	}
}