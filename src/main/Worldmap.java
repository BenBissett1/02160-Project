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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Worldmap {

    public static void main(String[] args) {
        new Worldmap();
    }

    public Worldmap() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = new JFrame("Worldmap of journeys");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Painter());
                frame.pack();
                frame.setSize(1073, 561);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });
    }

    public class Painter extends JPanel {

        private BufferedImage Worldmap;

        public Painter() {
            try {
                Worldmap = ImageIO.read(new File("C:/Users/320/git/02160-Project/Images/WorldMapSimpleSmall.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            Graphics2D g2d = (Graphics2D) g.create();
            if (Worldmap != null) {

                int x = (getWidth() - Worldmap.getWidth()) / 2;
                int y = (getHeight() - Worldmap.getHeight()) / 2;
                g2d.drawImage(Worldmap, x, y, this);
                
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
                
                int[][] allLocations = {Copenhagen, NewYork, Toronto, Edinburgh, Busan, Shenzhen, Shanghai, TanjungPerak, Dubai, LosAngeles, Valencia, Santos, TangerMed, Salalah, CapeTown, Colombo, Comodoro, Christchurch, Perth, Mogadishu};
                
                dataStructure data = new dataStructure();
                Client client = new Client();
                int[] location_initial2;
                int[] location_final2;
                
                
                
                if (client.getID() == -1) {
                	//Do the company side of things
                	
                	Iterator<Integer> itr = data.journeys.keySet().iterator();
            		while(itr.hasNext()) {
            			int i = itr.next();
            			String location_i = data.journeys.get(i).origin;
            			String location_f = data.journeys.get(i).destination;
            			String status = data.journeys.get(i).status;
            			
            			if (location_i.equals("Copenhagen")) location_initial2 = Copenhagen;
            			else if (location_i.equals("New York")) location_initial2 = NewYork;
            			else if (location_i.equals("Toronto")) location_initial2 = Toronto;
            			else if (location_i.equals("Edinburgh")) location_initial2 = Edinburgh;
            			else if (location_i.equals("Busan")) location_initial2 = Busan;
            			else if (location_i.equals("Shenzhen")) location_initial2 = Shenzhen;
            			else if (location_i.equals("Shanghai")) location_initial2 = Shanghai;
            			else if (location_i.equals("Tanjung Perak")) location_initial2 = TanjungPerak;
            			else if (location_i.equals("Dubai")) location_initial2 = Dubai;
            			else if (location_i.equals("Los Angeles")) location_initial2 = LosAngeles;
            			else if (location_i.equals("Valencia")) location_initial2 = Valencia;
            			else if (location_i.equals("Santos")) location_initial2 = Santos;
            			else if (location_i.equals("Tanger Med")) location_initial2 = TangerMed;
            			else if (location_i.equals("Salalah")) location_initial2 = Salalah;
            			else if (location_i.equals("Cape Town")) location_initial2 = CapeTown;
            			else if (location_i.equals("Colombo")) location_initial2 = Colombo;
            			else if (location_i.equals("Comodoro")) location_initial2 = Comodoro;
            			else if (location_i.equals("Christchurch")) location_initial2 = Christchurch;
            			else if (location_i.equals("Perth")) location_initial2 = Perth;
            			else if (location_i.equals("Mogadishu")) location_initial2 = Mogadishu;
            			else break;
            			
            			if (location_f.equals("Copenhagen")) location_final2 = Copenhagen;
            			else if (location_f.equals("New York")) location_final2 = NewYork;
            			else if (location_f.equals("Toronto")) location_final2 = Toronto;
            			else if (location_f.equals("Edinburgh")) location_final2 = Edinburgh;
            			else if (location_f.equals("Busan")) location_final2 = Busan;
            			else if (location_f.equals("Shenzhen")) location_final2 = Shenzhen;
            			else if (location_f.equals("Shanghai")) location_final2 = Shanghai;
            			else if (location_f.equals("Tanjung Perak")) location_final2 = TanjungPerak;
            			else if (location_f.equals("Dubai")) location_final2 = Dubai;
            			else if (location_f.equals("Los Angeles")) location_final2 = LosAngeles;
            			else if (location_f.equals("Valencia")) location_final2 = Valencia;
            			else if (location_f.equals("Santos")) location_final2 = Santos;
            			else if (location_f.equals("Tanger Med")) location_final2 = TangerMed;
            			else if (location_f.equals("Salalah")) location_final2 = Salalah;
            			else if (location_f.equals("Cape Town")) location_final2 = CapeTown;
            			else if (location_f.equals("Colombo")) location_final2 = Colombo;
            			else if (location_f.equals("Comodoro")) location_final2 = Comodoro;
            			else if (location_f.equals("Christchurch")) location_final2 = Christchurch;
            			else if (location_f.equals("Perth")) location_final2 = Perth;
            			else if (location_f.equals("Mogadishu")) location_final2 = Mogadishu;
            			else continue;
            			
            			
            			g2d.setColor(Color.BLACK);
                        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                        g2d.setStroke(dashed);
                        g2d.drawLine(location_initial2[0] + 7, location_initial2[1] + 7, location_final2[0] + 7, location_final2[1] + 7); //+ 7 is half of the rectangle size in order to center it)

                        g2d.setColor(Color.BLACK);
                        g2d.fillRoundRect(location_initial2[0], location_initial2[1], 15, 15, 10, 10);
                        g2d.setColor(Color.RED);
                        g2d.fillRoundRect(location_initial2[0] + 4, location_initial2[1] + 4, 7, 7, 10, 10);
                        g2d.setColor(Color.BLACK);
                        g2d.fillRoundRect(location_final2[0], location_final2[1], 15, 15, 10, 10);
                        g2d.setColor(Color.GREEN);
                        g2d.fillRoundRect(location_final2[0] + 4, location_final2[1] + 4, 7, 7, 10, 10);
                        
                        double slope = ((double) location_final2[1] - (double) location_initial2[1]) / ((double) location_final2[0] - (double) location_initial2[0]);
                        double b = ((double) location_initial2[1] - (slope * (double) location_initial2[0]));
                        
                        
                        Random r = new Random();
                        
                        
                        if (status == "at origin") {
                        	g2d.setColor(Color.BLACK);
                            g2d.fillRoundRect(location_initial2[0], location_initial2[1], 15, 15, 10, 10);
                            g2d.setColor(Color.WHITE);
                            g2d.fillRoundRect(location_initial2[0] + 4, location_initial2[1] + 4, 7, 7, 10, 10);
                        }
                        else if (status == "at destination") {
                        	g2d.setColor(Color.BLACK);
                            g2d.fillRoundRect(location_final2[0], location_final2[1], 15, 15, 10, 10);
                            g2d.setColor(Color.WHITE);
                            g2d.fillRoundRect(location_final2[0] + 4, location_final2[1] + 4, 7, 7, 10, 10);
                        }
                        else if (location_initial2[0] < location_final2[0]) {
                        	double random = r.nextInt(location_final2[0] - location_initial2[0]) + location_initial2[0];
                            double ycoord = random * slope + b;
                            g2d.setColor(Color.BLACK);
                            g2d.fillRoundRect((int) random, (int) ycoord, 15, 15, 10, 10);
                            g2d.setColor(Color.WHITE);
                            g2d.fillRoundRect((int) random + 4, (int) ycoord + 4, 7, 7, 10, 10);
                        } else {
                        	double random = r.nextInt(location_initial2[0] - location_final2[0]) + location_final2[0];
                            double ycoord = random * slope + b;
                            g2d.setColor(Color.BLACK);
                            g2d.fillRoundRect((int) random, (int) ycoord, 15, 15, 10, 10);
                            g2d.setColor(Color.WHITE);
                            g2d.fillRoundRect((int) random + 4, (int) ycoord + 4, 7, 7, 10, 10);
                        }
            			
            			
            			
            			
            		}
                	
                } else {
                	//Do the client side of things
                	
                	List<Integer> in = data.searchJ("" + client.getID(), 4, client.getID());
                	for (int i = 0; i < in.size(); i++) {
                		
                		Iterator<Integer> itr = data.journeys.keySet().iterator();
                		while(itr.hasNext()) {
                			int j = itr.next();
                			
                			if (in.get(i) == j) {
                				String location_i = data.journeys.get(j).origin;
                    			String location_f = data.journeys.get(j).destination;
                    			String status = data.journeys.get(j).status;
                    			
                    			if (location_i.equals("Copenhagen")) location_initial2 = Copenhagen;
                    			else if (location_i.equals("New York")) location_initial2 = NewYork;
                    			else if (location_i.equals("Toronto")) location_initial2 = Toronto;
                    			else if (location_i.equals("Edinburgh")) location_initial2 = Edinburgh;
                    			else if (location_i.equals("Busan")) location_initial2 = Busan;
                    			else if (location_i.equals("Shenzhen")) location_initial2 = Shenzhen;
                    			else if (location_i.equals("Shanghai")) location_initial2 = Shanghai;
                    			else if (location_i.equals("Tanjung Perak")) location_initial2 = TanjungPerak;
                    			else if (location_i.equals("Dubai")) location_initial2 = Dubai;
                    			else if (location_i.equals("Los Angeles")) location_initial2 = LosAngeles;
                    			else if (location_i.equals("Valencia")) location_initial2 = Valencia;
                    			else if (location_i.equals("Santos")) location_initial2 = Santos;
                    			else if (location_i.equals("Tanger Med")) location_initial2 = TangerMed;
                    			else if (location_i.equals("Salalah")) location_initial2 = Salalah;
                    			else if (location_i.equals("Cape Town")) location_initial2 = CapeTown;
                    			else if (location_i.equals("Colombo")) location_initial2 = Colombo;
                    			else if (location_i.equals("Comodoro")) location_initial2 = Comodoro;
                    			else if (location_i.equals("Christchurch")) location_initial2 = Christchurch;
                    			else if (location_i.equals("Perth")) location_initial2 = Perth;
                    			else if (location_i.equals("Mogadishu")) location_initial2 = Mogadishu;
                    			else break;
                    			
                    			if (location_f.equals("Copenhagen")) location_final2 = Copenhagen;
                    			else if (location_f.equals("New York")) location_final2 = NewYork;
                    			else if (location_f.equals("Toronto")) location_final2 = Toronto;
                    			else if (location_f.equals("Edinburgh")) location_final2 = Edinburgh;
                    			else if (location_f.equals("Busan")) location_final2 = Busan;
                    			else if (location_f.equals("Shenzhen")) location_final2 = Shenzhen;
                    			else if (location_f.equals("Shanghai")) location_final2 = Shanghai;
                    			else if (location_f.equals("Tanjung Perak")) location_final2 = TanjungPerak;
                    			else if (location_f.equals("Dubai")) location_final2 = Dubai;
                    			else if (location_f.equals("Los Angeles")) location_final2 = LosAngeles;
                    			else if (location_f.equals("Valencia")) location_final2 = Valencia;
                    			else if (location_f.equals("Santos")) location_final2 = Santos;
                    			else if (location_f.equals("Tanger Med")) location_final2 = TangerMed;
                    			else if (location_f.equals("Salalah")) location_final2 = Salalah;
                    			else if (location_f.equals("Cape Town")) location_final2 = CapeTown;
                    			else if (location_f.equals("Colombo")) location_final2 = Colombo;
                    			else if (location_f.equals("Comodoro")) location_final2 = Comodoro;
                    			else if (location_f.equals("Christchurch")) location_final2 = Christchurch;
                    			else if (location_f.equals("Perth")) location_final2 = Perth;
                    			else if (location_f.equals("Mogadishu")) location_final2 = Mogadishu;
                    			else continue;
                    			
                    			
                    			g2d.setColor(Color.BLACK);
                                Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                                g2d.setStroke(dashed);
                                g2d.drawLine(location_initial2[0] + 7, location_initial2[1] + 7, location_final2[0] + 7, location_final2[1] + 7); //+ 7 is half of the rectangle size in order to center it)

                                g2d.setColor(Color.BLACK);
                                g2d.fillRoundRect(location_initial2[0], location_initial2[1], 15, 15, 10, 10);
                                g2d.setColor(Color.RED);
                                g2d.fillRoundRect(location_initial2[0] + 4, location_initial2[1] + 4, 7, 7, 10, 10);
                                g2d.setColor(Color.BLACK);
                                g2d.fillRoundRect(location_final2[0], location_final2[1], 15, 15, 10, 10);
                                g2d.setColor(Color.GREEN);
                                g2d.fillRoundRect(location_final2[0] + 4, location_final2[1] + 4, 7, 7, 10, 10);
                                
                                double slope = ((double) location_final2[1] - (double) location_initial2[1]) / ((double) location_final2[0] - (double) location_initial2[0]);
                                double b = ((double) location_initial2[1] - (slope * (double) location_initial2[0]));
                                
                                
                                Random r = new Random();
                                
                                
                                if (status == "at origin") {
                                	g2d.setColor(Color.BLACK);
                                    g2d.fillRoundRect(location_initial2[0], location_initial2[1], 15, 15, 10, 10);
                                    g2d.setColor(Color.WHITE);
                                    g2d.fillRoundRect(location_initial2[0] + 4, location_initial2[1] + 4, 7, 7, 10, 10);
                                }
                                else if (status == "at destination") {
                                	g2d.setColor(Color.BLACK);
                                    g2d.fillRoundRect(location_final2[0], location_final2[1], 15, 15, 10, 10);
                                    g2d.setColor(Color.WHITE);
                                    g2d.fillRoundRect(location_final2[0] + 4, location_final2[1] + 4, 7, 7, 10, 10);
                                }
                                else if (location_initial2[0] < location_final2[0]) {
                                	double random = r.nextInt(location_final2[0] - location_initial2[0]) + location_initial2[0];
                                    double ycoord = random * slope + b;
                                    g2d.setColor(Color.BLACK);
                                    g2d.fillRoundRect((int) random, (int) ycoord, 15, 15, 10, 10);
                                    g2d.setColor(Color.WHITE);
                                    g2d.fillRoundRect((int) random + 4, (int) ycoord + 4, 7, 7, 10, 10);
                                } else {
                                	double random = r.nextInt(location_initial2[0] - location_final2[0]) + location_final2[0];
                                    double ycoord = random * slope + b;
                                    g2d.setColor(Color.BLACK);
                                    g2d.fillRoundRect((int) random, (int) ycoord, 15, 15, 10, 10);
                                    g2d.setColor(Color.WHITE);
                                    g2d.fillRoundRect((int) random + 4, (int) ycoord + 4, 7, 7, 10, 10);
                                }
                				
                				
                				
                			} else continue;
                			
                			
                			
                			
                		
                		
                		
                	}
                }
                
                
                
                for(int i = 0; i < allLocations.length - 1; i = i + 2) {
                	int[] location_initial = allLocations[i];
                	int[] location_final = allLocations[i+1];
                	
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
                    if (location_initial[0] < location_final[0]) {
                    	double random = r.nextInt(location_final[0] - location_initial[0]) + location_initial[0];
                        double ycoord = random * slope + b;
                        g2d.setColor(Color.BLACK);
                        g2d.fillRoundRect((int) random, (int) ycoord, 15, 15, 10, 10);
                        g2d.setColor(Color.WHITE);
                        g2d.fillRoundRect((int) random + 4, (int) ycoord + 4, 7, 7, 10, 10);
                    } else {
                    	double random = r.nextInt(location_initial[0] - location_final[0]) + location_final[0];
                        double ycoord = random * slope + b;
                        g2d.setColor(Color.BLACK);
                        g2d.fillRoundRect((int) random, (int) ycoord, 15, 15, 10, 10);
                        g2d.setColor(Color.WHITE);
                        g2d.fillRoundRect((int) random + 4, (int) ycoord + 4, 7, 7, 10, 10);
                    }
                    
                    /*
                    double random = r.nextInt(location_initial[0] - location_final[0]) + location_final[0];
                    double ycoord = random * slope + b;
                    
                    g2d.setColor(Color.BLACK);
                    g2d.fillRoundRect((int) random, (int) ycoord, 15, 15, 10, 10);
                    g2d.setColor(Color.WHITE);
                    g2d.fillRoundRect((int) random + 4, (int) ycoord + 4, 7, 7, 10, 10);
                    */
                	
                }
                
                /*
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
				*/
            }

            g2d.dispose();
        }
    }

}
}