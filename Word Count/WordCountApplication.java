import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class WordCountApplication extends JFrame {
	
	private int frameWidth = 875;
	private int frameHeight = 375;
	
	private Toolkit toolkit;
	
	// ================================================================================
	// constructor
	// ================================================================================
	public WordCountApplication() {
			
		WordCount wc1 = new WordCount();
		
        // add our panel, containing the widgets, to the frame
        this.getContentPane().setBackground(Color.LIGHT_GRAY);  
        this.getContentPane().add(wc1, BorderLayout.CENTER);
        
	}

	// ================================================================================
	// main method
	// ================================================================================
	public static void main(String[] args) {
		
		WordCountApplication app = new WordCountApplication();
		app.setVisible(true);
		
	}
	
}