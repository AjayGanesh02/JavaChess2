//Window Imports
import java.awt.*;
import javax.swing.*;

public class Game {

	private static void createWindow() {
		//Create and set up the window.
		JFrame frame = new JFrame("Java Chess"); 
		
		//terminates application when window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Adds a label to the window
		JLabel textLabel = new JLabel("Welcome to Java Chess, by Ajay Ganesh",SwingConstants.CENTER); 
		textLabel.setPreferredSize(new Dimension(300, 100)); 
		frame.getContentPane().add(textLabel, BorderLayout.CENTER); 
		
		//Display the window
		frame.setLocationRelativeTo(null); 
		frame.pack(); 
		frame.setVisible(true); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createWindow();
	}

}
