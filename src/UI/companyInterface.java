package UI;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.Client;
import main.dataStructure;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.ComponentOrientation;

class companyInterface extends JFrame {
	private ButtonGroup group;
	private JPanel panel;
	private JTextField txtinit;
    private BufferedImage Worldmap;
	
	public companyInterface() {
		super("Company Interface");
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setAlwaysOnTop(true);
		setFont(new Font("Times New Roman", Font.BOLD, 20));
		setResizable(false);
		setType(Type.NORMAL);
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
		
		JPanel headerPanel = new JPanel();
		headerPanel.setForeground(SystemColor.desktop);
		headerPanel.setBackground(SystemColor.desktop);
		headerPanel.setBounds(0, 0, 600, 50);
		panel.add(headerPanel);
		
		JLabel companyHeaderLabel = new JLabel("Company Interface");
		companyHeaderLabel.setForeground(SystemColor.controlShadow);
		companyHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		headerPanel.add(companyHeaderLabel);
		
		JPanel clientManagePanel = new JPanel();
		clientManagePanel.setBorder(null);
		clientManagePanel.setBackground(Color.BLACK);
		clientManagePanel.setBounds(0, 50, 600, 620);
		panel.add(clientManagePanel);
		clientManagePanel.setLayout(null);
		
		JLabel containerStatusLabel = new JLabel("Container Status");
		containerStatusLabel.setForeground(SystemColor.controlShadow);
		containerStatusLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		containerStatusLabel.setBounds(425, 25, 134, 20);
		clientManagePanel.add(containerStatusLabel);
		
		JLabel clientManageLabel = new JLabel("Client Management");
		clientManageLabel.setBounds(21, 25, 157, 20);
		clientManageLabel.setForeground(SystemColor.controlShadow);
		clientManageLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		clientManagePanel.add(clientManageLabel);
		
		JLabel journeyManageLabel = new JLabel("Journey Management");
		journeyManageLabel.setForeground(SystemColor.controlShadow);
		journeyManageLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		journeyManageLabel.setBounds(212, 25, 175, 20);
		clientManagePanel.add(journeyManageLabel);
		
		JButton regNewClientButton = new JButton("Register a New Client");
		regNewClientButton.setBounds(25, 70, 150, 25);
		regNewClientButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		regNewClientButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		regNewClientButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				companyCreateClient.companyCreateClient();		
			}
		});
		clientManagePanel.add(regNewClientButton);
		
		JButton searchClientButton = new JButton("Search for a Client");
		searchClientButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		searchClientButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		searchClientButton.setBounds(25, 120, 150, 25);
		searchClientButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				companySearchClient.companySearchClient();		
			}
		});
		clientManagePanel.add(searchClientButton);
		
		JButton seeAllCurrentButton = new JButton("View All Ongoing");
		seeAllCurrentButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		seeAllCurrentButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		seeAllCurrentButton.setBounds(425, 120, 150, 25);
		seeAllCurrentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String clients = (dataStructure.allClients()).stream().map(Object::toString)
						.collect(Collectors.joining(", "));
				String journeys = (dataStructure.allJourneys()).stream().map(Object::toString)
						.collect(Collectors.joining(", "));
				JOptionPane.showMessageDialog(panel,
						"\n" + "Clients: " + clients + "\n" + "Journeys: " + journeys,
						"All Ongoing Clients and Journeys",
						JOptionPane.INFORMATION_MESSAGE);
				}
		});
		clientManagePanel.add(seeAllCurrentButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		exitButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
		exitButton.setBounds(226, 540, 150, 25);
		exitButton.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
			    System.exit(0);
			  }
			});
		clientManagePanel.add(exitButton);
		
		JButton updateJourneyButton = new JButton("Update a Journey");
		updateJourneyButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		updateJourneyButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		updateJourneyButton.setBounds(226, 70, 150, 25);
		updateJourneyButton.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
			    companyUpdateJourney.companyUpdateJourney();
			    dispose();
			  }
			});
		clientManagePanel.add(updateJourneyButton);
		
		JButton searchJourneyButton = new JButton("Search for a Journey");
		searchJourneyButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		searchJourneyButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		searchJourneyButton.setBounds(226, 120, 150, 25);
		searchJourneyButton.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
			    companySearchJourney.companySearchJourney();
			    dispose();
			  }
			});
		clientManagePanel.add(searchJourneyButton);
		
		JButton updateContainerStatusButton = new JButton("Update Status");
		updateContainerStatusButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		updateContainerStatusButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		updateContainerStatusButton.setBounds(426, 70, 150, 25);
		updateContainerStatusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataStructure.save();
				companyUpdateStatus.companyUpdateStatus();		
			}
		});
		clientManagePanel.add(updateContainerStatusButton);
		
		Painter paintedPanel = new Painter();
		paintedPanel.setOpaque(true);
		paintedPanel.setBounds(0, 175, 595, 335);
		clientManagePanel.add(paintedPanel);

	}

	public static void companyInterface() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
			companyInterface cmpInterface = new companyInterface();
			cmpInterface.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			cmpInterface.setSize(600, 670);
			cmpInterface.setLocationRelativeTo(null);
			cmpInterface.setVisible(true);
			}
		});
	}
}

class Painter extends JPanel {

    private BufferedImage Worldmap;

    public Painter() {
        try {
            Worldmap = ImageIO.read(new File("C:/Users/320/git/02160-Project/Images/grayscale-vector-worldmap.jpg"));
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
        			String location_i = data.journeys.get(i).getOrigin();
        			String location_f = data.journeys.get(i).getDestination();
        			String status = data.journeys.get(i).getStatus();
        			
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
            				String location_i = data.journeys.get(j).getOrigin();
                			String location_f = data.journeys.get(j).getDestination();
                			String status = data.journeys.get(j).getStatus();
                			
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
            }
            }
        }
    }
}

