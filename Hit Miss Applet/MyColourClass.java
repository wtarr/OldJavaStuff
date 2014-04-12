/*============================================
 *=Author : wtarr                            =
 *=                                          =
 *=                                          =
 *=  Title: HITS AND MISSES - MyColourClass  = 
 *=                                          =
 *=                                          =          
 *============================================
 */
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyColourClass extends JPanel {
	
	//================V A R I A B L E S =================
	private int height = 30;
	private int width = 30;
	private Color myColor = Color.BLACK; //Default to black
	private Color borderColor = Color.BLACK;
	private Boolean fillIt = false; 
	private Boolean seeIt = true;

	
	//============== S E T T E R ===============
	//A setter method that sets a Color, whether it is filled or not
	//and whether its visible or not
	public void setCircleColor(Color c , Boolean fill, Boolean visible) {
			
			myColor = c;
			
			fillIt = fill;
			
			seeIt = visible;
	}
	//A setter method that allows manual setting of
	//width and height
	public void setWidthHeight(int w, int h){
		
		height = h;
		width = w;
		
		
	}
	
	
	
	
	//============== G E T T E R ================
	public Color getCircleColor(){
		
		return myColor;
		
	}
	
	
		
		
		
	//================== DRAW IT ========================
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // always call the superclass constructor
		setPreferredSize( new Dimension( width, height ) );
		
		// the following example draws a circle inside a box
	
		//The graphic is camoflaged
		if (seeIt == false){
			
			myColor = Color.LIGHT_GRAY;
			borderColor = Color.LIGHT_GRAY;
			setForeground(Color.LIGHT_GRAY);
			
			
		}
		
		
		this.setBackground(Color.LIGHT_GRAY);
		
		g.setColor(Color.LIGHT_GRAY);
		
		g.drawRect(0, 0, width - 1, height - 1);
		
		g.setColor(myColor); //Fill colour
						
		if (fillIt == true){
		//Then fill the circle
		g.fillOval(2, 2, width - 4, height - 4);
		
		}
		
		g.setColor(borderColor); //BorderColor
		//Draw the oval outline
		g.drawOval(2, 2, width - 4, height - 4);
		
		
	
	
		

		
	}
	
	
	
	
	
}
	
	