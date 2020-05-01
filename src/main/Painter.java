package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Painter extends JPanel {

    private BufferedImage Worldmap;
    private int genUser;

    public Painter(int genUser) {
        try {
            Worldmap = ImageIO.read(new File("Images/grayscale-vector-worldmap.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        Graphics2D g2d = (Graphics2D) g.create();
        if (Worldmap != null) {
        	
            g2d.drawImage(Worldmap, 0, 0, this);
            
            //g2d.setColor(Color.MAGENTA);
            //g2d.fillRoundRect(620, 330, 20, 20, 10, 10);
            
            int[] Copenhagen = {300, 92};
            int[] NewYork = {167, 122};
            int[] Toronto = {145, 110};
            int[] Edinburgh = {276, 91};
            int[] Busan = {483, 134};
            int[] Shenzhen = {458, 156};
            int[] Shanghai = {471, 143};
            int[] TanjungPerak = {456, 206};
            int[] Dubai = {368, 151};
            int[] LosAngeles = {91, 135};
            int[] Valencia = {282, 126};
            int[] Santos = {208, 233};
            int[] TangerMed = {271, 133};
            int[] Salalah = {371, 163};
            int[] CapeTown = {309, 250};
            int[] Colombo = {406, 181};
            int[] Comodoro = {174, 273};
            int[] Christchurch = {532, 270};
            int[] Perth = {460, 247};
            int[] Mogadishu = {359, 182};
            
            //int[][] allLocations = {Copenhagen, NewYork, Toronto, Edinburgh, Busan, Shenzhen, Shanghai, TanjungPerak, Dubai, LosAngeles, Valencia, Santos, TangerMed, Salalah, CapeTown, Colombo, Comodoro, Christchurch, Perth, Mogadishu};
            	
            int[] location_initial2;
            int[] location_final2;
            
            if (dataStructure.clients.isEmpty() || genUser == 0) {
            	//Do the company side of things
            	
            	Iterator<Integer> itr = dataStructure.journeys.keySet().iterator();
        		while(itr.hasNext()) {
        			int i = itr.next();
        			String location_i = dataStructure.journeys.get(i).getOrigin();
        			String location_f = dataStructure.journeys.get(i).getDestination();
        			String status = dataStructure.journeys.get(i).getStatus();
        			
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
                    
                    
                    if (status.equals("Origin")) {
                    	g2d.setColor(Color.BLACK);
                        g2d.fillRoundRect(location_initial2[0], location_initial2[1], 15, 15, 10, 10);
                        g2d.setColor(Color.WHITE);
                        g2d.fillRoundRect(location_initial2[0] + 4, location_initial2[1] + 4, 7, 7, 10, 10);
                    }
                    else if (status.equals("Destination")) {
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
            	Client C = dataStructure.clients.get(genUser);
            	
            	List<Integer> in = dataStructure.searchJ("" + C.getID(), 4, C.getID());
            	for (int i = 0; i < in.size(); i++) {
            		
            		Iterator<Integer> itr = dataStructure.journeys.keySet().iterator();
            		while(itr.hasNext()) {
            			int j = itr.next();
            			
            			if (in.get(i) == j) {
            				String location_i = dataStructure.journeys.get(j).getOrigin();
                			String location_f = dataStructure.journeys.get(j).getDestination();
                			String status = dataStructure.journeys.get(j).getStatus();
                			
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
                			
                			
                			g2d.setColor(Color.blue);
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
                            
                            
                            if (status.equals("Origin")) {
                            	g2d.setColor(Color.BLACK);
                                g2d.fillRoundRect(location_initial2[0], location_initial2[1], 15, 15, 10, 10);
                                g2d.setColor(Color.WHITE);
                                g2d.fillRoundRect(location_initial2[0] + 4, location_initial2[1] + 4, 7, 7, 10, 10);
                            }
                            else if (status.equals("Destination")) {
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
            
            
            
//            for(int i = 0; i < allLocations.length - 1; i = i + 2) {
//            	int[] location_initial = allLocations[i];
//            	int[] location_final = allLocations[i+1];
//            	
//            	g2d.setColor(Color.BLACK);
//                Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
//                g2d.setStroke(dashed);
//                g2d.drawLine(location_initial[0] + 7, location_initial[1] + 7, location_final[0] + 7, location_final[1] + 7); //+ 7 is half of the rectangle size in order to center it)
//
//                g2d.setColor(Color.BLACK);
//                g2d.fillRoundRect(location_initial[0], location_initial[1], 15, 15, 10, 10);
//                g2d.setColor(Color.RED);
//                g2d.fillRoundRect(location_initial[0] + 4, location_initial[1] + 4, 7, 7, 10, 10);
//                g2d.setColor(Color.BLACK);
//                g2d.fillRoundRect(location_final[0], location_final[1], 15, 15, 10, 10);
//                g2d.setColor(Color.GREEN);
//                g2d.fillRoundRect(location_final[0] + 4, location_final[1] + 4, 7, 7, 10, 10);
//                
//                double slope = ((double) location_final[1] - (double) location_initial[1]) / ((double) location_final[0] - (double) location_initial[0]);
//                double b = ((double) location_initial[1] - (slope * (double) location_initial[0]));
//                
//                
//                Random r = new Random();
//                if (location_initial[0] < location_final[0]) {
//                	double random = r.nextInt(location_final[0] - location_initial[0]) + location_initial[0];
//                    double ycoord = random * slope + b;
//                    g2d.setColor(Color.BLACK);
//                    g2d.fillRoundRect((int) random, (int) ycoord, 15, 15, 10, 10);
//                    g2d.setColor(Color.WHITE);
//                    g2d.fillRoundRect((int) random + 4, (int) ycoord + 4, 7, 7, 10, 10);
//                } else {
//                	double random = r.nextInt(location_initial[0] - location_final[0]) + location_final[0];
//                    double ycoord = random * slope + b;
//                    g2d.setColor(Color.BLACK);
//                    g2d.fillRoundRect((int) random, (int) ycoord, 15, 15, 10, 10);
//                    g2d.setColor(Color.WHITE);
//                    g2d.fillRoundRect((int) random + 4, (int) ycoord + 4, 7, 7, 10, 10);
//                }
//            }
            }
        }
    }
}

