/*============================
 *=   Author : wtarr         =
 *=                          =
 *=  Title: GuessWord        = 
 *=                          =
 *============================
 */
 
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.plaf.ColorUIResource;

public class GuessWord extends JPanel implements ActionListener{
			
//================================================================
//=================== V A R I A B L E S ==========================
//================================================================

//Declare the variables that need to be global as more than one method
//will require access to them			
			
	//Create a textField for the Guess the word (24 character field)
	private JTextField guessTheWord = new JTextField(24);
		
	//Create a textField for the Guesses Remaining (3 character field size)
	private JTextField guessesRemaining = new JTextField(3);

	
	//Create the buttons
	private JButton A = new JButton("A");
	private JButton B = new JButton("B");
	private JButton C = new JButton("C");
	private JButton D = new JButton("D");
	private JButton E = new JButton("E");
	private JButton F = new JButton("F");
	private JButton G = new JButton("G");
	private JButton H = new JButton("H");
	private JButton I = new JButton("I");
	private JButton J = new JButton("J");
	private JButton K = new JButton("K");
	private JButton L = new JButton("L");
	private JButton M = new JButton("M");
	private JButton N = new JButton("N");
	private JButton O = new JButton("O");
	private JButton P = new JButton("P");
	private JButton Q = new JButton("Q");
	private JButton R = new JButton("R");
	private JButton S = new JButton("S");
	private JButton T = new JButton("T");
	private JButton U = new JButton("U");
	private JButton V = new JButton("V");
	private JButton W = new JButton("W");
	private JButton X = new JButton("X");
	private JButton Y = new JButton("Y");
	private JButton Z = new JButton("Z");
	private JButton START = new JButton("START");
	private JButton ANSWER = new JButton("ANSWER");

//The array that holds the words
private String[] wordStore = new String[5]; 		
	
//The word of the day (the word to be guessed)
private String wordOfTheDay = null;

//The number of the day (The index of the selected word to be guessed)
int num = 0;

//The word masked
StringBuffer mask; 
private String displayMask = null;

//The guess count
private int guess;


	
	//==============================================================================		
	//========================= C O N S T R U C T O R ==============================
	//==============================================================================
	
	public GuessWord() {
       
      //Build the main panel
      super (new FlowLayout	());
      this.setBackground(Color.LIGHT_GRAY);
      this.add(this.createpanel1());
   	   	
      	
      //Apply Listener and ToolTip to the buttons
      A.addActionListener(this);
	  A.setToolTipText("A"); 
	  B.addActionListener(this);
	  B.setToolTipText("B");
	  C.addActionListener(this);
	  C.setToolTipText("C");
      D.addActionListener(this);
	  D.setToolTipText("D");           
      E.addActionListener(this);
	  E.setToolTipText("E");  
	  F.addActionListener(this);
	  F.setToolTipText("F"); 
	  G.addActionListener(this);
	  G.setToolTipText("G"); 	
	  H.addActionListener(this);
	  H.setToolTipText("H"); 	
	  I.addActionListener(this);
	  I.setToolTipText("I"); 	
	  J.addActionListener(this);
	  J.setToolTipText("J"); 	
	  K.addActionListener(this);
	  K.setToolTipText("K"); 	
	  L.addActionListener(this);
	  L.setToolTipText("L"); 	
	  M.addActionListener(this);
	  M.setToolTipText("M"); 	
	  N.addActionListener(this);
	  N.setToolTipText("N"); 	
	  O.addActionListener(this);
	  O.setToolTipText("O"); 	
	  P.addActionListener(this);
	  P.setToolTipText("P"); 	
	  Q.addActionListener(this);
	  Q.setToolTipText("Q");	 	       	       	 	      	 	      	 	      	 	      	 	      	 	      	 	      	 	      
      R.addActionListener(this);
	  R.setToolTipText("R");
      S.addActionListener(this);
	  S.setToolTipText("S");
	  T.addActionListener(this);
	  T.setToolTipText("T");
	  U.addActionListener(this);
	  U.setToolTipText("U");
	  V.addActionListener(this);
	  V.setToolTipText("V");
	  W.addActionListener(this);
	  W.setToolTipText("W");
	  X.addActionListener(this);
	  X.setToolTipText("X");
	  Y.addActionListener(this);
	  Y.setToolTipText("Y");
	  Z.addActionListener(this);
	  Z.setToolTipText("Z");
	  START.addActionListener(this);
	  START.setToolTipText("START");
	  ANSWER.addActionListener(this);
	  ANSWER.setToolTipText("ANSWER");
	  
	    
	  //startGame();  
	    
	} // end of constructor
	

	//===============================================================================
	//========================= T H E  P A N E L S ==================================
	//===============================================================================
	public JPanel createpanel1(){ //For labels and text fields (3 panels within 1)
	
	//Create the borders
	javax.swing.border.Border bogStandard = BorderFactory.createEmptyBorder(5,10,5,10); //Standard
	javax.swing.border.Border gtwLabel = BorderFactory.createEmptyBorder(5,5,5,70); //Custom border for GuessTheWord Label
	javax.swing.border.Border myBorder = BorderFactory.createEmptyBorder(20,300,20,30); //Container for top Panel
	javax.swing.border.Border beveled = BorderFactory.createRaisedBevelBorder(); //Beveled panel			
	javax.swing.border.Border Loweredbeveled = BorderFactory.createLoweredBevelBorder(); //Sunken Beveled panel			
	
	//Create a color red
	Color rd = Color.RED;	
		
		//Guess the word label	   	   
	   JPanel panelA = new JPanel(new BorderLayout()); //PanelA
	   //Create a label "GUESS THE WORD"
		JLabel gtw = new JLabel("GUESS THE WORD");
		gtw.setForeground(rd);
		gtw.setBackground(Color.LIGHT_GRAY);
		panelA.setBackground(Color.LIGHT_GRAY);
		panelA.setBorder(gtwLabel);
		panelA.setBorder(gtwLabel);
		panelA.add(gtw, BorderLayout.EAST);
				
		//Guess the word textfield (Masked)				
		JPanel panelB = new JPanel(new BorderLayout()); //PanelB
		guessTheWord.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT); //align text to the right
		guessTheWord.setEditable(false); //Read Only
		guessTheWord.setBackground(Color.LIGHT_GRAY);
		panelB.setBorder(Loweredbeveled);
		panelB.setBackground(Color.LIGHT_GRAY);
		panelB.add(guessTheWord, BorderLayout.CENTER);
		
		
		//The guesses remaining textfield (Beveled border)
		JPanel panelGR =  new JPanel(new BorderLayout());
		panelGR.setBorder(Loweredbeveled);
		panelGR.setBackground(Color.LIGHT_GRAY);
		guessesRemaining.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT); //Allign text to the right
		guessesRemaining.setEditable(false);
		guessesRemaining.setBackground(Color.LIGHT_GRAY);
		panelGR.add(guessesRemaining, BorderLayout.CENTER);
		
		//Add both the Guesses remaining textfield and label to a single panel
		JPanel panelC = new JPanel(new BorderLayout()); //PanelC
		JLabel gr = new JLabel("GUESSES REMAINING");
		gr.setForeground(rd);
		gr.setBackground(Color.LIGHT_GRAY);
		//Set the textField properties
		panelC.setBorder(bogStandard);
		panelC.setBackground(Color.LIGHT_GRAY);
		panelC.add(gr, BorderLayout.WEST);
	   panelC.add(panelGR, BorderLayout.EAST);
	          	   
	   
	   //Panel1 holds all of the above panels
	   JPanel panel1 = new JPanel(new GridLayout(3,0)); 
		panel1.setBorder(myBorder); 
	   panel1.setBackground(Color.LIGHT_GRAY); 	   
	   panel1.add(panelA);
	   panel1.add(panelB);
	  	panel1.add(panelC);
	
	
	/*
	 *All the buttons panels
	 *A Panel with a beveled border is created 
	 *the button panel is then added beveled panel
	 */
	
	//A
	JPanel p_A = new JPanel(new GridLayout(1,1));
	p_A.setBackground(Color.LIGHT_GRAY);
	p_A.setBorder(beveled);
	A.setBackground(Color.LIGHT_GRAY);
	p_A.add(A);
	//B
	JPanel p_B = new JPanel(new GridLayout(1,1));
	p_B.setBackground(Color.LIGHT_GRAY);
	p_B.setBorder(beveled);
	B.setBackground(Color.LIGHT_GRAY);
	p_B.add(B);
	//C
	JPanel p_C = new JPanel(new GridLayout(1,1));
	p_C.setBackground(Color.LIGHT_GRAY);
	p_C.setBorder(beveled);
	C.setBackground(Color.LIGHT_GRAY);
	p_C.add(C);	
	//D	
	JPanel p_D = new JPanel(new GridLayout(1,1));
	p_D.setBackground(Color.LIGHT_GRAY);
	p_D.setBorder(beveled);
	D.setBackground(Color.LIGHT_GRAY);
	p_D.add(D);	
	//E
	JPanel p_E = new JPanel(new GridLayout(1,1));
	p_E.setBackground(Color.LIGHT_GRAY);
	p_E.setBorder(beveled);
	E.setBackground(Color.LIGHT_GRAY);
	p_E.add(E);	
	//F	
	JPanel p_F = new JPanel(new GridLayout(1,1));
	p_F.setBackground(Color.LIGHT_GRAY);
	p_F.setBorder(beveled);
	F.setBackground(Color.LIGHT_GRAY);
	p_F.add(F);	
	//G
	JPanel p_G = new JPanel(new GridLayout(1,1));
	p_G.setBackground(Color.LIGHT_GRAY);
	p_G.setBorder(beveled);
	G.setBackground(Color.LIGHT_GRAY);
	p_G.add(G);				
	
	//The above buttons are added to a grid layout panel forming buttons A - G
	JPanel panel3 = new JPanel(new GridLayout(1,0));// For buttons A - G
	panel3.setBorder(bogStandard);
	panel3.setBackground(Color.LIGHT_GRAY);	
	panel3.add(p_A);
	panel3.add(p_B);
	panel3.add(p_C);
	panel3.add(p_D);
	panel3.add(p_E);
	panel3.add(p_F);
	panel3.add(p_G);
	
	//H
	JPanel p_H = new JPanel(new GridLayout(1,1));
	p_H.setBackground(Color.LIGHT_GRAY);
	p_H.setBorder(beveled);
	H.setBackground(Color.LIGHT_GRAY);
	p_H.add(H);
	//I
	JPanel p_I = new JPanel(new GridLayout(1,1));
	p_I.setBackground(Color.LIGHT_GRAY);
	p_I.setBorder(beveled);
	I.setBackground(Color.LIGHT_GRAY);
	p_I.add(I);
	//J
	JPanel p_J = new JPanel(new GridLayout(1,1));
	p_J.setBackground(Color.LIGHT_GRAY);
	p_J.setBorder(beveled);
	J.setBackground(Color.LIGHT_GRAY);
	p_J.add(J);	
	//K	
	JPanel p_K = new JPanel(new GridLayout(1,1));
	p_K.setBackground(Color.LIGHT_GRAY);
	p_K.setBorder(beveled);
	K.setBackground(Color.LIGHT_GRAY);
	p_K.add(K);	
	//L	
	JPanel p_L = new JPanel(new GridLayout(1,1));
	p_L.setBackground(Color.LIGHT_GRAY);
	p_L.setBorder(beveled);
	L.setBackground(Color.LIGHT_GRAY);
	p_L.add(L);	
	//M
	JPanel p_M = new JPanel(new GridLayout(1,1));
	p_M.setBackground(Color.LIGHT_GRAY);
	p_M.setBorder(beveled);
	M.setBackground(Color.LIGHT_GRAY);
	p_M.add(M);	
	//N
	JPanel p_N = new JPanel(new GridLayout(1,1));
	p_N.setBackground(Color.LIGHT_GRAY);
	p_N.setBorder(beveled);
	N.setBackground(Color.LIGHT_GRAY);
	p_N.add(N);	
			
	//The above buttons are added to a grid layout panel forming buttons H - N
	JPanel panel4 = new JPanel(new GridLayout(1,0)); 
	panel4.setBorder(bogStandard);
	panel4.setBackground(Color.LIGHT_GRAY);
		
	panel4.add(p_H);
	panel4.add(p_I);
	panel4.add(p_J);
	panel4.add(p_K);
	panel4.add(p_L);
	panel4.add(p_M);
	panel4.add(p_N);
	
	//O
	JPanel p_O = new JPanel(new GridLayout(1,1));
	p_O.setBackground(Color.LIGHT_GRAY);
	p_O.setBorder(beveled);
	O.setBackground(Color.LIGHT_GRAY);
	p_O.add(O);
	//P
	JPanel p_P = new JPanel(new GridLayout(1,1));
	p_P.setBackground(Color.LIGHT_GRAY);
	p_P.setBorder(beveled);
	P.setBackground(Color.LIGHT_GRAY);
	p_P.add(P);
	//Q
	JPanel p_Q = new JPanel(new GridLayout(1,1));
	p_Q.setBackground(Color.LIGHT_GRAY);
	p_Q.setBorder(beveled);
	Q.setBackground(Color.LIGHT_GRAY);
	p_Q.add(Q);	
	//R	
	JPanel p_R = new JPanel(new GridLayout(1,1));
	p_R.setBackground(Color.LIGHT_GRAY);
	p_R.setBorder(beveled);
	R.setBackground(Color.LIGHT_GRAY);
	p_R.add(R);	
	//S	
	JPanel p_S = new JPanel(new GridLayout(1,1));
	p_S.setBackground(Color.LIGHT_GRAY);
	p_S.setBorder(beveled);
	S.setBackground(Color.LIGHT_GRAY);
	p_S.add(S);	
	//T
	JPanel p_T = new JPanel(new GridLayout(1,1));
	p_T.setBackground(Color.LIGHT_GRAY);
	p_T.setBorder(beveled);
	T.setBackground(Color.LIGHT_GRAY);
	p_T.add(T);	
	//U
	JPanel p_U = new JPanel(new GridLayout(1,1));
	p_U.setBackground(Color.LIGHT_GRAY);
	p_U.setBorder(beveled);
	U.setBackground(Color.LIGHT_GRAY);
	p_U.add(U);
	
	//The above buttons are added to a grid layout panel forming buttons O - U
	JPanel panel5 = new JPanel(new GridLayout(1,0));
	panel5.setBorder(bogStandard);
	panel5.setBackground(Color.LIGHT_GRAY);
	
	panel5.add(p_O);
	panel5.add(p_P);
	panel5.add(p_Q);
	panel5.add(p_R);
	panel5.add(p_S);
	panel5.add(p_T);
	panel5.add(p_U);
	
	//V
	JPanel p_V = new JPanel(new GridLayout(1,1));
	p_V.setBackground(Color.LIGHT_GRAY);
	p_V.setBorder(beveled);
	V.setBackground(Color.LIGHT_GRAY);
	p_V.add(V);
	//W
	JPanel p_W = new JPanel(new GridLayout(1,1));
	p_W.setBackground(Color.LIGHT_GRAY);
	p_W.setBorder(beveled);
	W.setBackground(Color.LIGHT_GRAY);
	p_W.add(W);
	//X
	JPanel p_X = new JPanel(new GridLayout(1,1));
	p_X.setBackground(Color.LIGHT_GRAY);
	p_X.setBorder(beveled);
	X.setBackground(Color.LIGHT_GRAY);
	p_X.add(X);	
	//Y	
	JPanel p_Y = new JPanel(new GridLayout(1,1));
	p_Y.setBackground(Color.LIGHT_GRAY);
	p_Y.setBorder(beveled);
	Y.setBackground(Color.LIGHT_GRAY);
	p_Y.add(Y);	
	//Z	
	JPanel p_Z = new JPanel(new GridLayout(1,1));
	p_Z.setBackground(Color.LIGHT_GRAY);
	p_Z.setBorder(beveled);
	Z.setBackground(Color.LIGHT_GRAY);
	p_Z.add(Z);	
	//START
	JPanel p_START = new JPanel(new GridLayout(1,1));
	p_START.setBackground(Color.LIGHT_GRAY);
	p_START.setBorder(beveled);
	START.setBackground(Color.LIGHT_GRAY);
	p_START.add(START);	
	//ANSWER
	JPanel p_ANSWER = new JPanel(new GridLayout(1,1));
	p_ANSWER.setBackground(Color.LIGHT_GRAY);
	p_ANSWER.setBorder(beveled);
	ANSWER.setBackground(Color.LIGHT_GRAY);
	p_ANSWER.add(ANSWER);
	
	//The above buttons are added to a grid layout panel forming buttons V - ANSWER
	JPanel panel6 = new JPanel(new GridLayout(1,0)); 
	panel6.setBorder(bogStandard);
	panel6.setBackground(Color.LIGHT_GRAY);
		
	panel6.add(p_V);
	panel6.add(p_W);
	panel6.add(p_X);
	panel6.add(p_Y);
	panel6.add(p_Z);
	panel6.add(p_START);
	panel6.add(p_ANSWER);
			
	//Add all the button row panels to a main holding panel		
	JPanel panel2 = new JPanel(new GridLayout(4,0)); 
	panel2.setBackground(Color.LIGHT_GRAY);
	panel2.add(panel3);
	panel2.add(panel4);
	panel2.add(panel5);
	panel2.add(panel6);
				
	//Add the top panel (textfields and labels) and the bottom panel(buttons)
	//to a main panel and return this to be displayed in the container		
	JPanel superPanel = new JPanel(new BorderLayout());
	superPanel.setBackground(Color.LIGHT_GRAY);
	superPanel.add(panel1, BorderLayout.NORTH);	
	superPanel.add(panel2, BorderLayout.CENTER);	
		
		return superPanel;		
		
	} //Create panel2
	
	//============================================================================
	//=======================A C T I O N   L I S T E N E R =========================
	//============================================================================
	public void actionPerformed(ActionEvent event){
		//this one event trap is called any of the buttons are pressed
		//we nedd to differentiate between which button was pressed
		//to do this we can use the getActionCommand() method
	
		//Boolean to disable the button
		boolean disable = false;
		
		//Button A 					
		if (event.getActionCommand().equals("A")){
			checkMyAnswer('A'); //Call the checkMyAnswer passing "A" as a argument
			A.setEnabled(disable); //Disable that button (Can only be guessed once)
		//Button B
		} else if (event.getActionCommand().equals("B")){
		   checkMyAnswer('B'); //Call the checkMyAnswer passing "B" as a argument
		   B.setEnabled(disable);	//Disable that button (Can only be guessed once)	
		//Button C	
		} else if (event.getActionCommand().equals("C")){
			checkMyAnswer('C'); //Call the checkMyAnswer passing "C" as a argument
			C.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button D
		} else if (event.getActionCommand().equals("D")){
			checkMyAnswer('D'); //Call the checkMyAnswer passing "D" as a argument
			D.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button E
		} else if (event.getActionCommand().equals("E")){
			checkMyAnswer('E'); //Call the checkMyAnswer passing "E" as a argument
			E.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button F
		} else if (event.getActionCommand().equals("F")){
		   checkMyAnswer('F'); //Call the checkMyAnswer passing "F" as a argument
		   F.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button G
		} else if (event.getActionCommand().equals("G")){
			checkMyAnswer('G'); //Call the checkMyAnswer passing "G" as a argument
			G.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button H
		} else if (event.getActionCommand().equals("H")){
			checkMyAnswer('H'); //Call the checkMyAnswer passing "H" as a argument
			H.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button I
		} else if (event.getActionCommand().equals("I")){
			checkMyAnswer('I'); //Call the checkMyAnswer passing "I" as a argument
			I.setEnabled(disable);  //Disable that button (can only be guessed once)
		//Button J
		} else if (event.getActionCommand().equals("J")){
			checkMyAnswer('J');  //Call the checkMyAnswer passing "J" as a argument
			J.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button K
		} else if (event.getActionCommand().equals("K")){
		 	checkMyAnswer('K'); //Call the checkMyAnswer passing "K" as a argument
		 	K.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button L
		} else if (event.getActionCommand().equals("L")){
			checkMyAnswer('L'); //Call the checkMyAnswer passing "L" as a argument
			L.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button M
		} else if (event.getActionCommand().equals("M")){
			checkMyAnswer('M'); //Call the checkMyAnswer passing "M" as a argument
			M.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button N
		} else if (event.getActionCommand().equals("N")){
			checkMyAnswer('N'); //Call the checkMyAnswer passing "N" as a argument
			N.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button O
		} else if (event.getActionCommand().equals("O")){
			checkMyAnswer('O'); //Call the checkMyAnswer passing "O" as a argument
			O.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button P
		} else if (event.getActionCommand().equals("P")){
			checkMyAnswer('P'); //Call the checkMyAnswer passing "P" as a argument
			P.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button Q
		} else if (event.getActionCommand().equals("Q")){
			checkMyAnswer('Q'); //Call the checkMyAnswer passing "Q" as a argument
			Q.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button R
		} else if (event.getActionCommand().equals("R")){
			checkMyAnswer('R'); //Call the checkMyAnswer passing "R" as a argument
			R.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button S
		} else if (event.getActionCommand().equals("S")){
		   checkMyAnswer('S'); //Call the checkMyAnswer passing "S" as a argument
		   S.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button T
		} else if (event.getActionCommand().equals("T")){
		   checkMyAnswer('T'); //Call the checkMyAnswer passing "T" as a argument
		   T.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button U
		} else if (event.getActionCommand().equals("U")){
		   checkMyAnswer('U'); //Call the checkMyAnswer passing "U" as a argument
		   U.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button V
		} else if (event.getActionCommand().equals("V")){
		   checkMyAnswer('V'); //Call the checkMyAnswer passing "V" as a argument
		   V.setEnabled(disable);  //Disable that button (can only be guessed once)
		//Button W
		} else if (event.getActionCommand().equals("W")){
		   checkMyAnswer('W'); //Call the checkMyAnswer passing "W" as a argument
		   W.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button X
		} else if (event.getActionCommand().equals("X")){
		   checkMyAnswer('X'); //Call the checkMyAnswer passing "X" as a argument
		   X.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button Y
		} else if (event.getActionCommand().equals("Y")){
		   checkMyAnswer('Y'); //Call the checkMyAnswer passing "Y" as a argument
		   Y.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button Z
		} else if (event.getActionCommand().equals("Z")){
		   checkMyAnswer('Z'); //Call the checkMyAnswer passing "Z" as a argument
		   Z.setEnabled(disable); //Disable that button (can only be guessed once)
		//Button START
	  } else if (event.getActionCommand().equals("START")){
		   startGame(); //Call the startGame method
		//Button ANSWER
	  } else if (event.getActionCommand().equals("ANSWER")){
		   showMyAnswer(); //Cheater
		   guessesRemaining.setText("");
		   
	  }
	  	 	  
	} //Action Listener

	//=================================================================================
	// ===========================S T A R T   G A M E==================================
	//=================================================================================
	
	public void startGame(){
		
		
		
		//ENABLE ALL BUTTONS
			boolean enable = true;
			
			A.setEnabled(enable);
			B.setEnabled(enable);
			C.setEnabled(enable);
			D.setEnabled(enable);
			E.setEnabled(enable);
			F.setEnabled(enable);
			G.setEnabled(enable);
			H.setEnabled(enable);
			I.setEnabled(enable);
			J.setEnabled(enable);
			K.setEnabled(enable);
			L.setEnabled(enable);
			M.setEnabled(enable);
			N.setEnabled(enable);
			O.setEnabled(enable);
			P.setEnabled(enable);
			Q.setEnabled(enable);
			R.setEnabled(enable);
			S.setEnabled(enable);
			T.setEnabled(enable);
			U.setEnabled(enable);
			V.setEnabled(enable);
			W.setEnabled(enable);
			X.setEnabled(enable);
			Y.setEnabled(enable);
			Z.setEnabled(enable);
			
		/*Create a new StringBuffer called mask
		* this will be used to create a masked version
		* of the word that we must guess
		*/
		
		
		mask = new StringBuffer();	
				
		//Add the words to the wordstore Array ....
   		this.wordStore[0] = "MEMORY"; 
		this.wordStore[1] = "COMPUTER";
		this.wordStore[2] = "PRINTER";
		this.wordStore[3] = "TROUSERS";
		this.wordStore[4] = "BUTTERCUP";
		
	
						
		//Assign the word
		wordOfTheDay = wordStore[num];
		
		num++; //increment the index
		
		if (num == 5){ //if it reaches the last word then send it back to Zero
			
			num = 0;
			
		}
 					
		for (int i = 0; i < wordOfTheDay.length() ; i++){
		/*Build a String composed entirely of asterik
		* that is of the equivielant length of the word to
		* be guessed
		*/
		mask.append("*"); 
				
		}
		
		displayMask = mask.toString();
				
		//Display the masked word
		guessTheWord.setText(displayMask);
		
			
		//Guess Counter in initally set to 8
		guess = 8;
		
		//Display the number of guesses left
		guessesRemaining.setText(String.valueOf(guess));//Output to textField
			
		//Test
		//System.out.println(wordOfTheDay);
		//System.out.println(mask.toString());
				
	} //startGame
	
	
	//==============================================================================
	//========================   C H E C K   M Y   A N S W E R   ===================
	//==============================================================================
	
	public void checkMyAnswer(char buttonPressed){
		
		guess --; //Each guess made will initially deduct a life 
					 //if the anwser guessed is correct then that life will 
					 //be returned
		
		//To keep track of the occurences of the users guess
		int count = 0;		
	
		//A holder for individual characters being analysied
		char holderWord;
							
		for (int a = 0; a < wordOfTheDay.length(); a++){
					
		holderWord = wordOfTheDay.charAt(a); // add that character at index (i) to the holder.
	 	
	 	//System.out.println("Word holder = " + holderWord);
	 	//System.out.println("Button pressed = " + buttonPressed);
	 		 		
	 	if (holderWord == buttonPressed){
	   
	   count++; 
	   
	   if (count == 1){ //This if statement insures that the life return can only happen ONCE with each guess
	     //Example two "T's" would return two lives (This must not be allowed)
	      guess++; //If guess is right the life will be returned
	      
	   }
	   
		mask.setCharAt(a, buttonPressed); //If guess is right replace the astrik with the correctly guessed letter
		
		//Refresh the display
		displayMask = mask.toString();
		
		//Display the masked word
		guessTheWord.setText(displayMask);
		
		//Check if the entire word has been guessed
		//correctly
		checkIfRight(displayMask);
		
	 	}
	 	
		}//End for cycle
		 	 										
		//Display the number of guesses left
		guessesRemaining.setText(String.valueOf(guess));//Output to textField	
	
		//Check if the game is still alive
		checkIfDead(guess);		
	
	count = 0;	//Reset count back to zero
		
	} //checkMyAnswer
	
	//================================================================================
	//======================= S H O W    T H E    A N S W E R ========================
	//================================================================================
	
	public void showMyAnswer(){
		
		//Disable all buttons except "START"
			boolean disable = false;
			A.setEnabled(disable);
			B.setEnabled(disable);
			C.setEnabled(disable);
			D.setEnabled(disable);
			E.setEnabled(disable);
			F.setEnabled(disable);
			G.setEnabled(disable);
			H.setEnabled(disable);
			I.setEnabled(disable);
			J.setEnabled(disable);
			K.setEnabled(disable);
			L.setEnabled(disable);
			M.setEnabled(disable);
			N.setEnabled(disable);
			O.setEnabled(disable);
			P.setEnabled(disable);
			Q.setEnabled(disable);
			R.setEnabled(disable);
			S.setEnabled(disable);
			T.setEnabled(disable);
			U.setEnabled(disable);
			V.setEnabled(disable);
			W.setEnabled(disable);
			X.setEnabled(disable);
			Y.setEnabled(disable);
			Z.setEnabled(disable);
		
		//Reveal the answer
		guessTheWord.setText(wordOfTheDay);
		
	}  //Show my answer
	
	//=============================================================
	//============= C H E C K    I F   D E A D   ==================
	//=============================================================
	public void checkIfDead(int g){
		
		//If guesses equal zero and the correct word has not been guessed
		//then display a messagebox to the user in RED stating "YOU LOSE"
		if (g == 0){
			Color rd = Color.RED;
			
			//Create the Red label to be displayed
			JLabel ULose = new JLabel("YOU LOSE", SwingConstants.CENTER);
			ULose.setFont(new Font("Times new roman", Font.BOLD, 24));
			ULose.setForeground(rd);
			
			

			//The following will make the backColour of the JOptionPane - LIGHT GREY
			ColorUIResource r = new ColorUIResource(Color.LIGHT_GRAY);
			UIManager.put("OptionPane.background", r);
			UIManager.put("Panel.background", r);
 			UIManager.put("Button.background", r);
 
			JOptionPane pane = new JOptionPane(ULose, JOptionPane.DEFAULT_OPTION);
 			//JOptionPane title message
			JDialog dlg = pane.createDialog(this, "You Lose!");
			dlg.setVisible(true);

			
			//Set text box "G A M E   O V E R"
			guessTheWord.setText("G A M E    O V E R");
			
			//Disable all buttons except "START"
			boolean disable = false;
			A.setEnabled(disable);
			B.setEnabled(disable);
			C.setEnabled(disable);
			D.setEnabled(disable);
			E.setEnabled(disable);
			F.setEnabled(disable);
			G.setEnabled(disable);
			H.setEnabled(disable);
			I.setEnabled(disable);
			J.setEnabled(disable);
			K.setEnabled(disable);
			L.setEnabled(disable);
			M.setEnabled(disable);
			N.setEnabled(disable);
			O.setEnabled(disable);
			P.setEnabled(disable);
			Q.setEnabled(disable);
			R.setEnabled(disable);
			S.setEnabled(disable);
			T.setEnabled(disable);
			U.setEnabled(disable);
			V.setEnabled(disable);
			W.setEnabled(disable);
			X.setEnabled(disable);
			Y.setEnabled(disable);
			Z.setEnabled(disable);
			//ANSWER.setEnabled(disable);
		}
		
		
	}//CheckifDead
	
	//==============================================================================
	//=================== C H E C K    I F    R I G H T ============================
	//==============================================================================
	public void checkIfRight(String displayedMask) {
		
		//If the words match - Disable all the buttons 
		//except START as there is no more game play
		if (displayedMask.compareTo(wordOfTheDay) == 0){
			
			//Disable all buttons except "START"
			boolean disable = false;
			A.setEnabled(disable);
			B.setEnabled(disable);
			C.setEnabled(disable);
			D.setEnabled(disable);
			E.setEnabled(disable);
			F.setEnabled(disable);
			G.setEnabled(disable);
			H.setEnabled(disable);
			I.setEnabled(disable);
			J.setEnabled(disable);
			K.setEnabled(disable);
			L.setEnabled(disable);
			M.setEnabled(disable);
			N.setEnabled(disable);
			O.setEnabled(disable);
			P.setEnabled(disable);
			Q.setEnabled(disable);
			R.setEnabled(disable);
			S.setEnabled(disable);
			T.setEnabled(disable);
			U.setEnabled(disable);
			V.setEnabled(disable);
			W.setEnabled(disable);
			X.setEnabled(disable);
			Y.setEnabled(disable);
			Z.setEnabled(disable);
			//ANSWER.setEnabled(disable);
			
			//Create a color variable color BLUE
			Color bl = Color.BLUE;
			
			//A you Win label with a forecolor of BLUE
			JLabel UWin = new JLabel("YOU WIN", SwingConstants.CENTER);
			UWin.setFont(new Font("Times new roman", Font.BOLD, 24));
			UWin.setForeground(bl);
						
			//JOptionPane.showMessageDialog(null, UWin, "H O O R A Y", JOptionPane.INFORMATION_MESSAGE);
			
			//The following will make the backColour of the JOptionPane - LIGHT GREY
			ColorUIResource r = new ColorUIResource(Color.LIGHT_GRAY);
			UIManager.put("OptionPane.background", r);
			UIManager.put("Panel.background", r);
 		
 			JOptionPane pane = new JOptionPane(UWin, JOptionPane.DEFAULT_OPTION);
 			//JOptionPane title message
			JDialog dlg = pane.createDialog(this, "You Win!");
			dlg.setVisible(true);
				
		}
				
	}//CheckIfRight
			
	
}//Class

	