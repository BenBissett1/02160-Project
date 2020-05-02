package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.Painter;
import main.dataStructure;

import java.awt.SystemColor;

public class clientContainerMap extends JFrame {
	public clientContainerMap(int genUser) {
		super("Client Container Map");
		setSize(new Dimension(595,425));
		setLocationByPlatform(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setAlwaysOnTop(true);
		setFont(new Font("Times New Roman", Font.BOLD, 20));
		setResizable(false);
		setType(Type.POPUP);
		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setForeground(SystemColor.desktop);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		Painter paintedPanel = new Painter(genUser);
		paintedPanel.setOpaque(true);
		paintedPanel.setBounds(0, 0, 595, 335);
		panel.add(paintedPanel);
		
		JButton clientCreateBack = new JButton("Back");
		clientCreateBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		clientCreateBack.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		clientCreateBack.setBounds(225, 350, 130, 25);
		clientCreateBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				dispose();				
			}
		});
		panel.add(clientCreateBack);
	}

	public static void clientContainerMap(int genUser) {
		clientContainerMap cltCntMap = new clientContainerMap(genUser);
		cltCntMap.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cltCntMap.setSize(595, 425);
		cltCntMap.setLocationRelativeTo(null);
		cltCntMap.setVisible(true);
	}
}
