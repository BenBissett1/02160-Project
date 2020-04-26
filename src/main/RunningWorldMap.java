package main;

public class RunningWorldMap implements Runnable {
	
	GUIWorldMap gui = new GUIWorldMap();
	
	public static void main(String[] args) {
		//This will create a new thread creating a main method and running the run method
		new Thread(new RunningWorldMap()).start();
	}
	@Override
	public void run() {
		while (true) {
			gui.repaint();
		}
	}
	
}
