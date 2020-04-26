package main;

import javax.swing.*;
import java.util.*;
import java.awt.*;

public class GUIWorldMap extends JFrame {
	
	
	
	
	
	public GUIWorldMap() {
		this.setTitle("World map");
		this.setSize(938, 588); //measured in pixels
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Whenever we click x button, it will be terminated
		this.setVisible(true);
		this.setLocation(65, 307);
		this.setResizable(false);
		
		
		
		//ImageIcon icon = new ImageIcon("C:/Users/bruger/git/02160-Project/Images/WorldMapPicture.jpg");
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("C:/Users/bruger/git/02160-Project/Images/WorldMapPicture.jpg"));
		this.add(label);
		
		Board board = new Board();
		this.setContentPane(board);
		
		
		
	}
	public static void main (String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUIWorldMap();
            }
        });
    }
	
	public class Board extends JPanel {
		
		
		//0, 7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91, 98, 105, 112, 119, 126, 133, 140, 147, 154, 161, 168, 175, 182, 189, 196, 203, 210, 217, 224, 231, 238, 245, 252, 259, 266, 273, 280
		@Override
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			double slope = (210 - 148) / (275 - 530);
            System.out.println(slope);
            double hi = 3.0 / 9.0;
            System.out.println(hi);
			
			
			//This will display all stuff inside it
			g.setColor(Color.black);
			
			for (int i = 126; i < 230; i = i + 7) {
				g.fillRoundRect(i, 0, 5, 5, 10, 10);
				g.fillRoundRect(0, i, 5, 5, 10, 10);
			}
			
			for (int i = 126; i < 230; i = i + 7) {
				for (int j = 91; j < 200; j = j + 7) {
					g.fillRoundRect(i, j, 5, 5, 10, 10);
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			g.setColor(Color.red);
			g.fillRoundRect(224, 203, 5, 5, 10, 10);
			g.fillRoundRect(224, 210, 5, 5, 10, 10);
			g.fillRoundRect(224, 217, 5, 5, 10, 10);
			g.fillRoundRect(224, 224, 5, 5, 10, 10);
			g.fillRoundRect(217, 203, 5, 5, 10, 10);
			g.fillRoundRect(217, 210, 5, 5, 10, 10);
			g.fillRoundRect(217, 217, 5, 5, 10, 10);
			g.fillRoundRect(210, 203, 5, 5, 10, 10);
			g.fillRoundRect(203, 203, 5, 5, 10, 10);
			g.fillRoundRect(196, 203, 5, 5, 10, 10);
			g.fillRoundRect(189, 203, 5, 5, 10, 10);
			g.fillRoundRect(196, 210, 5, 5, 10, 10);
			g.fillRoundRect(189, 210, 5, 5, 10, 10);
			g.fillRoundRect(182, 203, 5, 5, 10, 10);
			g.fillRoundRect(175, 203, 5, 5, 10, 10);
			
			g.fillRoundRect(168, 203, 5, 5, 10, 10);
			g.fillRoundRect(161, 203, 5, 5, 10, 10);
			g.fillRoundRect(154, 203, 5, 5, 10, 10);
			g.fillRoundRect(147, 203, 5, 5, 10, 10);
			g.fillRoundRect(140, 203, 5, 5, 10, 10);
			g.fillRoundRect(133, 203, 5, 5, 10, 10);
			g.fillRoundRect(126, 203, 5, 5, 10, 10);
			g.fillRoundRect(119, 203, 5, 5, 10, 10);
			g.fillRoundRect(112, 203, 5, 5, 10, 10);
			
			g.fillRoundRect(119, 210, 5, 5, 10, 10);
			g.fillRoundRect(119, 217, 5, 5, 10, 10);
			g.fillRoundRect(119, 224, 5, 5, 10, 10);
			g.fillRoundRect(112, 217, 5, 5, 10, 10);
			g.fillRoundRect(126, 224, 5, 5, 10, 10);
			g.fillRoundRect(126, 231, 5, 5, 10, 10);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
	}
	
	
}
