import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class tester {
	
	final static int WINDOW_HEIGHT = 1000;
	final static int WINDOW_WIDTH = 1000;
	
	public static void main(String[] args) {
		
		Map m = new Map();
		
		JFrame frame = new JFrame("Map"); 
		frame.setSize(WINDOW_WIDTH + 15, WINDOW_HEIGHT + 40);
		frame.setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DrawPanel disp = new DrawPanel(WINDOW_HEIGHT, WINDOW_WIDTH);
		disp.setMap(m);

		frame.add(disp);
		
		frame.setVisible(true);
		
	}
}
