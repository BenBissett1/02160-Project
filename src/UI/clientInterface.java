package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.Database;

import javax.swing.JLabel;
import javax.swing.JButton;

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
		setType(Type.NORMAL);
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
		
		JPanel clientManagePanel = new JPanel();
		clientManagePanel.setBackground(SystemColor.desktop);
		clientManagePanel.setBounds(0, 50, 200, 620);
		panel.add(clientManagePanel);
		
		JPanel journeyManagePanel = new JPanel();
		journeyManagePanel.setBackground(SystemColor.desktop);
		journeyManagePanel.setBounds(200, 50, 200, 620);
		panel.add(journeyManagePanel);
		journeyManagePanel.setLayout(null);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(60, 530, 80, 25);
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		exitButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		exitButton.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
				Database.saveC();
				Database.saveJ();
			    System.exit(0);
			  }
			});
		journeyManagePanel.add(exitButton);
		
		JPanel containerStatusPanel = new JPanel();
		containerStatusPanel.setBackground(SystemColor.desktop);
		containerStatusPanel.setBounds(400, 50, 200, 620);
		panel.add(containerStatusPanel);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(SystemColor.desktop);
		headerPanel.setBounds(0, 0, 600, 50);
		panel.add(headerPanel);
		
		JLabel clientHeaderLabel = new JLabel("Client Interface");
		clientHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		clientHeaderLabel.setForeground(SystemColor.controlShadow);
		headerPanel.add(clientHeaderLabel);
	}

	public static void clientInterface() {
		clientInterface cltInterface = new clientInterface();
		cltInterface.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cltInterface.setSize(600, 670);
		cltInterface.setLocationRelativeTo(null);
		cltInterface.setVisible(true);
	}
}