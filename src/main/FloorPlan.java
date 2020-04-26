package main;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FloorPlan {

    public static void main(String[] args) {
        new FloorPlan();
    }

    public FloorPlan() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage floorPlan;

        //private Rectangle myOffice = new Rectangle(150, 50, 32, 27);

        public TestPane() {
            try {
                floorPlan = ImageIO.read(new File("C:/Users/bruger/git/02160-Project/Images/WorldMapSimpleSmall.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return floorPlan == null ? new Dimension(200, 200) : new Dimension(floorPlan.getWidth(), floorPlan.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            Graphics2D g2d = (Graphics2D) g.create();
            if (floorPlan != null) {

                int x = (getWidth() - floorPlan.getWidth()) / 2;
                int y = (getHeight() - floorPlan.getHeight()) / 2;
                g2d.drawImage(floorPlan, x, y, this);
                
                
                //g2d.setColor(Color.MAGENTA);
                //g2d.fillRoundRect(620, 330, 20, 20, 10, 10);
                
                
                
                
                int[] Copenhagen = {530, 148};
                int[] NewYork = {275, 210};
                int[] Toronto = {250, 190};
                int[] Edinburgh = {470, 150};
                int[] Busan = {870, 225};
                int[] Shenzhen = {830, 265};
                int[] Shanghai = {840, 245};
                int[] TanjungPerak = {800, 350};
                int[] Dubai = {655, 260};
                int[] LosAngeles = {145, 230};
                int[] Valencia = {495, 205};
                int[] Santos = {370, 400};
                int[] TangerMed = {480, 222};
                int[] Salalah = {655, 280};
                int[] CapeTown = {550, 440};
                int[] Colombo = {730, 310};
                int[] Comodoro = {300, 475};
                int[] Christchurch = {995, 475};
                int[] Perth = {830, 430};
                int[] Mogadishu = {620, 330};
                
                int[] location_initial = Copenhagen;
                int[] location_final = NewYork;
                
                
                g2d.setColor(Color.BLACK);
                Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                g2d.setStroke(dashed);
                g2d.drawLine(location_initial[0] + 7, location_initial[1] + 7, location_final[0] + 7, location_final[1] + 7); //+ 7 is half of the rectangle size in order to center it)

                g2d.setColor(Color.BLACK);
                g2d.fillRoundRect(location_initial[0], location_initial[1], 15, 15, 10, 10);
                g2d.setColor(Color.RED);
                g2d.fillRoundRect(location_initial[0] + 4, location_initial[1] + 4, 7, 7, 10, 10);
                g2d.setColor(Color.BLACK);
                g2d.fillRoundRect(location_final[0], location_final[1], 15, 15, 10, 10);
                g2d.setColor(Color.GREEN);
                g2d.fillRoundRect(location_final[0] + 4, location_final[1] + 4, 7, 7, 10, 10);
                
                double slope = ((double) location_final[1] - (double) location_initial[1]) / ((double) location_final[0] - (double) location_initial[0]);
                double b = ((double) location_initial[1] - (slope * (double) location_initial[0]));
                
                Random r = new Random();
                double random = r.nextInt(location_initial[0] - location_final[0]) + location_final[0];
                double ycoord = random * slope + b;
                
                g2d.setColor(Color.BLACK);
                g2d.fillRoundRect((int) random, (int) ycoord, 15, 15, 10, 10);
                g2d.setColor(Color.WHITE);
                g2d.fillRoundRect((int) random + 4, (int) ycoord + 4, 7, 7, 10, 10);
                
                
                

            }

            g2d.dispose();
        }
    }

}