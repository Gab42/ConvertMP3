package Graphics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*; 

import program.Program;

public class TopLevelWindow {
	
	public static JFrame frame = new JFrame("Test");;

	public static void createWindow() {

		 frame.setLayout(new BorderLayout());
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 frame.setLocationRelativeTo(null); 	 
		 frame.setSize(700,300);
		 
		 JPanel panel = new JPanel(new GridBagLayout());
		 GridBagConstraints c = new GridBagConstraints();
		 
		 // Label
		 JLabel textLabel = new JLabel("Click button to start song download"); 
		 panel.add(textLabel, c); 
		 textLabel.setVisible(true);
		 
		 // Button to start download
		 JButton buttonGo = new JButton(); 
		 buttonGo.setText("Start download");	 
		 panel.add(buttonGo, c);
		 buttonGo.setVisible(true);
		 
		 buttonGo.addActionListener( new ActionListener()
		 {
		     @Override
		     public void actionPerformed(ActionEvent e)
		     {
		         System.out.println("Do Something Clicked");
		         try {
					Program.downloadVideos();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		     }
		 });
		 
		 frame.setContentPane(panel);
		 //frame.pack();
		 frame.setVisible(true); 
	 } 
	 
	 public static void CloseWindow(JFrame frame){
		 frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	 }
}
