/*==================================
 *=Author : wtarr                  =
 *=                                =
 *=  Title: GuessWord Application  = 
 *=                                =
 *==================================
 */
 
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GuessWordApplication extends JFrame {
	
	private int frameWidth = 650;
	private int frameHeight = 300;
	
	private Toolkit toolkit;
	
	// ================================================================================
	// =============================C O N S T R U C T O R =============================
	// ================================================================================
	public GuessWordApplication() {
			
		GuessWord gw = new GuessWord();
		
        // add our panel, containing the widgets, to the frame
        this.getContentPane().setBackground(Color.LIGHT_GRAY);  
        this.getContentPane().add(gw, BorderLayout.CENTER);
        
	}

	// ================================================================================
	// ==============================  M A I N    M E T H O D =========================
	// ================================================================================
	public static void main(String[] args) {
		
		GuessWordApplication app = new GuessWordApplication();
		app.setVisible(true);
		
	}
	
}