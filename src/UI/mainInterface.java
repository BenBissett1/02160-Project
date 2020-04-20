package UI;
import javax.swing.*;

import main.Database;

public class mainInterface extends JFrame{	
	
	public static void main(String[] args) {
		Database.loadC();
		Database.loadJ();
		initInterface.initInterface();
	}
}