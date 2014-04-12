/*============================================
 *=Author : wtarr                            =
 *=                                          =
 *=                                          =
 *=  Title: HITS AND MISSES - Application  = 
 *=                                          =
 *=                                          =
 *============================================
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class HitMissApplication extends JFrame {
	
	private int frameWidth = 875;
	private int frameHeight = 375;
	
	private Toolkit toolkit;
	
	// ================================================================================
	// constructor
	// ================================================================================
	public HitMissApplication() {
			
		HitMiss HM = new HitMiss();
		
        // add our panel, containing the widgets, to the frame
        this.getContentPane().setBackground(Color.LIGHT_GRAY);  
        this.getContentPane().add(HM, BorderLayout.CENTER);
        
	}

	// ================================================================================
	// main method
	// ================================================================================
	public static void main(String[] args) {
		
		HitMissApplication app = new HitMissApplication();
		app.setVisible(true);
		
	}
	
}