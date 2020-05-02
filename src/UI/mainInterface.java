package UI;
import javax.swing.*;

import main.dataStructure;

public class mainInterface extends JFrame{	
	public static void main(String[] args) {
		dataStructure.load();
		dataStructure.save();
		dataStructure.load();
		initInterface.initInterface();
	}
}