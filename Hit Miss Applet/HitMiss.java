/*============================
 *=Author : wtarr            =
 *=                          =
 *=                          =
 *=  Title: HITS AND MISSES  = 
 *=                          =
 *=                          =
 *============================
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class HitMiss extends JPanel implements ActionListener{
	
	
	// ==================V A R I A B L E S ==========================
	// use these dimensions for the width and height of the form
	private int frameWidth = 620;
	private int frameHeight = 500;
	
	private String title = "Hit and Miss";
	// class wide components
	private Toolkit toolkit;
	
	private Color[] theColour = new Color[5]; //The color choices
	private Color[] GuessThis = new Color[3]; //The programs choice
	
	//My choice of color
	private Color myColourChoice; 
			
	//The color buttons
	private JButton red = new JButton("Red");
	private JButton blue = new JButton("Blue");
	private JButton green = new JButton("Green");
	private JButton yellow = new JButton("Yellow");
	private JButton black = new JButton("Black");
	
	//Circle objects for Guess1
	MyColourClass a1 = new MyColourClass();
	MyColourClass a2 = new MyColourClass();
	MyColourClass a3 = new MyColourClass();
	//Circle objects for Guess2
	MyColourClass b1 = new MyColourClass();
	MyColourClass b2 = new MyColourClass();
	MyColourClass b3 = new MyColourClass();
	//Circle objects for Guess3
	MyColourClass c1 = new MyColourClass();
	MyColourClass c2 = new MyColourClass();
	MyColourClass c3 = new MyColourClass();
	//Circle objects for Guess4
	MyColourClass d1 = new MyColourClass();
	MyColourClass d2 = new MyColourClass();
	MyColourClass d3 = new MyColourClass();
	//Circle objects for Guess5
	MyColourClass e1 = new MyColourClass();
	MyColourClass e2 = new MyColourClass();
	MyColourClass e3 = new MyColourClass();
	//Circle objects for Guess6
	MyColourClass f1 = new MyColourClass();
	MyColourClass f2 = new MyColourClass();
	MyColourClass f3 = new MyColourClass();
	
	//The circles that will hold the actual answer
	MyColourClass p1 = new MyColourClass();
	MyColourClass p2 = new MyColourClass();
	MyColourClass p3 = new MyColourClass();
	
	JPanel p2b4 = new JPanel(new BorderLayout()); //Panel holding Guess 2nd label
	JPanel p2c4 = new JPanel(new BorderLayout()); //Panel holding Guess 3rd label 
	JPanel p2d4 = new JPanel(new BorderLayout()); //Panel holding Guess 4th label	
	JPanel p2e4 = new JPanel(new BorderLayout()); //Panel holding Guess 5th label
	JPanel p2f4 = new JPanel(new BorderLayout()); //Panel holding Guess 6th label
	
	//Panels for 2nd Guess circles 
	JPanel p2b1 = new JPanel(new GridLayout(1, 1));//b1
	JPanel p2b2 = new JPanel(new GridLayout(1, 1));//b2
	JPanel p2b3 = new JPanel(new GridLayout(1, 1));//b3
	//Panels for 3rd Guess circles
	JPanel p2c1 = new JPanel(new GridLayout(1, 1));//c1
	JPanel p2c2 = new JPanel(new GridLayout(1, 1));//c2
	JPanel p2c3 = new JPanel(new GridLayout(1, 1));//c3
	//Panels for 4th Guess circles
	JPanel p2d1 = new JPanel(new GridLayout(1, 1));//d1
	JPanel p2d2 = new JPanel(new GridLayout(1, 1));//d2
	JPanel p2d3 = new JPanel(new GridLayout(1, 1));//d3
	//Panels for 5th Guess circles
	JPanel p2e1 = new JPanel(new GridLayout(1, 1));//e1
	JPanel p2e2 = new JPanel(new GridLayout(1, 1));//e2
	JPanel p2e3 = new JPanel(new GridLayout(1, 1));//e3
	//Panels for 6th Guess circles
	JPanel p2f1 = new JPanel(new GridLayout(1, 1));//f1
	JPanel p2f2 = new JPanel(new GridLayout(1, 1));//f2
	JPanel p2f3 = new JPanel(new GridLayout(1, 1));//f3
		
	//ClickCounter
	private int clickCounter = 0;
	
	//Number of Guesses
	private int numberOfHits = 0;
	
	//Access Counter
	private int accessCounter = -1;
	
	//The user prompt label (Will change to you WIN/LOSE)
	private JLabel userPrompt = new JLabel("Guess the hidden code");
		
	//Access array 
	//This is for allowing access to the next guess if required
	private boolean[] access = new boolean[5];
	
	

	
	//===================C O N S T R U C T O R ============================ 
	public HitMiss() {
		
	   super (new FlowLayout	());
      this.setBackground(Color.LIGHT_GRAY);
      this.add(this.createPanel());
   
		
		
		//Apply Listener and ToolTip to the buttons
     	red.addActionListener(this);
	 	red.setToolTipText("Red"); 
	 	blue.addActionListener(this);
	 	blue.setToolTipText("Blue");
	 	green.addActionListener(this);
	 	green.setToolTipText("Green");
	 	yellow.addActionListener(this);
	 	yellow.setToolTipText("Yellow");
	 	black.addActionListener(this);
	 	black.setToolTipText("Black");	
		
		//The choice of colors available
		theColour[0] = Color.RED;
		theColour[1] = Color.BLUE;
		theColour[2] = Color.GREEN;
		theColour[3] = Color.YELLOW;
		theColour[4] = Color.BLACK;
		
		//Assign the programs guesses to the GuessThis Array
		GuessThis[0] = this.theColour[randomNum()];
		GuessThis[1] = this.theColour[randomNum()];
		GuessThis[2] = this.theColour[randomNum()];
		
		//Initalise the the access array
		access[0] = false;
		access[1] = false;
		access[2] = false;
		access[3] = false;
		access[4] = false;
		
		
		//**************
		//Cheater/Tester
		//**************
		
		//cheat();
		
		//**************
		
		
							
	
	  // add our panel, containing the widgets, to the frame
     // this.getContentPane().add(this.createPanel(), BorderLayout.CENTER);



        this.repaint();
        
                
	} // end of constructor
	
 		//=======================The Panels=======================
 		
		public JPanel createPanel(){ 
			
		//Programmers discretion advised
		//Some programmers may find the following content disturbing		
												  		
		//Create the borders
		javax.swing.border.Border bogStandard = BorderFactory.createEmptyBorder(2,2,2,2); 
		javax.swing.border.Border m_panel1 = BorderFactory.createEmptyBorder(40,2,100,2); 
		javax.swing.border.Border m_panel2 = BorderFactory.createEmptyBorder(40,2,2,2); 
		javax.swing.border.Border m_panel3 = BorderFactory.createEmptyBorder(2,2,2,2); 
		javax.swing.border.Border m_main = BorderFactory.createEmptyBorder(2,2,2,2); 
		javax.swing.border.Border m_p1a = BorderFactory.createEmptyBorder(2,2,40,2); 
		javax.swing.border.Border m_p1b = BorderFactory.createEmptyBorder(2,2,2,2); 
		javax.swing.border.Border m_p1c = BorderFactory.createEmptyBorder(2,10,2,10); 
		javax.swing.border.Border beveled = BorderFactory.createRaisedBevelBorder(); //Raised
			
							
		//Guess 1
		javax.swing.border.Border m_p2a = BorderFactory.createEmptyBorder(2,2,2,2); //Holder panel
		javax.swing.border.Border m_p2a1 = BorderFactory.createEmptyBorder(2,2,2,2); //a1
		javax.swing.border.Border m_p2a2 = BorderFactory.createEmptyBorder(2,2,2,2); //a2
		javax.swing.border.Border m_p2a3 = BorderFactory.createEmptyBorder(2,2,2,2); //a3
		javax.swing.border.Border m_p2a4 = BorderFactory.createEmptyBorder(2,2,2,2); //1st Guess label
		
		//Guess 2
		javax.swing.border.Border m_p2b = BorderFactory.createEmptyBorder(2,2,2,2); //Holder panel
		javax.swing.border.Border m_p2b1 = BorderFactory.createEmptyBorder(2,2,2,2); //b1
		javax.swing.border.Border m_p2b2 = BorderFactory.createEmptyBorder(2,2,2,2); //b2
		javax.swing.border.Border m_p2b3 = BorderFactory.createEmptyBorder(2,2,2,2); //b3
		javax.swing.border.Border m_p2b4 = BorderFactory.createEmptyBorder(2,2,2,2); //2nd Guess label
		
		//Guess 3
		javax.swing.border.Border m_p2c = BorderFactory.createEmptyBorder(2,2,2,2); //Holder panel
		javax.swing.border.Border m_p2c1 = BorderFactory.createEmptyBorder(2,2,2,2); //c1
		javax.swing.border.Border m_p2c2 = BorderFactory.createEmptyBorder(2,2,2,2); //c2
		javax.swing.border.Border m_p2c3 = BorderFactory.createEmptyBorder(2,2,2,2); //c2
		javax.swing.border.Border m_p2c4 = BorderFactory.createEmptyBorder(2,2,2,2); //3rd Guess label
		
		//Guess 4
		javax.swing.border.Border m_p2d = BorderFactory.createEmptyBorder(2,2,2,2); //Holder panel
		javax.swing.border.Border m_p2d1 = BorderFactory.createEmptyBorder(2,2,2,2); //d1
		javax.swing.border.Border m_p2d2 = BorderFactory.createEmptyBorder(2,2,2,2); //d2
		javax.swing.border.Border m_p2d3 = BorderFactory.createEmptyBorder(2,2,2,2); //d2
		javax.swing.border.Border m_p2d4 = BorderFactory.createEmptyBorder(2,2,2,2); //4th Guess label
		
		//Guess 5
		javax.swing.border.Border m_p2e = BorderFactory.createEmptyBorder(2,2,2,2); //Holder panel
		javax.swing.border.Border m_p2e1 = BorderFactory.createEmptyBorder(2,2,2,2); //e1
		javax.swing.border.Border m_p2e2 = BorderFactory.createEmptyBorder(2,2,2,2); //e2
		javax.swing.border.Border m_p2e3 = BorderFactory.createEmptyBorder(2,2,2,2); //e3
		javax.swing.border.Border m_p2e4 = BorderFactory.createEmptyBorder(2,2,2,2); //5th Guess label
		
		//Guess 6
		javax.swing.border.Border m_p2f = BorderFactory.createEmptyBorder(2,2,2,2); //Holder panel
		javax.swing.border.Border m_p2f1 = BorderFactory.createEmptyBorder(2,2,2,2); //f1
		javax.swing.border.Border m_p2f2 = BorderFactory.createEmptyBorder(2,2,2,2); //f2
		javax.swing.border.Border m_p2f3 = BorderFactory.createEmptyBorder(2,2,2,2); //f3
		javax.swing.border.Border m_p2f4 = BorderFactory.createEmptyBorder(2,2,2,2); //6th Guess label
		
				
		javax.swing.border.Border m_p3a1 = BorderFactory.createEmptyBorder(2,2,100,2); //User prompt label
		javax.swing.border.Border m_p3a2 = BorderFactory.createEmptyBorder(2,2,2,2); //Correct answer circle Graphics
		javax.swing.border.Border m_peg1 = BorderFactory.createEmptyBorder(2,2,2,2); //Yellow, Black
		javax.swing.border.Border m_peg2 = BorderFactory.createEmptyBorder(2,2,2,2); //Yellow, Black
		javax.swing.border.Border m_peg3 = BorderFactory.createEmptyBorder(2,2,2,2); //Yellow, Black
		javax.swing.border.Border m_p3a3 = BorderFactory.createEmptyBorder(2,2,2,2); //Yellow, Black
		javax.swing.border.Border m_p3a = BorderFactory.createEmptyBorder(2,2,2,2); //Yellow, Black
		javax.swing.border.Border m_p3b = BorderFactory.createEmptyBorder(2,2,20,2); //HIT AND MISSES label
		javax.swing.border.Border m_p3a4 = BorderFactory.createEmptyBorder(2,2,2,2); //Yellow, Black
				
				
		//The label panel
		JPanel p1a = new JPanel(new GridLayout(1,1));
		p1a.setBorder(m_p1a);
		p1a.setBackground(Color.LIGHT_GRAY);
		JLabel Click_a_Colour = new JLabel("Click a colour");
		p1a.add(Click_a_Colour);
				
		JPanel p_red = new JPanel(new GridLayout(1,1));
		p_red.setBackground(Color.LIGHT_GRAY);
		p_red.setBorder(beveled);
		red.setBackground(Color.LIGHT_GRAY);
		p_red.add(red);
		
		
		JPanel p_blue = new JPanel(new GridLayout(1,1));
		p_blue.setBackground(Color.LIGHT_GRAY);
		p_blue.setBorder(beveled);
		blue.setBackground(Color.LIGHT_GRAY);
		p_blue.add(blue);
		
		
		JPanel p_green = new JPanel(new GridLayout(1,1));
		p_green.setBackground(Color.LIGHT_GRAY);
		p_green.setBorder(beveled);
		green.setBackground(Color.LIGHT_GRAY);
		p_green.add(green);
		
		
		//Red, Blue and Green buttons panel
		JPanel p1b = new JPanel(new GridLayout(1, 3));
		p1b.setBorder(m_p1b);
		p1b.setBackground(Color.LIGHT_GRAY);
		p1b.add(p_red);
		p1b.add(p_blue);		
		p1b.add(p_green);
		
		//Yellow and Black buttons
		JPanel p_yellow = new JPanel(new GridLayout(1,1));
		p_yellow.setBackground(Color.LIGHT_GRAY);
		p_yellow.setBorder(beveled);
		yellow.setBackground(Color.LIGHT_GRAY);
		p_yellow.add(yellow);
		
		
		JPanel p_black = new JPanel(new GridLayout(1,1));
		p_black.setBackground(Color.LIGHT_GRAY);
		p_black.setBorder(beveled);
		black.setBackground(Color.LIGHT_GRAY);
		p_black.add(black);
		
		
		JPanel p1c = new JPanel(new GridLayout(1, 3));
		p1c.setBorder(m_p1c);
		p1c.setBackground(Color.LIGHT_GRAY);
		p1c.add(p_yellow);
		p1c.add(p_black);
		
		//######################
		//###### PANEL 1 #######
		//######################
		
		JPanel panel1 = new JPanel(new GridLayout(3, 1));
		panel1.setBorder(m_panel1);
		panel1.setBackground(Color.LIGHT_GRAY);
		//Build "panel1"
		panel1.add(p1a);
		panel1.add(p1b);
		panel1.add(p1c);
		
		
		//The first guess
				JPanel p2a1 = new JPanel(new GridLayout(1, 1));
				p2a1.setBorder(m_p2a1);
				p2a1.setBackground(Color.LIGHT_GRAY);
				a1.setCircleColor(myColourChoice , false, true); //Outline is visible on startup
			
				//Build p1a1
				p2a1.add(a1);
		
				JPanel p2a2 = new JPanel(new GridLayout(1, 1));
				p2a2.setBorder(m_p2a2);
				p2a2.setBackground(Color.LIGHT_GRAY);
				a2.setCircleColor(myColourChoice , false, true); //Outline is visible on startup
		
				//Build p2a2
				p2a2.add(a2);
			
				//a3 circle object and panel properties
				JPanel p2a3 = new JPanel(new GridLayout(1, 1));
				p2a3.setBorder(m_p2a3);
				p2a3.setBackground(Color.LIGHT_GRAY);
				a3.setCircleColor(myColourChoice , false, true); //Outline is visible on startup
		
				//Build p2a2
				p2a3.add(a3);
			
				JPanel p2a4 = new JPanel(new BorderLayout());
				p2a4.setBorder(m_p2a4);
				p2a4.setBackground(Color.LIGHT_GRAY);
				JLabel Guess1 = new JLabel("1st Guess");
				Guess1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT); //align text to the right
				//Build p2a2
				p2a4.add(Guess1, BorderLayout.NORTH);
										
		
		JPanel p2a = new JPanel(new GridLayout(1, 4));
		//p2a.setBorder(m_p2a);
		p2a.setBackground(Color.LIGHT_GRAY);
			//Build p2a
			p2a.add(p2a1); //a1
			p2a.add(p2a2); //a2
			p2a.add(p2a3); //a3
			p2a.add(p2a4); //Guess label 1
		
		
		
		//The second guess 
				p2b1.setBorder(m_p2b1);
				p2b1.setBackground(Color.LIGHT_GRAY);
						
				
				p2b2.setBorder(m_p2b2);
				p2b2.setBackground(Color.LIGHT_GRAY);
							
				p2b3.setBorder(m_p2b3);
				p2b3.setBackground(Color.LIGHT_GRAY);
						
			    //Guess 2 label (GLOBAL)
				p2b4.setBorder(m_p2b4);
				p2b4.setBackground(Color.LIGHT_GRAY);
				
				p2b4.setVisible(false);	//Hide the label
					
											
				JLabel Guess2 = new JLabel("2nd Guess");
				p2b4.setVisible(false);
				Guess2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT); //align text to the right
				//Build p2b2
				p2b4.add(Guess2, BorderLayout.NORTH);
										
	
		JPanel p2b = new JPanel(new GridLayout(1, 4));
		p2b.setBorder(m_p2b);
		p2b.setBackground(Color.LIGHT_GRAY);
			//Build p2b
			p2b.add(p2b1); //b1
			p2b.add(p2b2); //b2
			p2b.add(p2b3); //b3
			p2b.add(p2b4); //Guess label 2
			
			
		
		//The third guess
				p2c1.setBorder(m_p2c1);
				p2c1.setBackground(Color.LIGHT_GRAY);
				
		
				p2c2.setBorder(m_p2c2);
				p2c2.setBackground(Color.LIGHT_GRAY);
				
				p2c3.setBorder(m_p2c3);
				p2c3.setBackground(Color.LIGHT_GRAY);
				
							
				//Guess 3 label (GLOBAL)
				p2c4.setBorder(m_p2c4);
				p2c4.setBackground(Color.LIGHT_GRAY);
				
				p2c4.setVisible(false);	//Hide the label
				
				JLabel Guess3 = new JLabel("3rd Guess");
				Guess3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT); //align text to the right
				//Build p2c2
				p2c4.add(Guess3, BorderLayout.NORTH);
			
		 //Main 
		JPanel p2c = new JPanel(new GridLayout(1, 4));
		p2c.setBorder(m_p2c);
		p2c.setBackground(Color.LIGHT_GRAY);
		
			//Build p2c
			p2c.add(p2c1); //c1
			p2c.add(p2c2); //c2
			p2c.add(p2c3); //c3
			p2c.add(p2c4); //Guess label 3
			
			
		
		//The fourth guess 
				p2d1.setBorder(m_p2d1);
				p2d1.setBackground(Color.LIGHT_GRAY);
						
				p2d2.setBorder(m_p2d2);
				p2d2.setBackground(Color.LIGHT_GRAY);
				
			
				p2d3.setBorder(m_p2d3);
				p2d3.setBackground(Color.LIGHT_GRAY);
				
								
				//Guess 4 label (GLOBAL)
				p2d4.setBorder(m_p2d4);
				p2d4.setBackground(Color.LIGHT_GRAY);
				
				p2d4.setVisible(false);	//Hide the panel
				
				JLabel Guess4 = new JLabel("4th Guess");
				Guess4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT); //align text to the right
				//Build p2d2
				p2d4.add(Guess4, BorderLayout.NORTH);
										
			
		//Main 4th Guess panel
		JPanel p2d = new JPanel(new GridLayout(1, 4));
		p2d.setBorder(m_p2d);
		p2d.setBackground(Color.LIGHT_GRAY);
				//Build p2d
				p2d.add(p2d1); //d1
				p2d.add(p2d2); //d2
				p2d.add(p2d3); //d3
				p2d.add(p2d4); //Guess label 4
			
			
			
		//The fifth guess 
				p2e1.setBorder(m_p2e1);
				p2e1.setBackground(Color.LIGHT_GRAY);
				
		
				p2e2.setBorder(m_p2e2);
				p2e2.setBackground(Color.LIGHT_GRAY);
							
				p2e3.setBorder(m_p2e3);
				p2e3.setBackground(Color.LIGHT_GRAY);
									
				//Guess 5 label (GLOBAL)
				p2e4.setBorder(m_p2e4);
				p2e4.setBackground(Color.LIGHT_GRAY);
				
				p2e4.setVisible(false);	//Hide the panel
				
				
				JLabel Guess5 = new JLabel("5th Guess");
				Guess5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT); //align text to the right
				//Build p2e2
				p2e4.add(Guess5, BorderLayout.NORTH);
										
		JPanel p2e = new JPanel(new GridLayout(1, 4));
		p2e.setBorder(m_p2e);
		p2e.setBackground(Color.LIGHT_GRAY);
			//Build p2e
			p2e.add(p2e1); //e1
			p2e.add(p2e2); //e2
			p2e.add(p2e3); //e3
			p2e.add(p2e4); //Guess label 5
					
			
			//The sixth guess 
				p2f1.setBorder(m_p2f1);
				p2f1.setBackground(Color.LIGHT_GRAY);
			
		
				p2f2.setBorder(m_p2f2);
				p2f2.setBackground(Color.LIGHT_GRAY);
							
			
				p2f3.setBorder(m_p2f3);
				p2f3.setBackground(Color.LIGHT_GRAY);
								
				//Guess 6 label (GLOBAL)
				p2f4.setBorder(m_p2f4);
				p2f4.setBackground(Color.LIGHT_GRAY);
				
				p2f4.setVisible(false);	//Hide the label
								
				JLabel Guess6 = new JLabel("6th Guess");
				Guess6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT); //align text to the right
				//Build p2f2
				p2f4.add(Guess6, BorderLayout.NORTH);
										
		//Main 6th Guess panel
		JPanel p2f = new JPanel(new GridLayout(1, 4));
		p2f.setBorder(m_p2f);
		p2f.setBackground(Color.LIGHT_GRAY);
			//Build p2f
			p2f.add(p2f1); //f1
			p2f.add(p2f2); //f2
			p2f.add(p2f3); //f3
			p2f.add(p2f4); //Guess label 6
		
		//######################							
		//###### PANEL 2 #######
		//######################
		
		JPanel panel2 = new JPanel(new GridLayout(6, 1));
		panel2.setBorder(m_panel2);
		panel2.setBackground(Color.LIGHT_GRAY);
							
		//Build panel2
		panel2.add(p2a);
		panel2.add(p2b);
		panel2.add(p2c);
		panel2.add(p2d);
		panel2.add(p2e);
		panel2.add(p2f);
		
		
		//Guess the hidden code label
		JPanel p3a1 = new JPanel(new GridLayout(1,1));
		p3a1.setBorder(m_p3a1);
		p3a1.setBackground(Color.LIGHT_GRAY);
		userPrompt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); //align text to the right
		userPrompt.setFont(new Font("sansserif", Font.BOLD, 15));
		p3a1.add(userPrompt);
		
		
				
				JPanel peg1 = new JPanel(new GridLayout(1 ,1));
				peg1.setBorder(m_peg1);
				peg1.setBackground(Color.LIGHT_GRAY);
				 
			   p1.setCircleColor(	Color.WHITE , true, true); //Actual peg
			   p1.setWidthHeight(40, 40);
				peg1.add(p1);
				
				JPanel peg2 = new JPanel(new GridLayout(1 ,1));
				peg2.setBorder(m_peg2);
				peg2.setBackground(Color.LIGHT_GRAY);
				 
			   p2.setCircleColor(Color.WHITE , true, true); //Actual peg
			   p2.setWidthHeight(40, 40);	
				peg2.add(p2);
				
				JPanel peg3 = new JPanel(new GridLayout(1 ,1));
				peg3.setBorder(m_peg3);
				peg3.setBackground(Color.LIGHT_GRAY);
				 
			   p3.setCircleColor(Color.WHITE , true, true); //Actual peg
			   p3.setWidthHeight(40, 40);
				peg3.add(p3);
				
		//Hold the pegs (The correct combination)
		JPanel p3a2 = new JPanel(new GridLayout(1 ,3));
		p3a2.setBorder(m_p3a2);
		p3a2.setBackground(Color.LIGHT_GRAY);		
				
		//Build p3a2
		p3a2.add(peg1);
		p3a2.add(peg2);
		p3a2.add(peg3);
		
		
		JPanel p3a = new JPanel(new GridLayout(1,2));
		p3a.setBorder(m_p3a);
		p3a.setBackground(Color.LIGHT_GRAY);
		p3a.add(p3a1);
		p3a.add(p3a2);
		
		//HITS AND MISSES LABEL
		JPanel p3b = new JPanel(new GridLayout(1,1));
		p3b.setBorder(m_p3b);
		p3b.setBackground(Color.LIGHT_GRAY);
		JLabel title = new JLabel("HITS AND MISSES");
		title.setFont(new Font("sansserif", Font.PLAIN, 35));
		title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); //align text to the right
		title.setForeground(Color.BLUE);
		p3b.add(title);
		
		//#######################
		//####### PANEL 3 #######
		//#######################
		
		JPanel panel3 = new JPanel(new BorderLayout());
		panel3.setBorder(m_panel3);
		panel3.setBackground(Color.LIGHT_GRAY);
		
		//Build Panel3
		panel3.add(p3a, BorderLayout.NORTH);
		panel3.add(p3b, BorderLayout.SOUTH);
		
		
		//THE SUPER PANEL (Holder of all panels)
		JPanel main = new JPanel(new BorderLayout());
		main.setBorder(m_main);
		main.setBackground(Color.LIGHT_GRAY);
		
		
		javax.swing.border.Border m_FILL = BorderFactory.createEmptyBorder(2,50,2,50); //Filler
		//Filler Panel
		JPanel FILL = new JPanel(new BorderLayout());
		FILL.setBorder(m_FILL);
		FILL.setBackground(Color.LIGHT_GRAY);
		
		//Build the "main" panel
		main.add(panel1, BorderLayout.WEST);
		main.add(FILL, BorderLayout.CENTER);
		main.add(panel2, BorderLayout.EAST);
		main.add(panel3, BorderLayout.SOUTH);
			
		//Build the main Panel and return it	
		JPanel the_main = new JPanel();
		the_main.setBackground(Color.LIGHT_GRAY);
		the_main.setPreferredSize(new Dimension(650, 600));
		the_main.add(main);	
					
		return the_main;
				
		}
		
//========================GENERATE A RANDOM NUMBER=========================

	public int randomNum(){
		//Generate a random number between 0 and 4
		int ranNum = (int) (Math.random() * 5);
			
		return ranNum;	
	}
	
//==========================CHEATER TESTER METHOD=============================
public void cheat(){ //A method that reveals the answer to aid in testing
	
		if (GuessThis[0] == Color.BLACK){
			System.out.println("Colour 1 is BLACK");
		} else if (GuessThis[0] == Color.GREEN){
			System.out.println("Colour 1 is GREEN");
		} else if (GuessThis[0] == Color.RED){
			System.out.println("Colour 1 is RED");
		} else if (GuessThis[0] == Color.BLUE){
			System.out.println("Colour 1 is BLUE");
		} else if (GuessThis[0] == Color.YELLOW){
			System.out.println("Colour 1 is YELLOW");
		}
		
		if (GuessThis[1] == Color.BLACK){
			System.out.println("Colour 2 is BLACK");
		} else if (GuessThis[1] == Color.GREEN){
			System.out.println("Colour 2 is GREEN");
		} else if (GuessThis[1] == Color.RED){
			System.out.println("Colour 2 is RED");
		} else if (GuessThis[1] == Color.BLUE){
			System.out.println("Colour 2 is BLUE");
		} else if (GuessThis[1] == Color.YELLOW){
			System.out.println("Colour 2 is YELLOW");
		}
		
		if (GuessThis[2] == Color.BLACK){
			System.out.println("Colour 3 is BLACK");
		} else if (GuessThis[2] == Color.GREEN){
			System.out.println("Colour 3 is GREEN");
		} else if (GuessThis[2] == Color.RED){
			System.out.println("Colour 3 is RED");
		} else if (GuessThis[2] == Color.BLUE){
			System.out.println("Colour 3 is BLUE");
		} else if (GuessThis[2] == Color.YELLOW){
			System.out.println("Colour 3 is YELLOW");
		}
		
	
}
		
//============================A C T I O N   L I S T N E R ====================
	public void actionPerformed(ActionEvent event){
		//this one event trap is called any of the buttons are pressed
		//we nedd to differentiate between which button was pressed
		//to do this we can use the getActionCommand() method
		
		// *** Button Red ***
			if (event.getActionCommand().equals("Red")){ 
								
				clickCounter++;
				logUserGuess(Color.RED);
				
					
		// *** Button Blue ***	
		} else if (event.getActionCommand().equals("Blue")) {
	
				clickCounter++;
				logUserGuess(Color.BLUE);
								
		// *** Button Green ***
		} else if (event.getActionCommand().equals("Green")) {
		
				clickCounter++;
				logUserGuess(Color.GREEN);
				
		// *** Button Yellow ***
		} else if (event.getActionCommand().equals("Yellow")) {
		
				clickCounter++;
				logUserGuess(Color.YELLOW);
		
		// *** Button Black ***
		} else if (event.getActionCommand().equals("Black")) {
				
				clickCounter++;
				logUserGuess(Color.BLACK);
	
		}
	} //End actionListener
	
//==================== L O G   U S E R   G U E S S ==========
	
public void	logUserGuess(Color g){
					/*
					 *  a1  a2  a3   - guess 1
					 *  b1  b2  b3   - guess 2
					 *  c1  c2  c3   - guess 3
					 *  d1  d2  d3   - guess 4
					 *  e1  e2  e3   - guess 5
					 *  f1  f2  f3   - guess 6
					 */

//Method words by tracking the number of clicks
//example 1 button click is refering to 'a1' while
//7 equals c1.  As there is no reversing in the game 
//and guess selection is proceedural this works fine.

		myColourChoice = g;
		
		///            *****************	
		///				*** 1st Guess ***
		///            *****************
			
			if (clickCounter == 1) 	{ //a1
			
			//Paint user color choice and display it
			a1.setCircleColor(myColourChoice , true, true);
			this.repaint();
			
				//Check if we have a match
				if (a1.getCircleColor() == GuessThis[0]){
					//if so increment the Hit counter
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
									
				}
			
			
			} else if  (clickCounter == 2) 	{ //a2
			//Paint user color choice and display it
			a2.setCircleColor(myColourChoice , true, true);
			this.repaint();
			
				//Check if we have a match
				if (a2.getCircleColor() == GuessThis[1]){
				
					//if so increment the Hit counter
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
									
				}
			
			} else if (clickCounter == 3) 	{ //a3
			//Paint user color choice and display it
			a3.setCircleColor(myColourChoice , true, true);
			this.repaint();
			
			//Check if we have a match
				if (a3.getCircleColor() == GuessThis[2]){
					//if so increment the Hit counter
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
							
					
				}
			
						
			//Check if game is over
			isGameOver();
						
			} 
				
			///            *****************	
			///				*** 2nd Guess ***
			///            *****************
				
			if (access[0] == true){
				
				//Reveal all the Circle border outlines and Guess label
				p2b4.setVisible(true);	
				
				p2b1.add(b1);
			
				p2b2.add(b2);
			
				p2b3.add(b3);
		   
		      this.repaint();
				
				
				if (clickCounter == 4) 	{ //b1
				//Paint the user guess and display it
				b1.setCircleColor(myColourChoice , true, true);
				p2b1.add(b1);
				this.repaint();
				
					//Check if we have a match
					if (b1.getCircleColor() == GuessThis[0]){
					//If so increment the Hit counter
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
								
					}
						
				} else if  (clickCounter == 5) 	{ //b2
				//Paint the user guess and display it
				b2.setCircleColor(myColourChoice , true, true);
				p2b2.add(b2);
				this.repaint();
				
					//Check if we have a match
					if (b2.getCircleColor() == GuessThis[1]){
					
					//Increment the number of hits
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
											
					
					}
			
				} else if (clickCounter == 6) 	{ //b3
				//Paint the user guess and display it
				b3.setCircleColor(myColourChoice , true, true);
				p2b3.add(b3);
				this.repaint();
				
				//Check if we have a match
				if (b3.getCircleColor() == GuessThis[2]){
					
					//Increment the number of hits
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
									
				}
			

				//Check if game is over
				isGameOver();
				
				
			} 
			
				
			}
			
			///            *****************
			///				*** 3rd Guess ***
			///            *****************
			
			if (access[1] == true) {
				
				//Reveal all the Circle border outlines and Guess label
				p2c4.setVisible(true);
							
				p2c1.add(c1);
			
				p2c2.add(c2);
			
				p2c3.add(c3);
		   
		      this.repaint();
				
				
				
				if (clickCounter == 7) 	{ //c1
				//Paint the user guess and display it
				c1.setCircleColor(myColourChoice , true, true);
				p2c1.add(c1);
				this.repaint();
				
				//Check if we have a match
					if (c1.getCircleColor() == GuessThis[0]){
					
					//Increment the number of Hits
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
														
					
					}
			
				} else if  (clickCounter == 8) 	{ //c2
				//Paint the user guess and display it
				c2.setCircleColor(myColourChoice , true, true);
				p2c2.add(c2);
				this.repaint();
				
				//Check if we have a match
					if (c2.getCircleColor() == GuessThis[1]){
					
					//Increment the number of hits
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
					
					}
				
				} else if (clickCounter == 9) 	{ //c3
				//Paint the user guess and display it
				c3.setCircleColor(myColourChoice , true, true);
				p2c3.add(c3);
				this.repaint();
				
				//Check if we have a match
					if (c3.getCircleColor() == GuessThis[2]){
					
					//Increment the number of hits
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
									
				}
			
				//Check if game is over
				isGameOver();
				
			
				} 
				
			}
			
			//            *****************
			//            *** 4th Guess ***
			//            *****************
			
			if (access[2] == true){
				
				//Reveal all the Circle border outlines and Guess label
				p2d4.setVisible(true);
							
				p2d1.add(d1);
			
				p2d2.add(d2);
			
				p2d3.add(d3);
		   
		        this.repaint();
				
								
				if (clickCounter == 10) 	{ //d1
				//Paint the user guess and display it
				d1.setCircleColor(myColourChoice , true, true);
				p2d1.add(d1);
				this.repaint();
				
				//Check if we have a match
					if (d1.getCircleColor() == GuessThis[0]){
					
					//Increment the number of hits
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
														
					
					}
			
				} else if  (clickCounter == 11) 	{ //d2
				//Paint the user guess and display it
				d2.setCircleColor(myColourChoice , true, true);
				p2d2.add(d2);
				this.repaint();
				
				//Check if we have a match
					if (d2.getCircleColor() == GuessThis[1]){
					
					//Increment the number of hits
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
														
					
					}
			
				} else if (clickCounter == 12) 	{ //d3
				//Paint the user guess and display it
				d3.setCircleColor(myColourChoice , true, true);
				p2d3.add(d3);
				this.repaint();
				
				//Check if we have a match
					if (d3.getCircleColor() == GuessThis[2]){
					
					//Increment the number of hits
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
											
					
					}
							
				//Check if game is over
				isGameOver();
							
			} 	

			}	//End if 4th guess
				
			//           *****************	
			//           *** 5th Guess ***	
			//           *****************	
			if (access[3] == true){
				
				p2e4.setVisible(true);	//reveal the label
				
			
				p2e1.add(e1);
			
				p2e2.add(e2);
			
				p2e3.add(e3);
		   
		        this.repaint();
				
				
				
				if (clickCounter == 13) 	{ //e1
				//Paint the user guess and display it
				e1.setCircleColor(myColourChoice , true, true);
				p2e1.add(e1);
				this.repaint();
				
				//Check if we have a match
					if (e1.getCircleColor() == GuessThis[0]){

					//Increment the number of hits					
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
										
					}
			
				} else if  (clickCounter == 14) 	{ //e2
				//Paint the user guess and display it
				e2.setCircleColor(myColourChoice , true, true);
				p2e2.add(e2);
				this.repaint();
				
				//Check if we have a match
					if (e2.getCircleColor() == GuessThis[1]){
					
					//Increment the number of hits
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
										
					}
			
				} else if (clickCounter == 15) 	{ //e3
				//Paint the user guess and display it
				e3.setCircleColor(myColourChoice , true, true);
				p2e3.add(e3);
				this.repaint();
				
				//Check if we have a match
					if (e3.getCircleColor() == GuessThis[2]){
					
					//Increment the number of hits
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
											
					}
			
				//Check if game is over
				isGameOver();
							
						
			} 	
										
			}		
			
			///         *****************
			///         *** 6th Guess ***
			///         *****************
			
				if (access[4] == true){
				
				p2f4.setVisible(true);	//reveal the label
				
			
				p2f1.add(f1);
			
				p2f2.add(f2);
			
				p2f3.add(f3);
		   
		      this.repaint();
								
				
				if (clickCounter == 16) 	{ //b1
				//Paint the user guess and display it
				f1.setCircleColor(myColourChoice , true, true);
				p2f1.add(f1);
				this.repaint();
				
					//Check if we have a match
					if (f1.getCircleColor() == GuessThis[0]){
					
					//Increment the number of hits
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
														
					
					}
			
				} else if  (clickCounter == 17) 	{ //b2
				//Paint the user guess and display it
				f2.setCircleColor(myColourChoice , true, true);
				p2f2.add(f2);
				this.repaint();
				
				//Check if we have a match
					if (f2.getCircleColor() == GuessThis[1]){
					
					//increment the number of hits
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
														
					}
			
				} else if (clickCounter == 18) 	{ //b3
				//Paint the user guess and display it
				f3.setCircleColor(myColourChoice , true, true);
				p2f3.add(f3);
				this.repaint();
				
				 //Check if we have a match
					if (f3.getCircleColor() == GuessThis[2]){
					
					//increment the number of hits
					numberOfHits++;
					
					//Testing purposes
					//System.out.println("Hit, Counter =" + numberOfHits);
									
					}
									
				//Check if game is over
				isGameOver();
												
				//Disable buttons at this stage as no more guesses allowed
				red.setEnabled(false);
				blue.setEnabled(false);
				green.setEnabled(false);
				yellow.setEnabled(false);
				black.setEnabled(false);
				
			//reveal the answer (Boo, you suck)
			p1.setCircleColor(GuessThis[0] , true, true);
			p2.setCircleColor(GuessThis[1] , true, true);
			p3.setCircleColor(GuessThis[2] , true, true);
				
			} 	
			
			if (clickCounter >= 18 && numberOfHits != 3 ) {
				
				//Change label to you win
				userPrompt.setForeground(Color.YELLOW);
				userPrompt.setText("YOU LOSE");
				this.repaint();
				
				}
			
									
			}	
		
				
	} //logUserGuess
	
	public void isGameOver(){
				
		if (numberOfHits == 3){
			//Then its Game over
			
			//Disable buttons at this stage as no more guesses allowed
				red.setEnabled(false);
				blue.setEnabled(false);
				green.setEnabled(false);
				yellow.setEnabled(false);
				black.setEnabled(false);
		
			//reveal the answer
			p1.setCircleColor(GuessThis[0] , true, true);
			p2.setCircleColor(GuessThis[1] , true, true);
			p3.setCircleColor(GuessThis[2] , true, true);
			
			//if number of guesses is 6 or less change label to you win
			if (clickCounter <= 18){
				
				//Change label to you win
				userPrompt.setForeground(Color.RED);
				userPrompt.setText("YOU WIN");
				this.repaint();
				
			}  //Check if 6 guesses or less
			
		} else {
						
			//reset the hit counter
			numberOfHits = 0;
			
			//No not yet then...
			//Allow access to next guess
			if (clickCounter == 3){
			
				access[0] = true; //allows 2nd guess
								
			} else if (clickCounter == 6) {
						
				access[1] = true; //allows 3rd Guess
			
			} else if (clickCounter == 9) {
				
				access[2] = true; //allows 4th Guess
				
			} else if (clickCounter == 12) {
				
				access[3] = true; //allows 5th Guess
				
			} else if (clickCounter == 15) {
				
				access[4] = true; //allows 6th Guess
				
			} 
							
		}
	
	} //isGameOver
		
	
//====================== M A I N ==========================
//	public static void main(String[] args) {
//		
//		HitMiss app = new HitMiss();
//		app.setVisible(true);
//		
//	}
	
}