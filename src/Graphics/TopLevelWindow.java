package Graphics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*; 

import program.Program;

public class TopLevelWindow {
	
	public static JFrame frame = new JFrame("Find songs");;

	public static void createWindow() {

		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 frame.setLocationRelativeTo(null); 	 
		 frame.setSize(700,300);
		 
		 JPanel panel = new JPanel(new GridBagLayout());
		 frame.add(panel);
		 GridBagConstraints c = new GridBagConstraints();
		 
		 // Label
		 JLabel textLabel = new JLabel("<html>1. Enter songs you want to find, each song on a separate line <br>"
		 		+ "2. Be descriptive - artist name + song on each line <br>"
		 		+ "3. Press button</html>"); 
		 c.gridy = 0;
		 c.insets = new Insets(20,20,20,20);
		 panel.add(textLabel, c); 
		 textLabel.setVisible(true);
		 
		 // Disclaimer
		 JLabel disclaimer = new JLabel("<html> Disclaimer: The user is responsible for searching only for royalty free music.  <br>"
		 		+ "This software is meant as a Selenium learning experience. <br>"
				+ "The creator is not responsible for how it will be used.</html>");
		 c.gridy = 1;
		 panel.add(disclaimer, c); 
		 disclaimer.setVisible(true);
		 
		 // Text field for input with scroll
		 final JTextArea textField = new JTextArea(10, 30);	
		 final JScrollPane scroll = new JScrollPane(textField);
		 c.gridy = 2;
		 panel.add(scroll,c );
		 
		 // Button to start download
		 JButton buttonFind = new JButton(); 
		 c.gridy = 3;
		 buttonFind.setText("Find songs");	 
		 panel.add(buttonFind, c);
		 buttonFind.setVisible(true);
		 
		 frame.pack();
		 
		 buttonFind.addActionListener( new ActionListener()
		 {
		     @Override
		     public void actionPerformed(ActionEvent e)
		     {
		         try {	        
		        	// If no songs entered, warn the user and do nothing
		        	if (textField.getText().isEmpty() ){
		        		JOptionPane.showMessageDialog(null, "Please enter song names", "Alert", JOptionPane.ERROR_MESSAGE);
		        	} else{
		        	// If songs entered, download them
		        		program.Program.songsList = GetInput(textField);
		        		Program.downloadVideos();
		        	}					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		     }
		 });
		 
		 frame.setContentPane(panel);
		 frame.setVisible(true); 
	 } 
	 
	 public static void CloseWindow(JFrame frame){
		 frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	 }
	 
	 public static ArrayList<String> GetInput(JTextArea textField){
		 String input[] = textField.getText().split("\\r?\\n");
		 ArrayList<String> arrList = new ArrayList<String>(Arrays.asList(input)) ;
		 return arrList;
	 }
}
